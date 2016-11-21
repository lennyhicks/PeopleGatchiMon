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

    public static void setMoney(Integer payment) {
        //TODO Calculations need to happen here

        money.moneyLevel += payment;
        money.save();
    }
}
