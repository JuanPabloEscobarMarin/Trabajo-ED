package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private void Buscar(ActionEvent salir)throws IOException{


        //Proceso de busqueda

        App.setRoot("MenuUsuario");
    }

    @FXML
    private void Salir(ActionEvent salir)throws IOException {
        App.setRoot("MenuUsuario");
    }


}
