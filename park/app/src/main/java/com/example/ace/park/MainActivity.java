package com.example.ace.park;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insert,display;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        display = findViewById(R.id.display);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ins.class);
                MainActivity.this.startActivity(intent);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,dis.class);
                MainActivity.this.startActivity(intent);
            }
        });


    }
}
