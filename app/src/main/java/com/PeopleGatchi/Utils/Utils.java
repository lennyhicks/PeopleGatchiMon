package com.PeopleGatchi.Utils;

import java.util.Random;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class Utils {

    public static Integer getRand(Integer max){
      Random r = new Random();
        return r.nextInt(max + 1);

    }
}
