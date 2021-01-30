package com.example.footballdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner playerSpinner = (Spinner) findViewById(R.id.player_spinner);
        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kansas_players));
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerSpinner.setAdapter(playerAdapter);

        //team selection spinner
        Spinner teamSpinner = (Spinner) findViewById(R.id.team_spinner);
        ArrayAdapter<String> teamAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_spinner));
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamSpinner.setAdapter(teamAdapter);
        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                changePlayerSpinner(playerSpinner, playerAdapter, teamSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //do nothing
            }
        });

    }

    protected void changePlayerSpinner(Spinner playerSpinner, ArrayAdapter playerAdapter, String team) {
        if(team.equals("Kansas City Chiefs")) {
            playerAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kansas_players));
            playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            playerSpinner.setAdapter(playerAdapter);
        } else if (team.equals("Tampa Bay Buccaneers")) {
            playerAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tampa_players));
            playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            playerSpinner.setAdapter(playerAdapter);
        }
    }
}