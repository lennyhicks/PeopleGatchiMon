package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Poo extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for poo level
     */

    private Long id;
    public Integer pooLevel;


    public Poo(){
    }

    public Poo(Integer pooLevel){
        this.pooLevel = pooLevel;
    }
}
