package com.PeopleGatchi.Utils;

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
    static Poo pooBladder;
    static Pee peeBladder;
    static Happiness happiness;
    static Hunger hunger;
    static Thirst thirst;
    static Hygiene hygiene;
    static Rest rest;


    public static void setPooBladder(Integer bladderControl) {
        if(pooBladder == null) {
            pooBladder = new Poo(20);
        }
        pooBladder.pooLevel += bladderControl;
        pooBladder.save();

    }

    public static void setPeeBladder(Integer bladderControl) {
        if(peeBladder == null) {
            peeBladder = new Pee(20);
        }
        peeBladder.peeLevel += bladderControl;
        peeBladder.save();

    }

    public static void setHappiness(Integer happinessControl){
        if(happiness == null) {
            happiness = new Happiness(20);
        }
        happiness.happinessLevel += happinessControl;
        happiness.save();
    }

    public static void setHunger(Integer hungerControl){
        if(hunger == null) {
            hunger = new Hunger(20);
        }
        hunger.hungerLevel += hungerControl;
        hunger.save();
    }

    public static void setThirst(Integer thirstConrol){
        if(thirst == null) {
            thirst = new Thirst(20);
        }
        thirst.thirstLevel += thirstConrol;
        thirst.save();
    }

    public static void setHygiene(Integer hygieneControl){
        if(hygiene == null) {
            hygiene = new Hygiene(20);
        }
        hygiene.hygieneLevel += hygieneControl;
        hygiene.save();
    }

    public static void setRest(Integer restControl){
        if(rest == null) {
            rest = new Rest(20);
        }
        rest.restLevel += restControl;
        rest.save();
    }

    public static void getLevels(){

        pooBladder = Poo.findById(Poo.class, 1);
        peeBladder = Pee.findById(Pee.class, 1);
        happiness = Happiness.findById(Happiness.class, 1);
        hunger = Hunger.findById(Hunger.class, 1);
        thirst = Thirst.findById(Thirst.class, 1);
        hygiene = Hygiene.findById(Hygiene.class, 1);
        rest = Rest.findById(Rest.class, 1);
        happiness.happinessLevel =  getPeeLevel() +
                getPooLevel() +
                getHungerLevel() +
                getThirstLevel() +
                getHygieneLevel() +
                getRestLevel();

    }

    public static Integer getPooLevel(){
        if (pooBladder.pooLevel > 20){
            pooBladder.pooLevel = 20;
        }
        return pooBladder.pooLevel;
    }

    public static Integer getPeeLevel(){
        if (peeBladder.peeLevel > 20){
            peeBladder.peeLevel = 20;
        }
        return peeBladder.peeLevel;
    }

    public static Integer getHungerLevel(){

        if (hunger.hungerLevel > 20){
            hunger.hungerLevel = 20;
        }
        return hunger.hungerLevel;
    }

    public static Integer getThirstLevel(){
        if (thirst.thirstLevel > 20){
            thirst.thirstLevel = 20;
        }
        return thirst.thirstLevel;
    }

    public static Integer getHygieneLevel(){
        if (hygiene.hygieneLevel > 20){
            hygiene.hygieneLevel = 20;
        }
        return hygiene.hygieneLevel;
    }

    public static Integer getRestLevel(){
        if (rest.restLevel > 20){
            rest.restLevel = 20;
        }
        return rest.restLevel;
    }

    public static void firstRun(){
//        Poo pooBladderNew = new Poo(20);;
//        pooBladderNew.save();
//        Pee peeBladderNew = new Pee(14);
//        peeBladderNew.save();
//        Hunger hungerNew = new Hunger(20);
//        hungerNew.save();
//        Thirst thirstNew = new Thirst(20);
//        thirstNew.save();
//        Hygiene hygieneNew = new Hygiene(20);
//        hygieneNew.save();
//        Rest restNew = new Rest(20);
//        restNew.save();
//        Happiness happinessNew = new Happiness(120);
//        happinessNew.save();

//        setHappiness(120);
//        setHunger(20);
//        setHygiene(20);
//        setPeeBladder(20);
//        setPooBladder(20);
//        setRest(20);
//        getLevels();
    }
}
