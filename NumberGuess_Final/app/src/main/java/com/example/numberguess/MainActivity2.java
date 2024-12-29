package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
    public int attempts = 3;
    int result;

    static int getRandomNumber(int max, int min) {
//        return (int) ((Math.random()
//                * (max - min)) + min);
        Random rand = new Random();
        return rand.nextInt(max-min+1) + min;
    }

    public void makeToast(String str) {
        Toast.makeText(MainActivity2.this, str, Toast.LENGTH_SHORT).show();
    }

    public void restartClickFunction(View view) {
        MyApplication myApplication = (MyApplication) getApplication();
        Player currentPlayer = myApplication.getCurrentPlayer();
        currentPlayer.setUserPoints(0);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void makeDialog(String msg, Intent redirectingIntent) {
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage(msg)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(redirectingIntent);
                    }
                })
                .show();
    }

    private void clickFunction(View view, int userGuessing) {
        if (attempts == 1 && userGuessing != result) {
            makeDialog("You Lost", new Intent(this, MainActivity5.class));
            return;
        }
        if (userGuessing < result) {
            makeToast("Think of Higher Number, Try Again");
            attempts--;
            TextView textView = (TextView) findViewById(R.id.attempts);
            textView.setText("Attempts: " + attempts);
            textView.invalidate();
        } else if (userGuessing > result) {
            makeToast("Think of Lower Number, Try Again");
            attempts--;
            TextView textView = (TextView) findViewById(R.id.attempts);
            textView.setText("Attempts: " + attempts);
            textView.invalidate();
        } else {
            MyApplication myApplication = (MyApplication) getApplication();
            Player currentPlayer = myApplication.getCurrentPlayer();
            int newPoints = currentPlayer.getUserPoints() + attempts;
            currentPlayer.setUserPoints(newPoints) ;
            makeDialog("Congratulations, You Got The Number", new Intent(this, MainActivity3.class));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result = getRandomNumber(5,1);

        findViewById(R.id.buttonView1).setOnClickListener(view -> {
            clickFunction(view, 1);
        });
        findViewById(R.id.buttonView2).setOnClickListener(view -> {
            clickFunction(view, 2);
        });
        findViewById(R.id.buttonView3).setOnClickListener(view -> {
            clickFunction(view, 3);
        });
        findViewById(R.id.buttonView4).setOnClickListener(view -> {
            clickFunction(view, 4);
        });
        findViewById(R.id.buttonView5).setOnClickListener(view -> {
            clickFunction(view, 5);
        });

        TextView textView = (TextView) findViewById(R.id.attempts);
        textView.setText("Attempts: " + attempts);
        textView.invalidate();
    }
}

