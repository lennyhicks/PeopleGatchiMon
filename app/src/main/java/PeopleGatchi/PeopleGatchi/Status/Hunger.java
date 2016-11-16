package PeopleGatchi.PeopleGatchi.Status;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class Hunger {

    public void HungerLevelUp () {

        hungerLevel += 2;
    }

    public void hungerLevelDown () {
        hungerLevel -= 2;
        happinessLevel += 2;
    }

}