package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Rest extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for rest level
     */

    private Long id;
    public Integer restLevel;


    public Rest(){
    }

    public Rest(Integer rest){
        this.restLevel = rest;
    }
}
