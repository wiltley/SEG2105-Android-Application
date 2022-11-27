package com.example.mealerapplication.ui.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mealerapplication.R;
import com.example.mealerapplication.data.accounthandling.CookHandler;
import com.example.mealerapplication.data.model.Recipe;
import com.example.mealerapplication.ui.client.MyPurchases;
import com.example.mealerapplication.ui.cook.MyMealsActivity;
import com.example.mealerapplication.ui.cook.MyOfferedMealsActivity;
import com.example.mealerapplication.ui.cook.MySales;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class CookRecipeView extends AppCompatActivity {
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        // The recipe to display
        Recipe recipe = (Recipe) getIntent().getSerializableExtra("recipe");
        String offered = recipe.getOffered();

        TextView name = findViewById(R.id.recipeName);
        TextView cuisineType = findViewById(R.id.recipeCuisineType);
        TextView price =findViewById(R.id.recipePrice);
        TextView description = findViewById(R.id.recipeDescription);

        name.setText(getString(R.string.recipe_name, recipe.getRecipeName()));
        cuisineType.setText(getString(R.string.recipe_cuisine_type, recipe.getCuisineType()));
        price.setText(getString(R.string.recipe_price, recipe.getPrice()));
        description.setText(getString(R.string.recipe_description, recipe.getDescription()));


        Button submit = findViewById(R.id.submitRecipeOffered);
        TextView offer = findViewById(R.id.cookIsOffered);


        if(offered.equals("true")){

            offer.setText("Remove this meal from offered?");

        }else{

            offer.setText("Add this meal to offered?");
        }

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                if(offered.equals("false")){

                    CookHandler.addRecipeToOffered(recipe, CookRecipeView.this);
                }
                    else{

                    CookHandler.removeFromOffered(recipe, CookRecipeView.this);;

                }

                Intent intent = new Intent(CookRecipeView.this, MyOfferedMealsActivity.class);
                    startActivity(intent);
            }
        });


        // Pulls the ingredients and instructions...
        //recipe.getFullRecipe();

        nav = findViewById(R.id.btm_nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.myMenu:
                        Toast.makeText(CookRecipeView.this, "meals", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CookRecipeView.this, MyMealsActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.createFood:
                        Toast.makeText(CookRecipeView.this, "meals", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(CookRecipeView.this, CreateRecipe.class);
                        startActivity(intent2);
                        break;

                    case R.id.requests:
                        Toast.makeText(CookRecipeView.this, "requests", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(CookRecipeView.this, MySales.class);
                        startActivity(intent3);
                        break;
                    case R.id.myProfile:
                        Toast.makeText(CookRecipeView.this, "profile", Toast.LENGTH_LONG).show();
//                        Intent intent2 = new Intent(MyMealsActivity.this, .class);
//                        startActivity(intent2);
                        break;

                    default:
                }

                return true;
            }
        });
    }
}