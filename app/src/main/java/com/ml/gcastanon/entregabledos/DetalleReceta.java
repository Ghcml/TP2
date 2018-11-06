package com.ml.gcastanon.entregabledos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleReceta extends AppCompatActivity {
    public static  final String KEY_RECETA = "object_receta";
    private ImageView imageViewPerfil;
    private TextView textViewTitulo,textViewIngredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        imageViewPerfil = findViewById(R.id.imageView_detalle_perfil);
        textViewTitulo = findViewById(R.id.textView_detalle_titulo);
        textViewIngredientes = findViewById(R.id.textView_detalle_ingredientes);
        //OBTENEMOS EL INTENT QUE LE MANDAMOS DESDE EL MAIN
        Intent intent = getIntent();
        //PEDIMOS LA BURBUJA QUE VIENE CON EL OBJETO (RECETAS) DESDE EL MAIN
        Bundle bundle = intent.getExtras();

        Receta receta = (Receta) bundle.getSerializable(KEY_RECETA);

        imageViewPerfil.setImageResource(receta.getImagen());
        textViewIngredientes.setText(receta.getDescripcion());
        textViewTitulo.setText(receta.getNombre());

    }
}
