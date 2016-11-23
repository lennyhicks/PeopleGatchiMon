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
    public void changeScience() {
        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setScienceEd(increase);
        pokeStats();
    }

    @OnClick(R.id.increase_math)
    public void changeMath() {
        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setMathEd(increase);
        pokeStats();
    }

    @OnClick(increase_philo)
    public void changePhilo() {
        int increase = ((int) (Math.random() * 5) + 1);
        StatusControls.setPhiloEd(increase);
        pokeStats();
    }

    @OnClick(R.id.home_button)
    public void homeButton() {
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    public void pokeStats() {
        philoLevel.setText("Your Philosophy Score is: " + StatusControls.getPhiloEd());
        mathLevel.setText("Your Maths score is: " + StatusControls.getMathEd());
        scienceLevel.setText("Your Science score is: " + StatusControls.getScienceEd());
        // passes time.
        HomeView.workSchoolDay();
        statusCheck();
    }

    public void statusCheck() {
        if (StatusControls.getHungerLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your baby is super hungry!\n Go fed them!", Toast.LENGTH_SHORT).show();
        } else if (StatusControls.getPooLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your baby really needs to go!\n Let them go to the bathroom!", Toast.LENGTH_SHORT).show();
        } else if (StatusControls.getPeeLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your baby needs to tinkle! \n Let them pee!", Toast.LENGTH_SHORT).show();
        } else if (StatusControls.getHygieneLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your baby is filthy!\n Bathe them!", Toast.LENGTH_SHORT).show();
        } else if (StatusControls.getThirstLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your sweet baby needs a drink!\n Don't let them go thirsty!", Toast.LENGTH_SHORT).show();
        } else if (StatusControls.getRestLevel() <= 5) {
            disableButton();
            Toast.makeText(context, "Your baby needs a nap!\n Put them to bed!", Toast.LENGTH_SHORT).show();
        }
    }


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
