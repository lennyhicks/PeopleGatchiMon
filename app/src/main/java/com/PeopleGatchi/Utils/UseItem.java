package com.PeopleGatchi.Utils;

import android.content.Context;
import android.widget.Toast;

import com.PeopleGatchi.Models.Item;

import static com.PeopleGatchi.Components.Constants.MAX_LEVEL;

/**
 * Created by lennyhicks on 11/21/16.
 */

public class UseItem {
    Item item;
    Context context;

    public UseItem(Context context,Item item){
        this.item = item;
        this.context = context;
        itemEffects(context, item.getName().toLowerCase());
    }

    public static void itemEffects(Context context, String name){
        switch (name){
            case "candy":
                if(StatusControls.getHungerLevel() < MAX_LEVEL - 2 && StatusControls.getPooLevel() > 1) {
                    StatusControls.setHunger(2);
                    StatusControls.setPooBladder(-1);
                    break;
                } else if (StatusControls.getHungerLevel() + 2 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this", Toast.LENGTH_SHORT).show();
                    break;
                } else if (StatusControls.getPooLevel() - 1 < 0){
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    break;
                }
            case "pretzels":
                if(StatusControls.getHungerLevel() < MAX_LEVEL - 3 && StatusControls.getPooLevel() > 1) {
                    StatusControls.setHunger(3);
                    StatusControls.setPooBladder(-1);
                    break;
                } else if (StatusControls.getHungerLevel() + 2 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this", Toast.LENGTH_SHORT).show();
                    break;
                } else if (StatusControls.getPeeLevel() - 1 < 0){
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    break;
                }
            case "mushrooms":
                StatusControls.setHunger(4);
                StatusControls.setPooBladder(-1);
                break;
            case "grapes":
                StatusControls.setHunger(5);
                StatusControls.setPooBladder(-2);
                break;
            case "bacon":
                StatusControls.setHunger(6);
                StatusControls.setPooBladder(-2);
                break;
            case "taco":
                StatusControls.setHunger(7);
                StatusControls.setPooBladder(-2);
                break;
            case "burger":
                StatusControls.setHunger(9);
                StatusControls.setPooBladder(-3);
                break;
            case "desert":
                StatusControls.setHunger(10);
                StatusControls.setPooBladder(-3);
                break;
            case "pinapple":
                StatusControls.setHunger(12);
                StatusControls.setPooBladder(-3);
                break;
            case "watermelon":
                StatusControls.setHunger(15);
                StatusControls.setPooBladder(-4);
                break;
//Drinks
            case "water" :
                StatusControls.setPeeBladder(-1);
                StatusControls.setThirst(2);
                break;
            case "big water" :
                StatusControls.setPeeBladder(-2);
                StatusControls.setThirst(4);
                break;
            case "milk" :
                StatusControls.setPeeBladder(-3);
                StatusControls.setThirst(2);
                break;
            case "milk jug" :
                StatusControls.setPeeBladder(-5);
                StatusControls.setThirst(5);
                break;
            case "coffee sm" :
                StatusControls.setPeeBladder(-4);
                StatusControls.setThirst(4);
                break;
            case "coffee lg" :
                StatusControls.setPeeBladder(-8);
                StatusControls.setThirst(8);
                break;
            case "beer" :
                StatusControls.setPeeBladder(-10);
                StatusControls.setThirst(2);
                break;
            case "40oz" :
                StatusControls.setPeeBladder(-15);
                StatusControls.setThirst(4);
                break;
            case "wine" :
                StatusControls.setPeeBladder(-10);
                StatusControls.setThirst(5);
                break;
            case "vodka" :
                StatusControls.setPeeBladder(-10);
                StatusControls.setThirst(-5);
                break;
        }
    }
}
