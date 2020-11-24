package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MenuRegistro {
    @FXML
    public Label ErrorDocumento;
    @FXML
    public Label ErrorNombre;
    @FXML
    public Label ErrorApellido;
    @FXML
    public Label ErrorCorreo;
    @FXML
    public Label ErrorPassword;
    @FXML
    public Label ErrorConfirmarPassword;
    @FXML
    public TextField Documento;
    @FXML
    public TextField Nombre;
    @FXML
    public TextField Apellido;
    @FXML
    public TextField Correo;
    @FXML
    public TextField Password;
    @FXML
    public TextField ConfirmarPassword;
    @FXML
    private void Enviar(ActionEvent enviar)throws IOException {
        ErrorDocumento.setText("");
        ErrorNombre.setText("");
        ErrorApellido.setText("");
        ErrorCorreo.setText("");
        ErrorPassword.setText("");
        ErrorConfirmarPassword.setText("");
        if(Documento.getText().equals("")){
            ErrorDocumento.setText("Documento vacio");
        }
        else if(Nombre.getText().equals("")){
            ErrorNombre.setText("Nombre vacio");
        }
        else if(Apellido.getText().equals("")){
            ErrorApellido.setText("Apeliido vacio");
        }
        else if(Correo.getText().equals("")){
            ErrorCorreo.setText("Correo vacio");
        }
        else if(Password.getText().equals("")){
            ErrorPassword.setText("contaseña vacia");
        }
        else if(!ConfirmarPassword.getText().equals(Password.getText())){
            ErrorConfirmarPassword.setText("Las contraseñas no son iguales");
        }
        else{
            Usuario nuevoUsuario =new Usuario(Documento.getText(),Nombre.getText(),Apellido.getText(),Correo.getText(),Password.getText());
            App.usuarios.add(nuevoUsuario);
            App.setRoot("MenuUsuario");
        }

    }

    @FXML
    private void Salir(ActionEvent salir)throws IOException{
        App.setRoot("MenuUsuario");
    }


}
