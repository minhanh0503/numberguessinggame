package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        result = getRandomNumber(15,1);

        findViewById(R.id.buttonView1).setOnClickListener( view -> {
            clickFunction(view , 1);
        });
        findViewById(R.id.buttonView2).setOnClickListener( view -> {
            clickFunction(view , 2);
        });
        findViewById(R.id.buttonView3).setOnClickListener( view -> {
            clickFunction(view , 3);
        });
        findViewById(R.id.buttonView4).setOnClickListener( view -> {
            clickFunction(view , 4);
        });
        findViewById(R.id.buttonView5).setOnClickListener( view -> {
            clickFunction(view , 5);
        });
        findViewById(R.id.buttonView6).setOnClickListener( view -> {
            clickFunction(view , 6);
        });
        findViewById(R.id.buttonView7).setOnClickListener( view -> {
            clickFunction(view , 7);
        });
        findViewById(R.id.buttonView8).setOnClickListener( view -> {
            clickFunction(view , 8);
        });
        findViewById(R.id.buttonView9).setOnClickListener( view -> {
            clickFunction(view , 9);
        });
        findViewById(R.id.buttonView10).setOnClickListener( view -> {
            clickFunction(view , 10);
        });
        findViewById(R.id.buttonView11).setOnClickListener( view -> {
            clickFunction(view , 11);
        });
        findViewById(R.id.buttonView12).setOnClickListener( view -> {
            clickFunction(view , 12);
        });
        findViewById(R.id.buttonView13).setOnClickListener( view -> {
            clickFunction(view , 13);
        });
        findViewById(R.id.buttonView14).setOnClickListener( view -> {
            clickFunction(view , 14);
        });
        findViewById(R.id.buttonView15).setOnClickListener( view -> {
            clickFunction(view , 15);
        });
        TextView textView = (TextView)findViewById(R.id.attempts);
        textView.setText("Attempts: "+ attempts);
    };

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

    int result;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }


    public void makeToast(String str)
    {
        Toast.makeText(MainActivity4.this, str, Toast.LENGTH_SHORT).show();
    }

    public int attempts = 3;

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
        }
        else if (userGuessing > result) {
            makeToast("Think of Lower Number, Try Again");
            attempts--;
            TextView textView = (TextView) findViewById(R.id.attempts);
            textView.setText("Attempts: " + attempts);
            textView.invalidate();
        }
        else {
            MyApplication myApplication = (MyApplication) getApplication();
            Player currentPlayer = myApplication.getCurrentPlayer();
            int newPoints = currentPlayer.getUserPoints() + attempts;
            currentPlayer.setUserPoints(newPoints) ;
            makeDialog("Congratulations, You Got The Number", new Intent(this, MainActivity5.class));
        }
    }
}