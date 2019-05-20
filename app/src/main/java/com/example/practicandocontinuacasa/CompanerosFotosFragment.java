package com.example.practicandocontinuacasa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CompanerosFotosFragment extends Fragment {

    RecyclerView companeros_recycler;
    List<Companeros> companeros_lista;

    public CompanerosFotosFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_companeros_fotos, container, false);

        companeros_recycler = view.findViewById(R.id.rvFotos);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        companeros_recycler.setLayoutManager(lm);
        companeros_recycler.setHasFixedSize(true);

        cargarData();
        cargarAdapter();

        return view;
    }

    private void cargarData()
    {
        companeros_lista = new ArrayList<>();
        companeros_lista.add(new Companeros("El alto", R.drawable.alto, 24));
        companeros_lista.add(new Companeros("El chato", R.drawable.chato, 22));
        companeros_lista.add(new Companeros("El flaco", R.drawable.flaco, 30));
        companeros_lista.add(new Companeros("El gordo", R.drawable.gordo, 27));
        companeros_lista.add(new Companeros("El cachi", R.drawable.cachi, 20));
        companeros_lista.add(new Companeros("El cachi 2", R.drawable.cachi, 20));
        companeros_lista.add(new Companeros("La sobrina", R.drawable.sobrina, 8));
        companeros_lista.add(new Companeros("La hija de mi hermano", R.drawable.sobrina, 8));
    }

    private void cargarAdapter()
    {
        RVAdapter rvAdapter = new RVAdapter(companeros_lista);
        companeros_recycler.setAdapter(rvAdapter);
    }
}
