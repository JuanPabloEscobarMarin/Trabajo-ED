package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    private void SeleccionArea(ActionEvent event) throws IOException{
        if(Area.isSelected()){
            Empleado.setSelected(false);
            Cliente.setSelected(false);
            Atributo1.setText("Nombre");
            Atributo2.setText("Ingresos");
            Atributo3.setText("Sede");
        }
    }

    @FXML
    private void SeleccionEmpleado(ActionEvent event) throws IOException{
        if(Empleado.isSelected()){
            Area.setSelected(false);
            Cliente.setSelected(false);
            Atributo1.setText("Cedula");
            Atributo2.setText("Edad");
            Atributo3.setText("Nombre");
        }
    }

    @FXML
    private void SeleccionarCliente(ActionEvent event) throws IOException{
        if(Cliente.isSelected()){
            Area.setSelected(false);
            Empleado.setSelected(false);
            Atributo1.setText("Cedula");
            Atributo2.setText("Dinero");
            Atributo3.setText("Nombre");
        }
    }
    @FXML
    private void SeleccionarAtributo1(ActionEvent event)throws IOException{
        if(Atributo1.isSelected()){
            Atributo2.setSelected(false);
            Atributo3.setSelected(false);
        }
    }

    @FXML
    private void SeleccionarAtributo2(ActionEvent event)throws IOException{
        if(Atributo2.isSelected()){
            Atributo1.setSelected(false);
            Atributo3.setSelected(false);
        }
    }

    @FXML
    private void SeleccionarAtributo3(ActionEvent event) throws IOException{
        if(Atributo3.isSelected()){
            Atributo1.setSelected(false);
            Atributo2.setSelected(false);
        }
    }

    @FXML
    private void Buscar(ActionEvent salir)throws IOException{
        if (!Area.isSelected() && !Empleado.isSelected() && !Cliente.isSelected()){
            ErroropcionesClase.setText("Seleccione una clase");
        } else {
            ErroropcionesClase.setText("");
        }
        if (!Atributo1.isSelected() && !Atributo2.isSelected() && !Atributo3.isSelected()){
            ErroropcionesAtributo.setText("Seleccione un atributo");
        } else {
            ErroropcionesAtributo.setText("");
        }
        if (Area.isSelected() && Atributo1.isSelected()){
            if (!caracterABuscar.getText().equals("")){
                ErrorcaracterABuscar.setText("");
                if(App.areas.containsKey(caracterABuscar.getText().toLowerCase())){
                    Consola.setHeaderText("Resultados: ");
                    Consola.setContentText(String.valueOf(App.areas.get(caracterABuscar.getText().toLowerCase())));
                } else {
                    Consola.setHeaderText("No se encuentran resultados!");
                    Consola.setContentText("");
                }
            } else {
                ErrorcaracterABuscar.setText("Ingrese un valor valido");
            }
        }

        if (Empleado.isSelected() && Atributo1.isSelected()) {
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

        if (Cliente.isSelected() && Atributo1.isSelected()) {
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
                } catch (NumberFormatException nfe){
                    ErrorcaracterABuscar.setText("Valor invalido!");
                }
            } else {
                ErrorcaracterABuscar.setText("Ingrese un valor valido");
            }
        }

        if (Area.isSelected() && Atributo2.isSelected()){
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
