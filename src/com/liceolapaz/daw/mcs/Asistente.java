package com.liceolapaz.daw.mcs;

import java.time.LocalDate;
import java.time.Period;

public class Asistente {
    private String nombre;
    private String dni;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;

    public Asistente(String nombre, String dni, String apellido, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public boolean esMayorDeEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " DNI: " + dni + " - Email: " + email + "  Nacimiento: " + fechaNacimiento;
    }
}

