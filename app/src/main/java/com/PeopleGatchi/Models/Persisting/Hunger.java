package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Hunger extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for hunger
     */
    private Long id;
    public Integer hungerLevel;


    public Hunger(){
    }

    public Hunger(Integer hungerLevel){
        this.hungerLevel = hungerLevel;
    }

}