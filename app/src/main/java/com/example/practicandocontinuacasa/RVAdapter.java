package com.example.practicandocontinuacasa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<CompanerosViewHolder> {

    List<Companeros> lista_companeros;

    public RVAdapter(List<Companeros> lista_companeros){
        this.lista_companeros = lista_companeros;
    }

    @NonNull
    @Override
    public CompanerosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_companero,
                viewGroup, false);

        return new CompanerosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanerosViewHolder cvh, int i) {

        cvh.nombre.setText(lista_companeros.get(i).getNombre());
        cvh.edad.setText(String.valueOf(lista_companeros.get(i).getEdad()));
        cvh.foto.setImageResource(lista_companeros.get(i).getFoto());
    }

    @Override
    public int getItemCount() {
        return lista_companeros.size();
    }
}
