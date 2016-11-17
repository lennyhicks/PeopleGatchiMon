package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Stages.RegisterStage;

import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;
import com.PeopleGatchi.R;

/**
 * Created by lennyhicks on 10/31/16.
 */
//HELLO LENNY!!!!!
public class LoginView extends LinearLayout {
    private Context context;

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registerButton)
    public void showRegisterView(){
        Flow flow = PeopleGatchiApplication.getMainFlow();
        History newHistory = flow.getHistory().buildUpon()
                .push(new RegisterStage())
                .build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);
    }

}
