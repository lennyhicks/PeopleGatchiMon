package com.PeopleGatchi.Utils;

import com.PeopleGatchi.R;

import java.util.Random;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class Utils {

    public static Integer getRand(Integer max){
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
}
