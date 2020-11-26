package org.example;

import org.jgrapht.Graphs;

import java.util.ArrayList;

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
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Cliente)){
            return false;
        }
        Cliente cliente =(Cliente) obj;
        return cliente.cedula==this.cedula;
    }

    public ArrayList<Object> relaciones(){

        return new ArrayList<>(Graphs.neighborListOf(App.sistema, this));
    }
}