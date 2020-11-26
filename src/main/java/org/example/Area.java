package org.example;

import org.jgrapht.Graphs;

import java.util.ArrayList;

public class Area {

    public String nombreDelArea;
    public int ingresoArea;
    public  int gastoArea;

    public Area (String nombreDelArea, int ingresoArea, int gastoArea) {
        this.nombreDelArea = nombreDelArea ;
        this.ingresoArea = ingresoArea;
        this.gastoArea= gastoArea;

    }

    @Override
    public String toString(){
        return "Nombre del area: "+nombreDelArea+", ingresos: "+ingresoArea+", gastos: "+gastoArea;
    }
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Area)){
            return false;
        }
        Area area =(Area) obj;
        return area.nombreDelArea.toLowerCase().equals(this.nombreDelArea.toLowerCase());
    }

    public ArrayList<Object> relaciones(){
        return new ArrayList<>(Graphs.neighborListOf(App.sistema, this));
    }

}