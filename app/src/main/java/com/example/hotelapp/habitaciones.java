package com.example.hotelapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class habitaciones extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HabitacionesAdapter adapter;
    private List<Habitacion> habitacionesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitaciones);

        recyclerView = findViewById(R.id.recyclerHabitaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Simulación de datos de habitaciones con URLs en lugar de imágenes locales
        habitacionesList = new ArrayList<>();
        habitacionesList.add(new Habitacion("Suite Presidencial", "$300 por noche", "Lujo y exclusividad con vista panorámica.",
                "https://lh3.googleusercontent.com/pw/AP1GczPdf-O9eMFe1Wz0HjVvhhgzRuT9iP5nw4HDMwbK9r6-veRKrK8MaDPSkn1X7NqqXBbpgWOV_yM2hYlWgvE06SH2HoMQiVbfTQn_SUccq4qj1wOlzsd-OC0O_t3qYdiyDZeySBJes0Znw8VOQrjZbtk=w930-h620-s-no-gm?authuser=1"));

        habitacionesList.add(new Habitacion("Habitación Doble", "$150 por noche", "Ideal para parejas o amigos.",
                "https://lh3.googleusercontent.com/pw/AP1GczMjvFQzdiXxchZlBgwjJVunaIEqfEz6QA1T-a_gXJCORbNQX2YsWSRO6pi8UnQh11FQw15A1XlewIrkBJas-PVctMjdbSaEVPpnTKsNb69cDezFVon3ATurzeAvuDl061lrdqQgt1Fdm6UOQ_tZU4I=w851-h620-s-no-gm?authuser=1"));

        habitacionesList.add(new Habitacion("Habitación Individual", "$100 por noche", "Comodidad para viajeros solitarios.",
                "https://lh3.googleusercontent.com/pw/AP1GczP8B2lsArR68ZpU0MNWVKXNIlMv2fhExHJ1YMUa9Z2KkLTg0xraaagj_JWEGMy8kDJv4AA3OaUulj-VcdIusWdfxA8yCj-5uOTIUbiGZ3H1RG-gqyoi408-L1Ef_zJUzlhHdJPvT6SBG2dSt5kBAa8=w800-h600-s-no-gm?authuser=1"));

        adapter = new HabitacionesAdapter(habitacionesList);
        recyclerView.setAdapter(adapter);
    }
}