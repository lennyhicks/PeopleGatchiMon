package com.PeopleGatchi.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Hunger extends SugarRecord {
    //bladder level down, happiness goes up.
    private Long id;
    public Integer hungerLevel;

    public Hunger(){
    }

    public Hunger(Integer hungerLevel){
        this.hungerLevel = hungerLevel;
    }

}