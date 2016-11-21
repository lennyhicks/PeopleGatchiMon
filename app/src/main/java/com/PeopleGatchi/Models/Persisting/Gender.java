package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by eaglebrosi on 11/21/16.
 */

@Table
public class Gender  extends SugarRecord {
    //bladder level down, happiness goes up.
    private Long id;
    public String pokeGender;

    public Gender(){
    }

    public Gender(String genderChoice){
        this.pokeGender = genderChoice;
    }
}