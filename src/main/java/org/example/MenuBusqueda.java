package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
    private void SeleccionCliente(ActionEvent event) throws IOException{
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


        //Proceso de busqueda

        App.setRoot("MenuUsuario");
    }

    @FXML
    private void Salir(ActionEvent salir)throws IOException {
        App.setRoot("MenuUsuario");
    }


}
