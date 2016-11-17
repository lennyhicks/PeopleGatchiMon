package com.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Stages.EducationStage;
import com.PeopleGatchi.Stages.JobStage;

import com.PeopleGatchi.R;
import com.PeopleGatchi.Utils.StatusControls;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class HomeView extends RelativeLayout {
    private Flow flow;

    private Context context;


    @Bind(R.id.food_bar)
    ProgressBar foodBar;

    @Bind(R.id.drink_bar)
    ProgressBar drinkBar;

    @Bind(R.id.sleep_bar)
    ProgressBar sleepBar;

    @Bind(R.id.image_view)
    ImageView imageView;

    @Bind(R.id.hygiene_bar)
    ProgressBar hygieneBar;

    @Bind(R.id.pee_bar)
    ProgressBar peeBar;

    @Bind(R.id.poop_bar)
    ProgressBar poopBar;

    @Bind(R.id.bank_amount)
    TextView bankAmount;

    @Bind(R.id.fastforward_button)
    ImageButton fastForward;

    @Bind(R.id.clock)
    TextView clock;

    @Bind(R.id.store_button)
    ImageButton storeButton;

    @Bind(R.id.inventory_button)
    ImageButton inventoryButton;

    @Bind(R.id.education_button)
    ImageButton educationButton;

    @Bind(R.id.work_button)
    ImageButton workButton;

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        flow = PeopleGatchiApplication.getMainFlow();
        StatusControls.updatePooBladder(10);
        StatusControls.updateHunger(10);
        StatusControls.update();


       // EventBus.getDefault().register(this);
    }

    @OnClick(R.id.food_bar)
    public void feedPet(){
        int foodAmount = ((int)(Math.round(Math.random() *15 ) +5));
        Toast.makeText(context, "BELCH!! Whew, i'm stuffed!!!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.drink_bar)
    public void waterPet(){
        int drinkAmount = ((int)(Math.round(Math.random() *15 ) +5));
        Toast.makeText(context, "Slurp slurp, mmmm!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){
        int sleepyTime = ((int)(Math.round(Math.random() *15 ) +5));
        Toast.makeText(context, "Whew, I feel rested and ready!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.image_view)
    public void happinessView(){

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet(){
        int cleanBaby = ((int)(Math.round(Math.random() *15 ) +5));
        Toast.makeText(context, "Yay, so fresh and so clean clean!!", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){
    int peeAmount = ((int)(Math.round(Math.random() *15 ) +5));
        Toast.makeText(context, "Yay, we made a pee-pee, Yay!!!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){
       int dumpSize = (int)(Math.round(Math.random() * 15 )+5);
        if(dumpSize == 20){
            Toast.makeText(context, "Holy COW WHAT A DUMP! the king lives!!!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "That was a sweet sweet #2!", Toast.LENGTH_SHORT).show();
            //       Status.poo(dumpSize);
        }
        StatusControls.updatePooBladder(dumpSize);
    }

    @OnClick(R.id.bank_amount)
    public void bankTotal(){

    }

    @OnClick(R.id.fastforward_button)
    public void increaseTime(){

    }

    @OnClick(R.id.clock)
    public void clock(){

    }

    @OnClick(R.id.store_button)
    public void goToStore(){

    }

    @OnClick(R.id.inventory_button)
    public void goToInventory(){

    }

    @OnClick(R.id.education_button)
    public void goToSchool(){
        History newHistory = History.single(new EducationStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);

    }

    @OnClick(R.id.work_button)
    public void goToWork(){
        History newHistory = History.single(new JobStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);

    }

}
