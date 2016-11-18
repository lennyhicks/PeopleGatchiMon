package com.PeopleGatchi.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by sheamaynard on 11/16/16.
 */

@Table
public class Money extends SugarRecord {

    public Integer money;

    public Money() {
    }


    public Money(Integer money) {
        this.money = money;
    }


}




