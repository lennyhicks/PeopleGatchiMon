package PeopleGatchi.PeopleGatchi.Stages;

import android.app.Application;

import PeopleGatchi.PeopleGatchi.PeopleGatchiApplication;
import PeopleGatchi.PeopleGatchi.R;
import PeopleGatchi.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class HomeStage extends IndexedStage {
    public final SlideRigger rigger;

    public HomeStage(Application context){
        super(HomeStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public HomeStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
