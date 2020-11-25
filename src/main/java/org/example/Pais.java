package org.example;

public class Pais {
    public String nombre;
    public String presidente;

    public Pais(String nombre,String presidente){
        this.nombre=nombre;
        this.presidente=presidente;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+", presidente: "+presidente;
    }

}