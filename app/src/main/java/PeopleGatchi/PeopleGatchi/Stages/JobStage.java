package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class JobStage extends IndexedStage {
    public final SlideRigger rigger;

    public JobStage(Application context){
        super(JobStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public JobStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.job_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
