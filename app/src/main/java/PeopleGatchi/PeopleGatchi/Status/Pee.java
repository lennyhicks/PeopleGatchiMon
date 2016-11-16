package PeopleGatchi.PeopleGatchi.Status;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by andrewlewis on 11/16/16.
 */
@Table
public class Pee extends SugarRecord {
    //bladder level down, happiness goes up.
    public Integer peeLevel;

    public Pee(){
    }

    public Pee(Integer peeLevel){
        this.peeLevel = peeLevel;
    }
}
