package com.jms.infogram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jms.infogram.R;
import com.jms.infogram.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CradViewHolder>{
    //Lista de imagenes

    private ArrayList<Image>images;
    private int resource;
    private Activity activity;

    public CardViewAdapter(ArrayList<Image> images,int resource, Activity activity){
        this.images = images;
        this.resource = resource;
        this.activity = activity;
    }


    @NonNull
    @Override
    public CradViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent, false);

        return new CradViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CradViewHolder holder, int position) {

        Image image = images.get(position);

        //imag
        Picasso.get().load(image.getUrlImagen()).into(holder.imageCardView);

        holder.usernameCardView.setText(image.getUsername());
        holder.cantidadDiasCardView.setText(image.getCantidadDias());
        holder.cantidadMeGustaCardView.setText(image.getCantidadMeGusta());

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CradViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageCardView;
        private TextView usernameCardView;
        private TextView cantidadDiasCardView;
        private TextView cantidadMeGustaCardView;

        public CradViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCardView= itemView.findViewById(R.id.imageCardView);
            usernameCardView= itemView.findViewById(R.id.usernameCardView);
            cantidadDiasCardView= itemView.findViewById(R.id.cantidadDiasCardView);
            cantidadMeGustaCardView= itemView.findViewById(R.id.cantidadMeGustaCardView);

        }
    }

}
