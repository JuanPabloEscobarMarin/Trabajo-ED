package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MenuAdministracion {
    @FXML
    public  Label ErrorClase;
    @FXML
    public Label ErrorOpcion;
    @FXML
    public Label ErrorText;
    @FXML
    public Label IngresarTexto;
    @FXML
    public Label Informacion;
    @FXML
    public Label Atributo1;
    @FXML
    public Label Atributo2;
    @FXML
    public Label Atributo3;
    @FXML
    public Label Atributo4;
    @FXML
    public Label Relacion1;
    @FXML
    public Label LabelRelacion1;
    @FXML
    public Label ErrorCrear;
    @FXML
    public Label ErrorVer;
    @FXML
    public Label ErrorEditar;
    @FXML
    public Label ErrorEliminar;
    @FXML
    public Label Atributoeditar1;
    @FXML
    public Label Atributoeditar2;
    @FXML
    public Label Atributoeditar3;
    @FXML
    public Label Atributoeditar4;
    @FXML
    public Label RelacionEditar1;
    @FXML
    public Label RelacionEditar2;



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
    public CheckBox Si1;
    @FXML
    public CheckBox No1;
    @FXML
    public CheckBox Atributos;
    @FXML
    public CheckBox Relaciones;
    @FXML
    public CheckBox BoxRelacion1;
    @FXML
    public CheckBox BoxRelacion2;
    @FXML
    public CheckBox BoxRelacion11;
    @FXML
    public CheckBox BoxRelacion22;




    @FXML
    public TextField Texto;
    @FXML
    public TextField Texto1;
    @FXML
    public TextField Texto2;
    @FXML
    public TextField Texto3;
    @FXML
    public TextField Texto4;
    @FXML
    public TextField RelacionTexto1;
    @FXML
    public TextField TextoEditar1;
    @FXML
    public TextField TextoEditar2;
    @FXML
    public TextField TextoEditar3;
    @FXML
    public TextField TextoEditar4;
    @FXML
    public TextField TextoRelacionEditar1;
    @FXML
    public TextField TextoRelacionEditar2;


    @FXML
    public Button BotonVer;
    @FXML
    public  Button BotonEliminar;
    @FXML
    public Button BotonCrear;
    @FXML
    public Button BotonEditar;
    @FXML
    public Button BotonBuscar;

    @FXML
    private void SeleccionarArea(ActionEvent area)throws IOException{
        if(Area.isSelected()){
            Empleado.setSelected(false);
            Cliente.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }
    @FXML
    private void SeleccionarEmpleado(ActionEvent empleado)throws IOException{
        if(Empleado.isSelected()){
            Area.setSelected(false);
            Cliente.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");}
    }
    @FXML
    private void SeleccionarCliente(ActionEvent cliente)throws IOException{
        if(Cliente.isSelected()){
            Empleado.setSelected(false);
            Area.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }

    @FXML
    private void SeleccionarCrear(ActionEvent crear)throws IOException{
        if(Crear.isSelected()){
            Editar.setSelected(false);
            Ver.setSelected(false);
            Eliminar.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }
    @FXML
    private void SeleccionarEditar(ActionEvent editar)throws IOException{
        if(Editar.isSelected()){
            Crear.setSelected(false);
            Ver.setSelected(false);
            Eliminar.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }
    @FXML
    private void SeleccionarVer(ActionEvent ver)throws IOException{
        if(Ver.isSelected()){
            Editar.setSelected(false);
            Crear.setSelected(false);
            Eliminar.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }
    @FXML
    private void SeleccionarEliminar(ActionEvent eliminar)throws IOException{
        if(Eliminar.isSelected()){
            Editar.setSelected(false);
            Ver.setSelected(false);
            Crear.setSelected(false);
            Informacion.setText("");
            Texto.setVisible(false);
            BotonVer.setVisible(false);
            IngresarTexto.setText("");
            BotonEliminar.setVisible(false);
            Texto1.setVisible(false);
            Texto2.setVisible(false);
            Texto3.setVisible(false);
            Texto4.setVisible(false);
            RelacionTexto1.setVisible(false);
            Si1.setVisible(false);
            No1.setVisible(false);
            BotonCrear.setVisible(false);
            Atributo1.setText("");
            Atributo2.setText("");
            Atributo3.setText("");
            Atributo4.setText("");
            Relacion1.setText("");
            LabelRelacion1.setText("");
            LabelRelacion1.setText("");
            ErrorCrear.setText("");
            ErrorVer.setText("");
            ErrorEditar.setText("");
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
            RelacionEditar1.setText("");
            RelacionEditar2.setText("");
            Atributos.setVisible(false);
            Relaciones.setVisible(false);
            BoxRelacion1.setVisible(false);
            BoxRelacion2.setVisible(false);
            BoxRelacion11.setVisible(false);
            BoxRelacion22.setVisible(false);
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            TextoRelacionEditar1.setVisible(false);
            TextoRelacionEditar2.setVisible(false);
            BotonEditar.setVisible(false);
            BotonBuscar.setVisible(false);
            ErrorClase.setText("");
            ErrorOpcion.setText("");
            ErrorText.setText("");
        }
    }

    @FXML
    private void Siguiente(ActionEvent siguiente)throws IOException {
        Informacion.setText("");
        Texto.setVisible(false);
        BotonVer.setVisible(false);
        IngresarTexto.setText("");
        BotonEliminar.setVisible(false);
        Texto1.setVisible(false);
        Texto2.setVisible(false);
        Texto3.setVisible(false);
        Texto4.setVisible(false);
        RelacionTexto1.setVisible(false);
        Si1.setVisible(false);
        No1.setVisible(false);
        BotonCrear.setVisible(false);
        Atributo1.setText("");
        Atributo2.setText("");
        Atributo3.setText("");
        Atributo4.setText("");
        Relacion1.setText("");
        LabelRelacion1.setText("");
        LabelRelacion1.setText("");
        ErrorCrear.setText("");
        ErrorVer.setText("");
        ErrorEditar.setText("");
        Atributoeditar1.setText("");
        Atributoeditar2.setText("");
        Atributoeditar3.setText("");
        Atributoeditar4.setText("");
        RelacionEditar1.setText("");
        RelacionEditar2.setText("");
        Atributos.setVisible(false);
        Relaciones.setVisible(false);
        BoxRelacion1.setVisible(false);
        BoxRelacion2.setVisible(false);
        BoxRelacion11.setVisible(false);
        BoxRelacion22.setVisible(false);
        TextoEditar1.setVisible(false);
        TextoEditar2.setVisible(false);
        TextoEditar3.setVisible(false);
        TextoEditar4.setVisible(false);
        TextoRelacionEditar1.setVisible(false);
        TextoRelacionEditar2.setVisible(false);
        BotonEditar.setVisible(false);
        BotonBuscar.setVisible(false);
        ErrorClase.setText("");
        ErrorOpcion.setText("");
        ErrorText.setText("");
        if(!Area.isSelected()&&!Empleado.isSelected()&&!Cliente.isSelected()){
            ErrorClase.setText("Seleccione una opcion");
        }
        else if(!Crear.isSelected()&&!Editar.isSelected()&&!Ver.isSelected()&&!Eliminar.isSelected()){
            ErrorOpcion.setText("Seleccione una opcion");
        }
        else if(Area.isSelected()){
            if (Ver.isSelected()){
                Texto.setVisible(true);
                BotonVer.setVisible(true);
                IngresarTexto.setText("Ingrese el nombre de la area");
            }
            if (Eliminar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                BotonEliminar.setVisible(true);
                IngresarTexto.setText("Ingrese el nombre de la area");
            }
            if (Crear.isSelected()){
                Texto1.setVisible(true);
                Texto2.setVisible(true);
                Texto3.setVisible(true);
                Texto4.setVisible(true);
                BotonCrear.setVisible(true);
                Atributo1.setText("Nombre");
                Atributo2.setText("Gerente");
                Atributo3.setText("Ingresos");
                Atributo4.setText("Gastos");
                Texto1.setText("");
                Texto2.setText("");
                Texto3.setText("");
                Texto4.setText("");
            }
            if(Editar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                IngresarTexto.setText("Ingrese el nombre del area");
                BotonBuscar.setVisible(true);
            }
        }
        else if(Empleado.isSelected()){
            if (Ver.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                BotonVer.setVisible(true);
                IngresarTexto.setText("Ingrese la cedula del empleado");
            }
            if (Eliminar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                BotonEliminar.setVisible(true);
                IngresarTexto.setText("Ingrese la cedula del empelado");
            }
            if(Crear.isSelected()){
                Texto1.setVisible(true);
                Texto2.setVisible(true);
                Texto3.setVisible(true);
                Texto4.setVisible(true);
                BotonCrear.setVisible(true);
                Atributo1.setText("Nombre");
                Atributo2.setText("Cedula");
                Atributo3.setText("Edad");
                Atributo4.setText("Salario");
                Relacion1.setText("Tiene Area");
                Si1.setVisible(true);
                No1.setVisible(true);
                Si1.setSelected(false);
                No1.setSelected(false);
                Texto1.setText("");
                Texto2.setText("");
                Texto3.setText("");
                Texto4.setText("");
            }
            if(Editar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                IngresarTexto.setText("Ingrese la cedula del empleado");
                BotonBuscar.setVisible(true);
            }
        }
        else if(Cliente.isSelected()){
            if (Ver.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                BotonVer.setVisible(true);
                IngresarTexto.setText("Ingrese la cedula del Cliente");
            }
            if (Eliminar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                BotonEliminar.setVisible(true);
                IngresarTexto.setText("Ingrese la cedula del cliente");
            }
            if(Crear.isSelected()){
                Texto1.setVisible(true);
                Texto2.setVisible(true);
                Texto3.setVisible(true);
                BotonCrear.setVisible(true);
                Atributo1.setText("Nombre");
                Atributo2.setText("Cedula");
                Atributo3.setText("Dinero");
                Relacion1.setText("Tiene Area");
                Si1.setVisible(true);
                No1.setVisible(true);
                Si1.setSelected(false);
                No1.setSelected(false);
                Texto1.setText("");
                Texto2.setText("");
                Texto3.setText("");
            }
            if(Editar.isSelected()){
                Texto.setVisible(true);
                Texto.setText("");
                IngresarTexto.setText("Ingrese la cedula del cliente");
                BotonBuscar.setVisible(true);
            }
        }
    }
    @FXML
    private void ActionBuscar(ActionEvent actionEvent)throws IOException{
        ErrorText.setText("");
        ErrorEditar.setText("");
        Informacion.setText("");
        if(Area.isSelected()&&Editar.isSelected()){
            String area=Texto.getText().toLowerCase();
            if(!App.areas.containsKey(area)){
                ErrorText.setText("Area no encontrada");
            }
            else {
                Atributos.setVisible(true);
                Relaciones.setVisible(true);
                Atributos.setSelected(false);
                Relaciones.setSelected(false);
                BotonBuscar.setVisible(false);
                BotonEditar.setVisible(true);
            }
        }
        else if(Empleado.isSelected()&&Editar.isSelected()){
            try {
                int empleado=Integer.parseInt(Texto.getText());
                if(!App.empleados.containsKey(empleado)){
                    ErrorText.setText("No se encuentra empleado registrado");
                }
                else {
                    Atributos.setVisible(true);
                    Relaciones.setVisible(true);
                    Atributos.setSelected(false);
                    Relaciones.setSelected(false);
                    BotonBuscar.setVisible(false);
                    BotonEditar.setVisible(true);
                }
            } catch (NumberFormatException nfe){
                ErrorText.setText("Valor invalido");
            }

        }
        if(Cliente.isSelected()&&Editar.isSelected()){
            int cliente=Integer.parseInt(Texto.getText());
            try {
                if(!App.clientes.containsKey(cliente)){
                    ErrorEditar.setText("No se encuentra cliente registrado");
                }
                else {
                    Atributos.setVisible(true);
                    Relaciones.setVisible(true);
                    Atributos.setSelected(false);
                    Relaciones.setSelected(false);
                    BotonBuscar.setVisible(false);
                    BotonEditar.setVisible(true);
                }
            } catch (NumberFormatException nfe){
                ErrorText.setText("Valor invalido");
            }

        }
    }
    @FXML
    private void ActionAtributos(ActionEvent actionEvent)throws IOException{
        if(Atributos.isSelected()){
            if(Area.isSelected()){
                TextoEditar1.setVisible(true);
                TextoEditar2.setVisible(true);
                TextoEditar3.setVisible(true);
                TextoEditar4.setVisible(true);
                TextoEditar1.setText("");
                TextoEditar2.setText("");
                TextoEditar3.setText("");
                TextoEditar4.setText("");
                Atributoeditar1.setText("Nombre");
                Atributoeditar2.setText("Gerente");
                Atributoeditar3.setText("Ingresos");
                Atributoeditar4.setText("Gastos");
            }
            else if(Empleado.isSelected()){
                TextoEditar1.setVisible(true);
                TextoEditar2.setVisible(true);
                TextoEditar3.setVisible(true);
                TextoEditar4.setVisible(true);
                TextoEditar1.setText("");
                TextoEditar2.setText("");
                TextoEditar3.setText("");
                TextoEditar4.setText("");
                Atributoeditar1.setText("Nombre");
                Atributoeditar2.setText("Cedula");
                Atributoeditar3.setText("Edad");
                Atributoeditar4.setText("Salario");
            }
            else if(Cliente.isSelected()){
                TextoEditar1.setVisible(true);
                TextoEditar2.setVisible(true);
                TextoEditar3.setVisible(true);
                TextoEditar1.setText("");
                TextoEditar2.setText("");
                TextoEditar3.setText("");
                Atributoeditar1.setText("Nombre");
                Atributoeditar2.setText("Cedula");
                Atributoeditar3.setText("Dinero");
        }
    }
        else{
            TextoEditar1.setVisible(false);
            TextoEditar2.setVisible(false);
            TextoEditar3.setVisible(false);
            TextoEditar4.setVisible(false);
            Atributoeditar1.setText("");
            Atributoeditar2.setText("");
            Atributoeditar3.setText("");
            Atributoeditar4.setText("");
        }
    }

    @FXML
    private void ActionRelaciones(ActionEvent actionEvent)throws IOException{
        if(Relaciones.isSelected()){
            if(Area.isSelected()){
                BoxRelacion1.setVisible(true);
                BoxRelacion1.setSelected(false);
                BoxRelacion11.setSelected(false);
                BoxRelacion2.setSelected(false);
                BoxRelacion22.setSelected(false);
                BoxRelacion1.setText("Unir Empleado");
                BoxRelacion11.setVisible(true);
                BoxRelacion11.setText("Elimiar Empleado");
                BoxRelacion2.setVisible(true);
                BoxRelacion2.setText("Unir Cliente");
                BoxRelacion22.setVisible(true);
                BoxRelacion22.setText("Eliminar Cliente");
            }
            else if(Empleado.isSelected()){
                BoxRelacion1.setVisible(true);
                BoxRelacion1.setText("Unir Area");
                BoxRelacion11.setVisible(true);
                BoxRelacion11.setText("Elimiar Area");
                BoxRelacion2.setVisible(true);
                BoxRelacion2.setText("Unir Cliente");
                BoxRelacion22.setVisible(true);
                BoxRelacion22.setText("Eliminar Cliente");
                BoxRelacion1.setSelected(false);
                BoxRelacion11.setSelected(false);
                BoxRelacion2.setSelected(false);
                BoxRelacion22.setSelected(false);
            }
            else if(Cliente.isSelected()){
                BoxRelacion1.setVisible(true);
                BoxRelacion1.setText("Unir Area");
                BoxRelacion11.setVisible(true);
                BoxRelacion11.setText("Elimiar Area");
                BoxRelacion2.setVisible(true);
                BoxRelacion2.setText("Unir Empleado");
                BoxRelacion22.setVisible(true);
                BoxRelacion22.setText("Eliminar Empleado");
                BoxRelacion1.setSelected(false);
                BoxRelacion11.setSelected(false);
                BoxRelacion2.setSelected(false);
                BoxRelacion22.setSelected(false);
            }
        }
        else{
            BoxRelacion1.setVisible(false);
            BoxRelacion1.setText("");
            BoxRelacion11.setVisible(false);
            BoxRelacion11.setText("");
            BoxRelacion2.setVisible(false);
            BoxRelacion2.setText("");
            BoxRelacion22.setVisible(false);
            BoxRelacion22.setText("");
        }
    }
    @FXML
    private void ActionRelacion1(ActionEvent actionEvent)throws IOException{
        if(BoxRelacion1.isSelected()){
            BoxRelacion2.setSelected(false);
            if(Area.isSelected()){
                TextoRelacionEditar1.setVisible(true);
                TextoRelacionEditar1.setText("");
                RelacionEditar1.setText("Cedula");
            }
            else if(Empleado.isSelected() || Cliente.isSelected()){
                TextoRelacionEditar1.setVisible(true);
                TextoRelacionEditar1.setText("");
                RelacionEditar1.setText("Nombre");
            }
        }
        else{
            TextoRelacionEditar1.setVisible(false);
            RelacionEditar1.setText("");
        }
    }
    @FXML
    private void ActionRelacion2(ActionEvent actionEvent)throws IOException{
        if(BoxRelacion2.isSelected()){
            BoxRelacion1.setSelected(false);
            if(Area.isSelected() || Empleado.isSelected() || Cliente.isSelected()){
                TextoRelacionEditar2.setVisible(true);
                TextoRelacionEditar2.setText("");
                RelacionEditar2.setText("Cedula");
            }
        }
        else{
            TextoRelacionEditar2.setVisible(false);
            RelacionEditar2.setText("");
        }
    }
    @FXML
    private void ActionRelacion11(ActionEvent actionEvent)throws IOException{
        if(BoxRelacion11.isSelected()){
            if(Area.isSelected()){
                TextoRelacionEditar1.setVisible(true);
                TextoRelacionEditar1.setText("");
                RelacionEditar1.setText("Cedula");
            }
            else if(Empleado.isSelected() || Cliente.isSelected()){
                TextoRelacionEditar1.setVisible(true);
                TextoRelacionEditar1.setText("");
                RelacionEditar1.setText("Nombre");
            }
        }
        else{
            TextoRelacionEditar1.setVisible(false);
            RelacionEditar1.setText("");
        }
    }
    @FXML
    private void ActionRelacion22(ActionEvent actionEvent)throws IOException{
        if(BoxRelacion22.isSelected()){
            if(Area.isSelected() || Empleado.isSelected() || Cliente.isSelected()){
                TextoRelacionEditar2.setVisible(true);
                TextoRelacionEditar2.setText("");
                RelacionEditar2.setText("Cedula");
            }
        }
        else{
            TextoRelacionEditar2.setVisible(false);
            RelacionEditar2.setText("");
        }
    }
    @FXML
    private void ActionSi(ActionEvent actionEvent)throws IOException{
        if(Si1.isSelected()){
            No1.setSelected(false);
            LabelRelacion1.setText("Nombre del Area");
            RelacionTexto1.setVisible(true);
            RelacionTexto1.setText("");
        }
    }
    @FXML
    private void ActionNo(ActionEvent actionEvent)throws IOException{
        if(No1.isSelected()){
            Si1.setSelected(false);
            LabelRelacion1.setText("");
            RelacionTexto1.setVisible(false);
        }
    }
    @FXML
    private void ActionVer(ActionEvent actionEvent)throws IOException {
        Informacion.setText("");
        ErrorVer.setText("");
        ErrorText.setText("");

        if(Texto.getText().equals("")){
            ErrorText.setText("Ingrese un valor");
        } else if(Area.isSelected()&&Ver.isSelected()){
            String area = Texto.getText().toLowerCase();
            if(!App.areas.containsKey(area)){
                ErrorVer.setText("No se encuentra un area con este nombre");
            }
            else{
                org.example.Area area1=App.areas.get(area);
                ArrayList<Object>relaciones=area1.relaciones();
                ErrorVer.setText("");
                Informacion.setText(App.areas.get(area).toString()+" Tiene: "+relaciones.size()+" relacion(es)");
            }
        }
        else if (Empleado.isSelected()&&Ver.isSelected()){
            int empleado=Integer.parseInt(Texto.getText());
            if(!App.empleados.containsKey(empleado)){
                ErrorVer.setText("No se encuentra un empledo con esta cedula");
            }else{
                org.example.Empleado empleado1=App.empleados.get(empleado);
                ArrayList<Object>relaciones=empleado1.relaciones();
                ErrorVer.setText("");
                Informacion.setText(App.empleados.get(empleado).toString()+" Tiene: "+relaciones.size()+" relacion(es)");

            }
        }
        else if(Cliente.isSelected()){
            int cliente=Integer.parseInt(Texto.getText());
            if(!App.clientes.containsKey(cliente)){
                ErrorVer.setText("No se encuentra un cliente con esta cedula");
            }
            else{
                org.example.Cliente cliente1=App.clientes.get(cliente);
                ArrayList<Object>relaciones=cliente1.relaciones();
                ErrorVer.setText("");
                Informacion.setText(App.clientes.get(cliente).toString()+" Tiene: "+relaciones.size()+" relacion(es)");

            }
        }
    }

    @FXML
    private void ActionEliminar(ActionEvent actionEvent)throws IOException{
        ErrorText.setText("");
        ErrorEliminar.setText("");
        Informacion.setText("");
        if(Texto.getText().equals("")){
            ErrorText.setText("Ingrese un valor");
        }
        else {
            if (Area.isSelected() && Eliminar.isSelected()) {
                String area = Texto.getText().toLowerCase();
                if (!App.areas.containsKey(area)) {
                    ErrorEliminar.setText("No se encuentra area registrada");
                }
                else {
                    org.example.Area area1 = App.areas.get(area);
                    ArrayList<Object> relaciones = area1.relaciones();
                    App.sistema.removeAllEdges(area1, relaciones);
                    App.sistema.removeVertex(area1);
                    App.areas.remove(area);
                    int ingresos= area1.ingresoArea;
                    ArrayList<Area> Areas=App.ingresos.get(ingresos);
                    Areas.remove(area1);
                    App.ingresos.replace(ingresos,Areas);
                    String Gerente=area1.Gerente;
                    ArrayList<Area> Areas2=App.Gerentes.get(Gerente);
                    Areas2.remove(area1);
                    App.Gerentes.replace(Gerente,Areas2);
                    ErrorEliminar.setText("");
                    Informacion.setText("Area Borrada con exito");
                    BotonEliminar.setVisible(false);
                    Texto.setVisible(false);
                    IngresarTexto.setText("");
                }
            } else if (Empleado.isSelected() && Eliminar.isSelected()) {
                int empleado = Integer.parseInt(Texto.getText());
                if(!App.empleados.containsKey(empleado)){
                    ErrorEliminar.setText("No se encuentra empelado registrado");
                }
                else {
                    org.example.Empleado empleado1 = App.empleados.get(empleado);
                    ArrayList<Object> relaciones = empleado1.relaciones();
                    App.sistema.removeAllEdges(empleado1, relaciones);
                    App.sistema.removeVertex(empleado1);
                    App.empleados.remove(empleado);
                    int edad= empleado1.edad;
                    ArrayList<Empleado> Empleados=App.edades.get(edad);
                    Empleados.remove(empleado1);
                    App.edades.replace(edad,Empleados);
                    String Nombre= empleado1.nombre;
                    ArrayList<Empleado> Empleados2=App.NombreEmpleado.get(Nombre);
                    Empleados2.remove(empleado1);
                    App.NombreEmpleado.replace(Nombre,Empleados2);
                    ErrorEliminar.setText("");
                    Informacion.setText("Empleado Borrado con exito");
                    BotonEliminar.setVisible(false);
                    Texto.setVisible(false);
                    IngresarTexto.setText("");
                }
            } else if (Cliente.isSelected() && Eliminar.isSelected()) {
                int cliente = Integer.parseInt(Texto.getText());
                if(!Cliente.isSelected()){
                    ErrorEliminar.setText("No se encuentra Cliente registrado");
                }
                else{
                org.example.Cliente cliente1 = App.clientes.get(cliente);
                ArrayList<Object> relaciones = cliente1.relaciones();
                App.sistema.removeAllEdges(cliente1, relaciones);
                App.sistema.removeVertex(cliente1);
                App.clientes.remove(cliente);
                int dinero= cliente1.dinero;
                    ArrayList<Cliente>Clientes=App.Dinero.get(dinero);
                    Clientes.remove(cliente1);
                    App.Dinero.replace(dinero,Clientes);
                    String Nombre= cliente1.nombre;
                    ArrayList<Cliente>Clientes2=App.NombreClientes.get(Nombre);
                    Clientes2.remove(cliente1);
                    App.NombreClientes.replace(Nombre,Clientes2);
                    ErrorEliminar.setText("");
                Informacion.setText("Cliente Borrado con exito");
                BotonEliminar.setVisible(false);
                Texto.setVisible(false);
                IngresarTexto.setText("");
            }}
        }
    }
    @FXML
    private void ActionCrear(ActionEvent actionEvent)throws IOException{
        ErrorCrear.setText("");
        Informacion.setText("");
        if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")||Texto4.getText().equals("")){
            ErrorCrear.setText("Falta atributo(s)");
        }
        if(Area.isSelected()&&Crear.isSelected()){
            if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")||Texto4.getText().equals("")){
                ErrorCrear.setText("Falta atributo(s)");
            }
            else{
               String Nombre=Texto1.getText().toLowerCase();
               String Gerente=Texto2.getText().toLowerCase();
               int Ingresos=Integer.parseInt(Texto3.getText());
               int Gastos=Integer.parseInt(Texto4.getText());
                if (App.areas.containsKey(Nombre)) {
                    ErrorCrear.setText("Ya se encuentra area registrada con este nombre");
                }
                else{
               org.example.Area nuevaArea=new Area(Nombre,Gerente,Ingresos,Gastos);
               App.areas.put(Nombre,nuevaArea);
               App.sistema.addVertex(nuevaArea);
               if(!App.ingresos.containsKey(Ingresos)){
                   App.ingresos.put(Ingresos,new ArrayList<>());
                   ArrayList<Area>areas=App.ingresos.get(Ingresos);
                   areas.add(nuevaArea);
                   App.ingresos.replace(Ingresos,areas);
               }
               else{
                   ArrayList<Area> areas=App.ingresos.get(Ingresos);
                   areas.add(nuevaArea);
                   App.ingresos.replace(Ingresos,areas);
               }
               if(!App.Gerentes.containsKey(Gerente)){
                   App.Gerentes.put(Gerente,new ArrayList<>());
                   ArrayList<Area>areas2=App.Gerentes.get(Gerente);
                   areas2.add(nuevaArea);
                   App.Gerentes.replace(Gerente,areas2);
               }
               else{
                   ArrayList<Area>areas2=App.Gerentes.get(Gerente);
                   areas2.add(nuevaArea);
                   App.Gerentes.replace(Gerente,areas2);
               }
               Informacion.setText("Area creada con exito");
                Texto.setVisible(false);
                BotonVer.setVisible(false);
                IngresarTexto.setText("");
                BotonEliminar.setVisible(false);
                Texto1.setVisible(false);
                Texto2.setVisible(false);
                Texto3.setVisible(false);
                Texto4.setVisible(false);
                RelacionTexto1.setVisible(false);
                Si1.setVisible(false);
                No1.setVisible(false);
                BotonCrear.setVisible(false);
                Atributo1.setText("");
                Atributo2.setText("");
                Atributo3.setText("");
                Atributo4.setText("");
                Relacion1.setText("");
                LabelRelacion1.setText("");
                LabelRelacion1.setText("");
                ErrorCrear.setText("");
                ErrorVer.setText("");}
            }
        }
        else if(Empleado.isSelected()&&Crear.isSelected()){
            if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")||Texto4.getText().equals("")){
                ErrorCrear.setText("Falta atributo(s)");
            }
            else {
                String Nombre = Texto1.getText().toLowerCase();
                int Cedula = Integer.parseInt(Texto2.getText());
                int Edad = Integer.parseInt(Texto3.getText());
                int Salario = Integer.parseInt(Texto4.getText());
                if (App.empleados.containsKey(Cedula)) {
                    ErrorCrear.setText("Ya se encuentra empelado registrado con esta cedula");
                } else {
                    org.example.Empleado nuevoEmpleado = new Empleado(Nombre, Cedula, Edad, Salario);
                    App.empleados.put(Cedula, nuevoEmpleado);
                    App.sistema.addVertex(nuevoEmpleado);

                    if (Si1.isSelected()) {
                        String NombreArea = RelacionTexto1.getText().toLowerCase();
                        if (!App.areas.containsKey(NombreArea)) {
                            ErrorCrear.setText("No se encontro un area registrada");
                            Informacion.setText("Empleado creado sin relacion");
                        } else {
                            org.example.Area area = App.areas.get(NombreArea);
                            App.sistema.addEdge(area, nuevoEmpleado);
                            ErrorCrear.setText("");
                            Informacion.setText("Empleado creado con relacion");
                        }
                    } else if (No1.isSelected()) {
                        ErrorCrear.setText("");
                        Informacion.setText("Empleado creado sin relacion");
                    }
                    Area.setSelected(false);
                    Cliente.setSelected(false);
                    Texto.setVisible(false);
                    BotonVer.setVisible(false);
                    IngresarTexto.setText("");
                    BotonEliminar.setVisible(false);
                    Texto1.setVisible(false);
                    Texto2.setVisible(false);
                    Texto3.setVisible(false);
                    Texto4.setVisible(false);
                    RelacionTexto1.setVisible(false);
                    Si1.setVisible(false);
                    No1.setVisible(false);
                    BotonCrear.setVisible(false);
                    Atributo1.setText("");
                    Atributo2.setText("");
                    Atributo3.setText("");
                    Atributo4.setText("");
                    Relacion1.setText("");
                    LabelRelacion1.setText("");
                    LabelRelacion1.setText("");
                    ErrorCrear.setText("");
                    ErrorVer.setText("");
                    if(!App.edades.containsKey(Edad)){
                        App.edades.put(Edad,new ArrayList<>());
                        ArrayList<Empleado>empleados=App.edades.get(Edad);
                        empleados.add(nuevoEmpleado);
                        App.edades.replace(Edad,empleados);
                    }
                    else{
                        ArrayList<Empleado>empleados=App.edades.get(Edad);
                        empleados.add(nuevoEmpleado);
                        App.edades.replace(Edad,empleados);
                    }
                    if(!App.NombreEmpleado.containsKey(Nombre)){
                        App.NombreEmpleado.put(Nombre,new ArrayList<>());
                        ArrayList<Empleado>empleados2=App.NombreEmpleado.get(Nombre);
                        empleados2.add(nuevoEmpleado);
                        App.NombreEmpleado.replace(Nombre,empleados2);
                    }
                    else{
                        ArrayList<Empleado>empleados2=App.NombreEmpleado.get(Nombre);
                        empleados2.add(nuevoEmpleado);
                        App.NombreEmpleado.replace(Nombre,empleados2);
                    }
                    Informacion.setText("Empleado creado con exito");
                    Texto.setVisible(false);
                    BotonVer.setVisible(false);
                    IngresarTexto.setText("");
                    BotonEliminar.setVisible(false);
                    Texto1.setVisible(false);
                    Texto2.setVisible(false);
                    Texto3.setVisible(false);
                    Texto4.setVisible(false);
                    RelacionTexto1.setVisible(false);
                    Si1.setVisible(false);
                    No1.setVisible(false);
                    BotonCrear.setVisible(false);
                    Atributo1.setText("");
                    Atributo2.setText("");
                    Atributo3.setText("");
                    Atributo4.setText("");
                    Relacion1.setText("");
                    LabelRelacion1.setText("");
                    LabelRelacion1.setText("");
                    ErrorCrear.setText("");
                    ErrorVer.setText("");}
                }
            }
        else if(Cliente.isSelected()&&Crear.isSelected()){
            if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")){
                ErrorCrear.setText("Falta atributo(s)");
            }
            else{
                String Nombre=Texto1.getText().toLowerCase();
                int Cedula=Integer.parseInt(Texto2.getText());
                int Dinero=Integer.parseInt(Texto3.getText());
                if(App.clientes.containsKey(Cedula)){
                    ErrorCrear.setText("Ya se encuentra cliente con esta cedula");
                }
                else{
                org.example.Cliente nuevoCliente=new Cliente(Nombre,Cedula,Dinero);
                App.clientes.put(Cedula,nuevoCliente);
                App.sistema.addVertex(nuevoCliente);
                if(Si1.isSelected()){
                    String NombreArea=RelacionTexto1.getText().toLowerCase();
                    if(!App.areas.containsKey(NombreArea)){
                        ErrorCrear.setText("No se encontro un area registrada");
                        Informacion.setText("Cliente creado sin relacion");
                    }
                    else{
                        org.example.Area area=App.areas.get(NombreArea);
                        App.sistema.addEdge(area,nuevoCliente);
                        ErrorCrear.setText("");
                        Informacion.setText("Cliente creado con relacion");
                    }
                }
                else if(No1.isSelected()){
                    ErrorCrear.setText("");
                    Informacion.setText("Cliente creado sin relacion");
                }
                    Area.setSelected(false);
                    Cliente.setSelected(false);
                    Texto.setVisible(false);
                    BotonVer.setVisible(false);
                    IngresarTexto.setText("");
                    BotonEliminar.setVisible(false);
                    Texto1.setVisible(false);
                    Texto2.setVisible(false);
                    Texto3.setVisible(false);
                    Texto4.setVisible(false);
                    RelacionTexto1.setVisible(false);
                    Si1.setVisible(false);
                    No1.setVisible(false);
                    BotonCrear.setVisible(false);
                    Atributo1.setText("");
                    Atributo2.setText("");
                    Atributo3.setText("");
                    Atributo4.setText("");
                    Relacion1.setText("");
                    LabelRelacion1.setText("");
                    LabelRelacion1.setText("");
                    ErrorCrear.setText("");
                    ErrorVer.setText("");
                    if(!App.Dinero.containsKey(Dinero)){
                        App.Dinero.put(Dinero,new ArrayList<>());
                        ArrayList<Cliente>clientes=App.Dinero.get(Dinero);
                        clientes.add(nuevoCliente);
                        App.Dinero.replace(Dinero,clientes);
                    }
                    else{
                        ArrayList<Cliente>clientes=App.Dinero.get(Dinero);
                        clientes.add(nuevoCliente);
                        App.Dinero.replace(Dinero,clientes);
                    }
                    if(!App.NombreClientes.containsKey(Nombre)){
                        App.NombreClientes.put(Nombre,new ArrayList<>());
                        ArrayList<Cliente>clientes2=App.NombreClientes.get(Nombre);
                        clientes2.add(nuevoCliente);
                        App.NombreClientes.replace(Nombre,clientes2);
                    }
                    else{
                        ArrayList<Cliente>clientes2=App.NombreClientes.get(Nombre);
                        clientes2.add(nuevoCliente);
                        App.NombreClientes.replace(Nombre,clientes2);
                    }
                    Informacion.setText("Cliente creado con exito");
                    Texto.setVisible(false);
                    BotonVer.setVisible(false);
                    IngresarTexto.setText("");
                    BotonEliminar.setVisible(false);
                    Texto1.setVisible(false);
                    Texto2.setVisible(false);
                    Texto3.setVisible(false);
                    Texto4.setVisible(false);
                    RelacionTexto1.setVisible(false);
                    Si1.setVisible(false);
                    No1.setVisible(false);
                    BotonCrear.setVisible(false);
                    Atributo1.setText("");
                    Atributo2.setText("");
                    Atributo3.setText("");
                    Atributo4.setText("");
                    Relacion1.setText("");
                    LabelRelacion1.setText("");
                    LabelRelacion1.setText("");
                    ErrorCrear.setText("");
                    ErrorVer.setText("");}
            }
        }
    }
    @FXML
    private void ActionEditar(ActionEvent editar)throws IOException{
        ErrorEditar.setText("");
        ErrorText.setText("");
        Informacion.setText("");
        if(Area.isSelected()){
            String nombre=Texto.getText();
            if(!App.areas.containsKey(nombre)){
                ErrorEditar.setText("No se encuentra area registrada");
            }
            else {
                org.example.Area areaActual = App.areas.get(Texto.getText().toLowerCase());
                if (Relaciones.isSelected()) {
                    if (BoxRelacion1.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Empleado vacio");
                        } else {
                            int empleado = Integer.parseInt(TextoRelacionEditar1.getText());

                            if (!App.empleados.containsKey(empleado)) {
                                ErrorEditar.setText("No se encuentra empelado registrado");
                            } else {
                                org.example.Empleado EmpleadoActual = App.empleados.get(empleado);
                                App.sistema.addEdge(areaActual, EmpleadoActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    } else if (BoxRelacion11.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Empleado vacio");
                        }
                        else{
                            int empleado = Integer.parseInt(TextoRelacionEditar1.getText());
                            if (!App.empleados.containsKey(empleado)) {
                                ErrorEditar.setText("No se encuentra empelado registrado");
                            }else{
                                org.example.Empleado EmpleadoActual = App.empleados.get(empleado);
                                App.sistema.removeEdge(areaActual,EmpleadoActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }

                    if (BoxRelacion2.isSelected()) {
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Cliente vacio");
                        } else {
                            int cliente = Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra cliente registrado");
                            } else {
                                org.example.Cliente ClienteActual = App.clientes.get(cliente);
                                App.sistema.addEdge(areaActual, ClienteActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                    else if(BoxRelacion22.isSelected()){
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Cliente vacio");
                        } else {
                            int cliente = Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra cliente registrado");
                            }
                            else{
                                org.example.Cliente ClienteActual = App.clientes.get(cliente);
                                App.sistema.removeEdge(areaActual,ClienteActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                }
                if (Atributos.isSelected()) {
                    if (TextoEditar1.getText().equals("") || TextoEditar2.getText().equals("") || TextoEditar3.getText().equals("")) {
                        ErrorEditar.setText("Espacios de atributos vacios");
                    } else {
                        String Nombre = TextoEditar1.getText().toLowerCase();
                        String Gerente=TextoEditar2.getText().toLowerCase();
                        int ingresos = Integer.parseInt(TextoEditar3.getText());
                        int gastos = Integer.parseInt(TextoEditar4.getText());
                        org.example.Area areaAux = new Area(Nombre,Gerente, ingresos, gastos);
                        ArrayList<Object>relaciones=areaActual.relaciones();
                        App.sistema.removeAllEdges(areaActual,relaciones);
                        App.sistema.removeVertex(areaActual);
                        App.sistema.addVertex(areaAux);
                        for (Object relacion:relaciones) {
                            App.sistema.addEdge(areaAux,relacion);
                        }
                        App.areas.remove(nombre);
                        App.areas.put(Nombre,areaAux);
                        int ingresosActual= areaActual.ingresoArea;
                        if(ingresos==ingresosActual){
                            ArrayList<Area> Areas=App.ingresos.get(ingresos);
                            Areas.remove(areaActual);
                            Areas.add(areaAux);
                            App.ingresos.replace(ingresos,Areas);
                        }
                        else{
                            ArrayList<Area> Areas=App.ingresos.get(ingresosActual);
                            Areas.remove(areaActual);
                            App.ingresos.replace(ingresosActual,Areas);
                            if(!App.ingresos.containsKey(ingresos)){
                                App.ingresos.put(ingresos,new ArrayList<>());
                                ArrayList<Area>Areas2=App.ingresos.get(ingresos);
                                Areas2.add(areaAux);
                                App.ingresos.replace(ingresos,Areas2);
                            }
                            else{
                                ArrayList<Area>Areas2=App.ingresos.get(ingresos);
                                Areas2.add(areaAux);
                                App.ingresos.replace(ingresos,Areas2);
                            }

                        }
                        String gerenteActual= areaActual.Gerente;
                        if(gerenteActual.equals(Gerente)){
                            ArrayList<Area> Areas=App.Gerentes.get(gerenteActual);
                            Areas.remove(areaActual);
                            Areas.add(areaAux);
                            App.Gerentes.replace(gerenteActual,Areas);
                        }
                        else{
                            ArrayList<Area> Areas=App.Gerentes.get(gerenteActual);
                            Areas.remove(areaActual);
                            App.ingresos.replace(ingresosActual,Areas);
                            if(!App.Gerentes.containsKey(Gerente)){
                                App.Gerentes.put(Gerente,new ArrayList<>());
                                ArrayList<Area>Areas2=App.Gerentes.get(Gerente);
                                Areas2.add(areaAux);
                                App.Gerentes.replace(Gerente,Areas2);
                            }
                            else{
                                ArrayList<Area>Areas2=App.Gerentes.get(Gerente);
                                Areas2.add(areaAux);
                                App.Gerentes.replace(Gerente,Areas2);
                            }
                        }
                        ErrorEditar.setText("");
                        Informacion.setText("Edicion satifactoria");
                    }
                }
            }
        }

        else if(Empleado.isSelected()){
            int empleado=Integer.parseInt(Texto.getText());
            if(!App.empleados.containsKey(empleado)){
                ErrorEditar.setText("No se encuentra empleado registrado");
            }
            else {
                org.example.Empleado empleadoActual = App.empleados.get(empleado);
                if (Relaciones.isSelected()) {
                    if (BoxRelacion1.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de area vacio");
                        } else {
                            String nombre=TextoRelacionEditar1.getText().toLowerCase();
                            if (!App.areas.containsKey(nombre)) {
                                ErrorEditar.setText("No se encuentra area registrada");
                            } else {
                                org.example.Area areaActual = App.areas.get(nombre);
                                App.sistema.addEdge(empleadoActual, areaActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    } else if (BoxRelacion11.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de area vacio");
                        }
                        else{
                            String nombre=TextoRelacionEditar1.getText().toLowerCase();
                            if (!App.areas.containsKey(nombre)) {
                                ErrorEditar.setText("No se encuentra area registrada");
                            } else{
                                org.example.Area areaActual = App.areas.get(nombre);
                                App.sistema.removeEdge(empleadoActual,areaActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }

                    if (BoxRelacion2.isSelected()) {
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Cliente vacio");
                        } else {
                            int cliente = Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra cliente registrado");
                            } else {
                                org.example.Cliente ClienteActual = App.clientes.get(cliente);
                                App.sistema.addEdge(empleadoActual, ClienteActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                    else if(BoxRelacion22.isSelected()){
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Cliente vacio");
                        } else {
                            int cliente = Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra cliente registrado");
                            }
                            else{
                                org.example.Cliente ClienteActual = App.clientes.get(cliente);
                                App.sistema.removeEdge(empleadoActual,ClienteActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                }
                if (Atributos.isSelected()) {
                    if (TextoEditar1.getText().equals("") || TextoEditar2.getText().equals("") || TextoEditar3.getText().equals("")) {
                        ErrorEditar.setText("Espacios de atributos vacios");
                    } else {
                        String Nombre = TextoEditar1.getText().toLowerCase();
                        int cedula = Integer.parseInt(TextoEditar2.getText());
                        int edad = Integer.parseInt(TextoEditar3.getText());
                        int salario=Integer.parseInt(TextoEditar4.getText());
                        org.example.Empleado empleadoAux = new Empleado(Nombre, cedula, edad,salario);
                        ArrayList<Object>relaciones=empleadoActual.relaciones();
                        App.sistema.removeAllEdges(empleadoActual,relaciones);
                        App.sistema.removeVertex(empleadoActual);
                        App.sistema.addVertex(empleadoAux);
                        for (Object relacion:relaciones) {
                            App.sistema.addEdge(empleadoAux,relacion);
                        }
                        App.empleados.remove(empleado);
                        App.empleados.put(cedula,empleadoAux);
                        int EdadActual= empleadoActual.edad;
                        if(EdadActual==edad){
                            ArrayList<Empleado> empleados=App.edades.get(edad);
                            empleados.remove(empleadoActual);
                            empleados.add(empleadoAux);
                            App.edades.replace(edad,empleados);
                        }
                        else{
                            ArrayList<Empleado> empleados=App.edades.get(EdadActual);
                            empleados.remove(empleadoActual);
                            App.edades.replace(EdadActual,empleados);
                            if(!App.edades.containsKey(edad)){
                                App.edades.put(edad,new ArrayList<>());
                                ArrayList<Empleado>empleados2=App.edades.get(edad);
                                empleados2.add(empleadoAux);
                                App.edades.replace(edad,empleados2);
                            }
                            else{
                                ArrayList<Empleado>empleados2=App.edades.get(edad);
                                empleados2.add(empleadoAux);
                                App.edades.replace(edad,empleados2);
                            }
                        }
                        String NombreActual= empleadoActual.nombre;
                        if(NombreActual.equals(Nombre)){
                            ArrayList<Empleado> empleados=App.NombreEmpleado.get(Nombre);
                            empleados.remove(empleadoActual);
                            empleados.add(empleadoAux);
                            App.NombreEmpleado.replace(Nombre,empleados);
                        }
                        else {
                            ArrayList<Empleado> empleados = App.NombreEmpleado.get(NombreActual);
                            empleados.remove(empleadoActual);
                            App.NombreEmpleado.replace(NombreActual, empleados);
                            if (!App.NombreEmpleado.containsKey(Nombre)) {
                                App.NombreEmpleado.put(Nombre, new ArrayList<>());
                                ArrayList<Empleado> empleados2 = App.NombreEmpleado.get(Nombre);
                                empleados2.add(empleadoAux);
                                App.NombreEmpleado.replace(Nombre, empleados2);
                            } else {
                                ArrayList<Empleado> empleados2 = App.NombreEmpleado.get(Nombre);
                                empleados2.add(empleadoAux);
                                App.NombreEmpleado.replace(Nombre, empleados2);
                            }
                        }
                        ErrorEditar.setText("");
                        Informacion.setText("Edicion satifactoria");
                    }
                }
            }
        }
        else if(Cliente.isSelected()){
            int cliente=Integer.parseInt(Texto.getText());
            if(!App.clientes.containsKey(cliente)){
                ErrorEditar.setText("No se encuentra cliente registrado");
            }
            else {
                org.example.Cliente clienteActual = App.clientes.get(cliente);
                if (Relaciones.isSelected()) {
                    if (BoxRelacion1.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de Area vacio");
                        } else {
                            String nombre=TextoRelacionEditar1.getText().toLowerCase();
                            if (!App.areas.containsKey(nombre)) {
                                ErrorEditar.setText("No se encuentra area registrada");
                            } else {
                                org.example.Area areaActual = App.areas.get(nombre);
                                App.sistema.addEdge(clienteActual, areaActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    } else if (BoxRelacion11.isSelected()) {
                        if (TextoRelacionEditar1.getText().equals("")) {
                            ErrorEditar.setText("Espacio de area vacio");
                        }
                        else{
                            String nombre=TextoRelacionEditar1.getText().toLowerCase();
                            if (!App.areas.containsKey(nombre)) {
                                ErrorEditar.setText("No se encuentra area registrada");
                            } else{
                                org.example.Area areaActual = App.areas.get(nombre);
                                App.sistema.removeEdge(clienteActual,areaActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }

                    if (BoxRelacion2.isSelected()) {
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de empleado vacio");
                        } else {
                            int empleado= Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra empleado registrado");
                            } else {
                                org.example.Empleado empleadoActual = App.empleados.get(empleado);
                                App.sistema.addEdge(clienteActual, empleadoActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                    else if(BoxRelacion22.isSelected()){
                        if (TextoRelacionEditar2.getText().equals("")) {
                            ErrorEditar.setText("Espacio de empleado vacio");
                        } else {
                            int empleado= Integer.parseInt(TextoRelacionEditar2.getText());

                            if (!App.clientes.containsKey(cliente)) {
                                ErrorEditar.setText("No se encuentra empleado registrado");
                            }
                            else{
                                org.example.Empleado empleadoActual = App.empleados.get(empleado);
                                App.sistema.removeEdge(clienteActual,empleadoActual);
                                ErrorEditar.setText("");
                                Informacion.setText("Edicion satifactoria");
                            }
                        }
                    }
                }
                if (Atributos.isSelected()) {
                    if (TextoEditar1.getText().equals("") || TextoEditar2.getText().equals("") || TextoEditar3.getText().equals("")) {
                        ErrorEditar.setText("Espacios de atributos vacios");
                    } else {
                        String Nombre = TextoEditar1.getText().toLowerCase();
                        int cedula = Integer.parseInt(TextoEditar2.getText());
                        int dinero = Integer.parseInt(TextoEditar3.getText());
                        org.example.Cliente clienteAux = new Cliente(Nombre, cedula, dinero);
                        ArrayList<Object>relaciones=clienteActual.relaciones();
                        App.sistema.removeAllEdges(clienteActual,relaciones);
                        App.sistema.removeVertex(clienteActual);
                        App.sistema.addVertex(clienteAux);
                        for (Object relacion:relaciones) {
                            App.sistema.addEdge(clienteAux,relacion);
                        }
                        App.clientes.remove(cliente);
                        App.clientes.put(cedula,clienteAux);
                        int DineroActual= clienteActual.dinero;
                        if(DineroActual==dinero){
                            ArrayList<Cliente> clientes=App.Dinero.get(dinero);
                            clientes.remove(clienteActual);
                            clientes.add(clienteAux);
                            App.Dinero.replace(dinero,clientes);
                        }
                        else{
                            ArrayList<Cliente> clientes=App.Dinero.get(DineroActual);
                            clientes.remove(clienteActual);
                            App.Dinero.replace(DineroActual,clientes);
                            if(!App.Dinero.containsKey(dinero)){
                                App.Dinero.put(dinero,new ArrayList<>());
                                ArrayList<Cliente>clientes2=App.Dinero.get(dinero);
                                clientes2.add(clienteAux);
                                App.Dinero.replace(dinero,clientes2);
                            }
                            else{
                                ArrayList<Cliente>clientes2=App.Dinero.get(dinero);
                                clientes2.add(clienteAux);
                                App.Dinero.replace(dinero,clientes2);
                            }

                        }
                        String NombreActual= clienteActual.nombre;
                        if(NombreActual.equals(Nombre)){
                            ArrayList<Cliente> clientes=App.NombreClientes.get(Nombre);
                            clientes.remove(clienteActual);
                            clientes.add(clienteAux);
                            App.NombreClientes.replace(Nombre,clientes);
                        }
                        else {
                            ArrayList<Cliente> clientes = App.NombreClientes.get(NombreActual);
                            clientes.remove(clienteActual);
                            App.NombreClientes.replace(NombreActual, clientes);
                            if (!App.NombreClientes.containsKey(Nombre)) {
                                App.NombreClientes.put(Nombre, new ArrayList<>());
                                ArrayList<Cliente> clientes2 = App.NombreClientes.get(Nombre);
                                clientes2.add(clienteAux);
                                App.NombreClientes.replace(Nombre, clientes2);
                            } else {
                                ArrayList<Cliente> clientes2 = App.NombreClientes.get(Nombre);
                                clientes2.add(clienteAux);
                                App.NombreClientes.replace(Nombre, clientes2);
                            }
                        }
                        ErrorEditar.setText("");
                        Informacion.setText("Edicion satifactoria");
                    }
                }
            }

        }
        TextoEditar1.setVisible(false);
        TextoEditar2.setVisible(false);
        TextoEditar3.setVisible(false);
        TextoEditar4.setVisible(false);
        TextoRelacionEditar1.setVisible(false);
        TextoRelacionEditar2.setVisible(false);
        BoxRelacion1.setVisible(false);
        BoxRelacion11.setVisible(false);
        BoxRelacion2.setVisible(false);
        BoxRelacion22.setVisible(false);
        Texto.setVisible(false);
        Atributos.setVisible(false);
        Relaciones.setVisible(false);
        BotonEditar.setVisible(false);
        RelacionEditar1.setText("");
        RelacionEditar2.setText("");
        Atributoeditar1.setText("");
        Atributoeditar2.setText("");
        Atributoeditar3.setText("");
        Atributoeditar4.setText("");
        IngresarTexto.setText("");
    }
    @FXML
    private void Salir(ActionEvent salir)throws IOException{
        App.setRoot("MenuPrincipal");
    }
}
