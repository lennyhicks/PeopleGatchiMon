package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Riggers.SlideRigger;
import com.davidstemmer.screenplay.stage.Stage;

import com.PeopleGatchi.R;

/**
 * Created by lennyhicks on 10/31/16.
 */
public class RegisterStage extends IndexedStage{
    public final SlideRigger rigger;

    public RegisterStage(Application context){
        super(RegisterStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public RegisterStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.register_view;
    }

    @Override
    public Stage.Rigger getRigger() {
        return rigger;
    }
}
