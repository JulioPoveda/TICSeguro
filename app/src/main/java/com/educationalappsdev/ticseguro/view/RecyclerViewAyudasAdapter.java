package com.educationalappsdev.ticseguro.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.educationalappsdev.ticseguro.R;

import java.util.ArrayList;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase RecyclerViewAyudasAdapter
 *
 * Gestiona la lista de Ayudas
 */
public class RecyclerViewAyudasAdapter extends RecyclerView.Adapter<RecyclerViewAyudasAdapter.ViewHolder> {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    //------------------------------------------------------------------------------------
    // Constructores
    //------------------------------------------------------------------------------------

    public RecyclerViewAyudasAdapter(Context mContext, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item_ayudas, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String nextActivity = mImageNames.get(position);

                Class nextClass = null;

                if (nextActivity.equals("Centro Cibernético Policial"))
                {
                    nextClass = CentroCiberneticoPolicialActivity.class;
                }
                else if (nextActivity.equals("Superintendencia de Industria y Comercio"))
                {
                    nextClass = SuperintendenciaIndustriaComercioActivity.class;
                }
                else
                {
                    nextClass = MinTICActivity.class;
                }

                Intent mainMenuIntent = new Intent(mContext, nextClass);
                mContext.startActivity(mainMenuIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        CardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagen_ayuda);
            parentLayout = itemView.findViewById(R.id.parent_layout_ayudas);
        }
    }

}
