package com.PeopleGatchi.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sheamaynard on 11/16/16.
 */

public class Money {

    @SerializedName("deposit")
    Integer deposit;

    @SerializedName("withdrawal")
    Integer withdrawal;


    public Money() {
    }


    public Money(Integer deposit) {
        this.deposit = deposit;
    }


    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Integer withdrawal) {
        this.withdrawal = withdrawal;
    }
}




