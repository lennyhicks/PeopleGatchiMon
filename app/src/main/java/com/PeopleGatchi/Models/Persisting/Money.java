package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by sheamaynard on 11/16/16.
 */

@Table
public class Money extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for money
     */

    private Long id;
    public Integer moneyLevel;


    public Money() {
    }

    public Money(Integer moneyLevel) {this.moneyLevel = moneyLevel;}
}