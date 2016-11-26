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


    public UseItem(Context context, Item item) {

        this.item = item;
        this.context = context;
        itemEffects(context, item.getName().toLowerCase());
    }

    /*
    Switch statement to control what happens when a user consumes a food or drink item.
     */
    public static boolean itemEffects(Context context, String name) {

        switch (name) {
            //Food
            case "candy":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 2 && StatusControls.getPooLevel() >= 1) {
                    StatusControls.setHunger(2);
                    StatusControls.setPooBladder(-1);
                    return true;
                } else if (StatusControls.getHungerLevel() + 2 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 2 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 1 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "pretzels":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 3 && StatusControls.getPooLevel() >= 1) {
                    StatusControls.setHunger(3);
                    StatusControls.setPooBladder(-1);
                    return true;
                } else if (StatusControls.getHungerLevel() + 3 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 3 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 1 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "mushrooms":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 4 && StatusControls.getPooLevel() >= 1) {

                    StatusControls.setHunger(4);
                    StatusControls.setPooBladder(-1);
                    return true;
                } else if (StatusControls.getHungerLevel() + 4 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 4 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 1 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "grapes":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 5 && StatusControls.getPooLevel() >= 2) {
                    StatusControls.setHunger(5);
                    StatusControls.setPooBladder(-2);
                    return true;
                } else if (StatusControls.getHungerLevel() + 5 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 5 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 2 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "bacon":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 6 && StatusControls.getPooLevel() >= 2) {
                    StatusControls.setHunger(6);
                    StatusControls.setPooBladder(-2);
                    return true;
                } else if (StatusControls.getHungerLevel() + 6 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 6 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 2 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "taco":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 7 && StatusControls.getPooLevel() >= 2) {
                    StatusControls.setHunger(7);
                    StatusControls.setPooBladder(-2);
                    return true;
                } else if (StatusControls.getHungerLevel() + 7 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 7 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 2 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "burger":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 9 && StatusControls.getPooLevel() >= 3) {
                    StatusControls.setHunger(9);
                    StatusControls.setPooBladder(-3);
                    return true;
                } else if (StatusControls.getHungerLevel() + 9 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 9 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "desert":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 10 && StatusControls.getPooLevel() >= 3) {
                    StatusControls.setHunger(10);
                    StatusControls.setPooBladder(-3);
                    return true;
                } else if (StatusControls.getHungerLevel() + 10 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 10 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "pinapple":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 12 && StatusControls.getPooLevel() >= 3) {
                    StatusControls.setHunger(12);
                    StatusControls.setPooBladder(-3);
                    return true;
                } else if (StatusControls.getHungerLevel() + 12 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 12 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "watermelon":
                if (StatusControls.getHungerLevel() < MAX_LEVEL - 15 && StatusControls.getPooLevel() >= 4) {
                    StatusControls.setHunger(15);
                    StatusControls.setPooBladder(-4);
                    return true;
                } else if (StatusControls.getHungerLevel() + 15 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not hungry enough to eat this \n You need 15 hunger", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPooLevel() - 4 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            //Drinks
            case "water":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 2 && StatusControls.getPeeLevel() >= 1) {
                    StatusControls.setPeeBladder(-1);
                    StatusControls.setThirst(2);
                    return true;
                } else if (StatusControls.getThirstLevel() + 2 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 2 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 1 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "big water":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 4 && StatusControls.getPeeLevel() >= 2) {
                    StatusControls.setPeeBladder(-2);
                    StatusControls.setThirst(4);
                    return true;
                } else if (StatusControls.getThirstLevel() + 4 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 4 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "milk":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 2 && StatusControls.getPeeLevel() >= 3) {
                    StatusControls.setPeeBladder(-3);
                    StatusControls.setThirst(2);
                    return true;
                } else if (StatusControls.getThirstLevel() + 3 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 2 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "milk jug":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 5 && StatusControls.getPeeLevel() >= 5) {

                    StatusControls.setPeeBladder(-5);
                    StatusControls.setThirst(5);
                    return true;
                } else if (StatusControls.getThirstLevel() + 5 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 5 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "coffee sm":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 4 && StatusControls.getPeeLevel() >= 4) {
                    StatusControls.setPeeBladder(-4);
                    StatusControls.setThirst(4);
                    return true;
                } else if (StatusControls.getThirstLevel() + 5 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 5 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 3 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "coffee lg":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 8 && StatusControls.getPeeLevel() >= 8) {
                    StatusControls.setPeeBladder(-8);
                    StatusControls.setThirst(8);
                    return true;
                } else if (StatusControls.getThirstLevel() + 8 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 5 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 8 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "beer":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 2 && StatusControls.getPeeLevel() >= 10) {
                    StatusControls.setPeeBladder(-10);
                    StatusControls.setThirst(2);
                    return true;
                } else if (StatusControls.getThirstLevel() + 2 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 2 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 10 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "40oz":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 4 && StatusControls.getPeeLevel() >= 15) {
                    StatusControls.setPeeBladder(-15);
                    StatusControls.setThirst(4);
                    return true;
                } else if (StatusControls.getThirstLevel() + 4 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 4 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 15 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "wine":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 5 && StatusControls.getPeeLevel() >= 10) {

                    StatusControls.setPeeBladder(-10);
                    StatusControls.setThirst(5);
                    return true;
                } else if (StatusControls.getThirstLevel() + 4 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 5 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 15 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case "vodka":
                if (StatusControls.getThirstLevel() < MAX_LEVEL - 4 && StatusControls.getPeeLevel() >= 10) {
                    StatusControls.setPeeBladder(-10);
                    StatusControls.setThirst(-4);
                    return true;
                } else if (StatusControls.getThirstLevel() + 4 > MAX_LEVEL) {
                    Toast.makeText(context, "You are not thirsty enough to drink this \n You need 4 thirst", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (StatusControls.getPeeLevel() - 10 < 0) {
                    Toast.makeText(context, "You have to use the bathroom to bad to use this item", Toast.LENGTH_SHORT).show();
                    return false;
                }

            default:
                Toast.makeText(context, "Unable to use this item, please try again",
                        Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}
