package com.PeopleGatchi.Utils;

import android.util.Log;

import com.PeopleGatchi.Models.Persisting.Time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sheamaynard on 11/21/16.
 */

public class TimeControls {

    static String  lastRan;
    static String  currentTime;



    static Time time = new Time();

    public static Date getTime() {
        return time.lastRan;
    }

    public static void setTime(Date lastRan) {
        time.lastRan = lastRan;
        time.save();
    }

    public static  void timeDifference () {

        try {

            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss aa", Locale.US);
            Date Date1 = format.parse(lastRan);
            Date Date2 = format.parse(currentTime);
            long mills = Date1.getTime() - Date2.getTime();
            Log.v("Data1", ""+Date1.getTime());
            Log.v("Data2", ""+Date2.getTime());
            int Hours = (int) (mills/(1000 * 60 * 60));
            int Mins = (int) (mills/(1000*60)) % 60;

            String diff = Hours + ":" + Mins; // updated value every1 second

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

