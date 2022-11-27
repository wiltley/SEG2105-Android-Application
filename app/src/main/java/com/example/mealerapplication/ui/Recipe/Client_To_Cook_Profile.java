package com.example.mealerapplication.ui.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mealerapplication.R;
import com.example.mealerapplication.ui.client.MealsSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Client_To_Cook_Profile extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_to_cook_profile);

        nav = findViewById(R.id.btm_nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.searchMenu_client:
                        Intent intent0 = new Intent(Client_To_Cook_Profile.this, MealsSearch.class);
                        startActivity(intent0);
                        return true;

                    case R.id.requests_client:
                        Intent intent = new Intent(Client_To_Cook_Profile.this, ClientRecipeView.class);
                        startActivity(intent);
                        return true;

                    case R.id.myProfile_client:
//                        Intent intent2 = new Intent(MyMealsActivity.this, .class);
//                        startActivity(intent2);
                        return true;

//                    default:
                }

                return false;
            }
        });
    }
}