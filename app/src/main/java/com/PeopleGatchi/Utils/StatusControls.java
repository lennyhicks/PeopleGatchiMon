package com.PeopleGatchi.Utils;

import com.PeopleGatchi.Models.Persisting.Happiness;
import com.PeopleGatchi.Models.Persisting.Hunger;
import com.PeopleGatchi.Models.Persisting.Hygiene;
import com.PeopleGatchi.Models.Persisting.MathEd;
import com.PeopleGatchi.Models.Persisting.Money;
import com.PeopleGatchi.Models.Persisting.Pee;
import com.PeopleGatchi.Models.Persisting.PhiloEd;
import com.PeopleGatchi.Models.Persisting.Poo;
import com.PeopleGatchi.Models.Persisting.Rest;
import com.PeopleGatchi.Models.Persisting.ScienceEd;
import com.PeopleGatchi.Models.Persisting.Thirst;
import com.PeopleGatchi.Models.Persisting.User;

import static com.PeopleGatchi.Utils.BankControls.money;
import static com.PeopleGatchi.Utils.BankControls.setMoney;
import static com.orm.SugarRecord.findById;

/**
 * Created by lennyhicks on 11/16/16.
 */

public class StatusControls {

    static Poo pooBladder = new Poo(20);
    static Pee peeBladder = new Pee(20);
    public static Happiness happiness = new Happiness();
    static Hunger hunger = new Hunger(20);
    static Thirst thirst = new Thirst(20);
    static Hygiene hygiene = new Hygiene(20);
    static Rest rest = new Rest(20);
    static ScienceEd scienceEd = new ScienceEd();
    static MathEd mathEd = new MathEd();
    static PhiloEd philoEd = new PhiloEd();
    static User name = new User();
    static User gender = new User();
    static Integer shelterHappiness = 0;
    static Integer adjustedDeath = 0;

    /*
    Getters and Setters for the required stats for the users peoplegatchi
     */


    public static void setPooBladder(Integer bladderControl) {

        if (pooBladder == null) {
            pooBladder = new Poo(20);
        }
        pooBladder.pooLevel += bladderControl;
        if (pooBladder.pooLevel < 0) {
            pooBladder.pooLevel = 0;
        }
        pooBladder.save();
    }

    public static void setPeeBladder(Integer bladderControl) {

        if (peeBladder == null) {
            peeBladder = new Pee(20);
        }
        peeBladder.peeLevel += bladderControl;
        if (peeBladder.peeLevel < 0) {
            peeBladder.peeLevel = 0;
        }
        peeBladder.save();
    }

    public static void setHappiness(Integer happinessControl) {

        if (happiness == null) {
            happiness = new Happiness(120);
        }
        happiness.happinessLevel += 120;
        happiness.save();
    }

    public static void setHunger(Integer hungerControl) {

        if (hunger == null) {
            hunger = new Hunger(20);
        }

        hunger.hungerLevel += hungerControl;

        if (hunger.hungerLevel < 0) {
            hunger.hungerLevel = 0;
        }

        hunger.save();
    }

    public static void setThirst(Integer thirstControl) {

        if (thirst == null) {
            thirst = new Thirst(20);
        }
        thirst.thirstLevel += thirstControl;

        if (thirst.thirstLevel < 0) {
            thirst.thirstLevel = 0;
        }

        thirst.save();
    }

    public static void setHygiene(Integer hygieneControl) {

        if (hygiene == null) {
            hygiene = new Hygiene(20);
        }

        hygiene.hygieneLevel += hygieneControl;

        if (hygiene.hygieneLevel < 0) {
            hygiene.hygieneLevel = 0;
        }

        hygiene.save();
    }

    public static void setRest(Integer restControl) {

        if (rest == null) {
            rest = new Rest(20);
        }

        rest.restLevel += restControl;

        if (rest.restLevel < 0) {
            rest.restLevel = 0;
        }

        rest.save();
    }


    public static String getName() {
        return name.pokeName;
    }

    public static void setName(String inputName) {

        name.pokeName = inputName;
        name.save();
    }

    public static String getGender() {
        return gender.pokeGender;
    }

    public static void setGender(String genderChoice) {

        gender.pokeGender = genderChoice;
        gender.save();
    }

    public static Integer getScienceEd() {
        return scienceEd.sciEdLevel;
    }

    public static void setScienceEd(Integer learning) {

        scienceEd.sciEdLevel += learning;
        scienceEd.save();
    }

    public static Integer getMathEd() {
        return mathEd.mathEdLevel;
    }

    public static void setMathEd(Integer learning) {

        mathEd.mathEdLevel += learning;
        mathEd.save();
    }

    public static Integer getPhiloEd() {
        return philoEd.philoEdLevel;
    }

