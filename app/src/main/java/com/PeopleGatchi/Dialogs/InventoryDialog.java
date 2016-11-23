package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Utils.InventoryControls;
import com.PeopleGatchi.Utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.PeopleGatchi.R.id.inventory_grid;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class InventoryDialog extends Dialog{

    @Bind(inventory_grid)
    GridView gridView;
    String[] from = { "resource","name"};
    Item[] items;
    int[] to = { R.id.inventory_img,R.id.inventory_name};
    SimpleAdapter adapter;

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


        refreshItems();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "You tapped " + items[i].getName(), Toast.LENGTH_SHORT).show();
                Utils.adjustedStatus();
                InventoryControls.useItem(items[i]);
                refreshItems();
            }
        });
    }

    private void refreshItems(){
        items = InventoryControls.getInventory().toArray(new Item[InventoryControls.getInventory().size()]);
        adapter = new SimpleAdapter(context, Utils.inventoryHashMap(items), R.layout.inventory_item, from, to);
        gridView.setAdapter(adapter);
    }
}
