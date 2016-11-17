package com.PeopleGatchi.Utils;

import android.util.Log;

import com.PeopleGatchi.Status.Happiness;
import com.PeopleGatchi.Status.Hunger;
import com.PeopleGatchi.Status.Hygiene;
import com.PeopleGatchi.Status.Pee;
import com.PeopleGatchi.Status.Poo;
import com.PeopleGatchi.Status.Rest;
import com.PeopleGatchi.Status.Thirst;

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
    static Rest rest = Rest.findById(Rest.class, 1);


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

    public static void updateRest(Integer restControl){
        rest.restLevel += restControl;
        rest.save();
    }

    public static void update(){
        pooBladder = Poo.findById(Poo.class, 1);
        peeBladder = Pee.findById(Pee.class, 1);
        hunger = Hunger.findById(Hunger.class, 1);
        Log.i("HUNGER ", hunger.hungerLevel +"");

        happiness.happinessLevel =  peeLevel() +
                                    pooLevel() +
                                    hungerLevel() +
                                    thirstLevel() +
                                    hygieneLevel() +
                                    restLevel();

    }

    public static Integer pooLevel(){
        if (pooBladder.pooLevel > 20){
            pooBladder.pooLevel = 20;
        }
        return pooBladder.pooLevel;
    }

    public static Integer peeLevel(){
        if (peeBladder.peeLevel > 20){
            peeBladder.peeLevel = 20;
        }
        return peeBladder.peeLevel;
    }

    public static Integer hungerLevel(){
        if (hunger.hungerLevel > 20){
            hunger.hungerLevel = 20;
        }
        return hunger.hungerLevel;
    }

    public static Integer thirstLevel(){
        if (thirst.thirstLevel > 20){
            thirst.thirstLevel = 20;
        }
        return thirst.thirstLevel;
    }

    public static Integer hygieneLevel(){
        if (hygiene.hygieneLevel > 20){
            hygiene.hygieneLevel = 20;
        }
        return hygiene.hygieneLevel;
    }

    public static Integer restLevel(){
        if (rest.restLevel > 20){
            rest.restLevel = 20;
        }
        return rest.restLevel;
    }

    public static void firstRun(){
        pooBladder = new Poo(20);
        pooBladder.save();
        peeBladder = new Pee(14);
        peeBladder.save();
        hunger = new Hunger(20);
        hunger.save();
        thirst = new Thirst(20);
        thirst.save();
        hygiene = new Hygiene(20);
        hygiene.save();
        rest = new Rest(20);
        rest.save();
    }
}
