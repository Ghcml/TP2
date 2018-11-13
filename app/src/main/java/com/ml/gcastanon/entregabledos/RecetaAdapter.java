package com.ml.gcastanon.entregabledos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter implements Filterable {

    private List<Receta> listRecetas;
    private List<Receta> filterListRecetas;
    private  ListenerRecetasAdapter listenerRecetasAdapter;
    private CustomFilter filter;

    public RecetaAdapter(List<Receta> listRecetas,ListenerRecetasAdapter listenerRecetasAdapter){
        this.listRecetas = listRecetas;
        this.listenerRecetasAdapter = listenerRecetasAdapter;
        this.filterListRecetas = listRecetas;
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

    @Override
    public Filter getFilter() {
        if(filter ==  null)
        {
            filter = new CustomFilter();
        }
        return filter;
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

            }else
                {
                    imageViewPerfil.setImageResource(receta.getImagen());
                }


        }
    }
    public interface ListenerRecetasAdapter{
        public void informarSeleccionado(Receta receta);
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();

            if(charSequence != null && charSequence.length()>0){
                charSequence = charSequence.toString().toUpperCase();
                List<Receta> filter = new ArrayList<>();

                for(int i = 0; i<filterListRecetas.size();i++) {
                    if (filterListRecetas.get(i).getNombre().toUpperCase().contains(charSequence)){
                        Receta  receta = new Receta(filterListRecetas.get(i).getNombre(),filterListRecetas.get(i).getDescripcion(),filterListRecetas.get(i).getImagen());
                        filter.add(receta);
                    }
                }

                results.count=filter.size();
                results.values=filter;
            }else{
                results.count=filterListRecetas.size();
                results.values=filterListRecetas;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            listRecetas= (List<Receta>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
