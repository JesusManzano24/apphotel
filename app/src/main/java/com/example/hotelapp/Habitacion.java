package com.example.hotelapp;

public class Habitacion {
    private String nombre, precio, descripcion;
    private String imagenUrl; // Cambiado a URL en lugar de int (R.drawable)

    public Habitacion(String nombre, String precio, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() { return nombre; }
    public String getPrecio() { return precio; }
    public String getDescripcion() { return descripcion; }
    public String getImagenUrl() { return imagenUrl; }
}