package com.PeopleGatchi.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by lennyhicks on 11/17/16.
 */

@Table
public class ScienceEd extends SugarRecord {
    private Long id;
    public Integer scienceLevel;

    public ScienceEd(){
    }

    public ScienceEd(Integer scienceLevel){
        this.scienceLevel = scienceLevel;
    }
}

