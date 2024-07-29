package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText nameInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication myApplication = (MyApplication) getApplication();
        List<Player> playerList = myApplication.getPlayerList();
        myApplication.setCurrentPlayer(new Player());
        Player currentPlayer = myApplication.getCurrentPlayer();
        playerList.add(currentPlayer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonRound1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPlayer.getUserName().length() != 0) {
                    openActivity2();
                }
            }
        });
        nameInput = (EditText) findViewById(R.id.name1);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String newName = nameInput.getText().toString();
                currentPlayer.setUserName(newName);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}