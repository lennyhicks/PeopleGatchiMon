package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Persisting.Happiness;
import com.PeopleGatchi.Models.Persisting.Hunger;
import com.PeopleGatchi.Models.Persisting.Hygiene;
import com.PeopleGatchi.Models.Persisting.Money;
import com.PeopleGatchi.Models.Persisting.Pee;
import com.PeopleGatchi.Models.Persisting.Poo;
import com.PeopleGatchi.Models.Persisting.Rest;
import com.PeopleGatchi.Models.Persisting.Thirst;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class StatusControls {
    static Poo pooBladder = new Poo(20);
    static Pee peeBladder = new Pee(20);
    static Happiness happiness= new Happiness();
    static Hunger hunger = new Hunger(20);
    static Thirst thirst = new Thirst(20);
    static Hygiene hygiene = new Hygiene(20);
    static Rest rest = new Rest(20);
    static Money money = new Money(0);


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
            happiness = new Happiness(120);
        }
        happiness.happinessLevel += 120;
        happiness.save();
    }

    public static void setHunger(Integer hungerControl){
        if(hunger == null) {
            hunger = new Hunger(20);
        }
        hunger.hungerLevel += hungerControl;
        hunger.save();
    }

    public static void setThirst(Integer thirstControl){
        if(thirst == null) {
            thirst = new Thirst(20);
        }
        thirst.thirstLevel += thirstControl;
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

    public static Integer getMoney() {
        return money.moneyLevel;
    }

    public static void setMoney(Integer payment) {
        //TODO Calculations need to happen here

        money.moneyLevel += payment;
        money.save();
    }

    public static Integer getLevels(){
        happiness = Happiness.findById(Happiness.class, 1);

        pooBladder = Poo.findById(Poo.class, 1);
        peeBladder = Pee.findById(Pee.class, 1);
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
        return happiness.happinessLevel;


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

        pooBladder = new Poo(20);
        peeBladder = new Pee(20);
        happiness = new Happiness(120);
        hunger = new Hunger(20);
        thirst = new Thirst(20);
        hygiene = new Hygiene(20);
        rest = new Rest(20);
        money = new Money(0);


        pooBladder.save();
        peeBladder.save();
        happiness.save();
        hunger.save();
        thirst.save();
        hygiene.save();
        rest.save();
        money.save();

        updateLevels();
//        getLevels();
    }

    public static void updateLevels(){


        pooBladder = Poo.findById(Poo.class, 1);
        peeBladder = Pee.findById(Pee.class, 1);
        hunger = Hunger.findById(Hunger.class, 1);
        thirst = Thirst.findById(Thirst.class, 1);
        hygiene = Hygiene.findById(Hygiene.class, 1);
        rest = Rest.findById(Rest.class, 1);
    }
}
