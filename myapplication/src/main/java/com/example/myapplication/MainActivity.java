package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView viewById;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
          viewById  = (TextView) findViewById(R.id.textview);
        Timer timer = new Timer(5, new Timer.TimeConnect() {
            @Override
            public void filash() {
                viewById.setText("ceshi");
            }

            @Override
            public void down(int ceshi) {
                String s = ceshi + "";

                viewById.setText(s);
            }
        });
        timer.start();
    }
}