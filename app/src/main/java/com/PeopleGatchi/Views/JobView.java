package com.PeopleGatchi.Views;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Utils.StatusControls;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;

/**
 * Created by eaglebrosi on 11/16/16.
 */
// todo move the payment into bank.
public class JobView extends LinearLayout {
    private Context context;
    public double bankBalance;
    private Flow flow;


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
        int payment = ((int) (Math.random() * 20) + 10);
        // let them know they're getting paid for X amount of work.
        Toast.makeText(context, "You were paid $" + payment + ".", Toast.LENGTH_SHORT).show();
        StatusControls.setMoney(payment);
        // Shows the user their Updated bank balance after payment added.
        bankBalance = StatusControls.getMoney();
        Toast.makeText(context, "Your bank balance is now $$$" + bankBalance + ".", Toast.LENGTH_LONG).show();
        //Actually retrieving the updated value.
        int newMoney= StatusControls.getMoney() + payment;
        //StatusControls.setMoney(newMoney);
    }

    @OnClick(R.id.engineer_butt)
    public void workMath() {
        //time passes while working
//        Utils.addTime();
        // So based on your level of education your ceiling and floor go up.
        int payment = ((int) (Math.random() * EducationView.mathEdScore) + EducationView.mathEdScore / 2);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        Toast.makeText(context, "You were paid $" + payment + ".", Toast.LENGTH_LONG).show();
        // puts the payment into the bank.
        StatusControls.setMoney(payment);
        // Shows the user their Updated bank balance after payment added.
        Toast.makeText(context, "Your bank balance is now $$$" + bankBalance + ".", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        int payment = ((int) (Math.random() * EducationView.sciEdScore) + EducationView.sciEdScore / 2);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        Toast.makeText(context, "You were paid $" + payment + ".", Toast.LENGTH_LONG).show();
        // puts the payment into the bank.
        StatusControls.setMoney(payment);
        // Shows the user their Updated bank balance after payment added.
        Toast.makeText(context, "Your bank balance is now $$$" + StatusControls.getMoney() + ".", Toast.LENGTH_LONG).show();
        //Actually retrieving the updated value.
        int newMoney= StatusControls.getMoney() + payment;
        //StatusControls.setMoney(newMoney);
    }

    @OnClick(R.id.philo_butt)
    public void workPhilosophy() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        // The Floor to philosophy pay is low and never increases.
        int payment = ((int) (Math.random() * EducationView.sciEdScore) + 5);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        Toast.makeText(context, "You were paid $" + payment + ".", Toast.LENGTH_LONG).show();
        // puts the payment into the bank.
        StatusControls.setMoney(payment);
        // Shows the user their Updated bank balance after payment added.
        Toast.makeText(context, "Your bank balance is now $$$" + StatusControls.getMoney() + ".", Toast.LENGTH_LONG).show();
        //Actually retrieving the updated value.
        int newMoney= StatusControls.getMoney() + payment;
        //StatusControls.setMoney(newMoney);
    }

    @OnClick(R.id.go_home)
    public void goHome() {
        flow = PeopleGatchiApplication.getMainFlow();
        //History newHistory = History.single(new HomeStage());
        flow.goBack();
    }
}