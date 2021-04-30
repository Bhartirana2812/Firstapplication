package com.example.fregmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fregmentexample.fragments.FragmentA;
import com.example.fregmentexample.fragments.FragmentB;

public class MainActivity extends AppCompatActivity {

    Button loadA,loadB,activity;

    LinearLayout layout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadA = findViewById(R.id.framA);
        loadB = findViewById(R.id.framB);
        layout = findViewById(R.id.layout);
        activity = findViewById(R.id.activity);

        loadA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,new FragmentB());
                fragmentTransaction.commit();
            }
        });


        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                }else{
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });


        loadB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,new FragmentA());
                fragmentTransaction.commit();
            }
        });
    }
}