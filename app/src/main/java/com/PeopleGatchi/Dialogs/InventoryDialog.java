package com.PeopleGatchi.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.PeopleGatchi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.PeopleGatchi.R.id.inventory_grid;

/**
 * Created by crystaladkins on 11/16/16.
 */

public class InventoryDialog extends Dialog{

    @Bind(inventory_grid)
    GridView gridView;
    String[] from = { "flag","txt"};

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

    public InventoryDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.inventory_view);

        ButterKnife.bind(this);

        List<HashMap<String,String>> aList = new ArrayList<>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }


        int[] to = { R.id.inventory_img,R.id.inventory_name};
        SimpleAdapter adapter = new SimpleAdapter(context, aList, R.layout.inventory_item, from, to);
        gridView.setAdapter(adapter);


//        InventoryAdapter adapter = new InventoryAdapter(new ArrayList<Item>(),context);
//        gridView.setAdapter(adapter);



        }


}
