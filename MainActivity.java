package com.myapp.aiqpg.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.myapp.aiqpg.R;
import com.myapp.aiqpg.fragments.GenerateFragment;
import com.myapp.aiqpg.fragments.HistoryFragment;
import com.myapp.aiqpg.fragments.HomeFragment;
import com.myapp.aiqpg.fragments.NotepadFragment;
import com.myapp.aiqpg.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private final HomeFragment homeFragment = new HomeFragment();
    private final GenerateFragment generateFragment = new GenerateFragment();
    private final NotepadFragment notepadFragment = new NotepadFragment();
    private final HistoryFragment historyFragment = new HistoryFragment();
    private final ProfileFragment profileFragment = new ProfileFragment();

    private Fragment activeFragment = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, profileFragment, "profile").hide(profileFragment)
                .add(R.id.fragment_container, historyFragment, "history").hide(historyFragment)
                .add(R.id.fragment_container, notepadFragment, "notepad").hide(notepadFragment)
                .add(R.id.fragment_container, generateFragment, "generate").hide(generateFragment)
                .add(R.id.fragment_container, homeFragment, "home")
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                showFragment(homeFragment);
                return true;
            } else if (itemId == R.id.nav_generate) {
                showFragment(generateFragment);
                return true;
            } else if (itemId == R.id.nav_notepad) {
                showFragment(notepadFragment);
                return true;
            } else if (itemId == R.id.nav_history) {
                showFragment(historyFragment);
                return true;
            } else if (itemId == R.id.nav_profile) {
                showFragment(profileFragment);
                return true;
            }
            return false;
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .hide(activeFragment)
                .show(fragment)
                .commit();
        activeFragment = fragment;
    }
}
