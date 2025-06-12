package com.example.hotelapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import androidx.core.os.HandlerCompat; // Mejora el manejo de Handler para mayor compatibilidad

public class inicio extends AppCompatActivity {
    private ImageView habitacionImagen;
    private Handler handler;
    private int indiceActual = 0;
    private final String[] imagenesHabitaciones = {
            "https://lh3.googleusercontent.com/pw/AP1GczPdf-O9eMFe1Wz0HjVvhhgzRuT9iP5nw4HDMwbK9r6-veRKrK8MaDPSkn1X7NqqXBbpgWOV_yM2hYlWgvE06SH2HoMQiVbfTQn_SUccq4qj1wOlzsd-OC0O_t3qYdiyDZeySBJes0Znw8VOQrjZbtk=w930-h620-s-no-gm?authuser=1",
            "https://lh3.googleusercontent.com/pw/AP1GczMjvFQzdiXxchZlBgwjJVunaIEqfEz6QA1T-a_gXJCORbNQX2YsWSRO6pi8UnQh11FQw15A1XlewIrkBJas-PVctMjdbSaEVPpnTKsNb69cDezFVon3ATurzeAvuDl061lrdqQgt1Fdm6UOQ_tZU4I=w851-h620-s-no-gm?authuser=1",
            "https://lh3.googleusercontent.com/pw/AP1GczP8B2lsArR68ZpU0MNWVKXNIlMv2fhExHJ1YMUa9Z2KkLTg0xraaagj_JWEGMy8kDJv4AA3OaUulj-VcdIusWdfxA8yCj-5uOTIUbiGZ3H1RG-gqyoi408-L1Ef_zJUzlhHdJPvT6SBG2dSt5kBAa8=w800-h600-s-no-gm?authuser=1"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        habitacionImagen = findViewById(R.id.habitacionImagen);
        Button reservarBtn = findViewById(R.id.reservarBtn);
        TextView tituloHotel = findViewById(R.id.tituloHotel);

        // Inicializar Handler con el hilo principal
        handler = new Handler(Looper.getMainLooper());

        // Cargar primera imagen
        cargarImagen();

        // Cambio automático cada 5 segundos utilizando HandlerCompat
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cambiarImagen();
                handler.postDelayed(this, 5000);
            }
        }, 5000);
    }

    private void cargarImagen() {
        Glide.with(this)
                .load(imagenesHabitaciones[indiceActual])
                .placeholder(new ColorDrawable(Color.GRAY)) // Muestra gris mientras carga
                .error(new ColorDrawable(Color.RED)) // Rojo si la carga falla
                .into(habitacionImagen);
    }

    private void cambiarImagen() {
        indiceActual = (indiceActual + 1) % imagenesHabitaciones.length;
        cargarImagen();
    }
}