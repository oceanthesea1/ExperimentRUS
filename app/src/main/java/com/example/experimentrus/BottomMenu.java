package com.example.experimentrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.experimentrus.databinding.ActivityBottomMenuBinding;
import com.example.experimentrus.databinding.ActivityMainBinding;

public class BottomMenu extends AppCompatActivity {

    ActivityBottomMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_home) {

                replaceFragment(new HomeFragment());

            } else if (itemId == R.id.menu_messages) {

                replaceFragment(new MessagesFragment());

            } else if (itemId == R.id.menu_me) {

                replaceFragment(new ProfileFragment());

            } else if (itemId == R.id.menu_settings) {

                replaceFragment(new SettingsFragment());

            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }
}