package com.PeopleGatchi.Components;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

/**
 * Created by lennyhicks on 10/31/16.
 */
public final class Constants {
    public static final String token = "token";
    public static final String tokenExpiration = "tokenExpiration";
    public static final int WORK_TIME = 8;
    public static final int MAX_PEE_LEVEL = 20;
    public static final int MAX_POOP_LEVEL = 20;
    public static final int MAX_HUNGER_LEVEL = 20;
    public static final int MAX_THIRST_LEVEL = 20;
    public static final int MAX_REST_LEVEL = 20;



    public static Item[] FOODITEMS = new Item[] {
            new Item("Burger", 1, R.drawable.hamburger),
            new Item("Bacon", 2, R.drawable.bacon),
            new Item("Desert", 3, R.drawable.bananasplit),
            new Item("Grapes", 4, R.drawable.grapes),
            new Item("Candy", 5, R.drawable.halloweencandy),
            new Item("Mushroom", 16, R.drawable.mushroom),
            new Item("PinApple", 17, R.drawable.pineapple),
            new Item("Pretzel", 18, R.drawable.pretzel),
            new Item("Taco", 19, R.drawable.taco),
            new Item("Watermelon", 20, R.drawable.watermelon),
    };

    public static Item[] DRINKITEMS = new Item[] {
            new Item("Beer", 1, R.drawable.beerbottlecap),
            new Item("40Oz", 2, R.drawable.beerman),
            new Item("Water", 3, R.drawable.water),
            new Item("Big Water", 4, R.drawable.bottleofwater),
            new Item("Milk", 5, R.drawable.milk),
            new Item("Milk Jug", 16, R.drawable.milkbottle),
            new Item("Wine", 17, R.drawable.winebottle),
            new Item("Coffee Sm", 18, R.drawable.coffeetogo),
            new Item("Coffee Lg", 19, R.drawable.coffeepot),
            new Item("Vodka", 20, R.drawable.vodka),
    };

    public static Item[] OTHERITEMS = new Item[] {
            new Item("DogHouse", 1, R.drawable.doghouse),
            new Item("SmallHouse", 2, R.drawable.gingerbreadhouse),
            new Item("Mobile Home", 3, R.drawable.mobilehome),
            new Item("Home", 4, R.drawable.home),
            new Item("Garage", 5, R.drawable.garage),
            new Item("Farm", 16, R.drawable.farm),
            new Item("Cottage", 17, R.drawable.cottage),
            new Item("Big House", 18, R.drawable.germanhouse),
            new Item("Bigger House", 19, R.drawable.church),
            new Item("DIAMONDZZZ", 20, R.drawable.minecraftdiamond),
    };



}
