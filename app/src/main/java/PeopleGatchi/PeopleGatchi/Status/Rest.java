package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Rest {
    //bladder level down, happiness goes up.

    public void restLevelUp () {
        restLevel += 2;
    }
    //bladder level up, happiness goes down.
    public void bladderLevelDown () {
        restLevel -= 2;
        happinessLevel += 2;
    }

}
