package org.example;

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

}