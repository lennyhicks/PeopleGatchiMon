package com.PeopleGatchi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.PeopleGatchi.R;



/**
 * Created by crystaladkins on 11/17/16.
 */

public class InventoryAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater layoutInflater;
    public int[] images;


        public InventoryAdapter(Context context, int[] images) {
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
            this.images = images;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            View gridView;


            if (convertView == null) {

                gridView = new View(context);

                gridView = layoutInflater.inflate(R.layout.inventory_view, null);

                ImageView imageView = (ImageView) gridView.findViewById(R.id.inventory_img);

                int itemImages = images[position];

                imageView.setImageResource(itemImages);

            } else {
                gridView = (View) convertView;
            }

            return gridView;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }