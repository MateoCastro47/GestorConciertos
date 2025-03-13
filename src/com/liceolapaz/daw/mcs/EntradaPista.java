package com.liceolapaz.daw.mcs;

public class EntradaPista extends Entrada{
    private boolean accesoBackstage;
    public static final double PRECIO_PISTA = 80.0;
    public static final double PRECIO_BACKSTAGE = 120.0;

    public EntradaPista(int codigo, Asistente asistente, boolean accesoBackstage) {
        super(codigo, asistente);
        this.accesoBackstage = accesoBackstage;
    }

    public boolean TieneAccesoBackstage() {
        return accesoBackstage;
    }
    @Override
    public String toString(){
        return super.toString() + " (Pista) Backstage: " + (accesoBackstage ? "Sí" : "No");
    }

    @Override
    public double getPrecio() {
        return accesoBackstage ? PRECIO_BACKSTAGE: PRECIO_PISTA;
    }
}

