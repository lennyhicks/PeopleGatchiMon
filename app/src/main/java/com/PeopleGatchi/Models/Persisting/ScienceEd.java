package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by eaglebrosi on 11/20/16.
 */

@Table
public class ScienceEd extends SugarRecord {
    private Long id;
    public Integer sciEdLevel;

    public ScienceEd(){
    }

    public ScienceEd(Integer sciEdLevel){
        this.sciEdLevel = sciEdLevel;
    }
}