package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.PeopleGatchi.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class JobView extends LinearLayout {
    private Context context;
    public double bankBalance;

    @Bind(R.id.labor_butt)
    Button labor;

    @Bind(R.id.engineer_butt)
    Button engineer;

    @Bind(R.id.science_butt)
    Button science;

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
    }

    @OnClick(R.id.engineer_butt)
    public void workMath() {
        //time passes while working
//        Utils.addTime();
        // So based on your level of education your ceiling and floor go up.
        int payment = ((int) (Math.random() * EducationView.mathEdScore) + EducationView.mathEdScore/2);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        Toast.makeText(context, "You were paid " + payment + " for 2 hours of work.", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.science_butt)
    public void workScience() {
        //time passes while working
//        Utils.addTime();
        // Based on your level of education your ceiling and floor go up.
        int payment = ((int) (Math.random() * EducationView.sciEdScore) + EducationView.sciEdScore/2);
        // we throw this into the Bank
//        BankManager.deposit(payment);
        // we let the person know how much they were paid.
        Toast.makeText(context, "You were paid "+ payment + " for 2 hours of work.", Toast.LENGTH_LONG).show();
    }
}