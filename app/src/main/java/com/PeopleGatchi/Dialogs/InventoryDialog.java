package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;

import com.PeopleGatchi.Adapters.InventoryAdapter;
import com.PeopleGatchi.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class InventoryDialog extends Dialog{

    @Bind(R.id.inventory_grid)
    GridView gridView;

    public int [] images = {R.drawable.cat, R.drawable.cheburashka, R.drawable.hachiko};
    private Context context;


    public InventoryDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.inventory_view);

        ButterKnife.bind(this);



        InventoryAdapter adapter = new InventoryAdapter(context, images);

         gridView.setAdapter(adapter);


        }

    @OnClick(R.id.inventory_img)
    public void itemSelected () {

    }

}
