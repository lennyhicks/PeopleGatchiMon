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
import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.EducationStage;
import com.PeopleGatchi.Stages.JobStage;
import com.PeopleGatchi.Utils.StatusControls;
import com.PeopleGatchi.Utils.Utils;

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

//
//        Happiness happy = Happiness.findById(Happiness.class, (long) 1);
//        happy = new Happiness(120);
//        Hunger hunger = new Hunger(20);
//        Hygiene hygiene = new Hygiene(20);
//        Pee pee = new Pee(20);
//        Poo poo = new Poo(20);
//        Rest rest = new Rest(20);
//        Thirst thirst = new Thirst(20);
//
//        happy.save();
//        hunger.save();
//        hygiene.save();
//        pee.save();
//        poo.save();
//        rest.save();
//        thirst.save();


        StatusControls.firstRun();
        foodBar.setProgress(StatusControls.getHungerLevel());
        drinkBar.setProgress(StatusControls.getHygieneLevel());
        hygieneBar.setProgress(StatusControls.getThirstLevel());
        peeBar.setProgress(StatusControls.getPeeLevel());
        poopBar.setProgress(StatusControls.getPooLevel());
        sleepBar.setProgress(StatusControls.getRestLevel());



       // EventBus.getDefault().register(this);
    }

    @OnClick(R.id.food_bar)
    public void feedPet(){
        //int foodAmount = ((int)(Math.round(Math.random() *15 ) +5));
        int foodAmount = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(-foodAmount);
        Toast.makeText(context, "BELCH!! Whew, i'm stuffed!!!" + foodAmount, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.drink_bar)
    public void waterPet(){
        //int drinkAmount = ((int)(Math.round(Math.random() *15 ) +5));
        //int drinkAmount = Utils.getRand(15) + 5;
        int drinkAmount = Utils.getRand(StatusControls.getThirstLevel());
        StatusControls.setThirst(-drinkAmount);
        Toast.makeText(context, "Slurp slurp, mmmm!" + drinkAmount, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){
        //int sleepyTime = ((int)(Math.round(Math.random() *15 ) +5));
        //int sleepyTime = Utils.getRand(15) + 5;
        int sleepyTime = Utils.getRand(StatusControls.getRestLevel());
        StatusControls.setRest(-sleepyTime);
        Toast.makeText(context, "Whew, I feel rested and ready!" + sleepyTime, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.image_view)
    public void happinessView(){

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet(){
        //int cleanBaby = ((int)(Math.round(Math.random() *15 ) +5));
        //int cleanBaby = Utils.getRand(15) + 5;
        int cleanBaby = Utils.getRand(StatusControls.getHygieneLevel());
        StatusControls.setHygiene(-cleanBaby);
        Toast.makeText(context, "Yay, so fresh and so clean clean!!" + cleanBaby, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){
    //int peeAmount = ((int)(Math.round(Math.random() *15 ) +5));
        //int drainPet = Utils.getRand(15) + 5;
        int drainPet = Utils.getRand(StatusControls.getPeeLevel());
        StatusControls.setPeeBladder(-drainPet);
        Toast.makeText(context, "Yay, we made a pee-pee, Yay!!!" + drainPet, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){
       //int dumpSize = (int)(Math.round(Math.random() * 15 )+5);
        //int dumpSize = Utils.getRand(15) + 5;
        int dumpSize = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(-dumpSize);
        if(dumpSize == 20){
            Toast.makeText(context, "Holy COW WHAT A DUMP! the king lives!!!!" + dumpSize, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "That was a sweet sweet #2!" + dumpSize, Toast.LENGTH_SHORT).show();
            //       Status.poo(dumpSize);
        }
       // StatusControls.updatePooBladder(dumpSize);
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
