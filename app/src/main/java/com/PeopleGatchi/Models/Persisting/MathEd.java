package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by eaglebrosi on 11/20/16.
 */

@Table
public class MathEd extends SugarRecord {
    private Long id;
    public Integer mathEdLevel;

    public MathEd(){
    }

    public MathEd(Integer mathEdLevel){
        this.mathEdLevel = mathEdLevel;
    }
}
