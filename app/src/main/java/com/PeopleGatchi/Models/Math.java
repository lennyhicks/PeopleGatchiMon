package com.PeopleGatchi.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by lennyhicks on 11/17/16.
 */
@Table
public class Math extends SugarRecord {
    private Long id;
    public Integer mathLevel;

    public Math(){
    }

    public Math(Integer mathLevel){
        this.mathLevel = mathLevel;
    }
}