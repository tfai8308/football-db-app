package com.example.footballdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;
import android.net.Uri;
//check input

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

        //jersey selection spinner
        Spinner numberSpinner = (Spinner) findViewById(R.id.number_spinner);
        ArrayAdapter<String> NumberAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Chief_Jersey));
        NumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberSpinner.setAdapter(NumberAdapter);

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

        WebView espn=(WebView) //keep these 2 lines
               findViewById(R.id.web);//important

  /*String a="ben ask";
        for(int i=0;i<a.length();i++)
        {
            if (a.charAt(i)==(' '))
                a=a.substring(0,i)+"%20"+a.substring(i+1);
        }
        String f="https://www.espn.com/search/_/q/"+a;
        espn.loadUrl(f);*/

        if(team.equals("Kansas City Chiefs")) {

            playerAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kansas_players));
            playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            playerSpinner.setAdapter(playerAdapter);

//important here
      String eurl=playerSpinner.getSelectedItem().toString(); //this lines gets input (player name)
            for(int i=0;i<eurl.length();i++)
            {
                if (eurl.charAt(i)==(' '))
                    eurl=eurl.substring(0,i)+"%20"+eurl.substring(i+1);
            }
                     String furl="https://www.espn.com/search/_/q/"+eurl; //transfer name into url address
            espn.loadUrl(furl);  //load url
            //copy and paste end here
        } else if (team.equals("Tampa Bay Buccaneers")) {
            playerAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tampa_players));
            playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            playerSpinner.setAdapter(playerAdapter);


//same as above
           String eurl=playerSpinner.getSelectedItem().toString();
            for(int i=0;i<eurl.length();i++)
            {
                if (eurl.charAt(i)==(' '))
                    eurl=eurl.substring(0,i)+"%20"+eurl.substring(i+1);
            }
            String furl="https://www.espn.com/search/_/q/"+eurl;
            espn.loadUrl(furl);
            //end here
        }
    }

}
