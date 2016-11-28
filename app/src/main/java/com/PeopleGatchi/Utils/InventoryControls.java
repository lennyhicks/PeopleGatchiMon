package com.PeopleGatchi.Utils;

import android.content.Context;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.Models.Persisting.Inventory;

import java.util.ArrayList;

/**
 * Created by lennyhicks on 11/19/16.
 */

public class InventoryControls {

    static Inventory inventory = new Inventory();

    /*
    Allows an item to be added to the users inventory if they have space left
     */
    public static void addItem(Item item){
        if(inventory.inventory.size() < 40) {
            inventory.inventory.add(inventory.inventory.size(), item);
        }
    }

    /*
    Allows user to consume an item by removing it from their inventory
     */
    public static void useItem(Context context, Item i){
        if(UseItem.itemEffects(context, i.getName().toLowerCase())) {
            inventory.inventory.remove(i);
        }
    }

    /*
    Returns the contents of what is stored in the users inventory array if there is anything,
    if not it returns a new empty array.
     */
    public static ArrayList<Item> getInventory(){
        if (inventory.inventory.size() > 0) {
            return inventory.inventory;
        } else return new ArrayList<Item>(40);
    }

    public static Integer getSize(){
        return inventory.inventory.size();
    }
}
