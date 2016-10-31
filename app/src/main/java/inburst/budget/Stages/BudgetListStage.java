package inburst.budget.Stages;

import android.app.Application;

import inburst.budget.BudgetApplication;
import inburst.budget.R;
import inburst.budget.Riggers.SlideRigger;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class BudgetListStage extends IndexedStage {

    public final SlideRigger rigger;

    public BudgetListStage(Application context){
        super(BudgetListStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public BudgetListStage(){
        this(BudgetApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.budget_list_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
