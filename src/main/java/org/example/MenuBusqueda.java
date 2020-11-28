package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Hashtable;
import java.util.TreeMap;

public class MenuBusqueda {

    @FXML
    public Label ErrorcaracterABuscar;

    @FXML
    public Label ErroropcionesClase;

    @FXML
    public Label ErroropcionesAtributo;

    @FXML
    public static TextField caracterABuscar;

    @FXML
    public static CheckBox Area;

    @FXML
    public static CheckBox Empleado;

    @FXML
    public static CheckBox Cliente;

    @FXML
    public static CheckBox Atributo1;

    @FXML
    public static CheckBox Atributo2;

    @FXML
    public static CheckBox Atributo3;

    @FXML
    public static DialogPane Consola;

    @FXML
    private void SeleccionArea(ActionEvent event) throws IOException {
        if (Area.isSelected()) {
            Empleado.setSelected(false);
            Cliente.setSelected(false);
            Atributo1.setText("ID");
            Atributo2.setText("Ingresos");
            Atributo3.setText("Nombre");
        }
    }

    @FXML
    private void SeleccionEmpleado(ActionEvent event) throws IOException {
        if (Empleado.isSelected()) {
            Area.setSelected(false);
            Cliente.setSelected(false);
            Atributo1.setText("Cedula");
            Atributo2.setText("Edad");
            Atributo3.setText("Nombre");
        }
    }

    @FXML
    private void SeleccionarCliente(ActionEvent event) throws IOException {
        if (Cliente.isSelected()) {
            Area.setSelected(false);
            Empleado.setSelected(false);
            Atributo1.setText("Cedula");
            Atributo2.setText("Dinero");
            Atributo3.setText("Nombre");
        }
    }

    @FXML
    private void SeleccionarAtributo1(ActionEvent event) throws IOException {
        if (Atributo1.isSelected()) {
            Atributo2.setSelected(false);
            Atributo3.setSelected(false);
        }
    }

    @FXML
    private void SeleccionarAtributo2(ActionEvent event) throws IOException {
        if (Atributo2.isSelected()) {
            Atributo1.setSelected(false);
            Atributo3.setSelected(false);
        }
    }

    @FXML
    private void SeleccionarAtributo3(ActionEvent event) throws IOException {
        if (Atributo3.isSelected()) {
            Atributo1.setSelected(false);
            Atributo2.setSelected(false);
        }
    }

