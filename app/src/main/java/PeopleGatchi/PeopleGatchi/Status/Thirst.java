package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Thirst {
    //bladder level down, happiness goes up.

    public void ThirstLevelUp () {

        bladderLevel += 2;
        happinessLevel -= 2;
    }
    //bladder level up, happiness goes down.
    public void ThirstLevelDown () {
        bladderLevel -= 2;
        happinessLevel += 2;
    }

}