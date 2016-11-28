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

public class InventoryDialog extends Dialog {

    String[] from = {"resource", "name"};
    Item[] items;
    int[] to = {R.id.inventory_img, R.id.inventory_name};
    SimpleAdapter adapter;
    private Context context;

    @Bind(inventory_grid)
    GridView gridView;

    public InventoryDialog(Context context) {

        super(context);
        this.context = context;
    }

    /*
    Sets up the dialog to show the items in the inventory in the proper GridView
     */
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
                Toast.makeText(context, "You consumed " + items[i].getName(), Toast.LENGTH_SHORT).show();
                String itemConsumed = items[i].getName();
                Utils.shelterAdjustment(itemConsumed);
                Utils.adjustedStatus();
                InventoryControls.useItem(context, items[i]);
                refreshItems();
            }
        });
    }

    /*
    Takes the updated items list for the users inventory and updates the adapter to display the
    correct information in the GridView for the user.
     */
    private void refreshItems() {

        items = InventoryControls.getInventory().toArray(new Item[InventoryControls.getInventory().size()]);
        adapter = new SimpleAdapter(context, Utils.inventoryHashMap(items), R.layout.inventory_item, from, to);
        gridView.setAdapter(adapter);
    }
}
