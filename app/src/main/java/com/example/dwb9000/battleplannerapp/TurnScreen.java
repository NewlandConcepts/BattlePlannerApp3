package com.example.dwb9000.battleplannerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TurnScreen extends AppCompatActivity
{
    private String lastOptionChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_screen);
    }

    public void displayTurnAbilities(View view)
    {
        String buttonPressed;
        switch(view.getId())
        {
            case R.id.MoveButton:
                buttonPressed = "Move";
                break;
            case R.id.ActionButton:
                buttonPressed = "Action";
                break;
            case R.id.BonusActionButton:
                buttonPressed = "BonusAction";
                break;
            default:
                throw new RuntimeException("Unknown Button ID...somehow");
        }


        Intent intent = new Intent(this, DisplayTurnAbilities.class);
        intent.putExtra("BUTTON_PRESSED", buttonPressed);
        startActivity(intent);
    }

    public String getLastOptionChecked(String option) {
        option = lastOptionChecked;
        return option;
    }
}
