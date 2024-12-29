package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        MyApplication myApplication = (MyApplication) getApplication();
        List<Player> playerList = myApplication.getPlayerList();
        Collections.sort(playerList);

        Player player1 = playerList.get(0);

        findViewById(R.id.newGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(intent);
            }
        });


        ((TextView) findViewById(R.id.name1)).setText(player1.getUserName() + ": " + player1.getUserPoints());

        if (playerList.size() > 1) {
            Player player2 = playerList.get(1);
            ((TextView) findViewById(R.id.name2)).setText(player2.getUserName() + ": " + player2.getUserPoints());
        }
        else {
            ((TextView) findViewById(R.id.name2)).setText("");
        }

        if (playerList.size() > 2) {
            Player player3 = playerList.get(2);
            ((TextView) findViewById(R.id.name3)).setText(player3.getUserName() + ": " + player3.getUserPoints());
        }
        else {
            ((TextView) findViewById(R.id.name3)).setText("");
        }

        if (playerList.size() > 3) {
            Player player4 = playerList.get(3);
            ((TextView) findViewById(R.id.name4)).setText(player4.getUserName() + ": " + player4.getUserPoints());
        }
        else {
            ((TextView) findViewById(R.id.name4)).setText("");
        }

    }
}