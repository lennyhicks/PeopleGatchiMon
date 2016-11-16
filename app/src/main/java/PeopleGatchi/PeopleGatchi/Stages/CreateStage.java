package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class CreateStage extends IndexedStage {
    public final SlideRigger rigger;

    public CreateStage(Application context){
        super(CreateStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public CreateStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.create_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}

