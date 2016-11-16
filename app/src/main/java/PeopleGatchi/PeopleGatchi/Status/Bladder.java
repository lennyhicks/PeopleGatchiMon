package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Bladder {

    public void bladderLevelUp () {


        bladderLevel += 2;
        happinessLevel -= 2;
    }
    public void bladderLevelDown () {
        bladderLevel -= 2;
        happinessLevel += 2;

        //Effect of emptying bladder against happiness.

    }

}
