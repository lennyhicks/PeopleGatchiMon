package com.PeopleGatchi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.PeopleGatchi.Network.UserStore;
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

    @Bind(R.id.container)
    RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);

        ButterKnife.bind(this);

        SugarContext.init(getApplicationContext());
        StatusControls.firstRun();

        try {
            flow = PeopleGatchiApplication.getMainFlow();
        } catch (Exception e) {

        }
        dispatcher = new ScreenplayDispatcher(this, container);
        dispatcher.setUp(flow);

        if(UserStore.getInstance().getToken() == null || UserStore.getInstance().getTokenExpiration() == null){

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
}


