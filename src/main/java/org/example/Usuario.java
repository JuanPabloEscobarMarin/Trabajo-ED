package org.example;

public class Usuario {
    public String documento;
    public String nombre;
    public String apellido;
    public String correo;
    public String password;

    public Usuario(String documento, String nombre, String apellido, String correo, String password) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }
}