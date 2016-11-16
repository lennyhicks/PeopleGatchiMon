package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Hygiene {
    //bladder level down, happiness goes up.

    public void hygieneLevelUp () {

        hygieneLevel += 2;
        happinessLevel -= 2;
    }
    //bladder level up, happiness goes down.
    public void bladderLevelDown () {
        hygieneLevel -= 2;
        happinessLevel += 2;
    }

}

