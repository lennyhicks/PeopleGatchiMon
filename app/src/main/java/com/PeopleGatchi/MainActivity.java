package com.PeopleGatchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.PeopleGatchi.Stages.CreateStage;
import com.PeopleGatchi.Stages.HomeStage;
import com.PeopleGatchi.Utils.StatusControls;
import com.PeopleGatchi.Utils.TimeControls;
import com.davidstemmer.flow.plugin.screenplay.ScreenplayDispatcher;
import com.orm.SugarContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import flow.Flow;
import flow.History;

import static com.PeopleGatchi.R.layout.activity_main;
import static com.PeopleGatchi.Views.HomeView.calendar;

public class MainActivity extends AppCompatActivity {

    private Flow flow;
    private ScreenplayDispatcher dispatcher;
    public static SharedPreferences peoplegatchiPrefs;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
    private Context context;

    @Bind(R.id.container)
    RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        peoplegatchiPrefs = getPreferences(Context.MODE_PRIVATE);

        setContentView(activity_main);

        ButterKnife.bind(this);

        SugarContext.init(getApplicationContext());

        Date date = new Date();
        dateFormat.format(date);

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

            calendar.set(Calendar.HOUR, 1);
            calendar.set(Calendar.MINUTE, 00);

            StatusControls.firstRun();

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
        TimeControls.getTime();

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


}


