package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Riggers.SlideRigger;

import com.PeopleGatchi.R;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class CreateStage extends IndexedStage {

    /*
    Stage needed by screenplay to create flow to the Create View
     */

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

