package com.jms.infogram.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jms.infogram.R;
import com.jms.infogram.view.fragment.HomeFragment;
import com.jms.infogram.view.fragment.ProfileFragment;
import com.jms.infogram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_container);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       /* BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {*/

                        Fragment selectedFragment = null;

                        if(item.getItemId() == R.id.search){
                            selectedFragment = new SearchFragment();
                        }
                        else if (item.getItemId() == R.id.home){
                            selectedFragment = new HomeFragment();
                        }
                        else if (item.getItemId() == R.id.profile){
                            selectedFragment = new ProfileFragment();
                        }

                     /*   switch (item.getItemId()){
                            case R.id.search:
                                selectedFragment = new SearchFragment();
                                break;

                            case R.id.home:
                                selectedFragment = new HomeFragment();
                                break;

                            case R.id.profile:
                                selectedFragment = new ProfileFragment();
                                break;
                        }*/

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame,selectedFragment)
                                .commit();

                        return true;
                    }
                }
        );

    }
}