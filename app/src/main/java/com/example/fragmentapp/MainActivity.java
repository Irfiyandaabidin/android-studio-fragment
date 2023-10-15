package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnFragmentKontak;
    private Button btnFragmentChat;
    private FrameLayout containerFragment;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragmentKontak = findViewById(R.id.btnFragmentKontak);
        btnFragmentChat = findViewById(R.id.btnFragmentChat);
        containerFragment = findViewById(R.id.containerFragment);

        btnFragmentChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayFragment(new ChatFragment());
            }
        });

        btnFragmentKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayFragment(new KontakFragment());
            }
        });
    }

    private void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.containerFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}