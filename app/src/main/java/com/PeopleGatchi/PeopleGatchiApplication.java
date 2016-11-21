package com.PeopleGatchi;

import android.app.Application;

import com.PeopleGatchi.Stages.HomeStage;

import flow.Flow;
import flow.History;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class PeopleGatchiApplication extends Application {
    private static PeopleGatchiApplication application;
    public final Flow mainFlow = new Flow(History.single(new HomeStage()));
    public static final String API_BASE_URL = "http://android301api.azurewebsites.net:80/";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }



    public static PeopleGatchiApplication getInstance() {
        return application;
    }

    public static Flow getMainFlow() {
        if (getInstance().mainFlow != null) {
            return getInstance().mainFlow;
        } else {
            return new Flow(History.single(new HomeStage()));
        }
    }


}
