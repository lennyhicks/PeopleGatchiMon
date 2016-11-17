package com.PeopleGatchi.Status;

import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Poo {

    private Long id;
    public Integer pooLevel;

    public Poo(){
    }

    public Poo(Integer pooLevel){
        this.pooLevel = pooLevel;
    }
}
