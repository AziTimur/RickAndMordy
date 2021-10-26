package com.example.rickandmordy.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rickandmordy.R;
import com.example.rickandmordy.databinding.ActivityMainBinding;
import com.example.rickandmordy.ui.ui.charakter_list.CharakterFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CharakterFragment()).commit();
    }
}