package com.ml.gcastanon.entregabledos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter {

    private List<Receta> listRecetas;
    private  ListenerRecetasAdapter listenerRecetasAdapter;

    public RecetaAdapter(List<Receta> listRecetas,ListenerRecetasAdapter listenerRecetasAdapter){
        this.listRecetas = listRecetas;
        this.listenerRecetasAdapter = listenerRecetasAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //Buscamos el inflador desde el contexto

        View view = layoutInflater.inflate(R.layout.celda_receta,parent,false);

        ViewHolderReceta viewHolderReceta = new ViewHolderReceta(view);

        return viewHolderReceta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receta receta = listRecetas.get(position);
        ViewHolderReceta viewHolderReceta = (ViewHolderReceta) holder;
        viewHolderReceta.bind(receta);
    }

    @Override
    public int getItemCount() {
        return listRecetas.size();
    }



    private class ViewHolderReceta extends  RecyclerView.ViewHolder {

        private ImageView imageViewPerfil;
        private TextView textViewTitulo,textViewDescripcion;
        private Receta receta;
        public ViewHolderReceta(View itemView) {
            super(itemView);
            imageViewPerfil = itemView.findViewById(R.id.imageView_celda_recetas_perfil);
            textViewTitulo = itemView.findViewById(R.id.textView_celda_recetas_titulo);
            textViewDescripcion = itemView.findViewById(R.id.textView_celda_recetas_descripcion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerRecetasAdapter.informarSeleccionado(receta);
                }
            });
        }

        public void bind(Receta receta){
            this.receta = receta;
            textViewTitulo.setText(receta.getNombre());
            textViewDescripcion.setText(receta.getDescripcion());
            if (receta.getImagen() == null){
                imageViewPerfil.setImageResource(R.drawable.ic_kitchen_black_24dp);
            }else
                {
                    imageViewPerfil.setImageResource(receta.getImagen());
                }


        }
    }
    public interface ListenerRecetasAdapter{
        public void informarSeleccionado(Receta receta);
    }
}
