package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;
import com.PeopleGatchi.Utils.BankControls;
import com.PeopleGatchi.Utils.InventoryControls;
import com.PeopleGatchi.Utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.PeopleGatchi.Components.Constants.DRINKITEMS;
import static com.PeopleGatchi.Components.Constants.FOODITEMS;
import static com.PeopleGatchi.Components.Constants.OTHERITEMS;
import static com.PeopleGatchi.R.id.food;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class StoreDialog extends Dialog{

    String[] from = { "resource","price","name"};

    @Bind(R.id.storeTabHost)
    TabHost tabs;

    @Bind(R.id.food_grid)
    GridView foodView;


    @Bind(R.id.drink_grid)
    GridView drinkView;


    @Bind(R.id.item_grid)
    GridView itemView;


    int[] to = { R.id.store_img,R.id.store_price,R.id.store_name};

    private Context context;

    public StoreDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.store_view);

        ButterKnife.bind(this);

        tabs.setup();

        TabHost.TabSpec foodTab = tabs.newTabSpec("food");
        foodTab.setContent(food);
        foodTab.setIndicator("Food");
        tabs.addTab(foodTab);

        SimpleAdapter foodAdapter = new SimpleAdapter(context, Utils.storeHashMap(FOODITEMS), R.layout.store_item, from, to);
        foodView.setAdapter(foodAdapter);
        foodView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = FOODITEMS[i];
                buyItem(item);
            }
        });

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                tabs.getTabWidget().setCurrentTab(2);
                tabs.bringToFront();
            }
        });
        final TabHost.TabSpec drinkTab = tabs.newTabSpec("drinks");
        drinkTab.setContent(R.id.drinks);
        drinkTab.setIndicator("Drinks");
        tabs.addTab(drinkTab);

        SimpleAdapter drinkAdapter = new SimpleAdapter(context, Utils.storeHashMap(DRINKITEMS), R.layout.store_item, from, to);
        drinkView.setAdapter(drinkAdapter);
        drinkView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = DRINKITEMS[i];
                buyItem(item);
            }
        });

        TabHost.TabSpec itemTab = tabs.newTabSpec("items");
        itemTab.setContent(R.id.items);
        itemTab.setIndicator("Items");
        tabs.addTab(itemTab);

        SimpleAdapter itemAdapter = new SimpleAdapter(context, Utils.storeHashMap(OTHERITEMS), R.layout.store_item, from, to);
        itemView.setAdapter(itemAdapter);
        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = OTHERITEMS[i];
                buyItem(item);
            }
        });

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s){
                    case "items" :
                        drinkView.setVisibility(View.GONE);
                        foodView.setVisibility(View.GONE);
                        itemView.setVisibility(View.VISIBLE);
                        break;
                    case "drinks" :
                        drinkView.setVisibility(View.VISIBLE);
                        foodView.setVisibility(View.GONE);
                        itemView.setVisibility(View.GONE);
                        break;
                    case "food" :
                        drinkView.setVisibility(View.GONE);
                        foodView.setVisibility(View.VISIBLE);
                        itemView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void buyItem(Item item){

        if (BankControls.getMoney() > item.getPrice()) {
            if (InventoryControls.getSize() < 40) {
                Toast.makeText(context, "You Bought: " + item.getName() + " Cost: " + item.getPrice(), Toast.LENGTH_SHORT).show();
            InventoryControls.addItem(item);
        } else {
                Toast.makeText(context, "Your Inventory is full.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "You do not have enough money.", Toast.LENGTH_SHORT).show();
        }
    }


}
