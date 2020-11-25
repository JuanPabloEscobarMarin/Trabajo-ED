package org.example;
public class Cliente {
    public String nombre;
    public int dinero;
    public int cedula;

    public Cliente(String nombre, int cedula, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.cedula = cedula;
    }

    @Override
    public String toString(){
        return "Nombre : "+nombre+", cedula: "+cedula;
    }
}