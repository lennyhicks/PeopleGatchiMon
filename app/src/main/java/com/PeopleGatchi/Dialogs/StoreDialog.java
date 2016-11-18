package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import com.PeopleGatchi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class StoreDialog extends Dialog{

    //@Bind(R.id.drinkRecyclerView)
    //RecyclerView drinkRecycler;
    String[] from = { "flag","txt"};

    @Bind(R.id.storeTabHost)
    TabHost tabs;


    String[] countries = new String[] {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10"

    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.cat,
            R.drawable.cheburashka,
            R.drawable.stomach,
            R.drawable.cheburashka,
            R.drawable.cat,
            R.drawable.cheburashka,
            R.drawable.stomach,
            R.drawable.cheburashka,
            R.drawable.cat,
            R.drawable.cheburashka
    };
    public int [] images = {R.drawable.cat, R.drawable.cheburashka, R.drawable.hachiko};
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

        List<HashMap<String,String>> aList = new ArrayList<>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

tabs.setup();

        TabHost.TabSpec calculatorTab = tabs.newTabSpec("food");
        calculatorTab.setContent(R.id.food);
        calculatorTab.setIndicator("Food");
        tabs.addTab(calculatorTab);

//        // Home
        TabHost.TabSpec homeTab = tabs.newTabSpec("drinks");
        homeTab.setContent(R.id.drinks);
        homeTab.setIndicator("Drinks");
        tabs.addTab(homeTab);

        // Home
        TabHost.TabSpec faqTab = tabs.newTabSpec("items");
        faqTab.setContent(R.id.items);
        faqTab.setIndicator("Items");
        tabs.addTab(faqTab);


        int[] to = { R.id.inventory_img,R.id.inventory_name};
        //SimpleAdapter adapter = new SimpleAdapter(context, aList, R.layout.inventory_item, from, to);
        //gridView.setAdapter(adapter);


//        InventoryAdapter adapter = new InventoryAdapter(new ArrayList<Item>(),context);
//        gridView.setAdapter(adapter);



        }


}
