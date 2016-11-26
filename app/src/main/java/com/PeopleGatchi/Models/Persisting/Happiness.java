package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Happiness extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for happiness
     */

    private Long id;
    public Integer happinessLevel;


    public Happiness(){
    }

    public Happiness(Integer happinessLevel){

        this.happinessLevel = happinessLevel;
    }
}
