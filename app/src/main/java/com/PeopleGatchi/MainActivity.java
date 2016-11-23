package com.PeopleGatchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.PeopleGatchi.Stages.CreateStage;
import com.PeopleGatchi.Stages.HomeStage;
import com.PeopleGatchi.Utils.StatusControls;
import com.PeopleGatchi.Utils.TimeControls;
import com.davidstemmer.flow.plugin.screenplay.ScreenplayDispatcher;
import com.orm.SugarContext;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");

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

        Date date = new Date();
        dateFormat.format(date);
        TimeControls.setTime(date);
        Toast.makeText(this, "Meow Time: " + TimeControls.getTime(), Toast.LENGTH_SHORT).show();

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
    protected void onPause() {
        Date date = new Date();
        TimeControls.setTime(date);
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

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
       
        handler = new Handler();
            handlerTask = new Runnable()
            {
                @Override
                public void run() {

                    StatusControls.setHunger(-1);
                    StatusControls.setThirst(-1);
                    StatusControls.setHygiene(-1);
                    StatusControls.setRest(-1);
                    StatusControls.setPeeBladder(-1);
                    StatusControls.setPooBladder(-1);
                    handler.postDelayed(handlerTask, 15000);
                }
            };
            handlerTask.run();
    }
    public void newMethod(){
        if(StatusControls.getHungerLevel() < 0){
            //placeholderMethod();
        }
    }
}


