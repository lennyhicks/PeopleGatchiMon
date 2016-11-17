package com.PeopleGatchi.Models;

import com.orm.SugarApp;
import com.orm.dsl.Table;

/**
 * Created by lennyhicks on 11/16/16.
 */
@Table
public class User extends SugarApp{
    private Long id;
    private String name;
    private Integer age;

    public User(){
    }

    public User(String name, Integer age ){
        this.name = name;
        this.age = age;
    }
}
