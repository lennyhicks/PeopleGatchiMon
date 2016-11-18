package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Hygiene extends SugarRecord {
    private Long id;
    public Integer hygieneLevel;

    public Hygiene(){
    }

    public Hygiene(Integer hygieneLevel){
        this.hygieneLevel = hygieneLevel;
    }
}
