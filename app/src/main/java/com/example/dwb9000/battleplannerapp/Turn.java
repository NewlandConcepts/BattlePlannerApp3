package com.example.dwb9000.battleplannerapp;

import java.util.ArrayList;

/**
 * Created by DWB9000 on 10/4/2017.
 */

public class Turn {
    public boolean move = true;
    public boolean action = true;
    public boolean bonusAction = true;

    public void PopulateListofActions(ArrayList<String> potentialActions)
    {
        //ArrayList<String> potentialActions = new ArrayList<String>();

        if(move)
        {
            potentialActions.add("Move");
        }
        if(action)
        {
            potentialActions.add("Action");
        }
        if(bonusAction)
        {
            potentialActions.add("BonusAction");
        }

        //return potentialActions;
    }

}
