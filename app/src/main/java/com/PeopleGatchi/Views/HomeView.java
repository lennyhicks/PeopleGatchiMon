package com.PeopleGatchi.Views;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.PeopleGatchi.Dialogs.InventoryDialog;
import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.EducationStage;
import com.PeopleGatchi.Stages.JobStage;
import com.PeopleGatchi.Stages.StoreStage;
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
//
//        Poo pooBladder = new Poo(20);
//        Pee peeBladder = new Pee(20);
//        Happiness happiness= new Happiness();
//        Hunger hunger = new Hunger(20);
//        Thirst thirst = new Thirst(20);
//        Hygiene hygiene = new Hygiene(20);
//        Rest rest = new Rest(20);
//
//        peeBladder.peeLevel = 20;
//        pooBladder.pooLevel = 20;
//        hunger.hungerLevel = 20;
//        thirst.thirstLevel = 20;
//        hygiene.hygieneLevel = 20;
//        rest.restLevel = 20;
//
//
//
//        pooBladder.save();
//        peeBladder.save();
//        happiness.save();
//        hunger.save();
//        thirst.save();
//        hygiene.save();
//        rest.save();

        flow = PeopleGatchiApplication.getMainFlow();

        StatusControls.firstRun();
        foodBar.setProgress(StatusControls.getHungerLevel());
        drinkBar.setProgress(StatusControls.getHygieneLevel());
        hygieneBar.setProgress(StatusControls.getThirstLevel());
        peeBar.setProgress(StatusControls.getPeeLevel());
        poopBar.setProgress(StatusControls.getPooLevel());
        sleepBar.setProgress(StatusControls.getRestLevel());

        Toast.makeText(context, StatusControls.getPooLevel()+ "", Toast.LENGTH_LONG).show();

        imageView.setImageResource(Utils.setHappinessImage());
       // EventBus.getDefault().register(this);
    }
//not working
    @OnClick(R.id.food_bar)
    public void feedPet(){
        //int foodAmount = ((int)(Math.round(Math.random() *15 ) +5));
        int foodAmount = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(-foodAmount);
        Toast.makeText(context, "BELCH!! Whew, i'm stuffed!!! \n Your food level has increased by: " + foodAmount, Toast.LENGTH_SHORT).show();
    }

    //not working
    @OnClick(R.id.drink_bar)
    public void waterPet(){
        //int drinkAmount = ((int)(Math.round(Math.random() *15 ) +5));
        //int drinkAmount = Utils.getRand(15) + 5;
        int drinkAmount = Utils.getRand(StatusControls.getThirstLevel());
        StatusControls.setThirst(-drinkAmount);
        Toast.makeText(context, "Slurp slurp, mmmm! \n Your Thirst level has increased by: " + drinkAmount, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){
        //int sleepyTime = ((int)(Math.round(Math.random() *15 ) +5));
        //int sleepyTime = Utils.getRand(15) + 5;
        int sleepyTime = Utils.getRand(StatusControls.getRestLevel());
        StatusControls.setRest(-sleepyTime);
        Toast.makeText(context, "Whew, I feel rested and ready! \n your Sleep level has increased by: " + sleepyTime, Toast.LENGTH_SHORT).show();
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
        Toast.makeText(context, "Yay, so fresh and so clean clean!! \n your Hygiene level has increased by: " + cleanBaby, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){
    //int peeAmount = ((int)(Math.round(Math.random() *15 ) +5));
        //int drainPet = Utils.getRand(15) + 5;
        int drainPet = Utils.getRand(StatusControls.getPeeLevel());
        StatusControls.setPeeBladder(-drainPet);
        Toast.makeText(context, "Yay, we made a pee-pee, Yay!!! \n your pee-pee level has been relieved by: " + drainPet, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){
       //int dumpSize = (int)(Math.round(Math.random() * 15 )+5);
        //int dumpSize = Utils.getRand(15) + 5;
        int dumpSize = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(-dumpSize);
        if(dumpSize == 20){
            Toast.makeText(context, "HOLY COW, You just dropped a bigfoot!!! And now you're dead. \n your poo level has been relieved by: " + dumpSize, Toast.LENGTH_SHORT).show();
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

        History newHistory = flow.getHistory().buildUpon().push(new StoreStage()).build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);
    }

    @OnClick(R.id.inventory_button)
    public void goToInventory(){

        final InventoryDialog inventoryDialog = new InventoryDialog(context);
        inventoryDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        inventoryDialog.show();


//        History newHistory = flow.getHistory().buildUpon().push(new InventoryStage()).build();
//        flow.setHistory(newHistory, Flow.Direction.FORWARD);
    }

    @OnClick(R.id.education_button)
    public void goToSchool(){
        //History newHistory = History.single(new EducationStage());
        History newHistory = flow.getHistory().buildUpon().push(new EducationStage()).build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);

    }

    @OnClick(R.id.work_button)
    public void goToWork(){
        //History newHistory = History.single(new JobStage());
        History newHistory = flow.getHistory().buildUpon().push(new JobStage()).build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);

    }

}
