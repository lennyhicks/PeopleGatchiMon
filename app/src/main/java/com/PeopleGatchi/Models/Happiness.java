package com.PeopleGatchi.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Happiness extends SugarRecord {

    private Long id;
    public Integer happinessLevel;


    public Happiness(){
    }

    public Happiness(Integer happinessLevel){

        this.happinessLevel = happinessLevel;
    }


}
