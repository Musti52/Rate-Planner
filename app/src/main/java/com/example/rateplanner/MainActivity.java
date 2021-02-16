package com.example.rateplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button raipurItemButton = (Button)findViewById(R.id.RaipurItemButton);
        raipurItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RaipurItemActivity.class);
                startActivity(intent);
            }
        });

        Button pipeButton = (Button)findViewById(R.id.PipeButton);
        pipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PipeActivity.class);
                startActivity(intent);
            }
        });

        Button raigarhItemButton = (Button)findViewById(R.id.RaigarhItemButton);
        raigarhItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RaigarhItemActivity.class);
                startActivity(intent);
            }
        });

        Button shreeOmTMTButton = (Button)findViewById(R.id.ShreeOmButton);
        shreeOmTMTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShreeOmTMTActivity.class);
                startActivity(intent);
            }
        });

        Button kamdhenuTMTButton = (Button)findViewById(R.id.KamdhenuButton);
        kamdhenuTMTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KamdhenuTMTActivity.class);
                startActivity(intent);
            }
        });

        Button raigarhTMTButton = (Button)findViewById(R.id.RaigarhTMTButton);
        raigarhTMTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RaigarhTMTActivity.class);
                startActivity(intent);
            }
        });

        Button goelTMTButton = (Button)findViewById(R.id.GoelTMTButton);
        goelTMTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoelTMTActivity.class);
                startActivity(intent);
            }
        });
    }
}