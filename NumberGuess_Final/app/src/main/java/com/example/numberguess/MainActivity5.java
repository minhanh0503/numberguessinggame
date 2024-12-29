package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity5 extends AppCompatActivity {
    private Button button3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        button3 = (Button) findViewById(R.id.buttonContinue);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityEnd();
            }
        });
    }

    public void openActivityEnd() {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }
}

