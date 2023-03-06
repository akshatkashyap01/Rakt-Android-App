package com.example.rakt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainscreenActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    public static final String information_file="information_file";
    public static final String information_key="information_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);


        findIds();
        navigationset();

    }

    private void findIds() {
        bottomNav = findViewById(R.id.bottomnav);
    }

    private void navigationset() {
        NavController navController = Navigation.findNavController(this, R.id.home_fragment);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }

//    @Override
//    public void onBackPressed() {
//
//
//
//    }

}