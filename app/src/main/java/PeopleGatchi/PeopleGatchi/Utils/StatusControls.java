package PeopleGatchi.PeopleGatchi.Utils;

import PeopleGatchi.PeopleGatchi.Status.Happiness;
import PeopleGatchi.PeopleGatchi.Status.Hunger;
import PeopleGatchi.PeopleGatchi.Status.Hygiene;
import PeopleGatchi.PeopleGatchi.Status.Pee;
import PeopleGatchi.PeopleGatchi.Status.Poo;
import PeopleGatchi.PeopleGatchi.Status.Thirst;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class StatusControls {
    static Poo pooBladder = Poo.findById(Poo.class, 1);
    static Pee peeBladder = Pee.findById(Pee.class, 1);
    static Happiness happiness = Happiness.findById(Happiness.class, 1);
    static Hunger hunger = Hunger.findById(Hunger.class, 1);
    static Thirst thirst = Thirst.findById(Thirst.class, 1);
    static Hygiene hygiene = Hygiene.findById(Hygiene.class, 1);


    public static void updatePooBladder(Integer bladderControl) {
        pooBladder.pooLevel += bladderControl;
        pooBladder.save();

    }

    public static void updatePeeBladder(Integer bladderControl) {
        peeBladder.peeLevel += bladderControl;
        peeBladder.save();

    }

    public static void updateHappiness(Integer happinessControl){
        happiness.happinessLevel += happinessControl;
        happiness.save();
    }

    public static void updateHunger(Integer hungerControl){
        hunger.hungerLevel += hungerControl;
        hunger.save();
    }

    public static void updateThirst(Integer thirstConrol){
        thirst.thirstLevel += thirstConrol;
        thirst.save();
    }

    public static void updateHygiene(Integer hygieneControl){
        hygiene.hygieneLevel += hygieneControl;
        hygiene.save();
    }

    public static void update(){
        pooBladder = Poo.findById(Poo.class, 1);
        peeBladder = Pee.findById(Pee.class, 1);
        hunger = Hunger.findById(Hunger.class, 1);

        happiness.happinessLevel = peeBladder.peeLevel +
                    pooBladder.pooLevel +
                    hunger.hungerLevel +
                    thirst.thirstLevel +
                    hygiene.hygieneLevel;

    }
}
