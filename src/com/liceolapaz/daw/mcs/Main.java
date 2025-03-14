package com.liceolapaz.daw.mcs;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        GestorEntradas gestor = new GestorEntradas();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            //Escribir menu
            escribirmenu();
            //Leemos la opción
            opcion = scanner.nextInt();
            scanner.nextLine();
            //Hacemos un switch para ver que opción seguir.
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Ingrese su nombre");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese su apellido");
                    String apellido = scanner.nextLine();

                    System.out.println("Ingrese su DNI");
                    String DNI = scanner.nextLine();

                    System.out.println("Ingrese su email");
                    String email = scanner.nextLine();

                    //Vamos a ver si el email existe
                    boolean emailExiste = false; //Inicialmente no existe.
                    for (Entrada e : gestor.getEntradasVendidas()){
                        if (e.getAsistente().getEmail().equals(email)){
                            emailExiste = true;
                            break;
                        }
                    }
                    if (emailExiste){
                        System.out.println("Este email ya existe");
                        break;
                    }
                    //Validación de fecha
                    System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD)");
                    String fechaUsuario = scanner.nextLine();
                    while (!fechaUsuario.matches("\\d{4}-\\d{2}-\\d{2}")){
                        System.out.println("Error: Formato incorrecto. Use (YYYY-MM-DD)");
                        fechaUsuario = scanner.nextLine();
                    }
                    LocalDate fechaNacimiento = LocalDate.parse(fechaUsuario);

                    //Creamos el objeto asistente
                    Asistente asistente = new Asistente(nombre,DNI,apellido,email,fechaNacimiento);
                    //Creamos un submenú para pedir el tipo de entrada
                    System.out.println("""
                            TIPO DE ENTRADA:
                            1. Grada
                            2. Pista""");
                    int tipoEntrada = scanner.nextInt();
                    scanner.nextLine(); //Consume el salto de linea
                    Entrada entrada = null;
                    //Si la entrada es de grada pedimos fila y asiento.
                    if (tipoEntrada == 1){
                        System.out.println("Ingrese fila");
                        int fila = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ingrese asiento");
                        int asiento = scanner.nextInt();
                        scanner.nextLine();
                        //Contamos cuantos asientos hay en esa fila
                        int asientosOcupadosEnFila = 0;
                        for (Entrada e : gestor.getEntradasVendidas()){
                            if (e instanceof EntradaGrada){
                                EntradaGrada eg = (EntradaGrada) e;
                                if (eg.getFila() == fila) {
                                    asientosOcupadosEnFila++;
                                }
                            }
                        }
                        //Validamos si el asiento está ocupado.
                        boolean asientoOcupado = false;
                        for (Entrada e : gestor.getEntradasVendidas()){
                            if (e instanceof EntradaGrada){
                                EntradaGrada eg = (EntradaGrada) e;
                                if (eg.getFila() == fila && eg.getAsiento() == asiento){
                                    asientoOcupado = true;
                                    break;
                                }
                            }
                        }
                        if (asientoOcupado){
                            System.out.println("Asiento ya ocupado");
                            break;
                        }
                        entrada = new EntradaGrada(gestor.generarCodigoEntrada(), asistente, fila, asiento);
                    } else if (tipoEntrada == 2) {
                        System.out.println("¿Acceso a backstage? (true/false):");
                        boolean backstage = scanner.nextBoolean();
                        scanner.nextLine();
                        entrada = new EntradaPista(gestor.generarCodigoEntrada(), asistente, backstage);
                    }
                    //Intentamos reservar la entrada:
                    if (gestor.reservarEntrada(entrada)) {
                        System.out.println("¡Entrada reservada con éxito!");
                    } else {
                        System.out.println("No se pudo completar la reserva.");
                    }
                    break;
                case 2:
                    //Mostramos la entrada por email
                    System.out.println("Ingrese su email:");
                    String emailBusqueda = scanner.nextLine();
                    boolean encontrada = false;
                    for (Entrada e : gestor.getEntradasVendidas()) {
                        if (e.getAsistente().getEmail().equals(emailBusqueda)) {
                            System.out.println("Entrada encontrada:");
                            System.out.println(e);
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("No se encontró ninguna entrada con ese email.");
                    }
                    break;
                case 3:
                    //Mostramos las entradas vendidas
                    System.out.println("Entradas vendidas:");
                    gestor.mostrarEntradas();
                    break;
                case 4:
                    //Mostramos las entradas sin vender
                    gestor.mostrarEntradasDisponibles();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(true);
    }

    private static void escribirmenu() {
        System.out.println("""
                Gestor Conciertos
                1. Reservar Entrada
                2. Mostrar Entrada
                3. Listar entradas vendidas
                4. Mostrar entradas disponibles
                0. Salir
                Escoja una opción""");
    }
}
