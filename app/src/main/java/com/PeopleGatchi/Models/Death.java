package com.PeopleGatchi.Models;

import android.content.SharedPreferences;

import com.PeopleGatchi.Stages.CreateStage;

import flow.Flow;
import flow.History;

import static com.PeopleGatchi.MainActivity.peoplegatchiPrefs;
import static com.PeopleGatchi.Utils.StatusControls.happiness;

/**
 * Created by crystaladkins on 11/21/16.
 */

public class Death {

    private Flow flow;

    public void isDead () {

        if (happiness.happinessLevel <= 5) {
            SharedPreferences.Editor editor = peoplegatchiPrefs.edit();
            editor.putBoolean("firstRun", true);
            editor.apply();

            //TODO UPDATE THIS TO THE DEATH STAGE!!!
            History newHistory = History.single(new CreateStage());
            flow.setHistory(newHistory, Flow.Direction.REPLACE);
        }
    }
}
