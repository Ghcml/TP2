package com.ml.gcastanon.entregabledos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {

    private static  final String CLAVE_OBJ = "receta";

    public DetalleFragment() {
        // Required empty public constructor
    }

    public static DetalleFragment getFragment(Receta receta){
        DetalleFragment detalleFragment = new DetalleFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(CLAVE_OBJ,receta);

        detalleFragment.setArguments(bundle);
        return detalleFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        Bundle bundle = getArguments();

        Receta receta = (Receta) bundle.getSerializable(CLAVE_OBJ);

        TextView textViewTitulo = view.findViewById(R.id.textView_fragment_detalle_titulo);
        ImageView imageViewFoto = view.findViewById(R.id.imageView_fragment_detalle_foto);
        TextView  textViewIngredientes = view.findViewById(R.id.textView_fragment_detalle_ingredientes);

        textViewTitulo.setText(receta.getNombre());
        imageViewFoto.setImageResource(receta.getImagen());
        textViewIngredientes.setText(receta.getDescripcion());


        return view;
    }

}
