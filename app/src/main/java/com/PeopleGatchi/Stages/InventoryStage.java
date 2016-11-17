package com.PeopleGatchi.Stages;

import android.app.Application;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Riggers.SlideRigger;

import com.PeopleGatchi.R;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class InventoryStage extends IndexedStage {
    public final SlideRigger rigger;

    public InventoryStage(Application context){
        super(InventoryStage.class.getName());
        this.rigger = new SlideRigger(context);
    }

    public InventoryStage(){
        this(PeopleGatchiApplication.getInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.inventory_view;
    }

    @Override
    public Rigger getRigger() {
        return rigger;
    }
}
