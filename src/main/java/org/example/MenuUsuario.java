package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MenuUsuario {
    @FXML
    public Label ErrorUsuario;
    @FXML
    public Label ErrorPasword;
    @FXML
    public TextField Usuario;
    @FXML
    public TextField Password;
    @FXML
    private void Entrar(ActionEvent entrar)throws IOException {
        ErrorPasword.setText("");
        ErrorUsuario.setText("");
        for (Usuario usuario:App.usuarios) {
            if(Usuario.getText().equals(usuario.documento)||Usuario.getText().equals(usuario.correo)){
                if(Password.getText().equals(usuario.password)){
                    App.setRoot("MenuPrincipal");
                }
                else{
                   ErrorPasword.setText("Contraseña incorrecta");
                }

            }
            else{
                ErrorUsuario.setText("Usuario incorrecto");
            }
        }
    }
    @FXML
    private void Salir(ActionEvent salir) throws IOException{
        System.exit(0);
    }

    @FXML
    private void Registro(ActionEvent registro)throws  IOException{
        App.setRoot("MenuRegistro");
    }


}
