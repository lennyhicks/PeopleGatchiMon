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

import butterknife.Bind;
import butterknife.ButterKnife;
import flow.Flow;
import flow.History;

import static com.PeopleGatchi.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private Flow flow;
    private ScreenplayDispatcher dispatcher;
    public static SharedPreferences peoplegatchiPrefs;
    private Handler handler;
    private Runnable handlerTask;

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

                    StatusControls.setHunger(-2);
                    StatusControls.setThirst(-2);
                    StatusControls.setHygiene(-2);
                    StatusControls.setRest(-2);
                    StatusControls.setPeeBladder(-2);
                    StatusControls.setPooBladder(-2);
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
}


