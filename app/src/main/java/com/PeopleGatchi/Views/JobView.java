package com.PeopleGatchi.Views;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Utils.BankControls;
import com.PeopleGatchi.Utils.StatusControls;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;

import static com.PeopleGatchi.Views.EducationView.warningMessage;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class JobView extends LinearLayout {
    private Context context;
    public double bankBalance;
    private Flow flow;
    private int payment;
    private Handler handler;
    private Runnable handlerTask;

    @Bind(R.id.labor_butt)
    Button labor;

    @Bind(R.id.engineer_butt)
    Button engineer;

    @Bind(R.id.science_butt)
    Button science;

    @Bind(R.id.philo_butt)
    Button philosophy;

    @Bind(R.id.go_home)
    FloatingActionButton goHome;

    @Bind(R.id.money_laundering)
    TextView wheresTheMoney;

    @Bind(R.id.bank_update)
    TextView updateBank;

    public JobView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.labor_butt)
    public void workLabor() {
        // Manual Labor pay is between 30 and 10 dollars. It doesn't change.
        payment = ((int) (Math.random() * 20) + 10);
        updateMoney();
    }

    @OnClick(R.id.engineer_butt)
    public void workMath() {
        // Based on your level of math education your ceiling and floor go up.
        payment = ((int) (Math.random() * StatusControls.getMathEd()) + StatusControls.getMathEd() / 2);
        updateMoney();
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        // Based on your level of science education your ceiling and floor go up.
        payment = ((int) (Math.random() * StatusControls.getScienceEd()) + StatusControls.getScienceEd() / 2);
        updateMoney();
    }

    @OnClick(R.id.philo_butt)
    public void workPhilosophy() {
        // Based on your level of philosophy education your ceiling and floor go up.
        payment = ((int) (Math.random() * StatusControls.getPhiloEd()));
        updateMoney();
    }

    @OnClick(R.id.go_home)
    public void goHome() {
        // Just lets the FAB bring you back to the home screen.
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    public void updateMoney(){
        // Checks to make sure the user isn't educating themselves to death.
        checkDisable();
        // Adds the money to the bank account.
        BankControls.setMoney(payment);
        // While you were at school- time has passed.
        HomeView.workSchoolDay();
        // Prints to the screen what you were paid and your updated bank balance.
        wheresTheMoney.setText("You were paid: $"+ payment+".");
        updateBank.setText("Bank Balance: $"+BankControls.getMoney()+".");
    }

    public void checkDisable() {
        // Prevents you from working yourself and sends you a toast with a custom warning message about what status is low.
        if ((StatusControls.getHungerLevel() <= 5) || (StatusControls.getPooLevel() <= 5) || (StatusControls.getPeeLevel() <= 5)
                || (StatusControls.getHygieneLevel() <= 5) || (StatusControls.getThirstLevel() <= 5)
                || (StatusControls.getRestLevel() <= 5)) {
            setWarningMessage();
            Toast.makeText(context, warningMessage, Toast.LENGTH_SHORT).show();
            disableButton();
        }
    }

    public void setWarningMessage() {
        // This creates the warning message you will toast if a level is low.
        if (StatusControls.getHungerLevel() <= 5) {
            warningMessage = "Your baby is super hungry!\n Go fed them!";
        } else if (StatusControls.getPooLevel() <= 5) {
            warningMessage = "Your baby really needs to go!\n Let them go to the bathroom!";
        } else if (StatusControls.getPeeLevel() <= 5) {
            warningMessage = "Your baby needs to tinkle! \n Let them pee!";
        } else if (StatusControls.getHygieneLevel() <= 5) {
            warningMessage = "Your baby is filthy!\n Bathe them!";
        } else if (StatusControls.getThirstLevel() <= 5) {
            warningMessage = "Your sweet baby needs a drink!\n Don't let them go thirsty!";
        } else if (StatusControls.getRestLevel() <= 5) {
            warningMessage = "Your baby needs a nap!\n Put them to bed!";
        }
    }

    public void disableButton() {
        // If a status is low, this prevents you from clicking the button for 15 seconds.
        handler = new Handler();
        handlerTask = new Runnable() {
            @Override
            public void run() {
                labor.setEnabled(false);
                philosophy.setEnabled(false);
                science.setEnabled(false);
                engineer.setEnabled(false);
                handler.postDelayed(handlerTask, 15000);
            }
        };
        handlerTask.run();
    }
}