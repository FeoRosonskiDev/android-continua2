package com.example.practicandocontinuacasa;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PromedioFragment extends Fragment {

    private EditText c1;
    private EditText c2;
    private EditText c3;
    private EditText proyecto;
    private Spinner colores_fondo;
    private Button calcular;
    private TextView promedio;

    public PromedioFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_promedio, container, false);

        c1 = view.findViewById(R.id.txtC1);
        c2 = view.findViewById(R.id.txtC2);
        c3 = view.findViewById(R.id.txtC3);
        proyecto = view.findViewById(R.id.txtProyecto);
        promedio = view.findViewById(R.id.txtPromedio);
        calcular = view.findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validarCampos())
                    promedio.setText("Su promedio es: " + calcularPromedio(c1, c2, c3, proyecto));
                else
                    mensajeError();
            }
        });

        // Spinner part

        colores_fondo = view.findViewById(R.id.spinnerColorFondo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colores_fondo.setAdapter(adapter);

        colores_fondo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                cambiarColorFondo(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    private boolean validarCampos()
    {
        return !(c1.getText().toString().equals("") || c2.getText().toString().equals("")
            || c3.getText().toString().equals("") || proyecto.getText().toString().equals(""));
    }

    private double calcularPromedio(EditText c1, EditText c2, EditText c3, EditText pro)
    {
        double a = Double.parseDouble(c1.getText().toString());
        double b = Double.parseDouble(c2.getText().toString());
        double c = Double.parseDouble(c3.getText().toString());
        double d = Double.parseDouble(pro.getText().toString());

        return (a + b + c) / 3 * 0.4 + d * 0.6;
    }

    private void mensajeError()
    {
        Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
    }

    private void cambiarColorFondo(int posicion){
        switch (posicion) {
            case 0:
                getView().setBackgroundColor(Color.WHITE);
                break;
            case 1:
                getView().setBackgroundColor(Color.parseColor("#b2ffff"));
                break;
            case 2:
                getView().setBackgroundColor(Color.GREEN);
                break;
            case 3:
                getView().setBackgroundColor(Color.RED);
                break;
        }
    }

}
