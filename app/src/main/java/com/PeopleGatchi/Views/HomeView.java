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

    @OnClick(R.id.food_bar)
    public void feedPet(){

    }

    @OnClick(R.id.drink_bar)
    public void waterPet(){

    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){

    }

    @OnClick(R.id.image_view)
    public void happinessView(){

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet(){

    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){

    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){

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
