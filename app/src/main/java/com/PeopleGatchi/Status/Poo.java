package com.PeopleGatchi.Status;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Poo extends SugarRecord {

    private Long id;
    public Integer pooLevel;

    public Poo(){
    }

    public Poo(Integer pooLevel){
        this.pooLevel = pooLevel;
    }
}
