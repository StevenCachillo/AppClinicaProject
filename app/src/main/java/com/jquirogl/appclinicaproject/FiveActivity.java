package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;

public class FiveActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(FiveActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(FiveActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(FiveActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(FiveActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    //Intent intent5 = new Intent(FiveActivity.this, FiveActivity.class);
                    //startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }
}
