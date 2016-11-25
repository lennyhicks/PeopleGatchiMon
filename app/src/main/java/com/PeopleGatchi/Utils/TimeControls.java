package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Persisting.Time;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sheamaynard on 11/21/16.
 */

public class TimeControls {
    
    public static Calendar calendar;

    static Time time = new Time();

    public static Date getTime() {
        
        return time.lastRan;
    }

    public static void setTime(Date lastRan) {
        
        time.lastRan = lastRan;
        time.save();
    }
}
