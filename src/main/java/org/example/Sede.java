package org.example;

public class Sede {
    public String nombre;
    public String gerente;
    public int ingresoSede;
    public int gastosSede;

    public Sede (String nombre, String gerente, int ingresoSede, int gastosSede) {
        this.nombre = nombre;
        this.gerente = gerente;
        this.ingresoSede = ingresoSede;
        this.gastosSede = gastosSede;
    }

    @Override
    public String toString(){
        return ", nombre: "+nombre+", gerente: "+gerente+", fondos: "+ingresoSede+", gastos: "+gastosSede;
    }
}