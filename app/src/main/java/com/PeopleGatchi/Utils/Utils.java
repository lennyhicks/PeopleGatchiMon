package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Components.Constants;
import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.PeopleGatchi.Components.Constants.BASE_HAPPINESS;
import static com.PeopleGatchi.Components.Constants.DEATH;
import static com.PeopleGatchi.Utils.StatusControls.adjustedDeath;
import static com.PeopleGatchi.Utils.StatusControls.happiness;
import static com.PeopleGatchi.Utils.StatusControls.shelterHappiness;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class Utils {


    /*
    Gets a random number to set set status to when trying to better your stats
     */
    public static Integer getRand(Integer max) {

        Random r = new Random();

        if (max >= 0) {
            max = Constants.MAX_LEVEL - max;
        } else {

            max = Math.abs(max);
            return -(r.nextInt(max + 1));
        }

        return r.nextInt(max + 1);
    }

    /*
    Sets image that corresponds to your happiness level to provide a visual distinction for when your
    statuses are getting low
     */
    public static Integer setHappinessImage() {

        Integer happinessLevel = StatusControls.getLevels();

        if (happinessLevel >= 80) {
            return R.drawable.happy;

        } else if (happinessLevel >= 40) {
            return R.drawable.annoyed;

        } else if (happinessLevel >= 16) {
            return R.drawable.sad;

        } else {
            return R.drawable.dead;
        }
    }

    /*
    Creates the hashmap that is used to display the items that are in the store
     */
    public static List<HashMap<String, String>> storeHashMap(Item[] items) {

        List<HashMap<String, String>> hash = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            HashMap<String, String> hm = new HashMap<>();
            hm.put("name", items[i].getName());
            hm.put("resource", Integer.toString(items[i].getResourceId()));
            hm.put("price", "Price: $" + Integer.toString(items[i].getPrice()));
            hash.add(hm);
        }
        return hash;
    }

    /*
    Creates the hashmap that is used to display the items in the users inventory
     */
    public static List<HashMap<String, String>> inventoryHashMap(Item[] items) {

        List<HashMap<String, String>> hash = new ArrayList<>();
        for (int i = 0; i < InventoryControls.getSize(); i++) {

            HashMap<String, String> hm = new HashMap<>();
            hm.put("name", items[i].getName());
            hm.put("resource", Integer.toString(items[i].getResourceId()));
            hash.add(hm);
        }
        return hash;
    }

    /*
    Calculations that take into account if a user has bought and used an item that effects their
    overall happiness
     */
    public static void adjustedStatus() {

        if (shelterHappiness >= 1) {

            happiness.happinessLevel = BASE_HAPPINESS + shelterHappiness;
            adjustedDeath = DEATH - shelterHappiness;
        } else {

            happiness.happinessLevel = BASE_HAPPINESS;
            adjustedDeath = DEATH;
        }
    }

    /*
    Sets how much of a boost to total happiness the user gets by using other items
     */
    public static void shelterAdjustment(String itemName) {

        itemName = itemName.toLowerCase();

        switch (itemName) {

            case "doghouse":
                shelterHappiness = 1;
                break;
            case "sm house":
                shelterHappiness = 2;
                break;
            case "mob home":
                shelterHappiness = 3;
                break;
            case "home":
                shelterHappiness = 4;
                break;
            case "garage":
                shelterHappiness = 5;
                break;
            case "farm":
                shelterHappiness = 6;
                break;
            case "cottage":
                shelterHappiness = 7;
                break;
            case "med house":
                shelterHappiness = 8;
                break;
            case "lg house":
                shelterHappiness = 9;
                break;
            default:
                break;
        }
    }
}
