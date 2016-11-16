package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Bladder {
    //bladder level down, happiness goes up.

    public void bladderLevelUp () {

        bladderLevel += 2;
        happinessLevel -= 2;
    }
    //bladder level up, happiness goes down.
    public void bladderLevelDown () {
        bladderLevel -= 2;
        happinessLevel += 2;
    }

}
