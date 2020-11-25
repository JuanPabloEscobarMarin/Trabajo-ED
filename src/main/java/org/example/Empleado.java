package org.example;

public class Empleado {
    public String nombre;
    public int cedula;
    public int edad;
    public int salario;

    public Empleado(String nombre, int cedula, int edad, int salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad =edad;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Nombre : "+nombre+", cedula: "+cedula+", edad: "+edad+", salario: "+salario;
    }
}