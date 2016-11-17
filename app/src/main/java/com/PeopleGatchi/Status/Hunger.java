package com.PeopleGatchi.Status;

import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Hunger {
    //bladder level down, happiness goes up.
    private Long id;
    public Integer hungerLevel;

    public Hunger(){
    }

    public Hunger(Integer hungerLevel){
        this.hungerLevel = hungerLevel;
    }

}