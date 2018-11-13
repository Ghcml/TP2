package com.ml.gcastanon.entregabledos;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetalleReceta extends AppCompatActivity {
    public static  final String KEY_RECETA = "object_receta";
    private List<DetalleFragment> listaDetallesFragment;
    private  int indice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);
           listaDetallesFragment = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
          Receta receta = (Receta) bundle.get(KEY_RECETA);

           List<Receta> listaRecetas = RecetasProvider.cargarRecetas();

           for (int i = 0; i<listaRecetas.size();i++){
               DetalleFragment detalleFragment = DetalleFragment.getFragment(listaRecetas.get(i));
               listaDetallesFragment.add(detalleFragment);
                   if(listaRecetas.get(i).getNombre().equalsIgnoreCase(receta.getNombre())){
                       indice = i;
                   }
           }

           final ViewPager viewPager = findViewById(R.id.viewPager);
           final FragmentStateAdapter fragmentStateAdapter = new FragmentStateAdapter(getSupportFragmentManager(),listaDetallesFragment);

           viewPager.setAdapter(fragmentStateAdapter);

           viewPager.setCurrentItem(indice);


    }
}
