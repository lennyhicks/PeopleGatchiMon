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

    void startTimer() {
        handler = new Handler();
        handlerTask = new Runnable() {
            @Override
            public void run() {
                foodBar.setProgress(StatusControls.getHungerLevel());
                drinkBar.setProgress(StatusControls.getThirstLevel());
                hygieneBar.setProgress(StatusControls.getHygieneLevel());
                peeBar.setProgress(StatusControls.getPeeLevel());
                poopBar.setProgress(StatusControls.getPooLevel());
                sleepBar.setProgress(StatusControls.getRestLevel());
                bankAmount.setText("Bank: $" + BankControls.getMoney());
                imageView.setImageResource(Utils.setHappinessImage());
                Death death = new Death();
                death.isDead();
                handler.postDelayed(handlerTask, 200);
            }
        };
        handlerTask.run();
    }

    @Bind(R.id.update_text)
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
        ButterKnife.bind(this);

        flow = PeopleGatchiApplication.getMainFlow();

        name.setText(StatusControls.getName());

        StatusControls.firstRun();

        startTimer();
        updateScreen();


        bankAmount.setText("$" + BankControls.getMoney());

        imageView.setImageResource(Utils.setHappinessImage());

        setClock(clock);
    }

    @OnClick(R.id.food_bar)
    public void feedPet() {
        int foodAmount = Utils.getRand(StatusControls.getHungerLevel());
        StatusControls.setHunger(foodAmount);
        StatusControls.setPooBladder(-foodAmount/2);
        StatusControls.setRest(-foodAmount/3);
        StatusControls.setHygiene(-foodAmount/3);
        updateMessage = "Your stomach thanks you, but now you may need to use the bathroom and sleep. Don't forget to wash your hands!";
        updateText();
    }

    @OnClick(R.id.drink_bar)
    public void waterPet() {
        int drinkAmount = Utils.getRand(StatusControls.getThirstLevel());
        StatusControls.setThirst(drinkAmount);
        StatusControls.setPeeBladder(-drinkAmount/2);
        StatusControls.setHygiene(-drinkAmount/3);
        updateMessage = "Your thirst has been quenched, but now you may need to use the bathroom. Don't forget to wash your hands!";
        updateText();
    }

    @OnClick(R.id.sleep_bar)
    public void restPet() {
        int sleepyTime = Utils.getRand(StatusControls.getRestLevel());
        StatusControls.setRest(sleepyTime);
        StatusControls.setHunger(-sleepyTime/2);
        StatusControls.setThirst(-sleepyTime/2);
        StatusControls.setPooBladder(-sleepyTime/3);
        StatusControls.setPeeBladder(-sleepyTime/3);
        StatusControls.setHygiene(-sleepyTime/3);
        updateMessage = "You're now well rested but, there are probably a few other things that need your attention too!";
        updateText();
    }

    @OnClick(R.id.image_view)
    public void happinessView() {

    }

    @OnClick(R.id.hygiene_bar)
    public void cleanPet() {
        int cleanBaby = Utils.getRand(StatusControls.getHygieneLevel());
        StatusControls.setHygiene(cleanBaby);
        StatusControls.setPooBladder(-cleanBaby/3);
        StatusControls.setHunger(-cleanBaby/3);
        StatusControls.setThirst(-cleanBaby/3);
        StatusControls.setRest(-cleanBaby/3);
        if (cleanBaby == 20) {
            updateMessage = "You cant get any cleaner..!";
        } else {
            updateMessage = "Yay, so fresh and so clean clean!!";
        }
        updateText();
    }

    @OnClick(R.id.pee_bar)
    public void drainPet() {
        int drainPet = Utils.getRand(StatusControls.getPeeLevel());
        StatusControls.setPeeBladder(drainPet);
        StatusControls.setThirst(-drainPet/2);
        StatusControls.setHygiene(-drainPet/3);
        updateMessage = "Your pee bladder thanks you, but you may now be thirsty. Don't forget to wash your hands!";
        updateText();
    }

    @OnClick(R.id.poop_bar)
    public void pottyPet() {
        int dumpSize = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(dumpSize);
        StatusControls.setHunger(-dumpSize/2);
        StatusControls.setHygiene(-dumpSize/3);
        if (dumpSize == 20) {
            updateMessage = "Holy Cow! That was a sweet sweet #2!! However, now you're getting hungry. Don't forget to wash your hands!";
        } else {
            updateMessage = "Your poo bladder thanks you, but now you may be hungry. Don't forget to wash your hands!";
            //       Status.poo(dumpSize);
        }
        updateText();
        // StatusControls.updatePooBladder(dumpSize);
    }

    // TODO does this need to be in here. It's probably my fault that it exist.
    @OnClick(R.id.bank_amount)
    public void bankTotal() {

    }

    @OnClick(R.id.fastforward_button)
    public void increaseTime() {

    }

    @OnClick(R.id.clock)
    public void clock() {

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
    public void goToInventory() {
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

    public void printBank() {
        bankAmount.setText("Bank Balance: $" + BankControls.getMoney() + ".");
    }

    public void updateScreen() {
        bankAmount.setText("$" + BankControls.getMoney());
        imageView.setImageResource(Utils.setHappinessImage());

    }


    public void setClock(TextView clock) {
        this.clock = clock;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        calendar.add(Calendar.HOUR, 1);
        calendar.add(Calendar.MINUTE, 30);
        date = dateFormat.format(calendar.getTime());
        clock.setText(date);

    }

    public void updateText() {
        updateText.setText(updateMessage);


        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateText.setText(null);
            }
        }, 5000);
    }

    public static void workSchoolDay (){
        StatusControls.setHunger(-2);
        StatusControls.setThirst(-2);
        StatusControls.setPeeBladder(-2);
        StatusControls.setPooBladder(-2);
        StatusControls.setHygiene(-2);
        StatusControls.setRest(-2);
    }
}

//        handler = new Handler();
//        handlerTask = new Runnable()
//        {
//            @Override
//            public void run() {
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        updateText.setText(null);
//                    }
//                }, 5000);
//
//              //  updateText.setText(null);
//
//            }
//        };
//        handlerTask.run();
//    }

