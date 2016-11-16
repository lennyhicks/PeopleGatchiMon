package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Hunger {
    //bladder level down, happiness goes up.

    public void HungerLevelUp () {

        hungerLevel += 2;
        happinessLevel -= 2;
    }
    //bladder level up, happiness goes down.
    public void bladderLevelDown () {
        hungerLevel -= 2;
        happinessLevel += 2;
    }

}