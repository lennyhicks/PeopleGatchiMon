package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.PeopleGatchi.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class InventoryDialog extends Dialog{




    public InventoryDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.inventory_view);

        ButterKnife.bind(this);


        }

    @OnClick(R.id.inventory_img)
    public void itemSelected () {

    }


//    ImageAdapter adapter = new ImageAdapter(this, home_res);
//
//    gameGrid.setAdapter(adapter);

}
