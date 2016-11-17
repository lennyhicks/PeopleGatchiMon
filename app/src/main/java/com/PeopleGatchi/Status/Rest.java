package com.PeopleGatchi.Status;

import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Rest {
    private Long id;
    public Integer rest;

    public Rest(){
    }

    public Rest(Integer rest){
        this.rest = rest;
    }
}
