package com.example.scoutingdataentry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RobotEntry extends AppCompatActivity {

    EditText teamNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_entry);
        final Intent i = new Intent(RobotEntry.this, PitData.class);

        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamNumber = findViewById(R.id.teamNumber);
                if(Integer.parseInt(teamNumber.getText().toString()) == 0) {
                    Toast.makeText(RobotEntry.this, "Provide a Team Number", Toast.LENGTH_SHORT).show();
                } else {
                    GameData.mTempStorage.setTeamNumber(Integer.parseInt(teamNumber.getText().toString()));
                    Storage.isGameData.setGameDataCheck(true);
                    startActivity(new Intent(RobotEntry.this, GameData.class));
                }
            }
        });

        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamNumber = findViewById(R.id.teamNumber);
                if(Integer.parseInt(teamNumber.getText().toString()) == 0) {
                    Toast.makeText(RobotEntry.this, "Provide a Team Number", Toast.LENGTH_SHORT).show();
                } else {
                    PitData.mTempStorage.setTeamNumber(Integer.parseInt(teamNumber.getText().toString()));
                    Storage.isGameData.setGameDataCheck(false);
                    //using i to avoid bug
                    startActivity(i);
                }
            }
        });

    }
}
