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
import com.PeopleGatchi.Utils.StatusControls;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;

import static com.PeopleGatchi.R.id.increase_philo;

/**
 * Created by eaglebrosi on 11/16/16.
 */
public class EducationView extends LinearLayout {

    private Context context;
    private Flow flow;
    private Handler handler;
    private Runnable handlerTask;
    public static String warningMessage;

    @Bind(R.id.increase_science)
    Button increaseScience;

    @Bind(R.id.increase_math)
    Button increaseMath;

    @Bind(increase_philo)
    Button increasePhilo;

    @Bind(R.id.home_button)
    FloatingActionButton homeButton;

    @Bind(R.id.science_score)
    TextView scienceLevel;

    @Bind(R.id.math_score)
    TextView mathLevel;

    @Bind(R.id.philo_score)
    TextView philoLevel;


    public EducationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        pokeStats();
    }

    /*
    Increases your Science score with a random number between 1 and 5. Sometimes you learn better.
     */
    @OnClick(R.id.increase_science)
    public void changeScience() {

        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setScienceEd(increase);
        pokeStats();
    }

    /*
    Increases your Math score with a random number between 1 and 5.
     */
    @OnClick(R.id.increase_math)
    public void changeMath() {

        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setMathEd(increase);
        pokeStats();
    }

    /*
    Increases your Philosophy score with a random number between 0 and 6. It's Philosophy, sometimes you don't learn nothing.
     */
    @OnClick(increase_philo)
    public void changePhilo() {

        int increase = ((int) (Math.random() * 6));
        StatusControls.setPhiloEd(increase);
        pokeStats();
    }

    @OnClick(R.id.home_button)
    // On the FAB click it takes you back to the Home View.
    public void homeButton() {
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    /*
    This is the character sheet. It prints out the Philosophy, Math and Education scores.
     */
    public void pokeStats() {

        philoLevel.setText(getContext().getString(R.string.philosophy_score) + StatusControls.getPhiloEd());
        mathLevel.setText(getContext().getString(R.string.maths_score) + StatusControls.getMathEd());
        scienceLevel.setText(getContext().getString(R.string.science_score) + StatusControls.getScienceEd());
        // This calls the method that passes the time.
        HomeView.workSchoolDay();
        checkDisable();
    }

    /*
    This looks to see if any of the statuses are in danger of being too low (so you don't work yourself to death).
    It toast a warning message and then calls the disable button.
     */
    public void checkDisable() {

        if ((StatusControls.getHungerLevel() <= 7) || (StatusControls.getPooLevel() <= 7) || (StatusControls.getPeeLevel() <= 7)
                || (StatusControls.getHygieneLevel() <= 7) || (StatusControls.getThirstLevel() <= 7)
                || (StatusControls.getRestLevel() <= 7)) {
            setWarningMessage();
            Toast.makeText(context, warningMessage, Toast.LENGTH_SHORT).show();
            disableButton();
        }
    }

    /*
    Sets the warning message for when any status are low.
     */
    public void setWarningMessage() {

        if (StatusControls.getHungerLevel() <= 7) {
            warningMessage = getContext().getString(R.string.hungry_message);
        } else if (StatusControls.getPooLevel() <= 7) {
            warningMessage = getContext().getString(R.string.bathroom_message);
        } else if (StatusControls.getPeeLevel() <= 7) {
            warningMessage = getContext().getString(R.string.pee_message);
        } else if (StatusControls.getHygieneLevel() <= 7) {
            warningMessage = getContext().getString(R.string.bathe_message);
        } else if (StatusControls.getThirstLevel() <= 7) {
            warningMessage = getContext().getString(R.string.thirsty_message);
        } else if (StatusControls.getRestLevel() <= 7) {
            warningMessage = getContext().getString(R.string.sleepy_message);
        }
    }

    /*
    This disables the buttons for 15 seconds (to prevent a user from killing themselves).
     */
    public void disableButton() {

        handler = new Handler();
        handlerTask = new Runnable() {
            @Override
            public void run() {
                increaseMath.setEnabled(false);
                increasePhilo.setEnabled(false);
                increaseScience.setEnabled(false);
                handler.postDelayed(handlerTask, 15000);
            }
        };
        handlerTask.run();
    }
}