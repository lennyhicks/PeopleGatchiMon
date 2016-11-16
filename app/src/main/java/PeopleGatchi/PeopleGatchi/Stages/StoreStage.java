package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class StoreStage extends IndexedStage {
    public final SlideRigger rigger;

    public StoreStage(Application context){
        super(StoreStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public StoreStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.store_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
