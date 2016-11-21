package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.CreateStage;
import com.PeopleGatchi.Utils.StatusControls;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;

/**
 * Created by eaglebrosi on 11/21/16.
 */

public class DeathView extends LinearLayout {
    private Context context;
    private Flow flow;

    @Bind(R.id.death_text)
    TextView condolences;

    @Bind(R.id.play_again)
    Button playAgain;

    public DeathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        condolences.setText("Poor sweet "+ StatusControls.getName()+ " has passed away.\n Let's hope they are gently resting \n waiting for the time when you will meet again.");
    }

    @OnClick(R.id.play_again)
    public void playAgain(){
        History newHistory = History.single(new CreateStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
    }
}
