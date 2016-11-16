package PeopleGatchi.PeopleGatchi.Models;

import java.util.Calendar;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class User {
    static Calendar cal = Calendar.getInstance();

    public static Calendar getCal() {
        return cal;
    }

    public static void setCal(Calendar cal) {
        cal = cal;
    }
}
