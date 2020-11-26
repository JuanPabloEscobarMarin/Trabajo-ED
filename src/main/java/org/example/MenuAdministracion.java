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
    public Button BotonVer;
    @FXML
    public  Button BotonEliminar;
    @FXML
    public Button BotonCrear;

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
            ErrorVer.setText("");}
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
            ErrorVer.setText("");}
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
        if(!Area.isSelected()&&!Empleado.isSelected()&&!Cliente.isSelected()){
            ErrorClase.setText("Seleccione una opcion");
        }
        else if(!Crear.isSelected()&&!Editar.isSelected()&&!Ver.isSelected()&&!Eliminar.isSelected()){
            ErrorOpcion.setText("Seleccione una opcion");
        }
        else if(Area.isSelected()&&Ver.isSelected()){
            Texto.setVisible(true);
            BotonVer.setVisible(true);
            IngresarTexto.setText("Ingrese el nombre de la area");
        }
        else if(Area.isSelected()&&Eliminar.isSelected()){
            Texto.setVisible(true);
            BotonEliminar.setVisible(true);
            IngresarTexto.setText("Ingrese el nombre de la area");
        }
        else if(Empleado.isSelected()&&Ver.isSelected()){
            Texto.setVisible(true);
            BotonVer.setVisible(true);
            IngresarTexto.setText("Ingrese la cedula del empleado");
        }
        else if(Empleado.isSelected()&&Eliminar.isSelected()){
            Texto.setVisible(true);
            BotonEliminar.setVisible(true);
            IngresarTexto.setText("Ingrese la cedula del empelado");
        }
        else if(Cliente.isSelected()&&Ver.isSelected()){
            Texto.setVisible(true);
            BotonVer.setVisible(true);
            IngresarTexto.setText("Ingrese la cedula del Cliente");
        }
        else if(Cliente.isSelected()&&Eliminar.isSelected()){
            Texto.setVisible(true);
            BotonEliminar.setVisible(true);
            IngresarTexto.setText("Ingrese la cedual del cliente");
        }
        else if(Area.isSelected()&&Crear.isSelected()){
            Texto1.setVisible(true);
            Texto2.setVisible(true);
            Texto3.setVisible(true);
            BotonCrear.setVisible(true);
            Atributo1.setText("Nombre");
            Atributo2.setText("Ingresos");
            Atributo3.setText("Gastos");
        }
        else if(Empleado.isSelected()&&Crear.isSelected()){
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
        }
        else if(Cliente.isSelected()&&Crear.isSelected()){
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
        }
    }


    @FXML
    public void ActionSi(ActionEvent actionEvent)throws IOException{
        if(Si1.isSelected()){
            No1.setSelected(false);
            LabelRelacion1.setText("Nombre del Area");
            RelacionTexto1.setVisible(true);
        }
    }
    @FXML
    public void ActionNo(ActionEvent actionEvent)throws IOException{
        if(No1.isSelected()){
            Si1.setSelected(false);
            LabelRelacion1.setText("");
            RelacionTexto1.setVisible(false);
        }
    }
    @FXML
    public void ActionVer(ActionEvent actionEvent)throws IOException {
        Informacion.setText("");

        if(Texto.getText().equals("")){
            ErrorText.setText("Ingrese un valor");
        }
        else if(Area.isSelected()&&Ver.isSelected()){
            String area = Texto.getText().toLowerCase();
            if(!App.areas.containsKey(area)){
                ErrorVer.setText("No se encunetra un area con este nombre");
            }
            else{
            Informacion.setText(App.areas.get(area).toString());}
        }
        else if (Empleado.isSelected()&&Ver.isSelected()){
            int empleado=Integer.parseInt(Texto.getText());
            if(!App.empleados.containsKey(empleado)){
                ErrorVer.setText("No se encuentra un empledo con esta cedula");
            }else{
            Informacion.setText(App.empleados.get(empleado).toString());}
        }
        else if(Cliente.isSelected()){
            int cliente=Integer.parseInt(Texto.getText());
            if(!App.clientes.containsKey(cliente)){
                ErrorVer.setText("No se encuentra un cliente con esta cedula");
            }
            else{
            Informacion.setText(App.clientes.get(cliente).toString());}
        }
    }

    @FXML
    public void ActionEliminar(ActionEvent actionEvent)throws IOException{

    }
    @FXML
    public void ActionCrear(ActionEvent actionEvent)throws IOException{

        if(Area.isSelected()&&Crear.isSelected()){
            if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")){
                ErrorCrear.setText("Falta atributo(s)");
            }
            else{
               String Nombre=Texto1.getText().toLowerCase();
               int Ingresos=Integer.parseInt(Texto2.getText());
               int Gastos=Integer.parseInt(Texto3.getText());
               org.example.Area nuevaArea=new Area(Nombre,Ingresos,Gastos);
               App.areas.put(Nombre,nuevaArea);
               App.sistema.addVertex(nuevaArea);
               Informacion.setText("Area creada con exito");
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
            }
        }
        else if(Empleado.isSelected()&&Crear.isSelected()){
            if(Texto1.getText().equals("")||Texto2.getText().equals("")||Texto3.getText().equals("")||Texto4.getText().equals("")){
                ErrorCrear.setText("Falta atributo(s)");
            }
            else{
                String Nombre=Texto1.getText().toLowerCase();
                int Cedula=Integer.parseInt(Texto2.getText());
                int Edad=Integer.parseInt(Texto3.getText());
                int Salario=Integer.parseInt(Texto4.getText());
                org.example.Empleado nuevoEmpleado=new Empleado(Nombre,Cedula,Edad,Salario);
                App.empleados.put(Cedula,nuevoEmpleado);
                App.sistema.addVertex(nuevoEmpleado);

                if(Si1.isSelected()){
                    String NombreArea=RelacionTexto1.getText().toLowerCase();
                    if(!App.areas.containsKey(NombreArea)){
                        ErrorCrear.setText("No se encontro un area registrada");
                        Informacion.setText("Empleado creado sin relacion");
                    }
                    else{
                        org.example.Area area=App.areas.get(NombreArea);
                        App.sistema.addEdge(area,nuevoEmpleado);
                        Informacion.setText("Empleado creado con relacion");
                    }
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
                }
                else if(No1.isSelected()){
                    Informacion.setText("Empleado creado sin relacion");
                }
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
                org.example.Cliente nuevoCliente=new Cliente(Nombre,Cedula,Dinero);
                App.clientes.put(Cedula,nuevoCliente);
                App.sistema.addVertex(Cliente);
                if(Si1.isSelected()){
                    String NombreArea=RelacionTexto1.getText().toLowerCase();
                    if(!App.areas.containsKey(NombreArea)){
                        ErrorCrear.setText("No se encontro un area registrada");
                        Informacion.setText("Cliente creado sin relacion");
                    }
                    else{
                        org.example.Area area=App.areas.get(NombreArea);
                        App.sistema.addEdge(area,nuevoCliente);
                        Informacion.setText("Cliente creado con relacion");
                    }
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
                }
                else if(No1.isSelected()){
                    Informacion.setText("Cliente creado sin relacion");
                }
            }
        }
    }
    @FXML
    private void Salir(ActionEvent salir)throws IOException{
        App.setRoot("MenuPrincipal");
    }
}
