package com.PeopleGatchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.PeopleGatchi.Stages.CreateStage;
import com.PeopleGatchi.Stages.HomeStage;
import com.PeopleGatchi.Utils.StatusControls;
import com.davidstemmer.flow.plugin.screenplay.ScreenplayDispatcher;
import com.orm.SugarContext;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import flow.Flow;
import flow.History;

import static com.PeopleGatchi.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private Flow flow;
    private ScreenplayDispatcher dispatcher;
    private SharedPreferences peoplegatchiPrefs;
    private Handler handler;
    private Runnable handlerTask;
    private Long leaveGameTime;

    @Bind(R.id.container)
    RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        peoplegatchiPrefs = getPreferences(Context.MODE_PRIVATE);

        setContentView(activity_main);

        ButterKnife.bind(this);

        SugarContext.init(getApplicationContext());
        StatusControls.firstRun();

        decreaseStats();

        try {
            flow = PeopleGatchiApplication.getMainFlow();
        } catch (Exception e) {

        }
        dispatcher = new ScreenplayDispatcher(this, container);
        dispatcher.setUp(flow);

        if (peoplegatchiPrefs.getBoolean("firstRun", true)) {

            SharedPreferences.Editor editor = peoplegatchiPrefs.edit();
            editor.putBoolean("firstRun", false);
            editor.apply();

            History newHistory = History.single(new CreateStage());
            flow.setHistory(newHistory, Flow.Direction.REPLACE);
        } else {
            History newHistory = History.single(new HomeStage());
            flow.setHistory(newHistory, Flow.Direction.REPLACE);
        }
    }

    @Override
    public void onBackPressed(){
        if (!flow.goBack()){
            flow.removeDispatcher(dispatcher);
            flow.setHistory(History.single(new PeopleGatchiApplication()), Flow.Direction.BACKWARD);
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        SugarContext.terminate();
        super.onDestroy();
    }

    public void decreaseStats(){
       // newMethod();
        handler = new Handler();
            handlerTask = new Runnable()
            {
                @Override
                public void run() {

                    StatusControls.setHunger(-20);
                    StatusControls.setThirst(-20);
                    StatusControls.setHygiene(-20);
                    StatusControls.setRest(-20);
                    StatusControls.setPeeBladder(-20);
                    StatusControls.setPooBladder(-20);
                    handler.postDelayed(handlerTask, 2000);
                }
            };
            handlerTask.run();
    }
    public void newMethod(){
        if(StatusControls.getHungerLevel() < 0){
            //placeholderMethod();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        leaveGameTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss a");
        String newFormat = formatter.format(leaveGameTime);

        checkLevels();
    }

    public void checkLevels(){
        //TODO make this work!
        // when the status bar gets to 5, it should be a warning.
        int restTime = 5 - StatusControls.getRestLevel();
        int feedTime = 5 - StatusControls.getHungerLevel();
        int bathTime = 5 - StatusControls.getHygieneLevel();
        int drinkTime = 5 - StatusControls.getThirstLevel();
        int peeTime = 5 - StatusControls.getPeeLevel();
        int pooTime = 5 - StatusControls.getPooLevel();

    }
}