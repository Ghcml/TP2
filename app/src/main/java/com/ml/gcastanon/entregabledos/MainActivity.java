package com.ml.gcastanon.entregabledos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements RecetasFragment.ListenerRecyclerViewFragments {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView_main);
        drawerLayout = findViewById(R.id.drawerLayout_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemAbout:
                        Toast.makeText(getApplicationContext(),"Tocaste About",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemRecetas:
                        // TODO creo un fragment manager y llamo al fragment RecetasFragments
                        FragmentManager supportFragment = getSupportFragmentManager(); //TODO  creo y llamo al support fragment manager
                        FragmentTransaction fragmentTransaction = supportFragment.beginTransaction();
                        fragmentTransaction.replace(R.id.contenedor,new RecetasFragment()).commit();


                        break;

                        default:
                            break;
                }
                drawerLayout.closeDrawers();
                return  true;

            }
        });
    }

    @Override
    public void informarSeleccionado(Receta receta) {
        Intent intent = new Intent(this,DetalleReceta.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable(DetalleReceta.KEY_RECETA,receta);

        intent.putExtras(bundle);
        startActivity(intent);




    }
}
