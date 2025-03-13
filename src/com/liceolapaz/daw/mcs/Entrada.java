package com.liceolapaz.daw.mcs;

public abstract class Entrada {
    protected int codigo;
    protected Asistente asistente;

    public Entrada(int codigo, Asistente asistente) {
        this.codigo = codigo;
        this.asistente = asistente;
    }

    public int getCodigo() {
        return codigo;
    }

    public abstract double getPrecio();

    public Asistente getAsistente(){
        return asistente;
    }

    @Override
    public String toString() {
        return "Entrada " + codigo + " Precio " + getPrecio() + "€  Comprador: " + asistente.toString();
    }
}