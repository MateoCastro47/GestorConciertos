package com.liceolapaz.daw.mcs;

import java.util.ArrayList;
import java.util.List;

public class GestorEntradas {
    private List<Entrada> entradasVendidas = new ArrayList<>();
    private int totalEntradasGradas = 25000;
    private int totalEntradasPista = 1000;
    private int backstageDisponibles = 100;
    private int contadorEntradas = 1; // Contador único de entradas

    public GestorEntradas() {
        this.entradasVendidas = entradasVendidas;
        this.totalEntradasGradas = totalEntradasGradas;
        this.totalEntradasPista = totalEntradasPista;
        this.backstageDisponibles = backstageDisponibles;
    }

    public List<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    public int getTotalEntradasGradas() {
        return totalEntradasGradas;
    }

    public int getTotalEntradasPista() {
        return totalEntradasPista;
    }

    public int getBackstageDisponibles() {
        return backstageDisponibles;
    }

    public boolean reservarEntrada(Entrada entrada){
        if (entrada == null) {
            System.out.println("Error: La entrada no puede ser nula.");
            return false;
        }

        if (!entrada.getAsistente().esMayorDeEdad()){
            System.out.println("Error: Los menores de edad no pueden comprar entradas");
            return false;
        }
        if (entrada instanceof EntradaGrada && totalEntradasGradas > 0){
            entradasVendidas.add(entrada);
            totalEntradasGradas--;
            return true;
        } else if (entrada instanceof  EntradaPista) {
            EntradaPista ep = (EntradaPista) entrada;
            if (ep.TieneAccesoBackstage() && backstageDisponibles > 0){
                backstageDisponibles--;
                totalEntradasPista--;
                entradasVendidas.add(entrada);
                return true;
            } else if (!ep.TieneAccesoBackstage() && totalEntradasPista > 0) {
                totalEntradasPista--;
                entradasVendidas.add(entrada);
                return true;
            }
        }
        return false;
    }
    public void mostrarEntradas(){
        if (entradasVendidas.isEmpty()){
            System.out.println("No se han vendido entradas");
        }
        else {
            for (Entrada e : entradasVendidas){
                System.out.println(e);
            }
        }
    }
    public void mostrarEntradasDisponibles() {
        System.out.println("Entradas de grada: " + totalEntradasGradas);
        System.out.println("Entradas a pie de pista: " + totalEntradasPista);
        System.out.println("Backstage: " + backstageDisponibles);
    }

    public int generarCodigoEntrada() {
        return contadorEntradas++; // Devuelve el código y luego incrementa el contador
    }
}
