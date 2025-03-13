package com.liceolapaz.daw.mcs;

public class EntradaGrada extends Entrada{
    private final int fila;
    private final int asiento;
    public static final double PRECIO_GRADA = 50.0;
    public static final int maximo_asientos_por_fila = 15;

    public EntradaGrada(int codigo, Asistente asistente, int fila, int asiento) {
        super(codigo, asistente);
        this.fila = fila;
        this.asiento = asiento;
    }

    public int getFila() {
        return fila;
    }

    public int getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return super.toString() + "(Grada) Fila: " + fila + " Asientos: " + asiento;
    }

    @Override
    public double getPrecio() {
        return PRECIO_GRADA;
    }
}