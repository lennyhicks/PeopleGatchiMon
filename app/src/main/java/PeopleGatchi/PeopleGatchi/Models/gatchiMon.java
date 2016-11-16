package PeopleGatchi.PeopleGatchi.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class gatchiMon {
    @SerializedName("pokeName")
    String pokeName;

    @SerializedName("pokeGender")
    String pokeGender;

    @SerializedName("peeNeed")
    Integer peeNeed;

    @SerializedName("pooNeed")
    Integer pooNeed;

    @SerializedName("sleepNeed")
    Integer sleepNeed;

    @SerializedName("thirstNeed")
    Integer thirstNeed;

    @SerializedName("bathNeed")
    Integer bathNeed;

    @SerializedName("scienceEd")
    Integer scienceEd;

    @SerializedName("mathEd")
    Integer mathEd;

    @SerializedName("bankBalance")
    Double bankBalance;

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public String getPokeGender() {
        return pokeGender;
    }

    public void setPokeGender(String pokeGender) {
        this.pokeGender = pokeGender;
    }

    public Integer getPeeNeed() {
        return peeNeed;
    }

    public void setPeeNeed(Integer peeNeed) {
        this.peeNeed = peeNeed;
    }

    public Integer getPooNeed() {
        return pooNeed;
    }

    public void setPooNeed(Integer pooNeed) {
        this.pooNeed = pooNeed;
    }

    public Integer getSleepNeed() {
        return sleepNeed;
    }

    public void setSleepNeed(Integer sleepNeed) {
        this.sleepNeed = sleepNeed;
    }

    public Integer getThirstNeed() {
        return thirstNeed;
    }

    public void setThirstNeed(Integer thirstNeed) {
        this.thirstNeed = thirstNeed;
    }

    public Integer getBathNeed() {
        return bathNeed;
    }

    public void setBathNeed(Integer bathNeed) {
        this.bathNeed = bathNeed;
    }

    public Integer getScienceEd() {
        return scienceEd;
    }

    public void setScienceEd(Integer scienceEd) {
        this.scienceEd = scienceEd;
    }

    public Integer getMathEd() {
        return mathEd;
    }

    public void setMathEd(Integer mathEd) {
        this.mathEd = mathEd;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }
}