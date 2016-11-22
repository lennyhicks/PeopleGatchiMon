package com.PeopleGatchi.Models;

import com.PeopleGatchi.PeopleGatchiApplication;
import com.PeopleGatchi.Stages.DeathStage;

import flow.Flow;
import flow.History;

import static com.PeopleGatchi.Utils.StatusControls.happiness;

/**
 * Created by crystaladkins on 11/21/16.
 */

public class Death {


    public void isDead () {

        if (happiness.happinessLevel <= 5) {
           Flow flow = PeopleGatchiApplication.getMainFlow();
            History newHistory = flow.getHistory()
                    .buildUpon()
                    .push(new DeathStage())
                    .build();
            flow.setHistory(newHistory, Flow.Direction.FORWARD);
        } else {
            return;
        }
    }
}