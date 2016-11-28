package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by sheamaynard on 11/21/16.
 */
@Table
public class Time extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for in game time
     */

    private Long id;
    public Date lastRan;


    public Time(){
    }

    public Time(Date lastRan) {
        this.lastRan = lastRan;
    }
}


