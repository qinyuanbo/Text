package com.example.text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> objects = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            objects.add(i+"");
        }
        RecyclerView viewById = (RecyclerView) findViewById(R.id.recycleView);
        viewById.setAdapter(new Myadpet(objects));
        viewById.setLayoutManager(new Mymarger());

    }
}