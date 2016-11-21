package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by eaglebrosi on 11/21/16.
 */

@Table
public class User extends SugarRecord {
    private Long id;
    public String pokeName;
    public String pokeGender;

    public User(){
    }

    public User(String inputName, String chooseGender){
        this.pokeName = inputName;
        this.pokeGender = chooseGender;
    }
}