package Packaje_JSON;

import Clases.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.ArrayList;

public class EscribirJSON {

    public static String ruta = "src/main/resources/database/";

    public static void guardarUsuario(Usuario usuario){
        JSONObject UsuarioDatos = new JSONObject();
        UsuarioDatos.put("documento", usuario.documento);
        UsuarioDatos.put("nombre", usuario.nombre);
        UsuarioDatos.put("apellido", usuario.apellido);
        UsuarioDatos.put("correo", usuario.correo);
        UsuarioDatos.put("contraseña", usuario.contraseña);
        JSONObject UsuarioPerfil = new JSONObject();
        UsuarioPerfil.put("Usuario", UsuarioDatos);

        JSONArray UsuarioLista = new JSONArray();
        UsuarioLista.add(UsuarioPerfil);
        try (FileWriter file = new FileWriter(ruta+"usuariosJSON.json")) {
            file.write(UsuarioLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }
}