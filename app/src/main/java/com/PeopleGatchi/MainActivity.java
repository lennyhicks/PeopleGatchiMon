package com.PeopleGatchi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.PeopleGatchi.Network.UserStore;
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
    private Menu menu;

    @Bind(R.id.container)
    RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(activity_main);

        ButterKnife.bind(this);

        SugarContext.init(getApplicationContext());

        try {
            flow = PeopleGatchiApplication.getMainFlow();
        } catch (Exception e) {

        }
        dispatcher = new ScreenplayDispatcher(this, container);
        dispatcher.setUp(flow);

        if(UserStore.getInstance().getToken() == null){

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

    //It's your boy the menu button! I made it a little star!
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        this.menu = menu;
        return true;
    }


}


