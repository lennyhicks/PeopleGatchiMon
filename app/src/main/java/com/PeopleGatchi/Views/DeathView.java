package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.PeopleGatchi.PeopleGatchiApplication;
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

public class DeathView extends RelativeLayout {

    private Context context;
    private Flow flow;

    @Bind(R.id.rip)
    TextView restInPeace;

    @Bind(R.id.death_text)
    TextView condolences;

    @Bind(R.id.play_again)
    Button playAgainBtn;


    public DeathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        // Prints the name on the tombstone.
        flow = PeopleGatchiApplication.getMainFlow();
        condolences.setText(StatusControls.getName());
    }

    /*
    Takes the user to the create screen and resets the stats to be able to properly set a new
    character
     */
    @OnClick(R.id.play_again)
    public void playAgain() {

        StatusControls.resetGame();
        History newHistory = History.single(new CreateStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
    }
}