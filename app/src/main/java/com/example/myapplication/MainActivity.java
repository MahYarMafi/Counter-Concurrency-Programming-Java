package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtCounter;
    private int counter = 0;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                txtCounter.setText("" + counter);
            }
        };


        txtCounter = findViewById(R.id.txtCounter);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (counter < 10) {
                    try {
                        counter += 1;
                        Log.i("test", "Counter is : #" + counter);
                        handler.post(runnable) ;

                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();
    }
}