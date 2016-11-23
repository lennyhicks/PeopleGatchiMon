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
// todo gotta add time punishment to prevent spamming buttons!
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

//        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.labor_butt)
    public void workLabor() {
        //time passes while working
        //hour += 8;
        //Utils.Time.increaseHour();  Notes on how time is to be kept.
        // manual labor gets a set pay between 15 and 5 dollars an hour.
        payment = ((int) (Math.random() * 20) + 10);
        //now we call the function
        updateMoney();
    }

    @OnClick(R.id.engineer_butt)
    public void workMath() {
        //time passes while working
//        Utils.addTime();
        // So based on your level of education your ceiling and floor go up.
        payment = ((int) (Math.random() * StatusControls.getMathEd()) + StatusControls.getMathEd() / 2);
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        payment = ((int) (Math.random() * StatusControls.getScienceEd()) + StatusControls.getScienceEd() / 2);
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.philo_butt)
    public void workPhilosophy() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        // The Floor to philosophy pay is low and never increases. AKA sometimes they don't get paid.
        payment = ((int) (Math.random() * StatusControls.getPhiloEd()));
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.go_home)
    public void goHome() {
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    public void updateMoney(){
        statusCheck();
        BankControls.setMoney(payment);
        HomeView.workSchoolDay();
        wheresTheMoney.setText("You were paid: $"+ payment+".");
        updateBank.setText("Bank Balance: $"+BankControls.getMoney()+".");
    }

    public void statusCheck() {
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
        checkDisable();
    }

    public void checkDisable() {
        if ((StatusControls.getHungerLevel() <= 5) || (StatusControls.getPooLevel() <= 5) || (StatusControls.getPeeLevel() <= 5)
                || (StatusControls.getHygieneLevel() <= 5) || (StatusControls.getThirstLevel() <= 5)
                || (StatusControls.getRestLevel() <= 5)) {
            Toast.makeText(context, warningMessage, Toast.LENGTH_SHORT).show();
            disableButton();
        }
    }

    public void disableButton() {
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