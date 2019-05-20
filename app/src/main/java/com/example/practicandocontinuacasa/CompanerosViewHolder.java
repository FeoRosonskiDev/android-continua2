package com.example.practicandocontinuacasa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanerosViewHolder extends RecyclerView.ViewHolder {

    TextView nombre;
    TextView edad;
    ImageView foto;

    public CompanerosViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.txtNombreCompanero);
        edad = itemView.findViewById(R.id.txtEdadCompanero);
        foto = itemView.findViewById(R.id.ivFoto);
    }
}
