package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Graph<Object, DefaultEdge> sistema=new SimpleGraph<>(DefaultEdge.class);
    public static ArrayList<Usuario> usuarios=new ArrayList<>();
    public static Hashtable<String,Area>areas=new Hashtable<>();
    public static Hashtable<Integer,Empleado>empleados=new Hashtable<>();
    public static Hashtable<Integer, Cliente>clientes=new Hashtable<>();
    public static TreeMap<Integer, ArrayList<Area>> ingresos=new TreeMap<>();
    public static TreeMap<String,ArrayList<Area>> Gerentes= new TreeMap<>();
    public static TreeMap<Integer,ArrayList<Empleado>>edades=new TreeMap<>();
    public static TreeMap<String,ArrayList<Empleado>>NombreEmpleado=new TreeMap<>();
    public static TreeMap<Integer,ArrayList<Cliente>> Dinero=new TreeMap<>();
    public static TreeMap<String,ArrayList<Cliente>>NombreClientes=new TreeMap<>();

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MenuUsuario"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        Usuario nuevoUsuario = new Usuario("123456789","pepito", "perez", "example.com", "1234");
        usuarios.add(nuevoUsuario);
        launch();
    }

}