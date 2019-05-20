package com.example.practicandocontinuacasa;

public class Companeros {

    private String nombre;
    private int foto;
    private int edad;

    public Companeros() {
    }

    public Companeros(String nombre, int foto, int edad) {
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
