package com.PeopleGatchi.Views;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.PeopleGatchi.Dialogs.InventoryDialog;
import com.PeopleGatchi.Dialogs.StoreDialog;
import com.PeopleGatchi.Models.Death;
import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Stages.EducationStage;
import com.PeopleGatchi.Stages.JobStage;
import com.PeopleGatchi.Utils.BankControls;
import com.PeopleGatchi.Utils.StatusControls;
import com.PeopleGatchi.Utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private String date;

    private Context context;
    private String updateMessage;
    private Handler handler;
    private Runnable handlerTask;
    public static Calendar calendar;
    private static boolean runningTimer = false;
    public Integer speed = 200;

    void startTimer(){
        runningTimer = true;
        handler = new Handler();
        handlerTask = new Runnable()
        {
            @Override
            public void run() {
                setClock(clock);
                if(calendar.get(Calendar.MINUTE) % 20 == 0){
                    StatusControls.setHunger(-1);
                    StatusControls.setThirst(-1);
                    StatusControls.setHygiene(-1);
                    StatusControls.setRest(-1);
                    StatusControls.setPeeBladder(-1);
                    StatusControls.setPooBladder(-1);
                }
                foodBar.setProgress(StatusControls.getHungerLevel());
                drinkBar.setProgress(StatusControls.getThirstLevel());
                hygieneBar.setProgress(StatusControls.getHygieneLevel());
                peeBar.setProgress(StatusControls.getPeeLevel());
                poopBar.setProgress(StatusControls.getPooLevel());
                sleepBar.setProgress(StatusControls.getRestLevel());


                bankAmount.setText("$" + BankControls.getMoney());
                imageView.setImageResource(Utils.setHappinessImage());
                Death death = new Death();
                death.isDead();

                handler.postDelayed(handlerTask, speed);
            }
        };
        handlerTask.run();
    }

    @Bind(R.id. update_text)
    TextView updateText;

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

    @Bind(R.id.display_name)
    TextView name;

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        calendar = Calendar.getInstance();
        ButterKnife.bind(this);

        flow = PeopleGatchiApplication.getMainFlow();

        name.setText(StatusControls.getName());

        StatusControls.firstRun();

        if(!runningTimer) {
            startTimer();
        }

        updateScreen();


        bankAmount.setText("$" + BankControls.getMoney());

        imageView.setImageResource(Utils.setHappinessImage());
        calendar = Calendar.getInstance();
        setClock(clock);
    }

    @OnClick(R.id.food_bar)
    public void feedPet(){
        int foodAmount = Utils.getRand(StatusControls.getHungerLevel());
        StatusControls.setHunger(foodAmount);
        updateMessage = "BELCH!! Whew, i'm stuffed!!! \n Your food level has increased by: " + foodAmount;
    }

    @OnClick(R.id.drink_bar)
    public void waterPet(){
        int drinkAmount = Utils.getRand(StatusControls.getThirstLevel());
        StatusControls.setThirst(drinkAmount);
        updateMessage = "Slurp slurp, mmmm! \n Your Thirst level has increased by: " + drinkAmount;
    }

    @OnClick(R.id.sleep_bar)
    public void restPet(){
        int sleepyTime = Utils.getRand(StatusControls.getRestLevel());
        StatusControls.setRest(sleepyTime);
        updateMessage = "Whew, I feel rested and ready! \n your Sleep level has increased by: " + sleepyTime;
    }

    @OnClick(R.id.image_view)
    public void happinessView() {

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet() {
        int cleanBaby = Utils.getRand(StatusControls.getHygieneLevel());
        StatusControls.setHygiene(cleanBaby);
        if (cleanBaby == 20) {
            updateMessage = "You cant get any cleaner..!";
        } else {
            updateMessage = "Yay, so fresh and so clean clean!! \n your Hygiene level has increased by: " + cleanBaby;
        }
    }

    @OnClick(R.id.pee_bar)
    public void drainPet(){
        int drainPet = Utils.getRand(StatusControls.getPeeLevel());
        StatusControls.setPeeBladder(drainPet);
        updateMessage = "Yay, we made a pee-pee, Yay!!! \n your pee-pee level has been relieved by: " + drainPet;
    }

    @OnClick(R.id.poop_bar)
    public void pottyPet(){
        int dumpSize = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(dumpSize);
        if(dumpSize == 20){
            updateMessage = "HOLY COW, You just dropped a bigfoot!!! And now you're dead. \n your poo level has been relieved by: " + dumpSize;
        } else {
            Toast.makeText(context, "That was a sweet sweet #2! " + dumpSize, Toast.LENGTH_SHORT).show();
            //       Status.poo(dumpSize);
        }
        // StatusControls.updatePooBladder(dumpSize);
    }

    // TODO does this need to be in here. It's probably my fault that it exist.
    @OnClick(R.id.bank_amount)
    public void bankTotal() {

    }

    @OnClick(R.id.fastforward_button)
    public void increaseTime() {
        speed = 100;
    }

    @OnClick(R.id.clock)
    public void clock() {
        speed = 400;

    }

    @OnClick(R.id.store_button)
    public void goToStore() {

        final StoreDialog storeDialog = new StoreDialog(context);
        storeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        storeDialog.show();
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


    }

    @OnClick(R.id.education_button)
    public void goToSchool() {
        History newHistory = flow.getHistory().buildUpon().push(new EducationStage()).build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);

    }

    @OnClick(R.id.work_button)
    public void goToWork() {
        History newHistory = flow.getHistory().buildUpon().push(new JobStage()).build();
        flow.setHistory(newHistory, Flow.Direction.FORWARD);

    }

    public void updateScreen(){
        bankAmount.setText("$"+ BankControls.getMoney());
        imageView.setImageResource(Utils.setHappinessImage());

    }



    public void setClock(TextView clock) {
        this.clock = clock;
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        calendar.add(Calendar.MINUTE, 1);
        date = dateFormat.format(calendar.getTime());
        clock.setText(date);

    }
}
