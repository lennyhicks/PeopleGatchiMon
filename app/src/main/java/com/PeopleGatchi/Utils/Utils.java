package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Components.Constants;
import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class Utils {

    public static Integer getRand(Integer max){
        max = Constants.MAX_LEVEL - max;
      Random r = new Random();
        return r.nextInt(max + 1);

    }

    public static Integer setHappinessImage() {
        Integer happinessLevel = StatusControls.getLevels();
        if (happinessLevel >= 80) {
            return R.drawable.happy;
        }else if (happinessLevel >= 40) {
            return R.drawable.annoyed;
        } else if (happinessLevel >= 5) {
            return R.drawable.sad;
        }else {
            return R.drawable.dead;
        }
    }

    public static List<HashMap<String,String>> storeHashMap(Item[] items) {
        List<HashMap<String,String>> hash = new ArrayList<>();
        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("name", items[i].getName());
            hm.put("resource", Integer.toString(items[i].getResourceId()));
            hm.put("price", "Price: $"+ Integer.toString(items[i].getPrice()));
            hash.add(hm);
        }
        return hash;
    }

    public static List<HashMap<String,String>> inventoryHashMap(Item[] items) {
        List<HashMap<String,String>> hash = new ArrayList<>();
            for (int i = 0; i < InventoryControls.getSize(); i++) {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("name", items[i].getName());
                hm.put("resource", Integer.toString(items[i].getResourceId()));
                hash.add(hm);
            }
            return hash;
    }
}
