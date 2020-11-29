package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MenuBusqueda {

    @FXML
    public Label ErrorcaracterABuscar;

    @FXML
    public Label ErroropcionesClase;

    @FXML
    public Label ErroropcionesAtributo;

    @FXML
    public TextField caracterABuscar;

    @FXML
    public CheckBox Area;

    @FXML
    public CheckBox Empleado;

    @FXML
    public CheckBox Cliente;

    @FXML
    public CheckBox Atributo1;

    @FXML
    public CheckBox Atributo2;

    @FXML
    public CheckBox Atributo3;

    @FXML
    public DialogPane Consola;

    @FXML
    private void SeleccionArea(ActionEvent event) throws IOException {
        if (Area.isSelected()) {
            Empleado.setSelected(false);
            Cliente.setSelected(false);
            Atributo1.setText("Nombre");
            Atributo2.setText("Ingresos");
            Atributo3.setText("Gerente");
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
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                        if (App.areas.containsKey(String.valueOf(caracterABuscar.getText()).toLowerCase())) {
                            Consola.setHeaderText("Resultados: ");
                            Consola.setContentText(String.valueOf(App.areas.get(String.valueOf(caracterABuscar.getText()))));
                        } else {
                            Consola.setHeaderText("No se encuentran resultados!");
                            Consola.setContentText("");
                        }
                    } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor");
                }
                }
            if (Atributo2.isSelected()) {
                //Ingresos
                if (!caracterABuscar.getText().equals("")) {
                    try {
                        if(!App.ingresos.containsKey(Integer.parseInt(caracterABuscar.getText()))){
                            Consola.setContentText("No se encontraron resultados");
                        }
                        else{
                            ArrayList<Area>Areas=App.ingresos.get(Integer.parseInt(caracterABuscar.getText()));
                                Consola.setContentText(String.valueOf(Areas));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor");
                }
            }
            if (Atributo3.isSelected()) {
                //Gerente
                if (!caracterABuscar.getText().equals("")) {
                    if(!App.Gerentes.containsKey(caracterABuscar.getText().toLowerCase())){
                        Consola.setContentText("No se encontraron resultados");
                    }
                    else{
                        ArrayList<Area>Areas=App.Gerentes.get(caracterABuscar.getText().toLowerCase());
                        Consola.setContentText(String.valueOf(Areas));
                    }
                }
                else{
                    ErrorcaracterABuscar.setText("Ingrese  un valor");
                }
            }
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
                        if(!App.edades.containsKey(Integer.parseInt(caracterABuscar.getText()))){
                            Consola.setContentText("No se encontraron resultados");
                        }
                        else{
                            ArrayList<Empleado>Empleados=App.edades.get(Integer.parseInt(caracterABuscar.getText()));
                            Consola.setContentText(String.valueOf(Empleados));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor");
                }
            }
            if (Atributo3.isSelected()){
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                    if(!App.NombreEmpleado.containsKey(caracterABuscar.getText().toLowerCase())){
                        Consola.setContentText("No se encontraron resultados");
                    }
                    else{
                        ArrayList<Empleado>Empleados=App.NombreEmpleado.get(caracterABuscar.getText().toLowerCase());
                        Consola.setContentText(String.valueOf(Empleados));
                    }
                }
                else{
                    ErrorcaracterABuscar.setText("Ingrese un valor valido");
                }
            }
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
                        if(!App.Dinero.containsKey(Integer.parseInt(caracterABuscar.getText()))){
                            Consola.setContentText("No se encontraron resultados");
                        }
                        else{
                            ArrayList<Cliente>clientes=App.Dinero.get(Integer.parseInt(caracterABuscar.getText()));
                            Consola.setContentText(String.valueOf(clientes));
                        }
                    } catch (NumberFormatException nfe) {
                        ErrorcaracterABuscar.setText("Valor invalido!");
                    }
                } else {
                    ErrorcaracterABuscar.setText("Ingrese un valor");
                }
            }
            if (Atributo3.isSelected()){
                //Nombre
                if (!caracterABuscar.getText().equals("")) {
                    if(!App.NombreClientes.containsKey(caracterABuscar.getText().toLowerCase())){
                        Consola.setContentText("No se encontraron resultados");
                    }
                    else{
                        ArrayList<Cliente>clientes=App.NombreClientes.get(caracterABuscar.getText().toLowerCase());
                        Consola.setContentText(String.valueOf(clientes));
                    }
                }
                else{
                    ErrorcaracterABuscar.setText("Ingrese un valor valido");
                }
                }
        }
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
