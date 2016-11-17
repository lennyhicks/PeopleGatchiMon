package com.PeopleGatchi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.PeopleGatchi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**
 * Created by crystaladkins on 11/17/16.
 */

public class InventoryAdapter extends BaseAdapter {

    private ArrayList<Object> items;
    private LayoutInflater layoutInflater;
//    private SimpleDateFormat formatter;

    // Construct our custom adapter
    public InventoryAdapter(Context context, ArrayList<Object> object) {
        this.items = object;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
    }

    // Get the number of views we will need to inflate. Should be the size of our items array
    @Override
    public int getCount() {
        return items.size();
    }

    // Get the position in our array we are at
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Get the position of our item in the array
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    // Determine the amount of separate views our adapter will need to handle
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /*
    Determine the type of view being created and insert data
    */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

                convertView = layoutInflater.inflate(R.layout.inventory_item, parent, false);
        }

        GridView inventoryItem = (GridView) convertView.findViewById(R.id.inventory_grid);

            inventoryItem.//Need to figure out how to make things show up on the 



        return convertView;
    }
}