    @FXML
    private void Buscar(ActionEvent salir) throws IOException {
        if (!Area.isSelected() && !Empleado.isSelected() && !Cliente.isSelected()) {
            ErroropcionesClase.setText("Seleccione una clase");
        } else {
            ErroropcionesClase.setText("");
        }
        if (!Atributo1.isSelected() && !Atributo2.isSelected() && !Atributo3.isSelected()) {
            ErroropcionesAtributo.setText("Seleccione un atributo");
        } else {
            ErroropcionesAtributo.setText("");
            ErrorcaracterABuscar.setText("");
        }

        if (Area.isSelected()) {
            if (Atributo1.isSelected()) {
                //ID
                if (!caracterABuscar.getText().equals("")) {
                    int count = 1;
                    Hashtable<Integer, Area> ID = new Hashtable<>();
                    for (Area areas : App.areas.values()) {
                        ID.put(count, areas);
                        count++;
                    }
                    //Arreglar generador de ID que es aleatorio y mostrar el ID de cada Area creada
                    //Quitar ingresar Ingresos en administracion
                    try {
                        if (ID.containsKey(Integer.valueOf(caracterABuscar.getText()))) {
                            Consola.setHeaderText("Resultados: ");
                            Consola.setContentText(String.valueOf(ID.get(Integer.valueOf(caracterABuscar.getText()))));
                        } else {
                            Consola.setHeaderText("No se encuentran resultados!");
                            Consola.setContentText("");
                        }
                    } catch (NumberFormatException nfe) {
                        Consola.setHeaderText("Valor invalido!");
                    }
                    ID.clear();
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor valido");
                }

            }
            if (Atributo2.isSelected()) {
                //Ingresos
                if (!caracterABuscar.getText().equals("")) {
                    try {
                        TreeMap<Integer, Area> ingresos = new TreeMap<>();
                        int count = 1;
                        for (Area areas : App.areas.values()) {
                            if (areas.ingresoArea == Integer.parseInt(String.valueOf(caracterABuscar.getText()))) {
                                if (ingresos.containsKey(areas.ingresoArea)) {
                                    ingresos.put(areas.ingresoArea + count, areas);
                                    count++;
                                } else {
                                    ingresos.put(areas.ingresoArea, areas);
                                }
                            }
                        }
                        if (ingresos.size() == 0) {
                            Consola.setContentText("No se encontraron resultados");
                        } else {
                            Consola.setContentText(String.valueOf(ingresos.values()));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                }
            }
            if (Atributo3.isSelected()) {
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                    TreeMap<String, Area> nombres = new TreeMap<>();
                    //Quitar el for ya que el Nombre es único
                    int count = 1;
                    for (Area areas : App.areas.values()) {
                        if (areas.nombreDelArea.equals(String.valueOf(caracterABuscar.getText()))) {
                            if (nombres.containsKey(areas.nombreDelArea)) {
                                nombres.put(areas.nombreDelArea + count, areas);
                                count++;
                            } else {
                                nombres.put(areas.nombreDelArea, areas);
                            }
                        }
                    }
                    if (nombres.size() == 0) {
                        Consola.setContentText("No se encontraron resultados");
                    } else {
                        Consola.setContentText(String.valueOf(nombres.values()));
                    }
                }
            }
            borrarHistorialOpciones();
        }

        if (Empleado.isSelected()) {
            if (Atributo1.isSelected()){
                //Cedula
                if (!caracterABuscar.getText().equals("")) {
                    ErrorcaracterABuscar.setText("");
                    try {
                        if (App.empleados.containsKey(Integer.parseInt(caracterABuscar.getText()))) {
                            Consola.setHeaderText("Resultados: ");
                            Consola.setContentText(String.valueOf(App.empleados.get(Integer.valueOf(caracterABuscar.getText()))));
                        } else {
                            Consola.setHeaderText("No se encuentran resultados!");
                            Consola.setContentText("");
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor valido");
                }
            }
            if (Atributo2.isSelected()){
                //Edad
                if (!caracterABuscar.getText().equals("")) {
                    try {
                        TreeMap<Integer, Empleado> edades = new TreeMap<>();
                        int count = 1;
                        for (Empleado empleados : App.empleados.values()) {
                            if (empleados.edad == Integer.parseInt(String.valueOf(caracterABuscar.getText()))) {
                                if (edades.containsKey(empleados.edad)) {
                                    edades.put(empleados.edad + count, empleados);
                                    count++;
                                } else {
                                    edades.put(empleados.edad, empleados);
                                }
                            }
                        }
                        if (edades.size() == 0) {
                            Consola.setContentText("No se encontraron resultados");
                        } else {
                            Consola.setContentText(String.valueOf(edades.values()));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                }
            }
            if (Atributo3.isSelected()){
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                    TreeMap<String, Empleado> nombres = new TreeMap<>();
                    int count = 1;
                    for (Empleado empleados : App.empleados.values()) {
                        if (empleados.nombre.equals(String.valueOf(caracterABuscar.getText()))) {
                            if (nombres.containsKey(empleados.nombre)) {
                                nombres.put(empleados.nombre + count, empleados);
                                count++;
                            } else {
                                nombres.put(empleados.nombre, empleados);
                            }
                        }
                    }
                    if (nombres.size() == 0) {
                        Consola.setContentText("No se encontraron resultados");
                    } else {
                        Consola.setContentText(String.valueOf(nombres.values()));
                    }
                }
            }
            borrarHistorialOpciones();
        }

        if (Cliente.isSelected()) {
            if (Atributo1.isSelected()){
                //Cedula
                if (!caracterABuscar.getText().equals("")) {
                    ErrorcaracterABuscar.setText("");
                    try {
                        if (App.clientes.containsKey(Integer.parseInt(caracterABuscar.getText()))) {
                            Consola.setHeaderText("Resultados: ");
                            Consola.setContentText(String.valueOf(App.clientes.get(Integer.valueOf(caracterABuscar.getText()))));
                        } else {
                            Consola.setHeaderText("No se encuentran resultados!");
                            Consola.setContentText("");
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor valido");
                }
            }
            if (Atributo2.isSelected()){
                //Dinero
                if (!caracterABuscar.getText().equals("")) {
                    try {
                        TreeMap<Integer, Cliente> dineros = new TreeMap<>();
                        int count = 1;
                        for (Cliente cliente : App.clientes.values()) {
                            if (cliente.dinero == Integer.parseInt(String.valueOf(caracterABuscar.getText()))) {
                                if (dineros.containsKey(cliente.dinero)) {
                                    dineros.put(cliente.dinero + count, cliente);
                                    count++;
                                } else {
                                    dineros.put(cliente.dinero, cliente);
                                }
                            }
                        }
                        if (dineros.size() == 0) {
                            Consola.setContentText("No se encontraron resultados");
                        } else {
                            Consola.setContentText(String.valueOf(dineros.values()));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                }
            }
            if (Atributo3.isSelected()){
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                    TreeMap<String, Cliente> nombres = new TreeMap<>();
                    int count = 1;
                    for (Cliente cliente : App.clientes.values()) {
                        if (cliente.nombre.equals(String.valueOf(caracterABuscar.getText()))) {
                            if (nombres.containsKey(cliente.nombre)) {
                                nombres.put(cliente.nombre + count, cliente);
                                count++;
                            } else {
                                nombres.put(cliente.nombre, cliente);
                            }
                        }
                    }
                    if (nombres.size() == 0) {
                        Consola.setContentText("No se encontraron resultados");
                    } else {
                        Consola.setContentText(String.valueOf(nombres.values()));
                    }
                }
            }
            borrarHistorialOpciones();
        }
    }

    public static void borrarHistorialOpciones(){
        Area.setSelected(false);
        Empleado.setSelected(false);
        Cliente.setSelected(false);
        Atributo1.setSelected(false);
        Atributo2.setSelected(false);
        Atributo3.setSelected(false);
        caracterABuscar.setText("");
    }

    @FXML
    private void Salir(ActionEvent salir)throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
