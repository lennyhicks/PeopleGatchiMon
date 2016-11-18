package com.PeopleGatchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.PeopleGatchi.Stages.CreateStage;
import com.PeopleGatchi.Stages.HomeStage;
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
    private SharedPreferences peoplegatchiPrefs;

    @Bind(R.id.container)
    RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        peoplegatchiPrefs = getPreferences(Context.MODE_PRIVATE);

        setContentView(activity_main);

        ButterKnife.bind(this);

        SugarContext.init(getApplicationContext());

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
}


