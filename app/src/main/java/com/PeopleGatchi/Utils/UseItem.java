package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

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

            new Item("Candy", 2, R.drawable.halloweencandy),
                    new Item("Pretzels", 5, R.drawable.pretzel),
                    new Item("Mushroom", 8, R.drawable.mushroom),
                    new Item("Grapes", 10, R.drawable.grapes),
                    new Item("Bacon", 15, R.drawable.bacon),
                    new Item("Taco", 20, R.drawable.taco),
                    new Item("Burger", 25, R.drawable.hamburger),
                    new Item("Desert", 30, R.drawable.bananasplit),
                    new Item("PinApple", 40, R.drawable.pineapple),
                    new Item("Watermelon", 50, R.drawable.watermelon)


            case "candy":
                StatusControls.setHunger(2);
                StatusControls.setPooBladder(1);
                break;
            case "pretzels":
                StatusControls.setHunger(3);
                StatusControls.setPooBladder(1);
                break;
            case "mushrooms":
                StatusControls.setHunger(4);
                StatusControls.setPooBladder(1);
                break;
            case "grapes":
                StatusControls.setHunger(5);
                StatusControls.setPooBladder(2);
                break;
            case "bacon":
                StatusControls.setHunger(6);
                StatusControls.setPooBladder(2);
                break;
            case "taco":
                StatusControls.setHunger(7);
                StatusControls.setPooBladder(2);
                break;
            case "burger":
                StatusControls.setHunger(9);
                StatusControls.setPooBladder(3);
                break;
            case "desert":
                StatusControls.setHunger(10);
                StatusControls.setPooBladder(3);
                break;
            case "pinapple":
                StatusControls.setHunger(12);
                StatusControls.setPooBladder(3);
                break;
            case "watermelon":
                StatusControls.setHunger(15);
                StatusControls.setPooBladder(4);
                break;
        }
    }
}
