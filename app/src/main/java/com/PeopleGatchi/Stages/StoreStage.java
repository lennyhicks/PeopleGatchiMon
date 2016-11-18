package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Riggers.SlideRigger;

import com.PeopleGatchi.R;

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
