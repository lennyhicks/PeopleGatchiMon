package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by lennyhicks on 11/16/16.
 */
@Table
public class Name extends SugarRecord {
    private Long id;
    public String pokeName;

    public Name(){
    }

    public Name(String inputName){
        this.pokeName = inputName;
    }
}
