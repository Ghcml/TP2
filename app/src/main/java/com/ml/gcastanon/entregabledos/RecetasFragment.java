package com.ml.gcastanon.entregabledos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecetasFragment extends Fragment implements RecetaAdapter.ListenerRecetasAdapter {
    private RecyclerView recyclerViewRecetas;
    private ListenerRecyclerViewFragments listenerRecyclerViewFragments;
    public RecetasFragment() {
        // Required empty public constructor
    }


    public void onAttach(Context context){
        super.onAttach(context);
        this.listenerRecyclerViewFragments = (ListenerRecyclerViewFragments) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recetas_fragment, container, false);
        recyclerViewRecetas = view.findViewById(R.id.recyclerView_recetas);
        List<Receta> recetas = RecetasProvider.cargarRecetas();
        RecetaAdapter recetaAdapter = new RecetaAdapter(recetas,this);

        //CREAMOS LAYOUT MANAGER
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerViewRecetas.setAdapter(recetaAdapter);
        recyclerViewRecetas.setLayoutManager(linearLayoutManager);
        recyclerViewRecetas.setHasFixedSize(true);
        return view;
    }



    @Override
    public void informarSeleccionado(Receta receta) {
        listenerRecyclerViewFragments.informarSeleccionado(receta);
    }

    public interface  ListenerRecyclerViewFragments {
        public void informarSeleccionado(Receta receta);
    }
}
