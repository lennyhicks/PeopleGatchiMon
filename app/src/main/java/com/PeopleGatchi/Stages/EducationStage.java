package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Riggers.SlideRigger;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class EducationStage extends IndexedStage {
    public final SlideRigger rigger;

    public EducationStage(Application context){
        super(EducationStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public EducationStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.education_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
