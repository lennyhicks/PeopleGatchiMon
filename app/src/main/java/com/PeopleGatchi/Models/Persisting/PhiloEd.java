package com.PeopleGatchi.Models.Persisting;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by eaglebrosi on 11/20/16.
 */
@Table
public class PhiloEd extends SugarRecord {

    /*
    Model needed for sugarapp to create local persistence for the philosophy education level
     */

    private Long id;
    public Integer philoEdLevel;


    public PhiloEd(){
    }

    public PhiloEd(Integer philoEdLevel){
        this.philoEdLevel = philoEdLevel;
    }
}