    public static void setPhiloEd(Integer learning) {

        philoEd.philoEdLevel += learning;
        philoEd.save();
    }

    public static Integer getLevels() {

        if (adjustedDeath == 0) {

            happiness.happinessLevel = getPeeLevel() +
                    getPooLevel() +
                    getHungerLevel() +
                    getThirstLevel() +
                    getHygieneLevel() +
                    getRestLevel();
        }

        return happiness.happinessLevel;
    }

    public static Integer getPooLevel() {

        if (pooBladder.pooLevel > 20) {
            pooBladder.pooLevel = 20;
        }

        return pooBladder.pooLevel;
    }

    public static Integer getPeeLevel() {

        if (peeBladder.peeLevel > 20) {
            peeBladder.peeLevel = 20;
        }

        return peeBladder.peeLevel;
    }

    public static Integer getHungerLevel() {

        if (hunger.hungerLevel > 20) {
            hunger.hungerLevel = 20;
        }

        return hunger.hungerLevel;
    }

    public static Integer getThirstLevel() {

        if (thirst.thirstLevel > 20) {
            thirst.thirstLevel = 20;
        }

        return thirst.thirstLevel;
    }

    public static Integer getHygieneLevel() {

        if (hygiene.hygieneLevel > 20) {
            hygiene.hygieneLevel = 20;
        }

        return hygiene.hygieneLevel;
    }

    public static Integer getRestLevel() {

        if (rest.restLevel > 20) {
            rest.restLevel = 20;
        }

        return rest.restLevel;
    }
    public static Integer getShelterHappiness() {
        return shelterHappiness;
    }

    public static void setShelterHappiness(Integer shelterHappiness) {
        StatusControls.shelterHappiness = shelterHappiness;
    }

    public static Integer getAdjustedDeath() {
        return adjustedDeath;
    }

    public static void setAdjustedDeath(Integer adjustedDeath) {
        StatusControls.adjustedDeath = adjustedDeath;
    }

    /*
    Sets up the table that are needed by sugar app as the game is started to give local persistence
     */
    public static void firstRun() {

        pooBladder = new Poo(20);
        peeBladder = new Pee(20);
        happiness = new Happiness(120);
        hunger = new Hunger(20);
        thirst = new Thirst(20);
        hygiene = new Hygiene(20);
        rest = new Rest(20);
        money = new Money(0);
        scienceEd = new ScienceEd(0);
        mathEd = new MathEd(0);
        philoEd = new PhiloEd(0);
        name = new User();
        gender = new User();

        pooBladder.save();
        peeBladder.save();
        happiness.save();
        hunger.save();
        thirst.save();
        hygiene.save();
        rest.save();
        money.save();
        scienceEd.save();
        mathEd.save();
        philoEd.save();
        name.save();
        gender.save();

        updateLevels();
    }

    /*
    Updates the tables created for persistence with any changes that are made to the levels
     */
    public static void updateLevels() {

        pooBladder = findById(Poo.class, 1);
        peeBladder = findById(Pee.class, 1);
        hunger = findById(Hunger.class, 1);
        thirst = findById(Thirst.class, 1);
        hygiene = findById(Hygiene.class, 1);
        rest = findById(Rest.class, 1);
        money = findById(Money.class, 1);
        mathEd = MathEd.findById(MathEd.class, 1);
        scienceEd = findById(ScienceEd.class, 1);
        philoEd = findById(PhiloEd.class, 1);
        name = findById(User.class, 1);
        gender = findById(User.class, 1);
    }

    /*
    Allows the user to start a new game right away, resetting all stats to the appropriate levels
     */
    public static void resetGame() {

        setName(getName());
        setGender(getGender());
        setPooBladder(20);
        setPeeBladder(20);
        setHunger(20);
        setThirst(20);
        setHygiene(20);
        setRest(20);
        setMoney(0);
        setScienceEd(0);
        setMathEd(0);
        setPhiloEd(0);
        setShelterHappiness(0);
        setAdjustedDeath(0);
    }

    public static void resetLevels() {
        setPooBladder(20);
        setPeeBladder(20);
        setHunger(20);
        setThirst(20);
        setHygiene(20);
        setRest(20);
        setMoney(0);
        setScienceEd(0);
        setMathEd(0);
        setPhiloEd(0);
        setShelterHappiness(0);
        setAdjustedDeath(0);
    }

    public static Integer getShelterHappiness() {
        return shelterHappiness;
    }

    public static void setShelterHappiness(Integer shelterHappiness) {
        StatusControls.shelterHappiness = shelterHappiness;
    }

    public static Integer getAdjustedDeath() {
        return adjustedDeath;
    }

    public static void setAdjustedDeath(Integer adjustedDeath) {
        StatusControls.adjustedDeath = adjustedDeath;
    }
}
