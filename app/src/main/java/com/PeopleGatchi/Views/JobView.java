package com.PeopleGatchi.Views;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
// todo Eagle clean up your code!
public class JobView extends LinearLayout {
    private Context context;
    public double bankBalance;
    private Flow flow;
    private int payment;

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

        updateMoney();
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
        payment = ((int) (Math.random() * EducationView.mathEdScore) + EducationView.mathEdScore / 2);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        payment = ((int) (Math.random() * EducationView.sciEdScore) + EducationView.sciEdScore / 2);
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.philo_butt)
    public void workPhilosophy() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        // The Floor to philosophy pay is low and never increases.
        payment = ((int) (Math.random() * EducationView.sciEdScore) + 5);
        // we let the person know how much they were paid.
        updateMoney();
    }

    @OnClick(R.id.go_home)
    public void goHome() {
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    public void updateMoney(){
        StatusControls.setMoney(payment);
        wheresTheMoney.setText("You were paid: $"+ payment+".");
        // todo add an update bank balance as well.
        // TODO so here's what I think we are gonna have to do- we need to actually write some
        // todo--- code like HomeView.updateBank() that will look just like this function that puts
        // todo -- an updated Bank Balance onto the home screen!
        updateBank.setText("Bank Balance: $"+StatusControls.getMoney()+".");
 //       HomeView.printBank();
    }
}