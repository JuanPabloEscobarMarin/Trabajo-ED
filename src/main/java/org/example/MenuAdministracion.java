package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MenuAdministracion {
    @FXML
    public Label ErrorClase;
    @FXML
    public Label ErrorOpcion;
    @FXML
    public Label ErrorText;
    @FXML
    public CheckBox Area;
    @FXML
    public CheckBox Empleado;
    @FXML
    public CheckBox Cliente;
    @FXML
    public CheckBox Crear;
    @FXML
    public CheckBox Editar;
    @FXML
    public CheckBox Ver;
    @FXML
    public CheckBox Eliminar;
    @FXML
    public TextField Texto;
    @FXML
    public Button BotonVer;

    @FXML
    private void Siguiente(ActionEvent siguiente)throws IOException {
        if(Area.isSelected()&&Ver.isSelected()){
            Texto.setVisible(true);
            BotonVer.setVisible(true);

        }
    }
    @FXML
    private void Salir(ActionEvent salir)throws IOException{
        App.setRoot("MenuPrincipal");
    }


    public void ActionVer(ActionEvent actionEvent) {
    }
}
