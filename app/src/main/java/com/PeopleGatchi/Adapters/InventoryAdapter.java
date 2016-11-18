package com.PeopleGatchi.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by crystaladkins on 11/17/16.
 */

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.Items> {

    public ArrayList<Item> messages;
    private Context context;
    public static Item messageView;

    public InventoryAdapter(ArrayList<Item> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }


    @Override
    public void onBindViewHolder(final Items holder, int position) {
        Item message = messages.get(position);
        holder.bindCategory(message);
    }

    @Override
    public Items onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_item, parent, false);
        return new Items(inflatedView);
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }

    class Items extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.inventory_img)
        ImageView imageView;

        @Bind(R.id.inventory_name)
        TextView nameField;

        @Bind(R.id.price_textview)
        TextView messageCount;

        public Items(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        public void bindCategory(Item message) {

            imageView.setImageResource(R.drawable.cheburashka);
            nameField.setText("NAMEFIELD");
            messageCount.setText("PRICE");

        }


        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Clicked " + nameField.getText().toString(), Toast.LENGTH_SHORT).show();

        }

    }
}