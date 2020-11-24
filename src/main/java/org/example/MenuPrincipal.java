package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.IOException;

public class MenuPrincipal {

    @FXML
    private void Administracion(ActionEvent administracion)throws IOException {
        App.setRoot("MenuAdministracion");
    }

    @FXML
    private void Busqueda(ActionEvent busqueda) throws IOException{
        App.setRoot("MenuBusqueda");
    }
    @FXML
    private void Salir(ActionEvent salir)throws IOException{
        App.setRoot("MenuUsuario");
    }

}
