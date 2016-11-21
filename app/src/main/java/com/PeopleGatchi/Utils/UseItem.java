package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Item;

/**
 * Created by lennyhicks on 11/21/16.
 */

public class UseItem {
    Item item;

    public UseItem(Item item){
        this.item = item;
        itemEffects(item.getName().toLowerCase());
    }

    public void itemEffects(String name){
        switch (name){
            case "":
        }
    }
}
