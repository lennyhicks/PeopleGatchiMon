package com.PeopleGatchi.Views;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
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
    private Handler handlers;
    private Handler handler;
    private Runnable handlerTasks;
    public static Calendar calendar;
    public Integer speed = 500;


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

    @Bind(R.id.character_iv)
    ImageView charImg;


    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    /*
    Generates user name from registration / login screen to display on Main Screen.
    Shows the user how much money they currently have.
    Sets specific happiness image based on current progress bar status.
    Displays clock.
     */
    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        calendar = Calendar.getInstance();
        ButterKnife.bind(this);
        flow = PeopleGatchiApplication.getMainFlow();
        name.setText(StatusControls.getName());
        StatusControls.setGender(StatusControls.getGender());

//        switch (StatusControls.getGender()) {
//            case "cis female":
//                charImg.setBackground(context.getResources().getDrawable(R.drawable.female_blink));
//                break;
//            case "cis male":
//                charImg.setBackground(context.getResources().getDrawable(R.drawable.male_blink));
//                break;
//            case "non-conforming":
//                charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_blink));
//                break;
//            default:
//                charImg.setImageResource(R.drawable.hp_cat);
//        }

//        ((AnimationDrawable) charImg.getBackground()).start();

        StatusControls.firstRun();
        startTimer();
        updateText();
        updateScreen();
        bankAmount.setText("$" + BankControls.getMoney());
        calendar = Calendar.getInstance();
        setClock(clock);
        defaultImage();
    }


    /*
    Runnable that checks progress bar status every 500 milliseconds (.5 seconds).
     */
    void startTimer() {

        handlers = new Handler();
        handlerTasks = new Runnable() {

            @Override
            public void run() {

                setClock(clock);
                if (calendar.get(Calendar.MINUTE) % 30 == 0) {
                    decreaseStats();
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

                handlers.postDelayed(handlerTasks, speed);
            }
        };
        handlerTasks.run();
    }

    /*
    Declares foodAmount as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.food_bar)
    public void feedPet() {

        int foodAmount = Utils.getRand(StatusControls.getHungerLevel());
        StatusControls.setHunger(foodAmount);
        StatusControls.setPooBladder(-foodAmount / 2);
        StatusControls.setRest(-foodAmount / 3);
        StatusControls.setHygiene(-foodAmount / 3);
        if (foodAmount == 20) {
            updateMessage = "Your stomach thanks you, but now you may need to use the bathroom and sleep. Don't forget to wash your hands!";
        } else {
            updateMessage = "Beeelch!! Uhg, I'm stuffed..";
        }
        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_eat));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_eat));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_eat));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    /*
    Declares waterPet as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.drink_bar)
    public void waterPet() {

        int drinkAmount = Utils.getRand(StatusControls.getThirstLevel());
        StatusControls.setThirst(drinkAmount);
        StatusControls.setPeeBladder(-drinkAmount / 2);
        StatusControls.setHygiene(-drinkAmount / 3);
        if (drinkAmount == 20) {
            updateMessage = "Your thirst has been quenched, but now you may need to use the bathroom. Don't forget to wash your hands!";
        } else {
            updateMessage = "Slurp, Slurp, Mmmm..";
        }
        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_drink));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_drink));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_drink));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    /*
    Declares restPet as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.sleep_bar)
    public void restPet() {

        int sleepyTime = Utils.getRand(StatusControls.getRestLevel());
        StatusControls.setRest(sleepyTime);
        StatusControls.setHunger(-sleepyTime / 3);
        StatusControls.setThirst(-sleepyTime / 3);
        StatusControls.setPooBladder(-sleepyTime / 3);
        StatusControls.setPeeBladder(-sleepyTime / 3);
        StatusControls.setHygiene(-sleepyTime / 3);
        if (sleepyTime == 20) {
            updateMessage = "You're now well rested but, there are probably a few other things that need your attention too!";
        } else {
            updateMessage = "Yawn.. That was a good nap.";
        }
        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_sleep));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_sleep));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_sleep));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    /*
    Declares cleanPet as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.hygiene_bar)
    public void cleanPet() {

        int cleanBaby = Utils.getRand(StatusControls.getHygieneLevel());
        StatusControls.setHygiene(cleanBaby);
        StatusControls.setHunger(-cleanBaby / 3);
        StatusControls.setThirst(-cleanBaby / 3);
        StatusControls.setRest(-cleanBaby / 3);
        if (cleanBaby == 20) {
            updateMessage = "You cant get any cleaner..!";
        } else {
            updateMessage = "Yay, so fresh and so clean clean!!";
        }
        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_bathe));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_bathe));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_bathe));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    /*
    Declares drainPet as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.pee_bar)
    public void drainPet() {

        int drainPet = Utils.getRand(StatusControls.getPeeLevel());
        StatusControls.setPeeBladder(drainPet);
        StatusControls.setThirst(-drainPet / 2);
        StatusControls.setHygiene(-drainPet / 3);
        if (drainPet == 20) {
            updateMessage = "Your pee bladder thanks you, but you may now be thirsty. Don't forget to wash your hands!";
        } else {
            updateMessage = "Whew, my eyes were floating!";
        }
        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_pee));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_pee));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_pee));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    /*
    Declares pottyPet as a variable that generates a random number to decrease status bars.
    Displays message in a text view.
     */
    @OnClick(R.id.poop_bar)
    public void pottyPet() {

        int dumpSize = Utils.getRand(StatusControls.getPooLevel());
        StatusControls.setPooBladder(dumpSize);
        StatusControls.setHunger(-dumpSize / 2);
        StatusControls.setHygiene(-dumpSize / 3);
        if (dumpSize == 20) {
            updateMessage = "Holy Cow! That was a sweet sweet #2!! However, now you're getting hungry. Don't forget to wash your hands!";
        } else {
            updateMessage = "Your poo bladder thanks you, but now you may be hungry. Don't forget to wash your hands!";
        }

        updateText();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (StatusControls.getGender()) {
                    case "cis female":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.female_poo));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "cis male":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.male_poo));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    case "non-conforming":
                        charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_poo));
                        ((AnimationDrawable) charImg.getBackground()).start();
                        break;
                    default:
                        charImg.setImageResource(R.drawable.hp_cat);
                }
            }
        }, 500);
        ((AnimationDrawable) charImg.getBackground()).stop();
        defaultImage();
    }

    @OnClick(R.id.fastforward_button)
    public void increaseTime() {
        handlers.removeCallbacks(handlerTasks);
        speed = 250;
        startTimer();
    }

    @OnClick(R.id.clock)
    public void clock() {
        handlers.removeCallbacks(handlerTasks);
        speed = 500;
        startTimer();
    }

    /*
    Opens the store dialog interface.
     */
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

    /*
    Opens inventory dialog interface.
     */
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

    public void updateScreen() {
        //Updates text view on the main screen to show current balance, and updates happiness icon.
        bankAmount.setText("$" + BankControls.getMoney());
        imageView.setImageResource(Utils.setHappinessImage());
    }

    /*
    Sets the format for the clock.
     */
    public void setClock(TextView clock) {

        this.clock = clock;
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        calendar.add(Calendar.MINUTE, 1);
        date = dateFormat.format(calendar.getTime());
        clock.setText(date);
    }

    /*
    Being referenced from progress bar methods to update text view for message purposes.
    Also sets a 5000 millisecond timer (5 seconds) for the message to disappear.
     */
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

    /*
    Decreases progress bars by 2 points for each time user clicks education, or work.
     */
    public static void workSchoolDay() {

        StatusControls.setHunger(-2);
        StatusControls.setThirst(-2);
        StatusControls.setPeeBladder(-2);
        StatusControls.setPooBladder(-2);
        StatusControls.setHygiene(-2);
        StatusControls.setRest(-2);
    }

    /*
    Decreases the stats of the user depending on what their stats are already at.  If they have
    a status bar that is at 0 all other stats go down quicker than if they did not have a bar at 0.
     */
    private void decreaseStats() {
        if ((StatusControls.getHungerLevel() <= 0)
                || (StatusControls.getPooLevel() <= 0)
                || (StatusControls.getPeeLevel() <= 0)
                || (StatusControls.getHygieneLevel() <= 0)
                || (StatusControls.getThirstLevel() <= 0)
                || (StatusControls.getRestLevel() <= 0)) {

            StatusControls.setHunger(-3);
            StatusControls.setThirst(-3);
            StatusControls.setHygiene(-3);
            StatusControls.setRest(-3);
            StatusControls.setPeeBladder(-3);
            StatusControls.setPooBladder(-3);
        } else {

            StatusControls.setHunger(-1);
            StatusControls.setThirst(-1);
            StatusControls.setHygiene(-1);
            StatusControls.setRest(-1);
            StatusControls.setPeeBladder(-1);
            StatusControls.setPooBladder(-1);
        }
    }

    public void defaultImage() {
        switch (StatusControls.getGender()) {
            case "cis female":
                charImg.setBackground(context.getResources().getDrawable(R.drawable.female_blink));
                ((AnimationDrawable) charImg.getBackground()).start();
                break;
            case "cis male":
                charImg.setBackground(context.getResources().getDrawable(R.drawable.male_blink));
                ((AnimationDrawable) charImg.getBackground()).start();
                break;
            case "non-conforming":
                charImg.setBackground(context.getResources().getDrawable(R.drawable.snowflake_blink));
                ((AnimationDrawable) charImg.getBackground()).start();
                break;
            default:
                charImg.setImageResource(R.drawable.hp_cat);
        }
    }

    @OnClick(R.id.character_iv)
    public void charImg() {
        defaultImage();
    }
}

