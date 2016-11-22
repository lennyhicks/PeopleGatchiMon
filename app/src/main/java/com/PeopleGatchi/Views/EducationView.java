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
public class EducationView extends LinearLayout {
    private Context context;
    private Flow flow;

    @Bind(R.id.increase_science)
    Button increaseScience;

    @Bind(R.id.increase_math)
    Button increaseMath;

    @Bind(R.id.increase_philo)
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
    protected void onFinishInflate(){
        super.onFinishInflate();
        ButterKnife.bind(this);

        pokeStats();
    }

    @OnClick(R.id.increase_science)
    public void changeScience(){
        int increase= ((int)(Math.random()*5)+1);
        StatusControls.setScienceEd(increase);
        pokeStats();
    }

    @OnClick(R.id.increase_math)
    public void changeMath(){
        int increase= ((int)(Math.random()*5)+1);
        StatusControls.setMathEd(increase);
        pokeStats();
    }

    @OnClick(R.id.increase_philo)
    public void changePhilo(){
        int increase= ((int)(Math.random()*5)+1);
        StatusControls.setPhiloEd(increase);
        pokeStats();
    }

    @OnClick(R.id.home_button)
    public void homeButton(){
        flow = PeopleGatchiApplication.getMainFlow();
        flow.goBack();
    }

    public void pokeStats(){
        philoLevel.setText("Your Philosophy Score is: "+ StatusControls.getPhiloEd());
        mathLevel.setText("Your Maths score is: "+ StatusControls.getMathEd());
        scienceLevel.setText("Your Science score is: "+ StatusControls.getScienceEd());
        // passes time.
        HomeView.workSchoolDay();
    }
}
