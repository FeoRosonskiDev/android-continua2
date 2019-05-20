package com.example.practicandocontinuacasa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CompanerosListaFragment extends Fragment {

    private ListView lista_companeros;
    int LA_ULTIMA = compis().length - 1;

    public CompanerosListaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_companeros_lista, container, false);

        lista_companeros = view.findViewById(R.id.lvCompaneros);

        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, compis());
        lista_companeros.setAdapter(adapter);

        lista_companeros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mensajito(i);
            }
        });

        return view;
    }

    private String [] compis()
    {
        return new String[]{"El alto", "El chato", "El flaco", "El gordo", "El cachi",
                "El cachi 2", "La sobrina", "La hija de mi hermano"};
    }

    /* XD */
    private void mensajito(int posicion){

        if(posicion == LA_ULTIMA)
            Toast.makeText(getContext(), "Cachi está bien pendejo", Toast.LENGTH_SHORT).show();
    }

}
