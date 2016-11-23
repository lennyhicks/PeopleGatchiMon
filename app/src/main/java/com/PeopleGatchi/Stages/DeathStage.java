package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Riggers.FadeRigger;

/**
 * Created by eaglebrosi on 11/21/16.
 */

public class DeathStage extends IndexedStage {
    public final FadeRigger rigger;

    public DeathStage(Application context){
        super(DeathStage.class.getName());
        this.rigger = new FadeRigger(context);
    }

    public DeathStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.death_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
