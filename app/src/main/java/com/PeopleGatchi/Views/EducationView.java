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

    @OnClick(R.id.increase_science)
    // Increases your Science score with a random number between 1 and 5.
    public void changeScience() {
        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setScienceEd(increase);
        pokeStats();
    }

    @OnClick(R.id.increase_math)
    // Increases your Math score with a random number between 1 and 5.
    public void changeMath() {
        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setMathEd(increase);
        pokeStats();
    }

    @OnClick(increase_philo)
    // Increases your Philosophy score with a random number between 0 and 6. It's Philosophy, sometimes you don't learn nothing.
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

    public void pokeStats() {
        // This is the character sheet. It prints out the Philosophy, Math and Education scores.
        philoLevel.setText("Your Philosophy Score is: " + StatusControls.getPhiloEd());
        mathLevel.setText("Your Maths score is: " + StatusControls.getMathEd());
        scienceLevel.setText("Your Science score is: " + StatusControls.getScienceEd());
        // This calls the method that passes the time.
        HomeView.workSchoolDay();
        checkDisable();
    }

    public void checkDisable() {
        // This looks to see if any of the statuses are in danger of being too low (so you don't work yourself to death).
        // It toast a warning message and then calls the disable button.
        if ((StatusControls.getHungerLevel() <= 5) || (StatusControls.getPooLevel() <= 5) || (StatusControls.getPeeLevel() <= 5)
                || (StatusControls.getHygieneLevel() <= 5) || (StatusControls.getThirstLevel() <= 5)
                || (StatusControls.getRestLevel() <= 5)) {
            setWarningMessage();
            Toast.makeText(context, warningMessage, Toast.LENGTH_SHORT).show();
            disableButton();
        }
    }

    public void setWarningMessage() {
        // Sets the warning message for when any status are low.
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
        // This disables the buttons for 15 seconds (to prevent a user from killing themselves).
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