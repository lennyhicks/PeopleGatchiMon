package PeopleGatchi.PeopleGatchi.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Stages.EducationStage;
import PeopleGatchi.PeopleGatchi.Stages.JobStage;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flow.Flow;
import flow.History;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class HomeView extends LinearLayout {
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

        Toast.makeText(context, "Test", Toast.LENGTH_LONG).show();

        flow = PeopleGatchiApplication.getMainFlow();

        EventBus.getDefault().register(this);
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


    }

    @OnClick(R.id.inventory_button)
    public void goToInventory(){

    }

    @OnClick(R.id.education_button)
    public void goToSchool(){
        History newHistory = History.single(new EducationStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.work_button)
    public void goToWork(){
        History newHistory = History.single(new JobStage());
        flow.setHistory(newHistory, Flow.Direction.REPLACE);
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();

    }

}
