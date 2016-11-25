package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Persisting.Money;

/**
 * Created by crystaladkins on 11/17/16.
 */

public class BankControls {

    static Money money = new Money();

    public static Integer getMoney() {
        return money.moneyLevel;
    }

    /*
    Takes the users current money level and adds what they received for working a job
     */
    public static void setMoney(Integer payment) {

        money.moneyLevel += payment;
        money.save();
    }
}
