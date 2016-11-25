package com.PeopleGatchi.Components;

import com.PeopleGatchi.Models.Item;
import com.PeopleGatchi.R;

/**
 * Created by lennyhicks on 10/31/16.
 */
public final class Constants {

    public static final String token = "token";
    public static final int MAX_LEVEL = 20;
    public static final int BASE_HAPPINESS = 120;
    public static final int DEATH = 15;

    /*
    Static items that are shown in the store under food
     */
    public static Item[] FOODITEMS = new Item[]{

            new Item("Candy", 2, R.drawable.halloweencandy),
            new Item("Pretzels", 5, R.drawable.pretzel),
            new Item("Mushroom", 8, R.drawable.mushroom),
            new Item("Grapes", 10, R.drawable.grapes),
            new Item("Bacon", 15, R.drawable.bacon),
            new Item("Taco", 20, R.drawable.taco),
            new Item("Burger", 25, R.drawable.hamburger),
            new Item("Desert", 30, R.drawable.bananasplit),
            new Item("PinApple", 40, R.drawable.pineapple),
            new Item("Watermelon", 50, R.drawable.watermelon)
    };

    /*
    Static items shown in the store under drinks
     */
    public static Item[] DRINKITEMS = new Item[]{

            new Item("Water", 2, R.drawable.water),
            new Item("Big Water", 5, R.drawable.bottleofwater),
            new Item("Milk", 8, R.drawable.milk),
            new Item("Milk Jug", 10, R.drawable.milkbottle),
            new Item("Coffee Sm", 15, R.drawable.coffeetogo),
            new Item("Coffee Lg", 20, R.drawable.coffeepot),
            new Item("Beer", 25, R.drawable.beerbottlecap),
            new Item("40Oz", 30, R.drawable.beerman),
            new Item("Wine", 40, R.drawable.winebottle),
            new Item("Vodka", 50, R.drawable.vodka)
    };

    /*
    Static items that are shown in the store as other
     */
    public static Item[] OTHERITEMS = new Item[]{

            new Item("DogHouse", 100, R.drawable.doghouse),
            new Item("Sm House", 20000, R.drawable.gingerbreadhouse),
            new Item("Mob Home", 30000, R.drawable.mobilehome),
            new Item("Home", 70000, R.drawable.home),
            new Item("Garage", 100000, R.drawable.garage),
            new Item("Farm", 150000, R.drawable.farm),
            new Item("Cottage", 200000, R.drawable.cottage),
            new Item("Med House", 250000, R.drawable.germanhouse),
            new Item("Lg House", 300000, R.drawable.church),
            new Item("DIAMONDZ", 500000, R.drawable.minecraftdiamond)
    };
}
