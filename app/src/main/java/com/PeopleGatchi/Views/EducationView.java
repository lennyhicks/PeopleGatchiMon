package com.PeopleGatchi.Views;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
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
public class EducationView extends LinearLayout {
    private Context context;
    public static int sciEdScore;
    public static int mathEdScore;

    @Bind(R.id.increase_science)
    Button increaseScience;

    @Bind(R.id.increase_math)
    Button increaseMath;

    @Bind(R.id.home_button)
    FloatingActionButton homeButton;

    public EducationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        ButterKnife.bind(this);
//
//        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.increase_science)
    public void changeScience(){
        //time passes when being taught.
//        Utils.addTime();
        // sometimes you learns betters then others.
        int increase= ((int)(Math.random()*5)+1);
        sciEdScore += increase;
        Toast.makeText(context, "You got smarterer by " + increase, Toast.LENGTH_SHORT).show();
        // this is just to see if it's increasing. TODO get rid of this if it's working.
        Toast.makeText(context, "Your science score is now :"+ sciEdScore, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.increase_math)
    public void changeMath(){
        //time passes when being taught.
//        Utils.addTime();
        // sometimes you learns betters then others.
        int increase= ((int)(Math.random()*5)+1);
        mathEdScore += increase;
        Toast.makeText(context, "You got smarterer by " + increase, Toast.LENGTH_SHORT).show();
        // this is just to see if it's increasing. TODO get rid of this if it's working.
        Toast.makeText(context, "Your maths score is now :"+ mathEdScore, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.home_button)
    public void homeButton(){

    }
}
