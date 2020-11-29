package org.example;

import org.jgrapht.Graphs;

import java.util.ArrayList;

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
        return " -Nombre : "+nombre+"; cedula: "+cedula+"; edad: "+edad+"; salario: "+salario + "\n";
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Empleado)){
            return false;
        }
        Empleado empleado =(Empleado) obj;
        return empleado.cedula==this.cedula;
    }

    public ArrayList<Object> relaciones(){
        return new ArrayList<>(Graphs.neighborListOf(App.sistema, this));
    }
}