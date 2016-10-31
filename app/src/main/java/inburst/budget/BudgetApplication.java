package inburst.budget;

import android.app.Application;

import flow.Flow;
import flow.History;
import inburst.budget.Stages.BudgetListStage;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class BudgetApplication extends Application {
    private static BudgetApplication application;

    public final Flow mainFlow = new Flow(History.single(new BudgetListStage()));


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static BudgetApplication getInstance() {
        return application;
    }

    public static Flow getMainFlow() {
        return  getInstance().mainFlow;
    }


}
