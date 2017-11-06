package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.jquirogl.appclinicaproject.menu.BottomNavigationViewHelper;
import com.jquirogl.appclinicaproject.recycler.RecyclerServiciosAdapter;

public class TwoActivity extends AppCompatActivity {

    //NO TOCAR , CODIGO PARA LA BARRA DE NAVEGACION
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    //Intent intent2 = new Intent(TwoActivity.this, TwoActivity.class);
                    //startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(TwoActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(TwoActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(TwoActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    String [] nombreServ ={"Emergencias","Psicología","Nutrición"};
    String [] sedeServ = {"Sede Surco, La Molina","Todas las sedes","Sede surco"};
    String [] descServ = {"Alojasas pduandg hshdfuasdf hsdfhdfhsdh sdfjdhsfsdhfhsd hdsds","Nueva ashsadñfñoh asuasas bukasd auskdhkas ihasd","Ssdkasasgkdgas baskdbaksbd kasdkasdksabdkbdsa baskdbkasbdsabkdas"};
    String [] coberServ = {"Lima, Arequipa","Lima Metropolitana", "Lima, Arequipa, Ica"};
    String [] precioServ = {"95.00","42.00","56.00"};
    int [] imagenes = {R.drawable.emergencia128,R.drawable.fresa,R.drawable.fresa};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        //References
        RecyclerView rv = (RecyclerView) findViewById(R.id.myRecycler);

        //set propierties
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        RecyclerServiciosAdapter adapter = new RecyclerServiciosAdapter(this,nombreServ,sedeServ, descServ, coberServ, precioServ, imagenes);
        rv.setAdapter(adapter);
    }
}
