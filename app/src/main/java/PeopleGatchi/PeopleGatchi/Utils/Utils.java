package PeopleGatchi.PeopleGatchi.Utils;

import java.util.Calendar;

import PeopleGatchi.PeopleGatchi.Components.Constants;
import PeopleGatchi.PeopleGatchi.Models.User;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class Utils {
    public static void addTime(){
        Calendar cal = User.getCal();
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + Constants.WORK_TIME);
    }
}
