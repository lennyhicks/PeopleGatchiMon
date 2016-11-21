package com.PeopleGatchi.Models.Persisting;

import com.PeopleGatchi.Models.Item;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.ArrayList;

/**
 * Created by lennyhicks on 11/19/16.
 */

@Table
public class Inventory extends SugarRecord {

    private Long id;
    public ArrayList<Item> inventory = new ArrayList<>(40);

    public Inventory(){}

    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }
}
