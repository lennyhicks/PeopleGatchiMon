package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */

@Table
public class Thirst extends SugarRecord {

    private Long id;
    public int thirstLevel;

    public Thirst(){
    }

    public Thirst(Integer thirstLevel){
        this.thirstLevel = thirstLevel;
    }

}