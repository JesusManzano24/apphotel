package com.example.hotelapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class HabitacionesAdapter extends RecyclerView.Adapter<HabitacionesAdapter.ViewHolder> {
    private List<Habitacion> habitacionesList;

    public HabitacionesAdapter(List<Habitacion> habitacionesList) {
        this.habitacionesList = habitacionesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_habitacion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Habitacion habitacion = habitacionesList.get(position);
        holder.nombre.setText(habitacion.getNombre());
        holder.precio.setText(habitacion.getPrecio());
        holder.descripcion.setText(habitacion.getDescripcion());

        // Cargar imagen desde URL con Glide
        Glide.with(holder.itemView.getContext())
                .load(habitacion.getImagenUrl()) // Usa la URL en lugar de R.drawable
                .placeholder(new ColorDrawable(Color.GRAY)) // Muestra un fondo gris mientras carga
                .error(new ColorDrawable(Color.RED)) // Fondo rojo si la imagen no carga
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return habitacionesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, precio, descripcion;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreHabitacion);
            precio = itemView.findViewById(R.id.precioHabitacion);
            descripcion = itemView.findViewById(R.id.descripcionHabitacion);
            imagen = itemView.findViewById(R.id.imagenHabitacion);
        }
    }
}