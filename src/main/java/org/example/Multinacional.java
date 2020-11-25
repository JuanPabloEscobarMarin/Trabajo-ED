package org.example;

public class Multinacional {
    public String nombre;
    public String ceo;
    public int ingresoTotal;
    public int gastoTotal;
    public int NIT;



    public Multinacional(String nombre, String ceo, int ingresoTotal, int gastoTotal, int NIT) {
        this.nombre = nombre ;
        this.NIT = NIT;
        this.ceo = ceo;
        this.ingresoTotal = ingresoTotal;
        this.gastoTotal = gastoTotal;

    }


    @Override
    public String toString(){
        return "Nombre: "+nombre+", ceo: "+ceo+", NIT: "+NIT+", fondos: "+ingresoTotal+", gastos: "+gastoTotal;
    }


}