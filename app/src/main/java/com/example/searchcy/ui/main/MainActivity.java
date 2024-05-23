package com.example.searchcy.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.searchcy.R;
import com.example.searchcy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button bt_login;
    private Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //appBarConfiguration = new AppBarConfiguration.Builder(
          //      R.id.fragment_login, R.id.fragment_register) // Substitua fragment1 e fragment2 pelos IDs reais de seus fragmentos
            //    .build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        NavController navController = navHostFragment.getNavController();


       bt_login = findViewById(R.id.bt_login);
       bt_register = findViewById(R.id.bt_register);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LoginFragment loginFragment = new LoginFragment();
                fragmentTransaction.replace(R.id.fragment_container, loginFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                bt_login.setVisibility(View.GONE);
                bt_register.setVisibility(View.GONE);
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //getSupportFragmentManager().popBackStack("main_fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RegistarFragment registrarFragment = new RegistarFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main, registrarFragment); // Use R.id.nav_host_fragment_content_main como o contêiner do fragmento
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                bt_login.setVisibility(View.GONE);
                bt_register.setVisibility(View.GONE);
            }

        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onBackPressed(){
        super.onBackPressed();
        bt_login.setVisibility(View.VISIBLE);
        bt_register.setVisibility(View.VISIBLE);
    }
}
