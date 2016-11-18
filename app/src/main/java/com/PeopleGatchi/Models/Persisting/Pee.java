package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Pee extends SugarRecord {

    private Long id;
    public Integer peeLevel;

    public Pee(){
    }

    public Pee(Integer peeLevel){
        this.peeLevel = peeLevel;
    }
}
