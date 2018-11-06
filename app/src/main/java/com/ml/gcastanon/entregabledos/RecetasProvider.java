package com.ml.gcastanon.entregabledos;

import java.util.ArrayList;
import java.util.List;

public class RecetasProvider {

    public static List<Receta> cargarRecetas(){
        List<Receta> listRecetas = new ArrayList<>();
        listRecetas.add(new Receta("Hamburgesa Tradicional","BLABLABLALA",R.drawable.h_tradicional));
        listRecetas.add(new Receta("Hamburgesa de Pollo","BLABLABLALA",R.drawable.h_pollo));
        listRecetas.add(new Receta("Hamburgesa apta para Diabeticos","BLABLABLALA",R.drawable.h_diabeticos));
        listRecetas.add(new Receta("Hamburguesa de Camaron","BLABLABLALBA",R.drawable.h_camaron));
        return listRecetas;
    }
}
