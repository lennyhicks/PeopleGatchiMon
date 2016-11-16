package PeopleGatchi.PeopleGatchi;

import android.app.Application;

import PeopleGatchi.PeopleGatchi.Stages.BudgetListStage;
import flow.Flow;
import flow.History;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class PeopleGatchiApplication extends Application {
    private static PeopleGatchiApplication application;
    public final Flow mainFlow = new Flow(History.single(new BudgetListStage()));
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
        return  getInstance().mainFlow;
    }


}
