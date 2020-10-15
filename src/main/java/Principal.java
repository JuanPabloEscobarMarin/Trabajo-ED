import Clases.*;
import Comparadores.*;
import Packaje_JSON.EscribirJSON;

import  java.util.LinkedList;
import java.util.Scanner;

public  class  Principal {

    public static LinkedList<Multinacional>  multinacionales =new LinkedList<>();
    public static LinkedList<Sede>  sedes =new LinkedList<>();
    public static LinkedList<Pais>  paises =new LinkedList<>();
    public static LinkedList<Inversionista>  inversionistas =new LinkedList<>();
    public static LinkedList<Area>  areas =new LinkedList<>();
    public static LinkedList<Empleado>  empleados =new LinkedList<>();
    public static LinkedList<Cliente>  clientes =new LinkedList<>();
    public static LinkedList<Usuario> usuarios = new LinkedList<>();
    public static Scanner input = new Scanner(System.in);
    public static Usuario usuarioLogueado = new Usuario(null, null, null, null, null);


    public static void main(java.lang.String[] args) {
        String option;
        label:
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Bienvenido ");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ingresar usuario");
            System.out.println("2. Registrar usuario");
            System.out.println("0. Salir");
            System.out.println("-----------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    ingresarUsuario();
                    break;
                case "2":
                    registrarUsuario();
                    break;
                case "0":
                    break label;
            }
        }
    }

    private static void registrarUsuario() {
        System.out.print("Documento : ");
        int Documento = input.nextInt();
        String documentoString = String.valueOf(Documento);
        input.nextLine();
        while (Documento <= 0) {
            System.out.println("Documento invalido ,ingreselo de nuevo ");
            System.out.print("Documento : ");
            Documento = input.nextInt();
        }
        System.out.print("Nombre : ");
        String Nombre = input.nextLine();
        while (Nombre.equals("")) {
            System.out.println("Nombre invalido, ingreselo de nuevo ");
            System.out.print("Nombre : ");
            Nombre = input.nextLine();
        }
        System.out.print("Apellido : ");
        String Apellido = input.nextLine();
        while (Apellido.equals("")) {
            System.out.println("Apellido invalido, ingreselo de nuevo ");
            System.out.print("Apellido: ");
            Apellido = input.nextLine();
        }
        System.out.print("Correo Electronico : ");
        String Correo = input.nextLine();
        while (Correo.equals("")) {
            System.out.println("Correo invalido, ingreselo de nuevo ");
            System.out.print("Correo: ");
            Correo = input.nextLine();
        }
        System.out.print("Contraseña : ");
        String Password = input.nextLine();
        while (Password.equals("")) {
            System.out.println("Contraseña invalido, ingreselo de nuevo ");
            System.out.print("Contraseña: ");
            Password = input.nextLine();
        }

        Usuario nuevoUsuario = new Usuario(documentoString, Nombre, Apellido, Correo, Password);
        usuarios.add(nuevoUsuario);
        Usuario prueba = new Usuario(documentoString,Nombre, Apellido, Correo, Password);
        EscribirJSON.guardarUsuario(prueba);
        System.out.println("USUARIO REGISTRADO EXITOSAMENTE");


        ingresarUsuario();
    }

    private static void ingresarUsuario() {

        if (usuarios.isEmpty()) {
            System.out.println("No se encuentra usuario, debes registrar usuario");
            System.out.println("-----------------------------");
            registrarUsuario();
        }
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Ingresar Documento/Correo");
            System.out.println("-----------------------------");
            String DocumentoIngresado = input.nextLine();
            System.out.println("-----------------------------");
            System.out.println("Ingresa la contraseña");
            System.out.println("-----------------------------");
            String PasswordIngresado = input.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario.documento.equals(DocumentoIngresado) || usuario.correo.equals(DocumentoIngresado)) {
                    for (Usuario usuario2 : usuarios) {
                        if (usuario2.contraseña.equals(PasswordIngresado)) {

                            System.out.println("-----------------------------");
                            System.out.println("LOGUEADO CORRECTAMENTE");
                            System.out.println("logueando...................");
                            usuarioLogueado = usuario;
                            menuPrincipal();
                            return;
                        }
                    }
                }
            }
            System.out.println("Datos invalidos, ingreselos denuevo");
        }
    }
    private static void menuPrincipal() {
        String option;

        System.out.println("Bienvenido " + usuarioLogueado.nombre + " " + usuarioLogueado.apellido);

        label:
        while (true) {

            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Administración");
            System.out.println("2. Búsqueda");
            System.out.println("3. Diagnóstico de inconsistencias");
            System.out.println("4. Guardar");
            System.out.println("0. Salir y cancelar");
            System.out.println("-----------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    administracion();
                    break;
                case "2":
                    busqueda();

                    break;
                case "3":
                    diagnostico();

                    break;
                case "4":
                    guardar();
                    break;
                case "0":
                    salirCancelar();
                    break label;
            }
        }
    }


    private static void administracion() {
        String option;
        label:
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Multinacional");
            System.out.println("2. Sedes");
            System.out.println("3. Paises");
            System.out.println("4. Inversionistas");
            System.out.println("5. Areas");
            System.out.println("6. Empleados");
            System.out.println("7. Clientes");
            System.out.println("0. Salir");
            System.out.println("-----------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    String optionMulti;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver multinacionales");
                    System.out.println("2. Crear multinacional");
                    System.out.println("3. Editar multinacional");
                    System.out.println("4. Eliminar multinacional");
                    System.out.println("-----------------------------");
                    optionMulti=input.next();
                    switch (optionMulti){
                        case "1":
                            VerMultinacional();
                            break;
                        case "2":
                            CrearMultinacional();
                            break;
                        case "3":
                            EditarMultinacional();
                            break;
                        case "4":
                            EliminarMultinacional();
                            break;
                    }
                    break;
                case "2":
                    String optionSede;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver sedes");
                    System.out.println("2. Crear sede");
                    System.out.println("3. Editar sede");
                    System.out.println("4. Eliminar sede");
                    System.out.println("-----------------------------");
                    optionSede=input.next();
                    switch (optionSede){
                        case "1":
                            VerSede();
                            break;
                        case "2":
                            CrearSede();
                            break;
                        case "3":
                            EditarSede();
                            break;
                        case "4":
                            EliminarSede();
                            break;
                    }

                    break;
                case "3":
                    String optionPais;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver paises");
                    System.out.println("2. Crear pais");
                    System.out.println("3. Editar pais");
                    System.out.println("4. Eliminar pais");
                    System.out.println("-----------------------------");
                    optionPais=input.next();
                    switch (optionPais){
                        case "1":
                            VerPais();
                            break;
                        case "2":
                            CrearPais();
                            break;
                        case "3":
                            EditarPais();
                            break;
                        case "4":
                            EliminarPais();
                            break;
                    }
                    break;
                case "4":
                    String optionInversionista;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver invercionistas");
                    System.out.println("2. Crear invercionista");
                    System.out.println("3. Editar invercionista");
                    System.out.println("4. Eliminar invercionista");
                    System.out.println("-----------------------------");
                    optionInversionista=input.next();
                    switch (optionInversionista){
                        case "1":
                            VerInversionista();
                            break;
                        case "2":
                            CrearInversionista();
                            break;
                        case "3":
                            EditarInversionista();
                            break;
                        case "4":
                            //gg
                            EliminarInversionista();
                            break;
                    }

                    break;
                case "5":
                    String optionArea;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver areas");
                    System.out.println("2. Crear area");
                    System.out.println("3. Editar area");
                    System.out.println("4. Eliminar area");
                    System.out.println("-----------------------------");
                    optionArea=input.next();
                    switch (optionArea){
                        case "1":
                            VerArea();
                            break;
                        case "2":
                            CrearArea();
                            break;
                        case "3":
                            EditarArea();
                            break;
                        case "4":
                            EliminarArea();
                            break;
                    }
                    break;
                case "6":
                    String optionEmpleado;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver empleados");
                    System.out.println("2. Crear empleado");
                    System.out.println("3. Editar empleado");
                    System.out.println("4. Eliminar empleado");
                    System.out.println("-----------------------------");
                    optionEmpleado=input.next();
                    switch (optionEmpleado){
                        case "1":
                            VerEmpleado();
                            break;
                        case "2":
                            CrearEmpleado();
                            break;
                        case "3":
                            EditarEmpleado();
                            break;
                        case "4":
                            EliminarEmpleado();
                            break;
                    }
                    break;
                case "7":
                    String optionCliente;
                    System.out.println("-----------------------------");
                    System.out.println("Escoja una opcion:");
                    System.out.println("1. Ver clientes");
                    System.out.println("2. Crear cliente");
                    System.out.println("3. Editar cliente");
                    System.out.println("4. Eliminar cliente");
                    System.out.println("-----------------------------");
                    optionCliente=input.next();
                    switch (optionCliente){
                        case "1":
                            VerCliente();
                            break;
                        case "2":
                            CrearCliente();
                            break;
                        case "3":
                            EditarCliente();
                            break;
                        case "4":
                            EliminarCliente();
                            break;
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

    private static void busqueda() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion para realizar la busqueda:");
            System.out.println("1. Multinacionales");
            System.out.println("2. Paises");
            System.out.println("3. Sedes");
            System.out.println("4. Inversionistas");
            System.out.println("5. Areas");
            System.out.println("6. Empleados");
            System.out.println("7. Clientes");
            System.out.println("0. Salir");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    buscarMultinacionales();
                    break;
                case "2":
                    buscarPaises();
                    break;
                case "3":
                    buscarSedes();
                    break;
                case "4":
                    buscarInversionistas();
                    break;
                case "5":
                    buscarAreas();
                    break;
                case "6":
                    buscarEmpleados();
                    break;
                case "7":
                    buscarClientes();
                    break;
                case "0":
                    menuPrincipal();
                    break label;
            }
        }
    }
    private static void buscarMultinacionales(){
        if (multinacionales.isEmpty()) {
            System.out.println("No Hay multinacionales");
            busqueda();
        } else {
            while(true){
                LinkedList<Multinacional> repuesto = new LinkedList<>(multinacionales);
            System.out.println("Escoja un atributo de busqueda:");
            System.out.println("1. Nombre");
            System.out.println("2. NIT");
            System.out.println("3. Ceo");
            System.out.println("4. Ingreso total");
            System.out.println("5. Gasto total");
            System.out.println("6. Mostrar todas las multinacionales");
            String option2 = input.next();
            switch (option2) {
                case "1": {
                    while (true) {
                        String option3;
                        System.out.println("Escoja una opcion:");
                        System.out.println("1. Valor exacto");
                        System.out.println("2. Valor sin considerar las mayusculas");
                        option3 = input.next();
                        if ("1".equals(option3)) {
                            input.nextLine();
                            System.out.print("Ingrese el Nombre a buscar: ");
                            String buscarM = input.nextLine();
                            int index = 1;
                            int count = 0;
                            for (Multinacional multinacional : multinacionales) {
                                if (multinacional.nombre.equals(buscarM)) {
                                    System.out.println(index + " " + multinacional);
                                } else {
                                    count++;
                                    if (count == multinacionales.size()) {
                                        System.out.println("No se encuentra la multinacional");
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            System.out.println("Desea editar o eliminar algun elemento? :");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            String option4 = input.next();
                            if (option4.equals("1")) {
                                System.out.print("Ingrese el numero indice del objeto: ");
                                int iBuscar = input.nextInt();
                                System.out.println("¿Desea editar o eliminar el objeto?: ");
                                System.out.println("1. Editar");
                                System.out.println("2. Eliminar");
                                System.out.println("0. Salir");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.nombre.equals(buscarM)) {
                                            if (index2 == iBuscar) {
                                                System.out.println("Nombre: " + multinacional.nombre);
                                                System.out.print("Ingrese nuevo nombre: ");
                                                input.nextLine();
                                                String nombre = input.nextLine();
                                                if (nombre.equals("")) {
                                                    nombre = multinacional.nombre;
                                                }
                                                System.out.println("Ceo: " + multinacional.ceo);
                                                System.out.print("Ingrese nuevo ceo: ");
                                                String ceo = input.nextLine();
                                                if (ceo.equals("")) {
                                                    ceo = multinacional.ceo;
                                                }
                                                System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                System.out.print("Ingrese ingreso total: ");
                                                String Fondos = input.nextLine();
                                                int ingreso;
                                                if (Fondos.equals("")) {
                                                    ingreso = multinacional.ingresoTotal;
                                                } else {
                                                    ingreso = Integer.parseInt(Fondos);
                                                }
                                                System.out.println("Gasto: " + multinacional.gastoTotal);
                                                System.out.print("Ingrese gasto total: ");
                                                String Gasto = input.nextLine();
                                                int gasto;
                                                if (Gasto.equals("")) {
                                                    gasto = multinacional.gastoTotal;
                                                } else {
                                                    gasto = Integer.parseInt(Gasto);
                                                }
                                                System.out.println("NIT: " + multinacional.NIT);
                                                System.out.print("Ingrese NIT nuevo: ");
                                                String nit = input.nextLine();
                                                int NIT;
                                                if (nit.equals("")) {
                                                    NIT = multinacional.NIT;
                                                } else {
                                                    NIT = Integer.parseInt(nit);
                                                }
                                                Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                System.out.println("Multinacional editada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("2")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.nombre.equals(buscarM)) {
                                            if (index2 == iBuscar) {
                                                multinacionales.remove(multinacional);
                                                System.out.println("Multinacional eliminada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("0")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option4.equals("2")) {
                                busqueda();
                                return;
                            }
                        } else if ("2".equals(option3)) {
                            input.nextLine();
                            int count = 0;
                            System.out.print("Ingrese el nombre a buscar: ");
                            String buscarNombre = input.nextLine();
                            String nombreMinuscula = buscarNombre.toLowerCase();
                            int index2 = 1;
                            for (Multinacional multinacional : multinacionales) {
                                String minusculas = multinacional.nombre.toLowerCase();
                                if (minusculas.equals(nombreMinuscula)) {
                                    System.out.println(index2 + " " + multinacional);
                                    busqueda();
                                    return;
                                } else {
                                    count++;
                                    if (count == multinacionales.size()) {
                                        System.out.println("No se encuentra la multinacional");
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            System.out.println("Desea editar o eliminar algun elemento? :");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            String option4 = input.next();
                            if (option4.equals("1")) {
                                System.out.println("Ingrese el numero indice del objeto: ");
                                int iBuscar = input.nextInt();
                                System.out.println("¿Desea editar o eliminar el objeto?: ");
                                System.out.println("1. Editar");
                                System.out.println("2. Eliminar");
                                System.out.println("0. Salir");
                                String option5 = input.next();
                                switch (option5) {
                                    case "1": {
                                        int index3 = 1;
                                        for (Multinacional multinacional : multinacionales) {
                                            String minusculas = multinacional.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index3 == iBuscar) {
                                                    System.out.println("Nombre: " + multinacional.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = multinacional.nombre;
                                                    }
                                                    System.out.println("Ceo: " + multinacional.ceo);
                                                    System.out.print("Ingrese nuevo ceo: ");
                                                    String ceo = input.nextLine();
                                                    if (ceo.equals("")) {
                                                        ceo = multinacional.ceo;
                                                    }
                                                    System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                    System.out.print("Ingrese ingreso total: ");
                                                    String Fondos = input.nextLine();
                                                    int ingreso;
                                                    if (Fondos.equals("")) {
                                                        ingreso = multinacional.ingresoTotal;
                                                    } else {
                                                        ingreso = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gasto: " + multinacional.gastoTotal);
                                                    System.out.print("Ingrese gasto total: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto;
                                                    if (Gasto.equals("")) {
                                                        gasto = multinacional.gastoTotal;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    System.out.println("NIT: " + multinacional.NIT);
                                                    System.out.print("Ingrese NIT nuevo: ");
                                                    String nit = input.nextLine();
                                                    int NIT;
                                                    if (nit.equals("")) {
                                                        NIT = multinacional.NIT;
                                                    } else {
                                                        NIT = Integer.parseInt(nit);
                                                    }
                                                    Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                    multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                    System.out.println("Multinacional editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index3++;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case "2": {
                                        int index3 = 1;
                                        for (Multinacional multinacional : multinacionales) {
                                            String minusculas = multinacional.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index3 == iBuscar) {
                                                    multinacionales.remove(multinacional);
                                                    System.out.println("Multinacional eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index3++;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case "0":
                                        busqueda();
                                        break;
                                }
                            } else if (option4.equals("2")) {
                                busqueda();
                                return;
                            }
                        }
                    }
                }
                case "2": {
                    while (true) {
                        String orden;
                        System.out.println("¿De que manera desea organizar el resultado?");
                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        orden = input.next();
                        if (orden.equals("1")) {
                            repuesto.sort(new ComparadorM());
                        } else if (orden.equals("2")) {
                            repuesto.sort(new ComparadorM().reversed());
                        }
                        System.out.println("Escoja una opcion:");
                        System.out.println("1. Valor exacto");
                        System.out.println("2. Valor maximo");
                        System.out.println("3. Valor minimo");
                        System.out.println("4. Rango");
                        String option4 = input.next();
                        switch (option4) {
                            case "1": {
                                System.out.print("Ingrese el NIT a buscar: ");
                                int buscarNIT = input.nextInt();
                                int index = 1;
                                int count = 0;
                                for (Multinacional multinacional : multinacionales) {
                                    if (multinacional.NIT == buscarNIT) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == multinacionales.size()) {
                                            System.out.println("No se encuentra la multinacional");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option6 = input.next();
                                    if (option6.equals("1")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : multinacionales) {
                                            if (multinacional.NIT == buscarNIT) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + multinacional.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = multinacional.nombre;
                                                    }
                                                    System.out.println("Ceo: " + multinacional.ceo);
                                                    System.out.print("Ingrese nuevo ceo: ");
                                                    String ceo = input.nextLine();
                                                    if (ceo.equals("")) {
                                                        ceo = multinacional.ceo;
                                                    }
                                                    System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                    System.out.print("Ingrese ingreso total: ");
                                                    String Fondos = input.nextLine();
                                                    int ingreso;
                                                    if (Fondos.equals("")) {
                                                        ingreso = multinacional.ingresoTotal;
                                                    } else {
                                                        ingreso = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gasto: " + multinacional.gastoTotal);
                                                    System.out.print("Ingrese gasto total: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto;
                                                    if (Gasto.equals("")) {
                                                        gasto = multinacional.gastoTotal;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    System.out.println("NIT: " + multinacional.NIT);
                                                    System.out.print("Ingrese NIT nuevo: ");
                                                    String nit = input.nextLine();
                                                    int NIT;
                                                    if (nit.equals("")) {
                                                        NIT = multinacional.NIT;
                                                    } else {
                                                        NIT = Integer.parseInt(nit);
                                                    }
                                                    Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                    multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                    System.out.println("Multinacional editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("2")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : multinacionales) {
                                            if (multinacional.NIT == buscarNIT) {
                                                if (index2 == iBuscar) {
                                                    multinacionales.remove(multinacional);
                                                    System.out.println("Multinacional eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option5.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                            case "2": {
                                System.out.print("Ingrese el NIT de valor maximo a buscar: ");
                                int ValorMaximo = input.nextInt();
                                int count = 0;
                                int index = 1;
                                for (Multinacional multinacional : repuesto) {
                                    if (multinacional.NIT <= ValorMaximo) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == multinacionales.size()) {
                                            System.out.println("No se encuentra la multinacional");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option6 = input.next();
                                    if (option6.equals("1")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT <= ValorMaximo) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + multinacional.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = multinacional.nombre;
                                                    }
                                                    System.out.println("Ceo: " + multinacional.ceo);
                                                    System.out.print("Ingrese nuevo ceo: ");
                                                    String ceo = input.nextLine();
                                                    if (ceo.equals("")) {
                                                        ceo = multinacional.ceo;
                                                    }
                                                    System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                    System.out.print("Ingrese ingreso total: ");
                                                    String Fondos = input.nextLine();
                                                    int ingreso;
                                                    if (Fondos.equals("")) {
                                                        ingreso = multinacional.ingresoTotal;
                                                    } else {
                                                        ingreso = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gasto: " + multinacional.gastoTotal);
                                                    System.out.print("Ingrese gasto total: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto;
                                                    if (Gasto.equals("")) {
                                                        gasto = multinacional.gastoTotal;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    System.out.println("NIT: " + multinacional.NIT);
                                                    System.out.print("Ingrese NIT nuevo: ");
                                                    String nit = input.nextLine();
                                                    int NIT;
                                                    if (nit.equals("")) {
                                                        NIT = multinacional.NIT;
                                                    } else {
                                                        NIT = Integer.parseInt(nit);
                                                    }
                                                    Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                    multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                    System.out.println("Multinacional editada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("2")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT <= ValorMaximo) {
                                                if (index2 == iBuscar) {
                                                    multinacionales.remove(multinacional);
                                                    System.out.println("Multinacional eliminada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                            case "3": {
                                System.out.print("Ingrese el NIT de valor minimo a buscar: ");
                                int ValorMinimo = input.nextInt();
                                int count = 0;
                                int index = 1;
                                for (Multinacional multinacional : repuesto) {
                                    if (multinacional.NIT >= ValorMinimo) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == multinacionales.size()) {
                                            System.out.println("No se encuentra la multinacional");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    System.out.println("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option6 = input.next();
                                    if (option6.equals("1")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT >= ValorMinimo) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + multinacional.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = multinacional.nombre;
                                                    }
                                                    System.out.println("Ceo: " + multinacional.ceo);
                                                    System.out.print("Ingrese nuevo ceo: ");
                                                    String ceo = input.nextLine();
                                                    if (ceo.equals("")) {
                                                        ceo = multinacional.ceo;
                                                    }
                                                    System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                    System.out.print("Ingrese ingreso total: ");
                                                    String Fondos = input.nextLine();
                                                    int ingreso = 0;
                                                    if (Fondos.equals("")) {
                                                        ingreso = multinacional.ingresoTotal;
                                                    } else {
                                                        ingreso = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gasto: " + multinacional.gastoTotal);
                                                    System.out.print("Ingrese gasto total: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")) {
                                                        gasto = multinacional.gastoTotal;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    System.out.print("Ingrese NIT nuevo: ");
                                                    String nit = input.nextLine();
                                                    int NIT = 0;
                                                    if (nit.equals("")) {
                                                        NIT = multinacional.NIT;
                                                    } else {
                                                        NIT = Integer.parseInt(nit);
                                                    }
                                                    Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                    multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                    System.out.println("Multinacional editada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("2")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT >= ValorMinimo) {
                                                if (index2 == iBuscar) {
                                                    multinacionales.remove(multinacional);
                                                    System.out.println("Multinacional eliminada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                repuesto.removeAll(repuesto);
                                busqueda();
                                return;
                            }
                            case "4": {
                                System.out.print("Ingrese un valor minimo de NIT: ");
                                int rangoMinimo = input.nextInt();
                                System.out.print("Ingrese un valor maximo de NIT: ");
                                int rangoMaximo = input.nextInt();
                                int count = 0;
                                int index = 1;
                                for (Multinacional multinacional : repuesto) {
                                    if (multinacional.NIT >= rangoMinimo && multinacional.NIT <= rangoMaximo) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == multinacionales.size()) {
                                            System.out.println("No se encuentra la multinacional");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    System.out.println("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option6 = input.next();
                                    if (option6.equals("1")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT >= rangoMinimo && multinacional.NIT <= rangoMaximo) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + multinacional.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = multinacional.nombre;
                                                    }
                                                    System.out.println("Ceo: " + multinacional.ceo);
                                                    System.out.print("Ingrese nuevo ceo: ");
                                                    String ceo = input.nextLine();
                                                    if (ceo.equals("")) {
                                                        ceo = multinacional.ceo;
                                                    }
                                                    System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                    System.out.print("Ingrese ingreso total: ");
                                                    String Fondos = input.nextLine();
                                                    int ingreso = 0;
                                                    if (Fondos.equals("")) {
                                                        ingreso = multinacional.ingresoTotal;
                                                    } else {
                                                        ingreso = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gasto: " + multinacional.gastoTotal);
                                                    System.out.print("Ingrese gasto total: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")) {
                                                        gasto = multinacional.gastoTotal;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    System.out.print("Ingrese NIT nuevo: ");
                                                    String nit = input.nextLine();
                                                    int NIT = 0;
                                                    if (nit.equals("")) {
                                                        NIT = multinacional.NIT;
                                                    } else {
                                                        NIT = Integer.parseInt(nit);
                                                    }
                                                    Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                    multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                    System.out.println("Multinacional editada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("2")) {
                                        int index2 = 1;
                                        for (Multinacional multinacional : repuesto) {
                                            if (multinacional.NIT >= rangoMinimo && multinacional.NIT <= rangoMaximo) {
                                                if (index2 == iBuscar) {
                                                    multinacionales.remove(multinacional);
                                                    System.out.println("Multinacional eliminada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option6.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                repuesto.removeAll(repuesto);
                                busqueda();
                                return;
                            }
                        }
                    }
                }
                case "3": {
                    while (true) {
                        String option3;
                        System.out.println("Escoja una opcion:");
                        System.out.println("1. Valor exacto");
                        System.out.println("2. valor sin considerar mayusculas");
                        option3 = input.next();
                        if (option3.equals("1")) {
                            input.nextLine();
                            System.out.print("Ingrese el ceo a buscar: ");
                            String buscarceo = input.nextLine();
                            int count = 0;
                            int index = 1;
                            for (Multinacional multinacional : multinacionales) {
                                if (multinacional.ceo.equals(buscarceo)) {
                                    System.out.println(index + " " + multinacional);
                                    index++;
                                } else {
                                    count++;
                                    if (count == multinacionales.size()) {
                                        System.out.println("No se encuentra la multinacional");
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            System.out.println("Desea editar o eliminar algun elemento? :");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            String option4 = input.next();
                            if (option4.equals("1")) {
                                System.out.print("Ingrese el numero indice del objeto: ");
                                int iBuscar = input.nextInt();
                                System.out.println("¿Desea editar o eliminar el objeto?: ");
                                System.out.println("1. Editar");
                                System.out.println("2. Eliminar");
                                System.out.println("0. Salir");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.ceo.equals(buscarceo)) {
                                            if (index2 == iBuscar) {
                                                System.out.println("Nombre: " + multinacional.nombre);
                                                System.out.print("Ingrese nuevo nombre: ");
                                                input.nextLine();
                                                String nombre = input.nextLine();
                                                if (nombre.equals("")) {
                                                    nombre = multinacional.nombre;
                                                }
                                                System.out.println("Ceo: " + multinacional.ceo);
                                                System.out.print("Ingrese nuevo ceo: ");
                                                String ceo = input.nextLine();
                                                if (ceo.equals("")) {
                                                    ceo = multinacional.ceo;
                                                }
                                                System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                System.out.print("Ingrese ingreso total: ");
                                                String Fondos = input.nextLine();
                                                int ingreso = 0;
                                                if (Fondos.equals("")) {
                                                    ingreso = multinacional.ingresoTotal;
                                                } else {
                                                    ingreso = Integer.parseInt(Fondos);
                                                }
                                                System.out.println("Gasto: " + multinacional.gastoTotal);
                                                System.out.print("Ingrese gasto total: ");
                                                String Gasto = input.nextLine();
                                                int gasto = 0;
                                                if (Gasto.equals("")) {
                                                    gasto = multinacional.gastoTotal;
                                                } else {
                                                    gasto = Integer.parseInt(Gasto);
                                                }
                                                System.out.println("NIT: " + multinacional.NIT);
                                                System.out.print("Ingrese NIT nuevo: ");
                                                String nit = input.nextLine();
                                                int NIT = 0;
                                                if (nit.equals("")) {
                                                    NIT = multinacional.NIT;
                                                } else {
                                                    NIT = Integer.parseInt(nit);
                                                }
                                                Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                System.out.println("Multinacional editada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("2")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.ceo.equals(buscarceo)) {
                                            if (index2 == iBuscar) {
                                                multinacionales.remove(multinacional);
                                                System.out.println("Multinacional eliminada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("0")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option4.equals("2")) {
                                busqueda();
                                return;
                            }
                        } else if (option3.equals("2")) {
                            input.nextLine();
                            System.out.print("Ingrese el ceo a buscar: ");
                            String buscarceo = input.nextLine();
                            String ceoMinuscula = buscarceo.toLowerCase();
                            int count = 0;
                            int index = 1;
                            for (Multinacional multinacional : multinacionales) {
                                String minusculas = multinacional.ceo.toLowerCase();
                                if (minusculas.equals(ceoMinuscula)) {
                                    System.out.println(index + " " + multinacional);
                                    index++;
                                } else {
                                    count++;
                                    if (count == multinacionales.size()) {
                                        System.out.println("No se encuentra la multinacional");
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            System.out.println("Desea editar o eliminar algun elemento? :");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            String option4 = input.next();
                            if (option4.equals("1")) {
                                System.out.print("Ingrese el numero indice del objeto: ");
                                int iBuscar = input.nextInt();
                                System.out.println("¿Desea editar o eliminar el objeto?: ");
                                System.out.println("1. Editar");
                                System.out.println("2. Eliminar");
                                System.out.println("0. Salir");
                                String option5 = input.next();
                                if (option5.equals("1")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        String minusculas = multinacional.ceo.toLowerCase();
                                        if (minusculas.equals(ceoMinuscula)) {
                                            if (index2 == iBuscar) {
                                                System.out.println("Nombre: " + multinacional.nombre);
                                                System.out.print("Ingrese nuevo nombre: ");
                                                input.nextLine();
                                                String nombre = input.nextLine();
                                                if (nombre.equals("")) {
                                                    nombre = multinacional.nombre;
                                                }
                                                System.out.println("Ceo: " + multinacional.ceo);
                                                System.out.print("Ingrese nuevo ceo: ");
                                                String ceo = input.nextLine();
                                                if (ceo.equals("")) {
                                                    ceo = multinacional.ceo;
                                                }
                                                System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                System.out.print("Ingrese ingreso total: ");
                                                String Fondos = input.nextLine();
                                                int ingreso = 0;
                                                if (Fondos.equals("")) {
                                                    ingreso = multinacional.ingresoTotal;
                                                } else {
                                                    ingreso = Integer.parseInt(Fondos);
                                                }
                                                System.out.println("Gasto: " + multinacional.gastoTotal);
                                                System.out.print("Ingrese gasto total: ");
                                                String Gasto = input.nextLine();
                                                int gasto = 0;
                                                if (Gasto.equals("")) {
                                                    gasto = multinacional.gastoTotal;
                                                } else {
                                                    gasto = Integer.parseInt(Gasto);
                                                }
                                                System.out.println("NIT: " + multinacional.NIT);
                                                System.out.print("Ingrese NIT nuevo: ");
                                                String nit = input.nextLine();
                                                int NIT = 0;
                                                if (nit.equals("")) {
                                                    NIT = multinacional.NIT;
                                                } else {
                                                    NIT = Integer.parseInt(nit);
                                                }
                                                Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                System.out.println("Multinacional editada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("2")) {
                                    int index2 = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        String minusculas = multinacional.ceo.toLowerCase();
                                        if (minusculas.equals(ceoMinuscula)) {
                                            if (index2 == iBuscar) {
                                                multinacionales.remove(multinacional);
                                                System.out.println("Multinacional eliminada con exito");
                                                busqueda();
                                                return;
                                            } else {
                                                index2++;
                                            }
                                        }
                                    }
                                } else if (option5.equals("0")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option4.equals("2")) {
                                busqueda();
                                return;
                            }
                        }
                    }
                }
                case "4": {
                    while (true) {
                        System.out.println("¿De que manera desea organizar el resultado?");
                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        String orden = input.next();
                        if (orden.equals("1")) {
                            repuesto.sort(new ComparadorMIT());
                        } else if (orden.equals("2")) {
                            repuesto.sort(new ComparadorMIT().reversed());
                        }
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor maximo");
                            System.out.println("3. Valor minimo");
                            System.out.println("4. Rango");
                            option3 = input.next();
                            switch (option3) {
                                case "1": {
                                    System.out.print("Ingrese el valor de ingreso total a buscar: ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.ingresoTotal == buscarTotal) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : multinacionales) {
                                                if (multinacional.ingresoTotal == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : multinacionales) {
                                                if (multinacional.ingresoTotal == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        busqueda();
                                        return;
                                    }
                                }
                                case "2": {
                                    System.out.print("Ingrese el valor de ingreso total maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.ingresoTotal <= ValorMaximo) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                case "3": {
                                    System.out.print("Ingrese el valor de ingreso total minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.ingresoTotal >= ValorMinimo) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                case "4": {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.ingresoTotal <= Max && multinacional.ingresoTotal >= Min) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                        }
                                        if (count == multinacionales.size()) {
                                            System.out.println("No se encuentran multinacionales");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal <= Max && multinacional.ingresoTotal >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.ingresoTotal <= Max && multinacional.ingresoTotal >= Min) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                case "5": {

                    while (true) {
                        System.out.println("¿De que manera desea organizar el resultado?");
                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        String orden = input.next();
                        if (orden.equals("1")) {
                            repuesto.sort(new ComparadorMGT());
                        } else if (orden.equals("2")) {
                            repuesto.sort(new ComparadorMGT().reversed());
                        }
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor maximo");
                            System.out.println("3. Valor minimo");
                            System.out.println("4. Rango");
                            String option3 = input.next();
                            switch (option3) {
                                case "1": {
                                    System.out.print("Ingrese el valor de gasto total a buscar: ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : multinacionales) {
                                        if (multinacional.gastoTotal == buscarTotal) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : multinacionales) {
                                                if (multinacional.gastoTotal == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : multinacionales) {
                                                if (multinacional.gastoTotal == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        busqueda();
                                        return;
                                    }
                                }
                                case "2": {
                                    System.out.print("Ingrese el valor de gasto total maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.gastoTotal <= ValorMaximo) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                            }
                                case "3": {
                                    System.out.print("Ingrese el valor de gasto total minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.gastoTotal >= ValorMinimo) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentra la multinacional");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                case "4": {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Multinacional multinacional : repuesto) {
                                        if (multinacional.gastoTotal <= Max && multinacional.gastoTotal >= Min) {
                                            System.out.println(index + " " + multinacional);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == multinacionales.size()) {
                                                System.out.println("No se encuentran multinacionales");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal <= Max && multinacional.gastoTotal >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                if (multinacional.gastoTotal <= Max && multinacional.gastoTotal >= Min) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                case "6": {
                        while (true) {
                            System.out.println("Seleccione el atributo por el cual ordenar: ");
                            System.out.println("1. NIT");
                            System.out.println("2. Ingreso total");
                            System.out.println("3. Gasto total");
                            String option3 = input.next();
                            switch (option3) {
                                case "1": {
                                    int index = 1;
                                    repuesto.sort(new ComparadorM());
                                    for (Multinacional multinacional : repuesto) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                case "2": {
                                    int index = 1;
                                    repuesto.sort(new ComparadorMIT());
                                    for (Multinacional multinacional : repuesto) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                case "3": {
                                    int index = 1;
                                    repuesto.sort(new ComparadorMGT());
                                    for (Multinacional multinacional : repuesto) {
                                        System.out.println(index + " " + multinacional);
                                        index++;
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + multinacional.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = multinacional.nombre;
                                                        }
                                                        System.out.println("Ceo: " + multinacional.ceo);
                                                        System.out.print("Ingrese nuevo ceo: ");
                                                        String ceo = input.nextLine();
                                                        if (ceo.equals("")) {
                                                            ceo = multinacional.ceo;
                                                        }
                                                        System.out.println("Fondos: " + multinacional.ingresoTotal);
                                                        System.out.print("Ingrese ingreso total: ");
                                                        String Fondos = input.nextLine();
                                                        int ingreso = 0;
                                                        if (Fondos.equals("")) {
                                                            ingreso = multinacional.ingresoTotal;
                                                        } else {
                                                            ingreso = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gasto: " + multinacional.gastoTotal);
                                                        System.out.print("Ingrese gasto total: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")) {
                                                            gasto = multinacional.gastoTotal;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        System.out.println("NIT: " + multinacional.NIT);
                                                        System.out.print("Ingrese NIT nuevo: ");
                                                        String nit = input.nextLine();
                                                        int NIT = 0;
                                                        if (nit.equals("")) {
                                                            NIT = multinacional.NIT;
                                                        } else {
                                                            NIT = Integer.parseInt(nit);
                                                        }
                                                        Multinacional multinacionalaux = new Multinacional(nombre, ceo, ingreso, gasto, NIT);
                                                        multinacionales.set(multinacionales.indexOf(multinacional), multinacionalaux);
                                                        System.out.println("Multinacional editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Multinacional multinacional : repuesto) {
                                                    if (index2 == iBuscar) {
                                                        multinacionales.remove(multinacional);
                                                        System.out.println("Multinacional eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private static void buscarPaises(){
        if (paises.size() == 0) {
            System.out.println("No hay paises registrados");
        } else {
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Nombre");
                System.out.println("2. Presidente");
                System.out.println("3. Mostrar todos los paises");
                String option2 = input.next();
                switch (option2) {
                    case "1": {
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            String option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del pais a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Pais pais : paises) {
                                    if (pais.nombre.equals(buscarM)) {
                                        System.out.println(index + " " + pais);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == paises.size()) {
                                            System.out.println("No se encuentra el pais");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            if (pais.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + pais.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = pais.nombre;
                                                    }
                                                    System.out.println("Presidente: " + pais.presidente);
                                                    System.out.print("Ingrese nuevo presidente: ");
                                                    String presidente = input.nextLine();
                                                    if (presidente.equals("")) {
                                                        presidente = pais.presidente;
                                                    }
                                                    Pais paisAux = new Pais(nombre, presidente);
                                                    paises.set(paises.indexOf(pais), paisAux);
                                                    System.out.println("Pais editado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            if (pais.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    paises.remove(pais);
                                                    System.out.println("Pais eliminado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                            else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del pais a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Pais pais : paises) {
                                    String minusculas = pais.nombre.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + pais);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == paises.size()) {
                                            System.out.println("No se encuentra el pais");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            String minusculas = pais.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + pais.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = pais.nombre;
                                                    }
                                                    System.out.println("Presidente: " + pais.presidente);
                                                    System.out.print("Ingrese nuevo presidente: ");
                                                    String presidente = input.nextLine();
                                                    if (presidente.equals("")) {
                                                        presidente = pais.presidente;
                                                    }
                                                    Pais paisAux = new Pais(nombre, presidente);
                                                    paises.set(paises.indexOf(pais), paisAux);
                                                    System.out.println("Pais editado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            String minusculas = pais.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    paises.remove(pais);
                                                    System.out.println("Pais eliminado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "2": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del presidente a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Pais pais : paises) {
                                    if (pais.presidente.equals(buscarM)) {
                                        System.out.println(index + " " + pais);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == paises.size()) {
                                            System.out.println("No se encuentra el pais");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            if (pais.presidente.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + pais.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = pais.nombre;
                                                    }
                                                    System.out.println("Presidente" + pais.presidente);
                                                    System.out.print("Ingrese nuevo presidente: ");
                                                    String presidente = input.nextLine();
                                                    if (presidente.equals("")) {
                                                        presidente = pais.presidente;
                                                    }
                                                    Pais paisAux = new Pais(nombre, presidente);
                                                    paises.set(paises.indexOf(pais), paisAux);
                                                    System.out.println("Pais editado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            if (pais.presidente.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    paises.remove(pais);
                                                    System.out.println("Pais eliminado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del presidente a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Pais pais : paises) {
                                    String minusculas = pais.presidente.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + pais);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == paises.size()) {
                                            System.out.println("No se encuentra el pais");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            String minusculas = pais.presidente.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + pais.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = pais.nombre;
                                                    }
                                                    System.out.println("Presidente: " + pais.presidente);
                                                    System.out.print("Ingrese nuevo presidente: ");
                                                    String presidente = input.nextLine();
                                                    if (presidente.equals("")) {
                                                        presidente = pais.presidente;
                                                    }
                                                    Pais paisAux = new Pais(nombre, presidente);
                                                    paises.set(paises.indexOf(pais), paisAux);
                                                    System.out.println("Pais editado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Pais pais : paises) {
                                            String minusculas = pais.presidente.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    paises.remove(pais);
                                                    System.out.println("Pais eliminado con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "3": {
                        System.out.println("Paises registrados totales: ");
                        System.out.println();
                        int index = 1;
                        for (Pais pais : paises) {
                            System.out.println(index + " " + pais);
                            index++;
                        }
                        System.out.println("Desea editar o eliminar algun elemento? :");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        String option4 = input.next();
                        if (option4.equals("1")) {
                            System.out.print("Ingrese el numero indice del objeto: ");
                            int iBuscar = input.nextInt();
                            System.out.println("¿Desea editar o eliminar el objeto?: ");
                            System.out.println("1. Editar");
                            System.out.println("2. Eliminar");
                            System.out.println("0. Salir");
                            String option5 = input.next();
                            if (option5.equals("1")) {
                                int index2 = 1;
                                for (Pais pais : paises) {
                                        if (index2 == iBuscar) {
                                            System.out.println("Nombre: " + pais.nombre);
                                            System.out.print("Ingrese nuevo nombre: ");
                                            input.nextLine();
                                            String nombre = input.nextLine();
                                            if (nombre.equals("")) {
                                                nombre = pais.nombre;
                                            }
                                            System.out.println("Presidente: " + pais.presidente);
                                            System.out.print("Ingrese nuevo presidente: ");
                                            String presidente = input.nextLine();
                                            if (presidente.equals("")) {
                                                presidente = pais.presidente;
                                            }
                                            Pais paisAux = new Pais(nombre, presidente);
                                            paises.set(paises.indexOf(pais), paisAux);
                                            System.out.println("Pais editado con exito");
                                            busqueda();
                                            return;
                                        } else {
                                            index2++;
                                        }
                                    }
                                } else if (option5.equals("2")) {
                                int index2 = 1;
                                for (Pais pais : paises) {
                                        if (index2 == iBuscar) {
                                            paises.remove(pais);
                                            System.out.println("Pais eliminado con exito");
                                            busqueda();
                                            return;
                                        } else {
                                            index2++;
                                        }
                                    }
                            } else if (option5.equals("0")) {
                                busqueda();
                                return;
                            }
                        } else if (option4.equals("2")) {
                            busqueda();
                            return;
                        }
                    }
                }
            }
        }
    }
    private static void buscarSedes(){
        if (sedes.isEmpty()) {
            System.out.println("No hay sedes registradas");
            busqueda();
        } else {
            LinkedList<Sede> repuesto = new LinkedList<>();
            for (Sede sede:sedes) {
                repuesto.add(sede);
            }
            String option2;
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Gerente");
                System.out.println("2. Ingresos totales");
                System.out.println("3. Gastos totales");
                System.out.println("4. Nombre de sede");
                System.out.println("5. Sedes totales");
                option2 = input.next();
                switch (option2) {
                    case "1": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del gerente a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Sede sede : sedes) {
                                    if (sede.gerente.equals(buscarM)) {
                                        System.out.println(index + " " + sede);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            if (sede.gerente.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            if (sede.gerente.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del gerente a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Sede sede : sedes) {
                                    String minusculas = sede.gerente.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + sede);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            String minusculas = sede.gerente.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            String minusculas = sede.gerente.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "2": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorSIT());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorSIT().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de ingresos totales de la sede a buscar: ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : sedes) {
                                        if (sede.ingresoSede == buscarTotal) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : sedes) {
                                                if (sede.ingresoSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : sedes) {
                                                if (sede.ingresoSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de ingreso total maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : repuesto) {
                                        if (sede.ingresoSede <= ValorMaximo) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de ingreso total minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : repuesto) {
                                        if (sede.ingresoSede >= ValorMinimo) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Sede sede : repuesto) {
                                        if (sede.ingresoSede <= Max && sede.ingresoSede >= Min) {
                                            System.out.println(index + " " + sede);
                                        } else {
                                            count++;
                                        }
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede <= Max && sede.ingresoSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.ingresoSede <= Max && sede.ingresoSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    case "3": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorSGT());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorSGT().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion: ");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de gastos totales de la sede a buscar: ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : sedes) {
                                        if (sede.gastosSede == buscarTotal) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : sedes) {
                                                if (sede.gastosSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : sedes) {
                                                if (sede.gastosSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de gasto total maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : repuesto) {
                                        if (sede.gastosSede <= ValorMaximo) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de gasto total minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Sede sede : repuesto) {
                                        if (sede.gastosSede >= ValorMinimo) {
                                            System.out.println(index + " " + sede);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == sedes.size()) {
                                                System.out.println("No se encuentra la sede");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Sede sede : repuesto) {
                                        if (sede.gastosSede <= Max && sede.gastosSede >= Min) {
                                            System.out.println(index + " " + sede);
                                        } else {
                                            count++;
                                        }
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede <= Max && sede.gastosSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Gerente: " + sede.gerente);
                                                        System.out.print("Ingrese nuevo gerente: ");
                                                        input.nextLine();
                                                        String gerente = input.nextLine();
                                                        if (gerente.equals("")) {
                                                            gerente = sede.gerente;
                                                        }
                                                        System.out.println("Fondos: " + sede.ingresoSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Fondos = input.nextLine();
                                                        int fondos = 0;
                                                        if (Fondos.equals("")) {
                                                            fondos = sede.ingresoSede;
                                                        } else {
                                                            fondos = Integer.parseInt(Fondos);
                                                        }
                                                        System.out.println("Gastos: " + sede.gastosSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gastos = input.nextLine();
                                                        int gastos = 0;
                                                        if (Gastos.equals("")){
                                                            gastos = sede.gastosSede;
                                                        } else {
                                                            gastos = Integer.parseInt(Gastos);
                                                        }
                                                        System.out.println("Nombre: " + sede.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")){
                                                            nombre = sede.nombre;
                                                        }
                                                        Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                        sedes.set(sedes.indexOf(sede), SedeAux);
                                                        System.out.println("Sede editada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Sede sede : repuesto) {
                                                if (sede.gastosSede <= Max && sede.gastosSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        sedes.remove(sede);
                                                        System.out.println("Sede eliminada con exito");
                                                        repuesto.removeAll(repuesto);
                                                        busqueda();
                                                        return;
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    } else if (option4.equals("2")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    case "4": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre de sede a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Sede sede : sedes) {
                                    if (sede.nombre.equals(buscarM)) {
                                        System.out.println(index + " " + sede);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            if (sede.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            if (sede.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            } else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre del gerente a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Sede sede : sedes) {
                                    String minusculas = sede.nombre.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + sede);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == sedes.size()) {
                                            System.out.println("No se encuentra la sede");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            String minusculas = sede.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : sedes) {
                                            String minusculas = sede.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "5": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja un atributo de busqueda:");
                            System.out.println("1. Ingresos totales");
                            System.out.println("2. Gastos totales");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                int index = 1;
                                repuesto.sort(new ComparadorSIT());
                                for (Sede sede : repuesto) {
                                    System.out.println(index + " " + sede);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : repuesto) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                        }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            } else if (option3.equals("2")) {
                                int index = 1;
                                repuesto.sort(new ComparadorSIT());
                                for (Sede sede : repuesto) {
                                    System.out.println(index + " " + sede);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Sede sede : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Gerente: " + sede.gerente);
                                                    System.out.print("Ingrese nuevo gerente: ");
                                                    input.nextLine();
                                                    String gerente = input.nextLine();
                                                    if (gerente.equals("")) {
                                                        gerente = sede.gerente;
                                                    }
                                                    System.out.println("Fondos: " + sede.ingresoSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Fondos = input.nextLine();
                                                    int fondos = 0;
                                                    if (Fondos.equals("")) {
                                                        fondos = sede.ingresoSede;
                                                    } else {
                                                        fondos = Integer.parseInt(Fondos);
                                                    }
                                                    System.out.println("Gastos: " + sede.gastosSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gastos = input.nextLine();
                                                    int gastos = 0;
                                                    if (Gastos.equals("")){
                                                        gastos = sede.gastosSede;
                                                    } else {
                                                        gastos = Integer.parseInt(Gastos);
                                                    }
                                                    System.out.println("Nombre: " + sede.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")){
                                                        nombre = sede.nombre;
                                                    }
                                                    Sede SedeAux = new Sede(nombre,gerente,fondos,gastos, sede.multinacional, sede.paisPertenece);
                                                    sedes.set(sedes.indexOf(sede), SedeAux);
                                                    System.out.println("Sede editada con exito");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Sede sede : repuesto) {
                                                if (index2 == iBuscar) {
                                                    sedes.remove(sede);
                                                    System.out.println("Sede eliminada con exito");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                        }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private static void buscarInversionistas(){
        if (inversionistas.size() == 0) {
            System.out.println("No hay inversionistas registrados");
            busqueda();
        } else {
            LinkedList<Inversionista> repuesto = new LinkedList<>();
            for (Inversionista inversionista : inversionistas) {
                repuesto.add(inversionista);
            }
            String option2;
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Firma");
                System.out.println("2. Ganancias");
                System.out.println("3. Inversion en sede");
                System.out.println("4. Inversion en multinacional");
                System.out.println("5. Inversionistas totales");
                option2 = input.next();
                switch (option2) {
                    case "1": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            switch (option3) {
                                case "1": {
                                    input.nextLine();
                                    System.out.print("Ingrese la firma del inversionista a buscar: ");
                                    String buscarM = input.nextLine();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : inversionistas) {
                                        if (inversionista.firma.equals(buscarM)) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentra el inversionista");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.firma.equals(buscarM)) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")) {
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")) {
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista(firma, imultinacional, isede, ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.firma.equals(buscarM)) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            busqueda();
                                            return;
                                        }
                                        busqueda();
                                        return;
                                    }
                                    break;
                                }
                                case "2": {
                                    input.nextLine();
                                    System.out.print("Ingrese la firma del inversionista a buscar: ");
                                    String buscarNombre = input.nextLine();
                                    String nombreMinuscula = buscarNombre.toLowerCase();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : inversionistas) {
                                        String minusculas = inversionista.firma.toLowerCase();
                                        if (minusculas.equals(nombreMinuscula)) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentra el inversionista");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                String minusculas = inversionista.firma.toLowerCase();
                                                if (minusculas.equals(nombreMinuscula)) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")) {
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")) {
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista(firma, imultinacional, isede, ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                String minusculas = inversionista.firma.toLowerCase();
                                                if (minusculas.equals(nombreMinuscula)) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    break;
                                }
                            }
                            busqueda();
                            return;
                        }
                    }
                    case "2": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorGIN());
                            }
                            else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorGIN().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de ganancia de inversionista : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : inversionistas) {
                                        if (inversionista.ganancias == buscarTotal) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentra el inversionista");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.ganancias == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.ganancias == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de ganancia maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.ganancias <= ValorMaximo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de ganancia minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.ganancias >= ValorMinimo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.ganancias <= Max && inversionista.ganancias >= Min) {
                                            System.out.println(index + " " + inversionista);
                                        } else {
                                            count++;
                                        }
                                        if (count == inversionistas.size()) {
                                            System.out.println("No se encuentran inversionistas");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias <= Max && inversionista.ganancias >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.ganancias <= Max && inversionista.ganancias >= Min) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "3": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorINsede());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorINsede().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de inversion : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : inversionistas) {
                                        if (inversionista.inversionSede == buscarTotal) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentra el inversionista");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.inversionSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.inversionSede == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de inversion maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionSede <= ValorMaximo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de inversion minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionSede >= ValorMinimo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionSede <= Max && inversionista.inversionSede >= Min) {
                                            System.out.println(index + " " + inversionista);
                                        } else {
                                            count++;
                                        }
                                        if (count == inversionistas.size()) {
                                            System.out.println("No se encuentran inversionistas");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede <= Max && inversionista.inversionSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionSede <= Max && inversionista.inversionSede >= Min) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "4": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorINmulti());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorINmulti().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de inversion : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : inversionistas) {
                                        if (inversionista.inversionMN == buscarTotal) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentra el inversionista");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.inversionMN == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                        else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : inversionistas) {
                                                if (inversionista.inversionMN == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de inversion maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionMN <= ValorMaximo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de inversion minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionMN >= ValorMinimo) {
                                            System.out.println(index + " " + inversionista);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == inversionistas.size()) {
                                                System.out.println("No se encuentran inversionistas");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Inversionista inversionista : repuesto) {
                                        if (inversionista.inversionMN <= Max && inversionista.inversionMN >= Min) {
                                            System.out.println(index + " " + inversionista);
                                        } else {
                                            count++;
                                        }
                                        if (count == inversionistas.size()) {
                                            System.out.println("No se encuentran inversionistas");
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN <= Max && inversionista.inversionMN >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Firma: " + inversionista.firma);
                                                        System.out.print("Ingrese nueva firma: ");
                                                        input.nextLine();
                                                        String firma = input.nextLine();
                                                        if (firma.equals("")) {
                                                            firma = inversionista.firma;
                                                        }
                                                        System.out.println("Ganancias: " + inversionista.ganancias);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = inversionista.ganancias;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iSede = input.nextLine();
                                                        int isede = 0;
                                                        if (iSede.equals("")){
                                                            isede = inversionista.inversionSede;
                                                        } else {
                                                            isede = Integer.parseInt(iSede);
                                                        }
                                                        System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String iMultinacional = input.nextLine();
                                                        int imultinacional = 0;
                                                        if (iMultinacional.equals("")){
                                                            imultinacional = inversionista.inversionMN;
                                                        } else {
                                                            imultinacional = Integer.parseInt(iMultinacional);
                                                        }
                                                        Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                        inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                        System.out.println("Inversionista editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Inversionista inversionista : repuesto) {
                                                if (inversionista.inversionMN <= Max && inversionista.inversionMN >= Min) {
                                                    if (index2 == iBuscar) {
                                                        inversionistas.remove(inversionista);
                                                        System.out.println("Inversionista eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0") || option4.equals("2")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "5": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja un atributo para ordenar:");
                            System.out.println("1. Ganancias");
                            System.out.println("2. Inversion en sede");
                            System.out.println("3. Inversion en multinacional");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                int index = 1;
                                repuesto.sort(new ComparadorGIN());
                                for (Inversionista inversionista : repuesto) {
                                    System.out.println(index + " " + inversionista);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Firma: " + inversionista.firma);
                                                    System.out.print("Ingrese nueva firma: ");
                                                    input.nextLine();
                                                    String firma = input.nextLine();
                                                    if (firma.equals("")) {
                                                        firma = inversionista.firma;
                                                    }
                                                    System.out.println("Ganancias: " + inversionista.ganancias);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = inversionista.ganancias;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iSede = input.nextLine();
                                                    int isede = 0;
                                                    if (iSede.equals("")){
                                                        isede = inversionista.inversionSede;
                                                    } else {
                                                        isede = Integer.parseInt(iSede);
                                                    }
                                                    System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iMultinacional = input.nextLine();
                                                    int imultinacional = 0;
                                                    if (iMultinacional.equals("")){
                                                        imultinacional = inversionista.inversionMN;
                                                    } else {
                                                        imultinacional = Integer.parseInt(iMultinacional);
                                                    }
                                                    Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                    inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                    System.out.println("Inversionista editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    inversionistas.remove(inversionista);
                                                    System.out.println("Inversionista eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("0") || option4.equals("2")) {
                                        repuesto.removeAll(inversionistas);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            else if (option3.equals("2")) {
                                int index = 1;
                                repuesto.sort(new ComparadorINsede());
                                for (Inversionista inversionista : repuesto) {
                                    System.out.println(index + " " + inversionista);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Firma: " + inversionista.firma);
                                                    System.out.print("Ingrese nueva firma: ");
                                                    input.nextLine();
                                                    String firma = input.nextLine();
                                                    if (firma.equals("")) {
                                                        firma = inversionista.firma;
                                                    }
                                                    System.out.println("Ganancias: " + inversionista.ganancias);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = inversionista.ganancias;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iSede = input.nextLine();
                                                    int isede = 0;
                                                    if (iSede.equals("")){
                                                        isede = inversionista.inversionSede;
                                                    } else {
                                                        isede = Integer.parseInt(iSede);
                                                    }
                                                    System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iMultinacional = input.nextLine();
                                                    int imultinacional = 0;
                                                    if (iMultinacional.equals("")){
                                                        imultinacional = inversionista.inversionMN;
                                                    } else {
                                                        imultinacional = Integer.parseInt(iMultinacional);
                                                    }
                                                    Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                    inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                    System.out.println("Inversionista editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    inversionistas.remove(inversionista);
                                                    System.out.println("Inversionista eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(inversionistas);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            else if (option3.equals("3")) {
                                int index = 1;
                                repuesto.sort(new ComparadorINmulti());
                                for (Inversionista inversionista : repuesto) {
                                    System.out.println(index + " " + inversionista);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Firma: " + inversionista.firma);
                                                    System.out.print("Ingrese nueva firma: ");
                                                    input.nextLine();
                                                    String firma = input.nextLine();
                                                    if (firma.equals("")) {
                                                        firma = inversionista.firma;
                                                    }
                                                    System.out.println("Ganancias: " + inversionista.ganancias);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = inversionista.ganancias;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Inversion sede: " + inversionista.inversionSede);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iSede = input.nextLine();
                                                    int isede = 0;
                                                    if (iSede.equals("")){
                                                        isede = inversionista.inversionSede;
                                                    } else {
                                                        isede = Integer.parseInt(iSede);
                                                    }
                                                    System.out.println("Inversion multinacional: " + inversionista.inversionMN);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String iMultinacional = input.nextLine();
                                                    int imultinacional = 0;
                                                    if (iMultinacional.equals("")){
                                                        imultinacional = inversionista.inversionMN;
                                                    } else {
                                                        imultinacional = Integer.parseInt(iMultinacional);
                                                    }
                                                    Inversionista inverAux = new Inversionista (firma,imultinacional,isede,ganancia);
                                                    inversionistas.set(inversionistas.indexOf(inversionista), inverAux);
                                                    System.out.println("Inversionista editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Inversionista inversionista : repuesto) {
                                                if (index2 == iBuscar) {
                                                    inversionistas.remove(inversionista);
                                                    System.out.println("Inversionista eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(inversionistas);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            repuesto.removeAll(inversionistas);
                            busqueda();
                            return;
                        }
                    }
                }
            }
        }
    }
    private static void buscarAreas(){
        if (areas.size() == 0) {
            System.out.println("No hay areas registradas");
            busqueda();
        } else {
            LinkedList<Area> repuesto = new LinkedList<>();
            for (Area area : areas) {
                repuesto.add(area);
            }
            String option2;
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Tipo de area");
                System.out.println("2. Ingreso de area");
                System.out.println("3. Gasto de area");
                System.out.println("4. Areas totales");
                option2 = input.next();
                switch (option2) {
                    case "1": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el tipo de area a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Area area : areas) {
                                    if (area.nombreDelArea.equals(buscarM)) {
                                        System.out.println(index + " " + area);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == areas.size()) {
                                            System.out.println("No se encuentra el area");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Area area : areas) {
                                            if (area.nombreDelArea.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Tipo de area: " + area.nombreDelArea);
                                                    System.out.print("Ingrese nuevo area: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = area.nombreDelArea;
                                                    }
                                                    System.out.println("Fondos: " + area.ingresoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = area.ingresoArea;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Gasto: " + area.gastoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")){
                                                        gasto = area.gastoArea;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                    areas.set(areas.indexOf(area), areaAux);
                                                    System.out.println("Area editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Area area : areas) {
                                            if (area.nombreDelArea.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    areas.remove(area);
                                                    System.out.println("Area eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                            else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el tipo de area a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Area area : areas) {
                                    String minusculas = area.nombreDelArea.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + area);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == areas.size()) {
                                            System.out.println("No se encuentra el area");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Area area : areas) {
                                            String minusculas = area.nombreDelArea.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Tipo de area: " + area.nombreDelArea);
                                                    System.out.print("Ingrese nuevo area: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = area.nombreDelArea;
                                                    }
                                                    System.out.println("Fondos: " + area.ingresoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = area.ingresoArea;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Gasto: " + area.gastoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")){
                                                        gasto = area.gastoArea;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                    areas.set(areas.indexOf(area), areaAux);
                                                    System.out.println("Area editada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Area area : areas) {
                                            String minusculas = area.nombreDelArea.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    areas.remove(area);
                                                    System.out.println("Area eliminada con exito");
                                                    busqueda();
                                                    return;
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                } else if (option4.equals("2")) {
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "2": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorIarea());
                            }
                            else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorIarea().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de de ingresos de area : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : areas) {
                                        if (area.ingresoArea == buscarTotal) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : areas) {
                                                if (area.ingresoArea == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                        else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : areas) {
                                                if (area.ingresoArea == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de ingresos maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : repuesto) {
                                        if (area.ingresoArea <= ValorMaximo) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.ingresoArea <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.ingresoArea <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de ingresos minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : repuesto) {
                                        if (area.ingresoArea >= ValorMinimo) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                busqueda();
                                            }
                                        }
                                    }
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Area area : repuesto) {
                                        if (area.ingresoArea <= Max && area.ingresoArea >= Min) {
                                            System.out.println(index + " " + area);
                                        } else {
                                            count++;
                                        }
                                        if (count == areas.size()) {
                                            System.out.println("No se encuentran areas");
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                }
                            }
                        }
                    }
                    case "3": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorGarea());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorGarea().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de gasto : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : areas) {
                                        if (area.gastoArea == buscarTotal) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                repuesto.removeAll(areas);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : areas) {
                                                if (area.gastoArea == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : areas) {
                                                if (area.gastoArea == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            busqueda();
                                            return;
                                        }
                                    }
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de gastos maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : repuesto) {
                                        if (area.gastoArea <= ValorMaximo) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(areas);
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de gastos minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Area area : repuesto) {
                                        if (area.gastoArea >= ValorMinimo) {
                                            System.out.println(index + " " + area);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == areas.size()) {
                                                System.out.println("No se encuentra el area");
                                                repuesto.removeAll(areas);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(areas);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(areas);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Area area : repuesto) {
                                        if (area.gastoArea <= Max && area.gastoArea >= Min) {
                                            System.out.println(index + " " + area);
                                        } else {
                                            count++;
                                        }
                                        if (count == areas.size()) {
                                            System.out.println("No se encuentran areas");
                                            repuesto.removeAll(areas);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea <= Max && area.gastoArea >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Tipo de area: " + area.nombreDelArea);
                                                        System.out.print("Ingrese nuevo area: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = area.nombreDelArea;
                                                        }
                                                        System.out.println("Fondos: " + area.ingresoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Ganancia = input.nextLine();
                                                        int ganancia = 0;
                                                        if (Ganancia.equals("")) {
                                                            ganancia = area.ingresoArea;
                                                        } else {
                                                            ganancia = Integer.parseInt(Ganancia);
                                                        }
                                                        System.out.println("Gasto: " + area.gastoArea);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Gasto = input.nextLine();
                                                        int gasto = 0;
                                                        if (Gasto.equals("")){
                                                            gasto = area.gastoArea;
                                                        } else {
                                                            gasto = Integer.parseInt(Gasto);
                                                        }
                                                        Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                        areas.set(areas.indexOf(area), areaAux);
                                                        System.out.println("Area editada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Area area : repuesto) {
                                                if (area.gastoArea <= Max && area.gastoArea >= Min) {
                                                    if (index2 == iBuscar) {
                                                        areas.remove(area);
                                                        System.out.println("Area eliminada con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "4": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja un atributo a ordenar: ");
                            System.out.println("1. Ingreso de area");
                            System.out.println("2. Gasto de area");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                int index = 1;
                                repuesto.sort(new ComparadorIarea());
                                for (Area area : repuesto) {
                                    System.out.println(index + " " + area);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Area area : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Tipo de area: " + area.nombreDelArea);
                                                    System.out.print("Ingrese nuevo area: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = area.nombreDelArea;
                                                    }
                                                    System.out.println("Fondos: " + area.ingresoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = area.ingresoArea;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Gasto: " + area.gastoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")){
                                                        gasto = area.gastoArea;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                    areas.set(areas.indexOf(area), areaAux);
                                                    System.out.println("Area editada con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Area area : repuesto) {
                                                if (index2 == iBuscar) {
                                                    areas.remove(area);
                                                    System.out.println("Area eliminada con exito");
                                                } else {
                                                    index2++;
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            else if (option3.equals("2")) {
                                int index = 1;
                                repuesto.sort(new ComparadorGarea());
                                for (Area area : repuesto) {
                                    System.out.println(index + " " + area);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Area area : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Tipo de area: " + area.nombreDelArea);
                                                    System.out.print("Ingrese nuevo area: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = area.nombreDelArea;
                                                    }
                                                    System.out.println("Fondos: " + area.ingresoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Ganancia = input.nextLine();
                                                    int ganancia = 0;
                                                    if (Ganancia.equals("")) {
                                                        ganancia = area.ingresoArea;
                                                    } else {
                                                        ganancia = Integer.parseInt(Ganancia);
                                                    }
                                                    System.out.println("Gasto: " + area.gastoArea);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Gasto = input.nextLine();
                                                    int gasto = 0;
                                                    if (Gasto.equals("")){
                                                        gasto = area.gastoArea;
                                                    } else {
                                                        gasto = Integer.parseInt(Gasto);
                                                    }
                                                    Area areaAux = new Area (nombre,ganancia,gasto, area.sede);
                                                    areas.set(areas.indexOf(area), areaAux);
                                                    System.out.println("Area editada con exito");
                                                } else {
                                                    index2++;
                                                }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Area area : repuesto) {
                                                if (index2 == iBuscar) {
                                                    areas.remove(area);
                                                    System.out.println("Area eliminada con exito");
                                                } else {
                                                    index2++;
                                                }
                                        }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                            repuesto.removeAll(repuesto);
                            busqueda();
                            return;
                        }
                    }
                }
            }
        }
    }
    private static void buscarEmpleados(){
        if (empleados.size() == 0) {
            System.out.println("No hay empleados registradas");
        } else {
            LinkedList<Empleado> repuesto = new LinkedList<>();
            for (Empleado empleado:empleados) {
                repuesto.add(empleado);
            }
            String option2;
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Nombre");
                System.out.println("2. Cedula");
                System.out.println("3. Edad");
                System.out.println("4. Salario");
                System.out.println("5. Empleados totales");
                option2 = input.next();
                switch (option2) {
                    case "1": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Empleado empleado : empleados) {
                                    if (empleado.nombre.equals(buscarM)) {
                                        System.out.println(index + " " + empleado);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentra el empleado");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Empleado empleado : empleados) {
                                            if (empleado.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + empleado.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = empleado.nombre;
                                                    }
                                                    System.out.println("Cedula: " + empleado.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")) {
                                                        cedula = empleado.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    System.out.println("Edad: " + empleado.edad);
                                                    System.out.print("Ingrese nueva edad: ");
                                                    String Edad = input.nextLine();
                                                    int edad;
                                                    if (Edad.equals("")){
                                                        edad = empleado.edad;
                                                    } else {
                                                        edad = Integer.parseInt(Edad);
                                                    }
                                                    System.out.println("Salario: " + empleado.salario);
                                                    System.out.print("Ingrese nuevo salario: ");
                                                    String Salario = input.nextLine();
                                                    int salario;
                                                    if (Salario.equals("")){
                                                        salario = empleado.salario;
                                                    } else {
                                                        salario = Integer.parseInt(Salario);
                                                    }
                                                    Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                    empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                    System.out.println("Empleado editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Empleado empleado : empleados) {
                                            if (empleado.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    empleados.remove(empleado);
                                                    System.out.println("Empleado eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        busqueda();
                                        return;
                                    }
                                }
                                busqueda();
                                return;
                            }
                            else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Empleado empleado : empleados) {
                                    String minusculas = empleado.nombre.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + empleado);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentra el empleado");
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Empleado empleado : empleados) {
                                            String minusculas = empleado.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + empleado.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = empleado.nombre;
                                                    }
                                                    System.out.println("Cedula: " + empleado.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")) {
                                                        cedula = empleado.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    System.out.println("Edad: " + empleado.edad);
                                                    System.out.print("Ingrese nueva edad: ");
                                                    String Edad = input.nextLine();
                                                    int edad;
                                                    if (Edad.equals("")){
                                                        edad = empleado.edad;
                                                    } else {
                                                        edad = Integer.parseInt(Edad);
                                                    }
                                                    System.out.println("Salario: " + empleado.salario);
                                                    System.out.print("Ingrese nuevo salario: ");
                                                    String Salario = input.nextLine();
                                                    int salario;
                                                    if (Salario.equals("")){
                                                        salario = empleado.salario;
                                                    } else {
                                                        salario = Integer.parseInt(Salario);
                                                    }
                                                    Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                    empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                    System.out.println("Empleado editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Empleado empleado : empleados) {
                                            String minusculas = empleado.nombre.toLowerCase();
                                            if (minusculas.equals(buscarNombre)) {
                                                if (index2 == iBuscar) {
                                                    empleados.remove(empleado);
                                                    System.out.println("Empleado eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("0")) {
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                                repuesto.removeAll(repuesto);
                                busqueda();
                                return;
                            }
                        }
                    }
                    case "2": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorEcedula());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorEcedula().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese la cedula del empleado a buscar : ");
                                    int buscarTotal = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : empleados) {
                                        if (empleado.cedula == buscarTotal) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.cedula == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.cedula == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese la cedula maxima a buscar: ");
                                    int ValorMaximo = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.cedula <= ValorMaximo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese la cedula minima a buscar: ");
                                    int ValorMinimo = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.cedula >= ValorMinimo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("0")) {
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.cedula <= Max && empleado.cedula >= Min) {
                                            System.out.println(index + " " + empleado);
                                        } else {
                                            count++;
                                        }
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentran empleados");
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula <= Max && empleado.cedula >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.cedula <= Max && empleado.cedula >= Min) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "3": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorEedad());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorEedad().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese la edad del empleado a buscar : ");
                                    int buscarTotal = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : empleados) {
                                        if (empleado.edad == buscarTotal) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.edad == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.edad == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese la edad maxima a buscar: ");
                                    int ValorMaximo = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.edad <= ValorMaximo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese la edad minima a buscar: ");
                                    int ValorMinimo = input.nextInt();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.edad >= ValorMinimo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.edad <= Max && empleado.edad >= Min) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                        }
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentran empleados");
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad <= Max && empleado.edad >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.edad <= Max && empleado.edad >= Min) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "4": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorEsalario());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorEsalario().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el salario : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : empleados) {
                                        if (empleado.salario == buscarTotal) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.salario == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : empleados) {
                                                if (empleado.salario == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el salario maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.salario <= ValorMaximo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.salario <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.salario <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el salario minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.salario >= ValorMinimo) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentra el empleado");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.salario >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + empleado.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = empleado.nombre;
                                                        }
                                                        System.out.println("Cedula: " + empleado.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = empleado.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        System.out.println("Edad: " + empleado.edad);
                                                        System.out.print("Ingrese nueva edad: ");
                                                        String Edad = input.nextLine();
                                                        int edad;
                                                        if (Edad.equals("")){
                                                            edad = empleado.edad;
                                                        } else {
                                                            edad = Integer.parseInt(Edad);
                                                        }
                                                        System.out.println("Salario: " + empleado.salario);
                                                        System.out.print("Ingrese nuevo salario: ");
                                                        String Salario = input.nextLine();
                                                        int salario;
                                                        if (Salario.equals("")){
                                                            salario = empleado.salario;
                                                        } else {
                                                            salario = Integer.parseInt(Salario);
                                                        }
                                                        Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                        empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                        System.out.println("Empleado editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Empleado empleado : repuesto) {
                                                if (empleado.salario >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        empleados.remove(empleado);
                                                        System.out.println("Empleado eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Empleado empleado : repuesto) {
                                        if (empleado.salario <= Max && empleado.salario >= Min) {
                                            System.out.println(index + " " + empleado);
                                            index++;
                                        } else {
                                            count++;
                                        }
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentran empleados");
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "5": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja un atributo a ordenar: ");
                            System.out.println("1. Cedula");
                            System.out.println("2. Edad");
                            System.out.println("3. Salario");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                int index = 1;
                                repuesto.sort(new ComparadorEcedula());
                                for (Empleado empleado : repuesto) {
                                    System.out.println(index + " " + empleado);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + empleado.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = empleado.nombre;
                                                    }
                                                    System.out.println("Cedula: " + empleado.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")) {
                                                        cedula = empleado.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    System.out.println("Edad: " + empleado.edad);
                                                    System.out.print("Ingrese nueva edad: ");
                                                    String Edad = input.nextLine();
                                                    int edad;
                                                    if (Edad.equals("")){
                                                        edad = empleado.edad;
                                                    } else {
                                                        edad = Integer.parseInt(Edad);
                                                    }
                                                    System.out.println("Salario: " + empleado.salario);
                                                    System.out.print("Ingrese nuevo salario: ");
                                                    String Salario = input.nextLine();
                                                    int salario;
                                                    if (Salario.equals("")){
                                                        salario = empleado.salario;
                                                    } else {
                                                        salario = Integer.parseInt(Salario);
                                                    }
                                                    Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                    empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                    System.out.println("Empleado editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    empleados.remove(empleado);
                                                    System.out.println("Empleado eliminado con exito");
                                                } else {
                                                    index2++;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (option3.equals("2")) {
                                int index = 1;
                                repuesto.sort(new ComparadorEedad());
                                for (Empleado empleado : repuesto) {
                                    System.out.println(index + " " + empleado);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + empleado.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = empleado.nombre;
                                                    }
                                                    System.out.println("Cedula: " + empleado.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")) {
                                                        cedula = empleado.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    System.out.println("Edad: " + empleado.edad);
                                                    System.out.print("Ingrese nueva edad: ");
                                                    String Edad = input.nextLine();
                                                    int edad;
                                                    if (Edad.equals("")){
                                                        edad = empleado.edad;
                                                    } else {
                                                        edad = Integer.parseInt(Edad);
                                                    }
                                                    System.out.println("Salario: " + empleado.salario);
                                                    System.out.print("Ingrese nuevo salario: ");
                                                    String Salario = input.nextLine();
                                                    int salario;
                                                    if (Salario.equals("")){
                                                        salario = empleado.salario;
                                                    } else {
                                                        salario = Integer.parseInt(Salario);
                                                    }
                                                    Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                    empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                    System.out.println("Empleado editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    empleados.remove(empleado);
                                                    System.out.println("Empleado eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            else if (option3.equals("3")) {
                                int index = 1;
                                repuesto.sort(new ComparadorEsalario());
                                for (Empleado empleado : repuesto) {
                                    System.out.println(index + " " + empleado);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + empleado.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = empleado.nombre;
                                                    }
                                                    System.out.println("Cedula: " + empleado.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")) {
                                                        cedula = empleado.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    System.out.println("Edad: " + empleado.edad);
                                                    System.out.print("Ingrese nueva edad: ");
                                                    String Edad = input.nextLine();
                                                    int edad;
                                                    if (Edad.equals("")){
                                                        edad = empleado.edad;
                                                    } else {
                                                        edad = Integer.parseInt(Edad);
                                                    }
                                                    System.out.println("Salario: " + empleado.salario);
                                                    System.out.print("Ingrese nuevo salario: ");
                                                    String Salario = input.nextLine();
                                                    int salario;
                                                    if (Salario.equals("")){
                                                        salario = empleado.salario;
                                                    } else {
                                                        salario = Integer.parseInt(Salario);
                                                    }
                                                    Empleado empleadoAux = new Empleado (nombre,cedula,edad,salario,empleado.areaPertenece);
                                                    empleados.set(empleados.indexOf(empleado), empleadoAux);
                                                    System.out.println("Empleado editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Empleado empleado : repuesto) {
                                                if (index2 == iBuscar) {
                                                    empleados.remove(empleado);
                                                    System.out.println("Empleado eliminado con exito");
                                                } else {
                                                    index2++;
                                            }
                                        }
                                    }
                                }
                            }
                            repuesto.removeAll(repuesto);
                            busqueda();
                            return;
                        }
                    }
                }
            }
        }
    }
    private static void buscarClientes(){
        if (clientes.size() == 0) {
            System.out.println("No hay clientes registrados");
        } else {
            LinkedList<Cliente> repuesto = new LinkedList<>();
            for (Cliente cliente:clientes) {
                repuesto.add(cliente);
            }
            String option2;
            while (true) {
                System.out.println("Escoja un atributo de busqueda:");
                System.out.println("1. Nombre");
                System.out.println("2. Dinero");
                System.out.println("3. Cedula");
                System.out.println("4. Clientes totales");
                option2 = input.next();
                switch (option2) {
                    case "1": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja una opcion:");
                            System.out.println("1. Valor exacto");
                            System.out.println("2. Valor sin considerar las mayusculas");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre a buscar: ");
                                String buscarM = input.nextLine();
                                int count = 0;
                                int index = 1;
                                for (Cliente cliente : clientes) {
                                    if (cliente.nombre.equals(buscarM)) {
                                        System.out.println(index + " " + cliente);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == clientes.size()) {
                                            System.out.println("No se encuentra el cliente");
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Cliente cliente : clientes) {
                                            if (cliente.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + cliente.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = cliente.nombre;
                                                    }
                                                    System.out.println("Dinero: " + cliente.dinero);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Dinero = input.nextLine();
                                                    int dinero;
                                                    if (Dinero.equals("")) {
                                                        dinero = cliente.dinero;
                                                    } else {
                                                        dinero = Integer.parseInt(Dinero);
                                                    }
                                                    System.out.println("Cedula: " + cliente.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")){
                                                        cedula = cliente.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                    clientes.set(clientes.indexOf(cliente), clienteAux);
                                                    System.out.println("Cliente editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Cliente cliente : clientes) {
                                            if (cliente.nombre.equals(buscarM)) {
                                                if (index2 == iBuscar) {
                                                    clientes.remove(cliente);
                                                    System.out.println("Cliente eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    }
                                }
                                repuesto.removeAll(repuesto);
                                busqueda();
                                return;
                            }
                            else if (option3.equals("2")) {
                                input.nextLine();
                                System.out.print("Ingrese el nombre a buscar: ");
                                String buscarNombre = input.nextLine();
                                String nombreMinuscula = buscarNombre.toLowerCase();
                                int count = 0;
                                int index = 1;
                                for (Cliente cliente : clientes) {
                                    String minusculas = cliente.nombre.toLowerCase();
                                    if (minusculas.equals(nombreMinuscula)) {
                                        System.out.println(index + " " + cliente);
                                        index++;
                                    } else {
                                        count++;
                                        if (count == clientes.size()) {
                                            System.out.println("No se encuentra el cliente");
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Cliente cliente : clientes) {
                                            String minusculas = cliente.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + cliente.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = cliente.nombre;
                                                    }
                                                    System.out.println("Dinero: " + cliente.dinero);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Dinero = input.nextLine();
                                                    int dinero;
                                                    if (Dinero.equals("")) {
                                                        dinero = cliente.dinero;
                                                    } else {
                                                        dinero = Integer.parseInt(Dinero);
                                                    }
                                                    System.out.println("Cedula: " + cliente.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")){
                                                        cedula = cliente.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                    clientes.set(clientes.indexOf(cliente), clienteAux);
                                                    System.out.println("Cliente editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Cliente cliente : clientes) {
                                            String minusculas = cliente.nombre.toLowerCase();
                                            if (minusculas.equals(nombreMinuscula)) {
                                                if (index2 == iBuscar) {
                                                    clientes.remove(cliente);
                                                    System.out.println("Cliente eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    }
                                }
                                repuesto.removeAll(repuesto);
                                busqueda();
                                return;
                            }
                        }
                    }
                    case "2": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorCdinero());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorCdinero().reversed());
                            }
                            String option3;
                            while (true) {
                                System.out.println("Escoja una opcion:");
                                System.out.println("1. Valor exacto");
                                System.out.println("2. Valor maximo");
                                System.out.println("3. Valor minimo");
                                System.out.println("4. Rango");
                                option3 = input.next();
                                if (option3.equals("1")) {
                                    input.nextLine();
                                    System.out.print("Ingrese el valor de dinero a buscar : ");
                                    double buscarTotal = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Cliente cliente : clientes) {
                                        if (cliente.dinero == buscarTotal) {
                                            System.out.println(index + " " + cliente);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == clientes.size()) {
                                                System.out.println("No se encuentra el cliente");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Cliente cliente : clientes) {
                                                if (cliente.dinero == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + cliente.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = cliente.nombre;
                                                        }
                                                        System.out.println("Dinero: " + cliente.dinero);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Dinero = input.nextLine();
                                                        int dinero;
                                                        if (Dinero.equals("")) {
                                                            dinero = cliente.dinero;
                                                        } else {
                                                            dinero = Integer.parseInt(Dinero);
                                                        }
                                                        System.out.println("Cedula: " + cliente.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = cliente.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        Cliente clienteAux = new Cliente(nombre, cedula, dinero, cliente.AreaConsumo);
                                                        clientes.set(clientes.indexOf(cliente), clienteAux);
                                                        System.out.println("Cliente editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Cliente cliente : clientes) {
                                                if (cliente.dinero == buscarTotal) {
                                                    if (index2 == iBuscar) {
                                                        clientes.remove(cliente);
                                                        System.out.println("Cliente eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("2")) {
                                    System.out.print("Ingrese el valor de dinero maximo a buscar: ");
                                    double ValorMaximo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Cliente cliente : repuesto) {
                                        if (cliente.dinero <= ValorMaximo) {
                                            System.out.println(index + " " + cliente);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == clientes.size()) {
                                                System.out.println("No se encuentra el cliente");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + cliente.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = cliente.nombre;
                                                        }
                                                        System.out.println("Dinero: " + cliente.dinero);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Dinero = input.nextLine();
                                                        int dinero;
                                                        if (Dinero.equals("")) {
                                                            dinero = cliente.dinero;
                                                        } else {
                                                            dinero = Integer.parseInt(Dinero);
                                                        }
                                                        System.out.println("Cedula: " + cliente.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = cliente.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        Cliente clienteAux = new Cliente(nombre, cedula, dinero, cliente.AreaConsumo);
                                                        clientes.set(clientes.indexOf(cliente), clienteAux);
                                                        System.out.println("Cliente editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero <= ValorMaximo) {
                                                    if (index2 == iBuscar) {
                                                        clientes.remove(cliente);
                                                        System.out.println("Cliente eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("3")) {
                                    System.out.print("Ingrese el valor de dinero minimo a buscar: ");
                                    double ValorMinimo = input.nextDouble();
                                    int count = 0;
                                    int index = 1;
                                    for (Cliente cliente : repuesto) {
                                        if (cliente.dinero >= ValorMinimo) {
                                            System.out.println(index + " " + cliente);
                                            index++;
                                        } else {
                                            count++;
                                            if (count == clientes.size()) {
                                                System.out.println("No se encuentra el cliente");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + cliente.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = cliente.nombre;
                                                        }
                                                        System.out.println("Dinero: " + cliente.dinero);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Dinero = input.nextLine();
                                                        int dinero;
                                                        if (Dinero.equals("")) {
                                                            dinero = cliente.dinero;
                                                        } else {
                                                            dinero = Integer.parseInt(Dinero);
                                                        }
                                                        System.out.println("Cedula: " + cliente.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = cliente.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        Cliente clienteAux = new Cliente(nombre, cedula, dinero, cliente.AreaConsumo);
                                                        clientes.set(clientes.indexOf(cliente), clienteAux);
                                                        System.out.println("Cliente editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero >= ValorMinimo) {
                                                    if (index2 == iBuscar) {
                                                        clientes.remove(cliente);
                                                        System.out.println("Cliente eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                                if (option3.equals("4")) {
                                    System.out.print("Ingrese valor minimo del rango: ");
                                    int Min = input.nextInt();
                                    System.out.println("Ingrese valor maximo del rango: ");
                                    int Max = input.nextInt();
                                    int index = 1;
                                    int count = 0;
                                    for (Cliente cliente : repuesto) {
                                        if (cliente.dinero <= Max && cliente.dinero >= Min) {
                                            System.out.println(index + " " + cliente);
                                            index++;
                                        } else {
                                            count++;
                                        }
                                        if (count == empleados.size()) {
                                            System.out.println("No se encuentran empleados");
                                            repuesto.removeAll(repuesto);
                                            busqueda();
                                            return;
                                        }
                                    }
                                    System.out.println("Desea editar o eliminar algun elemento? :");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    String option4 = input.next();
                                    if (option4.equals("1")) {
                                        System.out.print("Ingrese el numero indice del objeto: ");
                                        int iBuscar = input.nextInt();
                                        System.out.println("¿Desea editar o eliminar el objeto?: ");
                                        System.out.println("1. Editar");
                                        System.out.println("2. Eliminar");
                                        System.out.println("0. Salir");
                                        String option5 = input.next();
                                        if (option5.equals("1")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero <= Max && cliente.dinero >= Min) {
                                                    if (index2 == iBuscar) {
                                                        System.out.println("Nombre: " + cliente.nombre);
                                                        System.out.print("Ingrese nuevo nombre: ");
                                                        input.nextLine();
                                                        String nombre = input.nextLine();
                                                        if (nombre.equals("")) {
                                                            nombre = cliente.nombre;
                                                        }
                                                        System.out.println("Dinero: " + cliente.dinero);
                                                        System.out.print("Ingrese nuevo valor: ");
                                                        String Dinero = input.nextLine();
                                                        int dinero;
                                                        if (Dinero.equals("")) {
                                                            dinero = cliente.dinero;
                                                        } else {
                                                            dinero = Integer.parseInt(Dinero);
                                                        }
                                                        System.out.println("Cedula: " + cliente.cedula);
                                                        System.out.print("Ingrese nueva cedula: ");
                                                        String Cedula = input.nextLine();
                                                        int cedula;
                                                        if (Cedula.equals("")) {
                                                            cedula = cliente.cedula;
                                                        } else {
                                                            cedula = Integer.parseInt(Cedula);
                                                        }
                                                        Cliente clienteAux = new Cliente(nombre, cedula, dinero, cliente.AreaConsumo);
                                                        clientes.set(clientes.indexOf(cliente), clienteAux);
                                                        System.out.println("Cliente editado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        } else if (option5.equals("2")) {
                                            int index2 = 1;
                                            for (Cliente cliente : repuesto) {
                                                if (cliente.dinero <= Max && cliente.dinero >= Min) {
                                                    if (index2 == iBuscar) {
                                                        clientes.remove(cliente);
                                                        System.out.println("Cliente eliminado con exito");
                                                    } else {
                                                        index2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    repuesto.removeAll(repuesto);
                                    busqueda();
                                    return;
                                }
                            }
                        }
                    }
                    case "3": {
                        String orden;
                        while (true) {
                            System.out.println("¿De que manera desea organizar el resultado?");
                            System.out.println("1. Ascendente");
                            System.out.println("2. Descendente");
                            orden = input.next();
                            if (orden.equals("1")) {
                                repuesto.sort(new ComparadorCcedula());
                            } else if (orden.equals("2")) {
                                repuesto.sort(new ComparadorCcedula().reversed());
                                String option3;
                                while (true) {
                                    System.out.println("Escoja una opcion:");
                                    System.out.println("1. Valor exacto");
                                    System.out.println("2. Valor maximo");
                                    System.out.println("3. Valor minimo");
                                    System.out.println("4. Rango");
                                    option3 = input.next();
                                    if (option3.equals("1")) {
                                        input.nextLine();
                                        System.out.print("Ingrese la cedula a buscar : ");
                                        double buscarTotal = input.nextDouble();
                                        int count = 0;
                                        int index = 1;
                                        for (Cliente cliente : clientes) {
                                            if (cliente.cedula == buscarTotal) {
                                                System.out.println(index + " " + cliente);
                                                index++;
                                            } else {
                                                count++;
                                                if (count == clientes.size()) {
                                                    System.out.println("No se encuentra el cliente");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                }
                                            }
                                        }
                                        System.out.println("Desea editar o eliminar algun elemento? :");
                                        System.out.println("1. Si");
                                        System.out.println("2. No");
                                        String option4 = input.next();
                                        if (option4.equals("1")) {
                                            System.out.print("Ingrese el numero indice del objeto: ");
                                            int iBuscar = input.nextInt();
                                            System.out.println("¿Desea editar o eliminar el objeto?: ");
                                            System.out.println("1. Editar");
                                            System.out.println("2. Eliminar");
                                            System.out.println("0. Salir");
                                            String option5 = input.next();
                                            if (option5.equals("1")) {
                                                int index2 = 1;
                                                for (Cliente cliente : clientes) {
                                                    if (cliente.cedula == buscarTotal) {
                                                        if (index2 == iBuscar) {
                                                            System.out.println("Nombre: " + cliente.nombre);
                                                            System.out.print("Ingrese nuevo nombre: ");
                                                            input.nextLine();
                                                            String nombre = input.nextLine();
                                                            if (nombre.equals("")) {
                                                                nombre = cliente.nombre;
                                                            }
                                                            System.out.println("Dinero: " + cliente.dinero);
                                                            System.out.print("Ingrese nuevo valor: ");
                                                            String Dinero = input.nextLine();
                                                            int dinero;
                                                            if (Dinero.equals("")) {
                                                                dinero = cliente.dinero;
                                                            } else {
                                                                dinero = Integer.parseInt(Dinero);
                                                            }
                                                            System.out.println("Cedula: " + cliente.cedula);
                                                            System.out.print("Ingrese nueva cedula: ");
                                                            String Cedula = input.nextLine();
                                                            int cedula;
                                                            if (Cedula.equals("")){
                                                                cedula = cliente.cedula;
                                                            } else {
                                                                cedula = Integer.parseInt(Cedula);
                                                            }
                                                            Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                            clientes.set(clientes.indexOf(cliente), clienteAux);
                                                            System.out.println("Cliente editado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            } else if (option5.equals("2")) {
                                                int index2 = 1;
                                                for (Cliente cliente : clientes) {
                                                    if (cliente.cedula == buscarTotal) {
                                                        if (index2 == iBuscar) {
                                                            clientes.remove(cliente);
                                                            System.out.println("Cliente eliminado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                    if (option3.equals("2")) {
                                        System.out.print("Ingrese la cedula maxima a buscar: ");
                                        double ValorMaximo = input.nextDouble();
                                        int count = 0;
                                        int index = 1;
                                        for (Cliente cliente : repuesto) {
                                            if (cliente.cedula <= ValorMaximo) {
                                                System.out.println(index + " " + cliente);
                                                index++;
                                            } else {
                                                count++;
                                                if (count == clientes.size()) {
                                                    System.out.println("No se encuentra el cliente");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                }
                                            }
                                        }
                                        System.out.println("Desea editar o eliminar algun elemento? :");
                                        System.out.println("1. Si");
                                        System.out.println("2. No");
                                        String option4 = input.next();
                                        if (option4.equals("1")) {
                                            System.out.print("Ingrese el numero indice del objeto: ");
                                            int iBuscar = input.nextInt();
                                            System.out.println("¿Desea editar o eliminar el objeto?: ");
                                            System.out.println("1. Editar");
                                            System.out.println("2. Eliminar");
                                            System.out.println("0. Salir");
                                            String option5 = input.next();
                                            if (option5.equals("1")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.cedula <= ValorMaximo) {
                                                        if (index2 == iBuscar) {
                                                            System.out.println("Nombre: " + cliente.nombre);
                                                            System.out.print("Ingrese nuevo nombre: ");
                                                            input.nextLine();
                                                            String nombre = input.nextLine();
                                                            if (nombre.equals("")) {
                                                                nombre = cliente.nombre;
                                                            }
                                                            System.out.println("Dinero: " + cliente.dinero);
                                                            System.out.print("Ingrese nuevo valor: ");
                                                            String Dinero = input.nextLine();
                                                            int dinero;
                                                            if (Dinero.equals("")) {
                                                                dinero = cliente.dinero;
                                                            } else {
                                                                dinero = Integer.parseInt(Dinero);
                                                            }
                                                            System.out.println("Cedula: " + cliente.cedula);
                                                            System.out.print("Ingrese nueva cedula: ");
                                                            String Cedula = input.nextLine();
                                                            int cedula;
                                                            if (Cedula.equals("")){
                                                                cedula = cliente.cedula;
                                                            } else {
                                                                cedula = Integer.parseInt(Cedula);
                                                            }
                                                            Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                            clientes.set(clientes.indexOf(cliente), clienteAux);
                                                            System.out.println("Cliente editado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            } else if (option5.equals("2")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.cedula <= ValorMaximo) {
                                                        if (index2 == iBuscar) {
                                                            clientes.remove(cliente);
                                                            System.out.println("Cliente eliminado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                    if (option3.equals("3")) {
                                        System.out.print("Ingrese la cedula minima a buscar: ");
                                        double ValorMinimo = input.nextDouble();
                                        int count = 0;
                                        int index = 1;
                                        for (Cliente cliente : repuesto) {
                                            if (cliente.cedula >= ValorMinimo) {
                                                System.out.println(index + " " + cliente);
                                                index++;
                                            } else {
                                                count++;
                                                if (count == clientes.size()) {
                                                    System.out.println("No se encuentra el cliente");
                                                    repuesto.removeAll(repuesto);
                                                    busqueda();
                                                    return;
                                                }
                                            }
                                        }
                                        System.out.println("Desea editar o eliminar algun elemento? :");
                                        System.out.println("1. Si");
                                        System.out.println("2. No");
                                        String option4 = input.next();
                                        if (option4.equals("1")) {
                                            System.out.print("Ingrese el numero indice del objeto: ");
                                            int iBuscar = input.nextInt();
                                            System.out.println("¿Desea editar o eliminar el objeto?: ");
                                            System.out.println("1. Editar");
                                            System.out.println("2. Eliminar");
                                            System.out.println("0. Salir");
                                            String option5 = input.next();
                                            if (option5.equals("1")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.cedula >= ValorMinimo) {
                                                        if (index2 == iBuscar) {
                                                            System.out.println("Nombre: " + cliente.nombre);
                                                            System.out.print("Ingrese nuevo nombre: ");
                                                            input.nextLine();
                                                            String nombre = input.nextLine();
                                                            if (nombre.equals("")) {
                                                                nombre = cliente.nombre;
                                                            }
                                                            System.out.println("Dinero: " + cliente.dinero);
                                                            System.out.print("Ingrese nuevo valor: ");
                                                            String Dinero = input.nextLine();
                                                            int dinero;
                                                            if (Dinero.equals("")) {
                                                                dinero = cliente.dinero;
                                                            } else {
                                                                dinero = Integer.parseInt(Dinero);
                                                            }
                                                            System.out.println("Cedula: " + cliente.cedula);
                                                            System.out.print("Ingrese nueva cedula: ");
                                                            String Cedula = input.nextLine();
                                                            int cedula;
                                                            if (Cedula.equals("")){
                                                                cedula = cliente.cedula;
                                                            } else {
                                                                cedula = Integer.parseInt(Cedula);
                                                            }
                                                            Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                            clientes.set(clientes.indexOf(cliente), clienteAux);
                                                            System.out.println("Cliente editado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            } else if (option5.equals("2")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.cedula >= ValorMinimo) {
                                                        if (index2 == iBuscar) {
                                                            clientes.remove(cliente);
                                                            System.out.println("Cliente eliminado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                    if (option3.equals("4")) {
                                        System.out.print("Ingrese valor minimo del rango: ");
                                        int Min = input.nextInt();
                                        System.out.println("Ingrese valor maximo del rango: ");
                                        int Max = input.nextInt();
                                        int index = 1;
                                        int count = 0;
                                        for (Cliente cliente : repuesto) {
                                            if (cliente.cedula <= Max && cliente.cedula >= Min) {
                                                System.out.println(index + " " + cliente);
                                                index++;
                                            } else {
                                                count++;
                                            }
                                            if (count == empleados.size()) {
                                                System.out.println("No se encuentran empleados");
                                                repuesto.removeAll(repuesto);
                                                busqueda();
                                                return;
                                            }
                                        }
                                        System.out.println("Desea editar o eliminar algun elemento? :");
                                        System.out.println("1. Si");
                                        System.out.println("2. No");
                                        String option4 = input.next();
                                        if (option4.equals("1")) {
                                            System.out.print("Ingrese el numero indice del objeto: ");
                                            int iBuscar = input.nextInt();
                                            System.out.println("¿Desea editar o eliminar el objeto?: ");
                                            System.out.println("1. Editar");
                                            System.out.println("2. Eliminar");
                                            System.out.println("0. Salir");
                                            String option5 = input.next();
                                            if (option5.equals("1")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.dinero <= Max && cliente.dinero >= Min) {
                                                        if (index2 == iBuscar) {
                                                            System.out.println("Nombre: " + cliente.nombre);
                                                            System.out.print("Ingrese nuevo nombre: ");
                                                            input.nextLine();
                                                            String nombre = input.nextLine();
                                                            if (nombre.equals("")) {
                                                                nombre = cliente.nombre;
                                                            }
                                                            System.out.println("Dinero: " + cliente.dinero);
                                                            System.out.print("Ingrese nuevo valor: ");
                                                            String Dinero = input.nextLine();
                                                            int dinero;
                                                            if (Dinero.equals("")) {
                                                                dinero = cliente.dinero;
                                                            } else {
                                                                dinero = Integer.parseInt(Dinero);
                                                            }
                                                            System.out.println("Cedula: " + cliente.cedula);
                                                            System.out.print("Ingrese nueva cedula: ");
                                                            String Cedula = input.nextLine();
                                                            int cedula;
                                                            if (Cedula.equals("")){
                                                                cedula = cliente.cedula;
                                                            } else {
                                                                cedula = Integer.parseInt(Cedula);
                                                            }
                                                            Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                            clientes.set(clientes.indexOf(cliente), clienteAux);
                                                            System.out.println("Cliente editado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            } else if (option5.equals("2")) {
                                                int index2 = 1;
                                                for (Cliente cliente : repuesto) {
                                                    if (cliente.cedula <= Max && cliente.cedula >= Min) {
                                                        if (index2 == iBuscar) {
                                                            clientes.remove(cliente);
                                                            System.out.println("Cliente eliminado con exito");
                                                        } else {
                                                            index2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        repuesto.removeAll(repuesto);
                                        busqueda();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    case "4": {
                        String option3;
                        while (true) {
                            System.out.println("Escoja un atributo a ordenar: ");
                            System.out.println("1. Dinero");
                            System.out.println("2. Cedula");
                            option3 = input.next();
                            if (option3.equals("1")) {
                                int index = 1;
                                repuesto.sort(new ComparadorCdinero());
                                for (Cliente cliente : repuesto) {
                                    System.out.println(index + " " + cliente);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Cliente cliente : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + cliente.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = cliente.nombre;
                                                    }
                                                    System.out.println("Dinero: " + cliente.dinero);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Dinero = input.nextLine();
                                                    int dinero;
                                                    if (Dinero.equals("")) {
                                                        dinero = cliente.dinero;
                                                    } else {
                                                        dinero = Integer.parseInt(Dinero);
                                                    }
                                                    System.out.println("Cedula: " + cliente.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")){
                                                        cedula = cliente.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                    clientes.set(clientes.indexOf(cliente), clienteAux);
                                                    System.out.println("Cliente editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Cliente cliente : repuesto) {
                                                if (index2 == iBuscar) {
                                                    clientes.remove(cliente);
                                                    System.out.println("Cliente eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    }
                            }
                            else if (option3.equals("2")) {
                                int index = 1;
                                repuesto.sort(new ComparadorCcedula());
                                for (Cliente cliente : repuesto) {
                                    System.out.println(index + " " + cliente);
                                    index++;
                                }
                                System.out.println("Desea editar o eliminar algun elemento? :");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                String option4 = input.next();
                                if (option4.equals("1")) {
                                    System.out.print("Ingrese el numero indice del objeto: ");
                                    int iBuscar = input.nextInt();
                                    System.out.println("¿Desea editar o eliminar el objeto?: ");
                                    System.out.println("1. Editar");
                                    System.out.println("2. Eliminar");
                                    System.out.println("0. Salir");
                                    String option5 = input.next();
                                    if (option5.equals("1")) {
                                        int index2 = 1;
                                        for (Cliente cliente : repuesto) {
                                                if (index2 == iBuscar) {
                                                    System.out.println("Nombre: " + cliente.nombre);
                                                    System.out.print("Ingrese nuevo nombre: ");
                                                    input.nextLine();
                                                    String nombre = input.nextLine();
                                                    if (nombre.equals("")) {
                                                        nombre = cliente.nombre;
                                                    }
                                                    System.out.println("Dinero: " + cliente.dinero);
                                                    System.out.print("Ingrese nuevo valor: ");
                                                    String Dinero = input.nextLine();
                                                    int dinero;
                                                    if (Dinero.equals("")) {
                                                        dinero = cliente.dinero;
                                                    } else {
                                                        dinero = Integer.parseInt(Dinero);
                                                    }
                                                    System.out.println("Cedula: " + cliente.cedula);
                                                    System.out.print("Ingrese nueva cedula: ");
                                                    String Cedula = input.nextLine();
                                                    int cedula;
                                                    if (Cedula.equals("")){
                                                        cedula = cliente.cedula;
                                                    } else {
                                                        cedula = Integer.parseInt(Cedula);
                                                    }
                                                    Cliente clienteAux = new Cliente (nombre,cedula,dinero, cliente.AreaConsumo);
                                                    clientes.set(clientes.indexOf(cliente), clienteAux);
                                                    System.out.println("Cliente editado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                    } else if (option5.equals("2")) {
                                        int index2 = 1;
                                        for (Cliente cliente : repuesto) {
                                                if (index2 == iBuscar) {
                                                    clientes.remove(cliente);
                                                    System.out.println("Cliente eliminado con exito");
                                                } else {
                                                    index2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            repuesto.removeAll(repuesto);
                            busqueda();
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void diagnostico() {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de las multinacionales");
        for (Multinacional multinacional: multinacionales
             ) {
            if(multinacional.inversores.isEmpty()){
                System.out.println(multinacional.nombre + " no tiene inversionistas asignados");

            }
            if(multinacional.sedes.isEmpty()){
                System.out.println(multinacional.nombre + " no tiene sedes asignadas");
            }

        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de las sedes");
        for (Sede sede: sedes
        ) {
            if(sede.inversionistas.isEmpty()){
                System.out.println(sede.nombre + " no tiene inversionistas asignados");

            }
            if(sede.areas.isEmpty()){
                System.out.println(sede.nombre + " no tiene areas asignadas");
            }

        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de los paises");
        for (Pais pais: paises
        ) {
            if(pais.sedes.isEmpty()){
                System.out.println(pais.nombre + " no tiene sedes asignadas");
            }


        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de los inversionistas");
        for (Inversionista inversionista: inversionistas
        ) {
            if(inversionista.multinacional==null){
                System.out.println(inversionista.firma + " no tiene multinacional asignada");

            }
            if(inversionista.sedes==null){
                System.out.println(inversionista.firma + " no tiene sede asignada");
            }

        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de las areas");
        for (Area area: areas
        ) {
            if(area.empleados.isEmpty()){
                System.out.println(area.nombreDelArea + " no tiene empleados asignados");

            }
            if(area.clientes.isEmpty()){
                System.out.println(area.nombreDelArea + " no tiene compradores asignados");

            }


        }

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de los empleados");
        for (Empleado empleado: empleados
        ) {
            if(empleado.compradores.isEmpty()){
                System.out.println(empleado.cedula+ " no tiene compradores asignados");

            }


        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inconsistencias de los clientes");
        for (Cliente cliente: clientes
        ) {
            if(cliente.vendedor==null){
                System.out.println(cliente.cedula + " no tiene vendedor asignados");

            }


        }



    }



    private static void guardar() {

    }

    private static void salirCancelar() {
        while(true){
            System.out.println("Si sale ahora se perderan los cambios sin guardar");
            System.out.println("Ingrese [N] si desea regresar al  menu principal");
            System.out.println("Ingrese [Y] si desea cerrar el programa");
            String cerrado = input.next();

            if (cerrado.equals("N")||cerrado.equals("n")) {
                System.out.println("Regresando al menu principal");

                return;
            }
            else if (cerrado.equals("Y")||cerrado.equals("y")) {
                System.out.println("CERRANDO PROGRAMA");
                System.out.println("-----------------------------");
                System.out.println("Programa cerrado con exito");
                System.out.println("-----------------------------");
                System.exit(0);

            } else {
                System.out.println("Opcion invalida");
                System.out.println("-----------------------------");



            }
        }
    }

    private static void VerMultinacional() {
        if(multinacionales.isEmpty()){
            System.out.println("No se encuentra ninguna multinacional");
            System.out.println("¿Desea crearla?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearMultinacional();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de multinacionales");
        for (Multinacional multinacional:multinacionales) {
            System.out.println(multinacional);
        }
    }

    private static void CrearMultinacional() {
        System.out.println("Ingresar datos de la Multinacional");
        System.out.print("Ingrese el nombre de la multinacional: ");
        String nombre=input.next();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        for (Multinacional multinacional:multinacionales) {
            if(multinacional.nombre.equals(nombre)){
                System.out.println("Multinaciona ya existe");
                CrearMultinacional();
                return;
            }
        }
        System.out.print("Ingrese el NIT: ");
        int NIT=input.nextInt();
        while(NIT<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("NIT: ");
            NIT=input.nextInt();
        }
        for(Multinacional multinacional:multinacionales){
            if(multinacional.NIT==NIT){
                System.out.println("Multinacional ya existe");
                return;
            }
        }
        System.out.print("Ingrese el nombre del CEO: ");
        String ceo= input.next();

        while(ceo.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            ceo= input.next();
        }
        System.out.print("Ingrese los fondos de la multinacional: ");
        int ingresos= input.nextInt();
        while(ingresos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Fondos: ");
            ingresos=input.nextInt();
        }
        System.out.print("Ingrese los gastos de la multinacional: ");
        int gastos= input.nextInt();
        while(gastos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Gastos: ");
            gastos=input.nextInt();
        }

        Multinacional nuevaMultinacional=new Multinacional(nombre,ceo,ingresos,gastos,NIT);
        multinacionales.add(nuevaMultinacional);
        System.out.println("Multinacional creada con exito");
    }

    private static void EditarMultinacional() {
        while (true) {
            Multinacional multinacionalAux = new Multinacional(null, null, 0, 0, 0);
            System.out.println("Selecione como desea buscar la multinacional");
            System.out.println("1. por nombre");
            System.out.println("2. por NIT");
            String option = input.next();
            switch (option) {
                case "1":
                    System.out.print("ingrese el nombre de la multinacional: ");
                    String nombre = input.next();
                    for (Multinacional multinacional : multinacionales) {
                        if (multinacional.nombre.equals(nombre)) {
                            System.out.println("Nombre: " + multinacional.nombre);
                            System.out.print("Nuevo nombre: ");
                            input.nextLine();
                            String nombreMulti = input.nextLine();
                            if (!nombreMulti.equals("")) {
                                multinacionalAux.nombre = nombreMulti;
                            } else {
                                multinacionalAux.nombre = multinacional.nombre;
                            }
                            System.out.println("Ceo: " + multinacional.ceo);
                            System.out.print("Nuevo ceo: ");
                            String ceo = input.nextLine();
                            if (!ceo.equals("")) {
                                multinacionalAux.ceo = ceo;
                            } else {
                                multinacionalAux.ceo = multinacional.ceo;
                            }
                            System.out.println("Fondos: " + multinacional.ingresoTotal);
                            System.out.print("Nuevos fondos: ");
                            String fondos = input.nextLine();
                            if (!fondos.equals("")) {
                                multinacionalAux.ingresoTotal = Integer.parseInt(fondos);
                            } else {
                                multinacionalAux.ingresoTotal = multinacional.ingresoTotal;
                            }
                            System.out.println("Gastos: " + multinacional.gastoTotal);
                            System.out.print("Nuevos gastos: ");
                            String gastos = input.nextLine();

                            if (!gastos.equals("")) {
                                multinacionalAux.gastoTotal = Integer.parseInt(gastos);
                            } else {
                                multinacionalAux.gastoTotal = multinacional.gastoTotal;
                            }
                            System.out.println("NIT: " + multinacional.NIT);
                            System.out.print("Nuevo NIT: ");
                            String NIT = input.nextLine();
                            if (!NIT.equals("")) {
                                multinacionalAux.NIT = Integer.parseInt(NIT);
                            } else {
                                multinacionalAux.NIT = multinacional.NIT;
                            }
                            System.out.println("Numero de inversionistas: "+multinacional.inversores.size());
                            System.out.print("Nombre de la firma del nuevo inversionista: ");
                            String inversionista=input.nextLine();
                            if(!inversionista.equals("")){
                                Inversionista inversionistaAux;
                                for (Inversionista inversionista1:inversionistas) {
                                    if(inversionista1.firma.equals(inversionista)){
                                        multinacionalAux.inversores= multinacional.inversores;
                                        multinacionalAux.inversores.add(inversionista1);
                                        inversionistaAux=inversionista1;
                                        inversionistaAux.multinacional= inversionista1.multinacional;
                                        inversionistaAux.multinacional=multinacional;
                                        System.out.println("¿Desea guardar los cambios?");
                                        System.out.println("Si(Y)/No(N)");
                                        String optionGuardado = input.next();
                                        switch (optionGuardado) {
                                            case "Y":
                                                int indiceinversionista= inversionistas.indexOf(inversionista1);
                                                int indicemultinacional = multinacionales.indexOf(multinacional);
                                                multinacionales.remove(multinacional);
                                                multinacionales.add(indicemultinacional, multinacionalAux);
                                                inversionistas.remove(inversionista1);
                                                inversionistas.add(indiceinversionista,inversionistaAux);
                                                return;
                                            case "N":
                                                return;
                                        }
                                    }

                                }
                                    System.out.println("No se encontro un inversionista con este nombre");
                                    EditarMultinacional();
                                    return;
                                }
                             else{
                                multinacionalAux.inversores= multinacional.inversores;
                            }
                            System.out.println("¿Desea guardar los cambios?");
                            System.out.println("Si(Y)/No(N)");
                            String optionGuardado = input.next();
                            switch (optionGuardado) {
                                case "Y":
                                    int indicemultinacional = multinacionales.indexOf(multinacional);
                                    multinacionales.remove(multinacional);
                                    multinacionales.add(indicemultinacional, multinacionalAux);
                                    return;
                                case "N":
                                    return;
                            }

                        }
                    }
                    System.out.println("No se encontro multinacional por este nombre");
                    break;

                case "2":
                    System.out.print("ingrese el NIT de la multinacional: ");
                    String multinacionalStringNIT = input.next();
                    String multinacionalStringNITDepurada = multinacionalStringNIT.replace(".", "");
                    int NIT = Integer.parseInt(multinacionalStringNITDepurada);
                    for (Multinacional multinacional : multinacionales) {
                        if (multinacional.NIT == NIT) {
                            System.out.println("Nombre: " + multinacional.nombre);
                            System.out.print("Nuevo nombre: ");
                            input.nextLine();
                            String nombreMulti = input.nextLine();
                            if (nombreMulti.equals("")) {
                                multinacionalAux.nombre = multinacional.nombre;
                            } else {
                                multinacionalAux.nombre = nombreMulti;
                            }
                            System.out.println("Ceo: " + multinacional.ceo);
                            System.out.print("Nuevo ceo: ");
                            String ceo = input.nextLine();
                            if (!ceo.equals("")) {
                                multinacionalAux.ceo = ceo;
                            } else {
                                multinacionalAux.ceo = multinacional.ceo;
                            }
                            System.out.println("Fondos: " + multinacional.ingresoTotal);
                            System.out.print("Nuevos fondos: ");
                            String fondos = input.nextLine();
                            if (!fondos.equals("")) {
                                multinacionalAux.ingresoTotal = Integer.parseInt(fondos);
                            } else {
                                multinacionalAux.ingresoTotal = multinacional.ingresoTotal;
                            }
                            System.out.println("Gastos: " + multinacional.gastoTotal);
                            System.out.print("Nuevos gastos: ");
                            String gastos = input.nextLine();
                            if (!gastos.equals("")) {
                                multinacionalAux.gastoTotal = Integer.parseInt(gastos);
                            } else {
                                multinacionalAux.gastoTotal = multinacional.gastoTotal;
                            }
                            System.out.println("NIT: " + multinacional.NIT);
                            System.out.print("Nuevo NIT: ");
                            String NITMulti = input.nextLine();
                            if (!NITMulti.equals("")) {
                                multinacionalAux.NIT = Integer.parseInt(NITMulti);
                            } else {
                                multinacionalAux.NIT = multinacional.NIT;
                            }
                            System.out.println("Numero de inversionistas: "+multinacional.inversores.size());
                            System.out.print("Nombre de la firma del nuevo inversionista: ");
                            String inversionista=input.nextLine();
                            if(!inversionista.equals("")){
                                Inversionista inversionistaAux;
                                for (Inversionista inversionista1:inversionistas) {
                                    if(inversionista1.firma.equals(inversionista)){
                                        multinacionalAux.inversores= multinacional.inversores;
                                        multinacionalAux.inversores.add(inversionista1);
                                        inversionistaAux=inversionista1;
                                        inversionistaAux.multinacional= inversionista1.multinacional;
                                        inversionistaAux.multinacional=multinacional;
                                        System.out.println("¿Desea guardar los cambios?");
                                        System.out.println("Si(Y)/No(N)");
                                        String optionGuardado = input.next();
                                        switch (optionGuardado) {
                                            case "Y":
                                                int indiceinversionista= inversionistas.indexOf(inversionista1);
                                                int indicemultinacional = multinacionales.indexOf(multinacional);
                                                multinacionales.remove(multinacional);
                                                multinacionales.add(indicemultinacional, multinacionalAux);
                                                inversionistas.remove(inversionista1);
                                                inversionistas.add(indiceinversionista,inversionistaAux);
                                                return;
                                            case "N":
                                                return;
                                        }
                                    }

                                }
                                System.out.println("No se encontro un inversionista con este nombre");
                                EditarMultinacional();
                                return;
                            }
                            else{
                                multinacionalAux.inversores= multinacional.inversores;
                            }
                            System.out.println("¿Desea guardar los cambios?");
                            System.out.println("Si(Y)/No(N)");
                            String optionGuardado = input.next();
                            switch (optionGuardado) {
                                case "Y":
                                    int indicemultinacional = multinacionales.indexOf(multinacional);
                                    multinacionales.remove(multinacional);
                                    multinacionales.add(indicemultinacional, multinacionalAux);
                                    return;
                                case "N":
                                    return;
                            }
                        }
                    }
                    System.out.println("No se encontro multinacional por este nombre");
                    break;
            }
        }
    }
    private static void EliminarMultinacional() {

        if (multinacionales.isEmpty()) {
            System.out.println("No existe ninguna multinacional");
            return;
        }
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("¿Desea buscar la multinacional a eliminar por nombre o por NIT?");
            System.out.println("1. Nombre ");
            System.out.println("2. NIT ");
            System.out.println("-----------------------------");

            String optionMultinacionalBorrador = input.next();

            switch (optionMultinacionalBorrador) {
                case "1":
                    System.out.println("Ingrese el nombre de la multinacional a borrar ");
                    input.nextLine();
                    String multinacionalBorrador = input.nextLine();
                    for (Multinacional multinacional : multinacionales) {
                        if (multinacionalBorrador.equalsIgnoreCase(multinacional.nombre)) {
                            System.out.println("Nombre: " + multinacional.nombre);
                            System.out.println("¿Esta seguro que desea borrarla?");
                            System.out.println("Si(Y)/No(N)");
                            String optionGuardado = input.next();
                            switch (optionGuardado) {
                                case "Y":
                                    multinacionales.remove(multinacional);
                                    System.out.println("Multinacional borrada con exito");
                                    return;
                                case "N":
                                    return;
                            }
                        }
                    }
                    System.out.println("No se encontra multinacional con este nombre");
                    break;
                case "2":
                    System.out.println("Ingrese el NIT de la multinacional");
                    String multinacionalStringNIT = input.next();
                    String multinacionalStringNITDepurada = multinacionalStringNIT.replace(".", "");
                    int multinacionalNITDepurada = Integer.parseInt(multinacionalStringNITDepurada);
                    for (Multinacional multinacional : multinacionales) {
                        if (multinacional.NIT == multinacionalNITDepurada) {
                            System.out.println("Nombre: " + multinacional.nombre);
                            System.out.println("¿Esta seguro que desea borrarla?");
                            System.out.println("Si(Y)/No(N)");
                            String optionGuardado = input.next();
                            switch (optionGuardado) {
                                case "Y":
                                    multinacionales.remove(multinacional);
                                    System.out.println("Multinacional borrada con exito");
                                    return;
                                case "N":
                                    return;
                            }
                        }

                    }
                    System.out.println("No se encontra multinacional con este nombre");
                    break;

            }
        }
    }


    private static void VerSede() {
        if(sedes.isEmpty()){
            System.out.println("No se encuentra ninguna sede");
            System.out.println("¿Desea crearla?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearSede();
                    return;
                case"2":
                    return;
            }
        }

        System.out.println("Lista de sedes");
        for (Sede sede:sedes) {
            System.out.println(sede);
        }
    }

    private static void CrearSede() {
        System.out.println("Ingrese los datos de la sede");
        System.out.print("Ingrese el nombre de la sede: ");
        String nombre=input.next();
        input.nextLine();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        for(Sede sede:sedes){
            if(sede.nombre.equals(nombre)){
                System.out.println("Sede ya existe");
                CrearSede();
                return;
            }
        }
        System.out.print("Ingrese el nombre del gerente: ");
        String gerente= input.next();
        while(gerente.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            gerente= input.next();
        }
        System.out.print("Ingrese los fondos de la sede: ");
        int ingresos= input.nextInt();
        while(ingresos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Fondos: ");
            ingresos=input.nextInt();
        }
        System.out.print("Ingrese los gastos de la sede: ");
        int gastos= input.nextInt();
        while(gastos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Gastos: ");
            gastos=input.nextInt();
        }
        System.out.print("Ingrese el nombre del pais de ubicacion de la sede: ");
        String nombrePais= input.next();
        while(nombrePais.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("nombre: ");
            nombrePais= input.next();
        }
        Pais paisAux=new Pais(null,null);

        for (Pais pais : paises) {
            if (pais.nombre.equals(nombrePais)) {
                paisAux = pais;
            }
        }
        if(paisAux.nombre==null){
            System.out.println("No se encontro un pais con este nombre");
            System.out.println("¿Desea crearlo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String optionPais=input.next();
            switch (optionPais){
                case "1":
                    CrearPais();
                    return;
                case "2":
                    System.out.println("¿Desea continuar creando una Sede? ");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    String optionAuxPais=input.next();
                    switch (optionAuxPais){
                        case "1":
                            CrearSede();
                            return;
                        case "2":
                            return;
                    }
                    break;
            }
        }

        System.out.print("Ingrese el NIT de la multinacional a la que pertenece la sede: ");
        int multinacionalNIT= input.nextInt();
        while(multinacionalNIT<=0) {
            System.out.println("NIT invalido, ingreselo de nuevo");
            System.out.print("NIT: ");
            multinacionalNIT= input.nextInt();
        }
        for (Multinacional multinacional:multinacionales) {
            if(multinacional.NIT==multinacionalNIT){
                Sede NuevaSede=new Sede(nombre,gerente,ingresos,gastos,multinacional,paisAux);
                sedes.add(NuevaSede);
                System.out.println("Sede creada con exito");
                multinacional.sedes.add(NuevaSede);
                return;
            }
        }

        System.out.println("No se encontro multinacional a la que pertenece la sede");
        System.out.println("¿Desea crearla?");
        System.out.println("1. si");
        System.out.println("2. no");
        String option= input.next();
        switch (option){
            case "1":
                CrearMultinacional();
                return;
            case "2":
                System.out.println("¿Desea continuar creando una sede?");
                System.out.println("1. si");
                System.out.println("2. no");
                String option2=input.next();
                switch (option2){
                    case "1":
                        CrearSede();
                        return;
                    case "2":
                        return;
                }
                break;
        }

    }

    private static void EditarSede() {
        while (true) {
            Sede sedeAux = new Sede(null, null, 0, 0, null, null);
            System.out.println("Ingrese el nombre de la sede");
            String nombre = input.next();
            for (Sede sede : sedes) {
                if (sede.nombre.equals(nombre)) {
                    sedeAux.multinacional = sede.multinacional;
                    sedeAux.paisPertenece = sede.paisPertenece;
                    System.out.println("Nombre: " + sede.nombre);
                    System.out.print("Nuevo nombre: ");
                    input.nextLine();
                    String nombreSede = input.nextLine();
                    if (!nombreSede.equals("")) {
                        sedeAux.nombre = nombreSede;
                    } else {
                        sedeAux.nombre = sede.nombre;
                    }
                    System.out.println("Gerente: " + sede.gerente);
                    System.out.print("Nuevo gerente: ");
                    String gerente = input.nextLine();
                    if (!gerente.equals("")) {
                        sedeAux.gerente = gerente;
                    } else {
                        sedeAux.gerente = sede.gerente;
                    }
                    System.out.println("Fondos: " + sede.ingresoSede);
                    System.out.print("Nuevos fondos: ");
                    String fondos = input.nextLine();
                    if (!fondos.equals("")) {
                        sedeAux.ingresoSede = Integer.parseInt(fondos);
                    } else {
                        sedeAux.ingresoSede = sede.ingresoSede;
                    }
                    System.out.println("Gastos: " + sede.gastosSede);
                    System.out.print("Nuevos gastos: ");
                    String gastos = input.nextLine();

                    if (!gastos.equals("")) {
                        sedeAux.gastosSede = Integer.parseInt(gastos);
                    } else {
                        sedeAux.gastosSede = sede.gastosSede;
                    }
                    System.out.println("Numero de inversionistas: "+sede.inversionistas.size());
                    System.out.print("Nombre de la firma del nuevo inversionista: ");
                    String inversionista=input.nextLine();
                    if(!inversionista.equals("")){
                        Inversionista inversionistaAux;
                        for (Inversionista inversionista1:inversionistas) {
                            if(inversionista1.firma.equals(inversionista)){
                                sedeAux.inversionistas= sede.inversionistas;
                                sedeAux.inversionistas.add(inversionista1);
                                inversionistaAux=inversionista1;
                                inversionistaAux.sedes= inversionista1.sedes;
                                inversionistaAux.sedes=sede;
                                System.out.println("¿Desea guardar los cambios?");
                                System.out.println("Si(Y)/No(N)");
                                String optionGuardado = input.next();
                                switch (optionGuardado) {
                                    case "Y":
                                        int indiceinversionista= inversionistas.indexOf(inversionista1);
                                        int indicesede =sedes.indexOf(sede);
                                        sedes.remove(sede);
                                        sedes.add(indicesede, sedeAux);
                                        inversionistas.remove(inversionista1);
                                        inversionistas.add(indiceinversionista,inversionistaAux);
                                        return;
                                    case "N":
                                        return;
                                }
                            }

                        }
                        System.out.println("No se encontro un inversionista con este nombre");
                        EditarSede();
                        return;
                    }
                    else{
                        sedeAux.inversionistas= sede.inversionistas;
                    }
                    System.out.println("¿Desea guardar los cambios?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            int indicesede =sedes.indexOf(sede);
                            sedes.remove(sede);
                            sedes.add(indicesede, sedeAux);
                            return;
                        case "N":
                            return;
                    }
                }
            }
            System.out.println("No se encontro sede por este nombre");
        }
    }
    private static void EliminarSede() {
        if (sedes.isEmpty()) {
            System.out.println("No existe ninguna sede");
            return;
        }
        while (true) {
            System.out.println("Ingrese el nombre de la sede a borrar ");
            input.nextLine();
            System.out.println("Ingrese el nombre de la sede a borrar ");
            String sedeBorrador = input.nextLine();
            for (Sede sede : sedes) {
                if (sedeBorrador.equalsIgnoreCase(sede.nombre)) {
                    System.out.println("Nombre: " + sede.nombre);
                    System.out.println("¿Esta seguro que desea borrarla?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            sedes.remove(sede);
                            System.out.println("Sede borrada con exito");
                            return;
                        case "N":
                            return;
                    }
                }
            }
            System.out.println("No se encontro sede con este nombre");
        }
    }

    private static void VerPais() {
        if(paises.isEmpty()){
            System.out.println("No se encuentra ningun pais");
            System.out.println("¿Desea crearlo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearPais();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de paises");
        for (Pais pais:paises) {
            System.out.println(pais);
        }
    }

    private static void CrearPais() {
        System.out.println("Ingrese los datos del pais");
        System.out.print("Ingrese el nombre del pais: ");
        String nombre=input.next();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        for(Pais pais:paises){
            if(pais.nombre.equals(nombre)){
                System.out.println("Pais ya existe");
                CrearPais();
                return;
            }
        }
        System.out.print("Ingrese el nombre del presidente: ");
        String presidente= input.next();
        while(presidente.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            presidente= input.next();
        }

        Pais paisNuevo=new Pais(nombre,presidente);
        paises.add(paisNuevo);
        System.out.println("Pais creado con exito");
    }

    private static void EditarPais() {
        Pais paisAux = new Pais(null, null);
        System.out.println("Ingrese el nombre del pais");
        String nombre = input.next();
        for (Pais pais : paises) {
            if (pais.nombre.equals(nombre)) {
                System.out.println("Nombre: " + pais.nombre);
                System.out.print("Nuevo nombre: ");
                input.nextLine();
                String nombrePais = input.nextLine();
                if (!nombrePais.equals("")) {
                    paisAux.nombre = nombrePais;
                } else {
                    paisAux.nombre = pais.nombre;
                }
                System.out.println("Presidente: " + pais.presidente);
                System.out.print("Nuevo Presidente: ");
                String presidente = input.nextLine();
                if (!presidente.equals("")) {
                    paisAux.presidente = presidente;
                } else {
                    paisAux.presidente = pais.presidente;
                }
                System.out.println("¿Desea guardar los cambios?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        int indice = paises.indexOf(pais);
                        paises.remove(pais);
                        paises.add(indice, paisAux);
                        System.out.println("Guardado con exito");
                        return;
                    case "N":
                        return;
                }

            }
        }
        System.out.println("No se encontro pais por este nombre");
        EditarPais();
    }

    private static void EliminarPais() {


        if(paises.isEmpty()){
            System.out.println("No existe ningun pais");
            return;
        }
        System.out.println("Ingrese el nombre de la pais a borrar ");
        input.nextLine();
        String paisBorrador = input.nextLine();
        for (Pais pais : paises) {
            if (paisBorrador.equalsIgnoreCase(pais.nombre)) {
                System.out.println("Nombre: "+pais.nombre);
                System.out.println("¿Esta seguro que desea borrarla?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        paises.remove(pais);
                        System.out.println("pais borrada con exito");
                        return;
                    case "N":
                        return;
                }
            }
        }
        System.out.println("No se encontro pais con este nombre");
        EliminarPais();
    }




    private static void VerInversionista() {
        if(inversionistas.isEmpty()){
            System.out.println("No se encuentra ningun invervesionista");
            System.out.println("¿Desea crearlo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearInversionista();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de inversionistas");
        for (Inversionista inversionista:inversionistas) {
            System.out.println(inversionista);
        }
    }

    private static void CrearInversionista() {
        System.out.println("Ingrese los datos del inversionista");
        System.out.print("Ingrese el nombre de la firma: ");
        String nombre=input.next();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        for(Inversionista inversionista:inversionistas){
            if(inversionista.firma.equals(nombre)){
                System.out.println("Inversionista ya existe");
                CrearInversionista();
                return;
            }
        }
        System.out.print("Ingrese la inversion para la multinacional: ");
        int inversionMn= input.nextInt();
        while(inversionMn<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Inversion: ");
            inversionMn=input.nextInt();
        }
        System.out.print("Ingrese la inversion para sedes: ");
        int inversionSede= input.nextInt();
        while(inversionSede<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Inversion: ");
            inversionSede=input.nextInt();
        }
        System.out.print("Ingrese las gananacias esperadas de la firma: ");
        int ganancia= input.nextInt();
        while(ganancia<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Ganancia: ");
            ganancia=input.nextInt();
        }
        Inversionista nuevoInversionista=new Inversionista(nombre,inversionMn,inversionSede,ganancia);
        inversionistas.add(nuevoInversionista);

    }

    private static void EditarInversionista() {
        Inversionista inversionistaAux = new Inversionista(null,0, 0, 0);
        while(true){
        System.out.println("Ingrese el nombre de la firma de inversores");
        String nombre=input.next();
        for (Inversionista inversionista:inversionistas) {
            if(inversionista.firma.equals(nombre)){
                System.out.println("Nombre: " + inversionista.firma);
                System.out.print("Nuevo nombre: ");
                input.nextLine();
                String nombreFirma = input.nextLine();
                if (!nombreFirma.equals("")) {
                    inversionistaAux.firma = nombreFirma;
                } else {
                    inversionistaAux.firma = inversionista.firma;
                }
                System.out.println("Inversion para multinacional: " + inversionista.inversionMN);
                System.out.print("Nueva inversion: ");
                String inversionMN = input.nextLine();
                if (!inversionMN.equals("")) {
                    inversionistaAux.inversionMN = Integer.parseInt(inversionMN);
                } else {
                    inversionistaAux.inversionMN = inversionista.inversionMN;
                }
                System.out.println("Inversion para sedes: " + inversionista.inversionSede);
                System.out.print("Nueva inversion: ");
                String inversionSede = input.nextLine();
                if (!inversionSede.equals("")) {
                    inversionistaAux.inversionMN = Integer.parseInt(inversionSede);
                } else {
                    inversionistaAux.inversionSede = inversionista.inversionSede;
                }
                System.out.println("Ganancia esperada: " + inversionista.ganancias);
                System.out.print("Nueva Ganancia: ");
                String ganancia = input.nextLine();
                if (!ganancia.equals("")) {
                    inversionistaAux.ganancias = Integer.parseInt(ganancia);
                } else {
                    inversionistaAux.ganancias = inversionista.ganancias;
                }
                System.out.println("¿Desea guardar los cambios?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        int indice = inversionistas.indexOf(inversionista);
                        inversionistas.remove(inversionista);
                        inversionistas.add(indice, inversionistaAux);
                        System.out.println("Guardado con exito");
                        return;
                    case "N":
                        return;
                }
            }
        }
        System.out.println("No se encontro inversionista por este nombre");
    }}

    private static void EliminarInversionista() {


        if(inversionistas.isEmpty()){
            System.out.println("No existe ningun inversionista");
            return;
        }
        while (true){
        System.out.println("Ingrese la firma del inversionista a borrar ");
        input.nextLine();
        String inversionistaBorrador = input.nextLine();
        for (Inversionista inversionista : inversionistas) {
            if (inversionistaBorrador.equalsIgnoreCase(inversionista.firma)) {
                System.out.println("Nombre: "+inversionista.firma);
                System.out.println("¿Esta seguro que desea borrarla?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        inversionistas.remove(inversionista);
                        System.out.println("inversionista borrado con exito");
                        return;
                    case "N":
                        return;
                }
            }
        }
        System.out.println("No se encontro un inversionista con esta firma");
    }}
    private static void VerArea() {
        if(areas.isEmpty()){
            System.out.println("No se encuentra ninguna area");
            System.out.println("¿Desea crearla?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearArea();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de areas");
        for (Area area:areas) {
            System.out.println(area);
        }
    }

    private static void CrearArea() {
        System.out.println("Ingrese los datos de la area");
        System.out.print("Ingrese el nombre de la area: ");
        String nombre=input.next();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        for(Area area:areas){
            if(area.nombreDelArea.equals(nombre)){
                System.out.println("Area ya existe");
                CrearArea();
                return;
            }
        }
        System.out.print("Ingrese los fondos de la area: ");
        int ingresos= input.nextInt();
        while(ingresos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Fondos: ");
            ingresos=input.nextInt();
        }
        System.out.print("Ingrese los gastos de la area: ");
        int gastos= input.nextInt();
        while(gastos<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Gastos: ");
            gastos=input.nextInt();
        }
        System.out.print("Ingrese el nombre de la sede a la que pertenece el area: ");
        String nombreSede=input.next();
        input.nextLine();
        while(nombreSede.equals("")) {
            System.out.println("Nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombreSede= input.next();
        }
        for (Sede sede:sedes) {
            if(sede.nombre.equals(nombreSede)){
                Area NuevaArea=new Area(nombre,ingresos,gastos,sede);
                areas.add(NuevaArea);
                sede.areas.add(NuevaArea);
                System.out.println("Area creada con exito");
                return;
            }
        }
        System.out.println("No se encontro sede a la que pertenece la area");
        System.out.println("¿Desea crearla?");
        System.out.println("1. si");
        System.out.println("2. no");
        String option= input.next();
        switch (option){
            case "1":
                CrearSede();
                break;
            case "2":
                System.out.println("¿Desea continuar creando una area?");
                System.out.println("1. si");
                System.out.println("2. no");
                String option2=input.next();
                switch (option2){
                    case "1":
                        CrearArea();
                        return;
                    case "2":
                        return;
                }
                break;
        }
    }

    private static void EditarArea() {
        Area areaAux = new Area(null, 0, 0, null);
        while (true){
        System.out.println("Ingrese el nombre del area");
        String nombre = input.next();
        for (Area area : areas) {
            if (area.nombreDelArea.equals(nombre)) {
                areaAux.sede = area.sede;
                System.out.println("Nombre: " + area.nombreDelArea);
                System.out.print("Nuevo nombre: ");
                input.nextLine();
                String nombreArea = input.nextLine();
                if (!nombreArea.equals("")) {
                    areaAux.nombreDelArea = nombreArea;
                } else {
                    areaAux.nombreDelArea = area.nombreDelArea;
                }
                System.out.println("Fondos: " + area.ingresoArea);
                System.out.print("Nuevos fondos: ");
                String fondos = input.nextLine();
                if (!fondos.equals("")) {
                    areaAux.ingresoArea = Integer.parseInt(fondos);
                } else {
                    areaAux.ingresoArea = area.ingresoArea;
                }
                System.out.println("Gastos: " + area.gastoArea);
                System.out.print("Nuevos gastos: ");
                String gastos = input.nextLine();
                if (!gastos.equals("")) {
                    areaAux.gastoArea = Integer.parseInt(gastos);
                } else {
                    areaAux.gastoArea = area.gastoArea;
                }
                System.out.println("¿Desea guardar los cambios?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        int indice = areas.indexOf(area);
                        areas.remove(area);
                        areas.add(indice, areaAux);
                        System.out.println("Guardado con exito");
                        return;
                    case "N":
                        return;
                }
            }
        }
        System.out.println("No se encontro area por este nombre");
    }}

    private static void EliminarArea() {
        if(areas.isEmpty()){
            System.out.println("No existe ningun area");
            return;
        }
        while (true) {
            System.out.println("Ingrese el nombre del area a borrar ");
            input.nextLine();
            String areaBorrador = input.nextLine();
            for (Area area : areas) {
                if (areaBorrador.equalsIgnoreCase(area.nombreDelArea)) {
                    System.out.println("nombreDeArea: " + area.nombreDelArea);
                    System.out.println("¿Esta seguro que desea borrarla?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            areas.remove(area);
                            System.out.println("area borrada con exito");
                            return;
                        case "N":
                            return;
                    }
                }
            }
            System.out.println("No se encontro un area con este nombre");
        }
    }

    private static void VerEmpleado() {
        if(empleados.isEmpty()){
            System.out.println("No se encuentra ningun empleado");
            System.out.println("¿Desea crearla?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearEmpleado();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de empleados");
        for (Empleado empleado:empleados) {
            System.out.println(empleado);
        }
    }

    private static void CrearEmpleado() {
        System.out.println("Ingrese los datos del empleado");
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre=input.next();
        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        System.out.print("Ingrese la cedula: ");
        int cedula=input.nextInt();
        while(cedula<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Cedula: ");
            cedula=input.nextInt();
        }
        for(Empleado empleado:empleados){
            if(empleado.cedula==cedula){
                System.out.println("Empleado ya existe");
                CrearEmpleado();
                return;
            }
        }
        System.out.print("Ingrese la edad: ");
        int edad=input.nextInt();
        while(edad<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Edad: ");
            edad=input.nextInt();
        }
        System.out.print("Ingrese el salario: ");
        int salario=input.nextInt();
        while(salario<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Salario: ");
            salario=input.nextInt();
        }
        System.out.print("Ingrese el nombre del area a la que pertenece el empleado: ");
        String nombreArea=input.next();
        while(nombreArea.equals("")) {
            System.out.println("Nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombreArea= input.next();
        }
        for (Area area:areas) {
            if(area.nombreDelArea.equals(nombreArea)){
                Empleado NuevoEmpleado=new Empleado(nombre,cedula,edad,salario,area);
                empleados.add(NuevoEmpleado);
                area.empleados.add(NuevoEmpleado);
                System.out.println("Empleado creado con exito");
                return;
            }
        }
        System.out.println("No se encontro area a la que pertenece el empelado");
        System.out.println("¿Desea crearla?");
        System.out.println("1. si");
        System.out.println("2. no");
        String option= input.next();
        switch (option){
            case "1":
                CrearArea();
                return;
            case "2":
                System.out.println("¿Desea continuar creando un empleado?");
                System.out.println("1. si");
                System.out.println("2. no");
                String option2=input.next();
                switch (option2){
                    case "1":
                        CrearEmpleado();
                        return;
                    case "2":
                        return;
                }
                break;
        }

    }

    private static void EditarEmpleado() {
        Empleado empleadoAux = new Empleado(null, 0, 0, 0, null);
        while (true) {
            System.out.println("Ingrese la cedula del empelado");
            int cedula = input.nextInt();
            for (Empleado empleado : empleados) {
                if (empleado.cedula == cedula) {
                    empleadoAux.areaPertenece = empleado.areaPertenece;
                    System.out.println("Nombre: " + empleado.nombre);
                    System.out.print("Nuevo nombre: ");
                    input.nextLine();
                    String nombreEmpleado = input.nextLine();
                    if (!nombreEmpleado.equals("")) {
                        empleado.nombre = nombreEmpleado;
                    } else {
                        empleadoAux.nombre = empleado.nombre;
                    }
                    System.out.println("Cedula: " + empleado.cedula);
                    System.out.print("Nueva cedula: ");
                    String cedulaEmpleado = input.nextLine();
                    if (!cedulaEmpleado.equals("")) {
                        empleadoAux.cedula = Integer.parseInt(cedulaEmpleado);
                    } else {
                        empleadoAux.cedula = empleado.cedula;
                    }
                    System.out.println("Edad: " + empleado.edad);
                    System.out.print("Nueva edad: ");
                    String edad = input.nextLine();
                    if (!edad.equals("")) {
                        empleadoAux.edad = Integer.parseInt(edad);
                    } else {
                        empleadoAux.edad = empleado.edad;
                    }
                    System.out.println("Salario: " + empleado.salario);
                    System.out.print("Nueva salario: ");
                    String salario = input.nextLine();
                    if (!cedulaEmpleado.equals("")) {
                        empleadoAux.salario = Integer.parseInt(salario);
                    } else {
                        empleadoAux.salario = empleado.salario;
                    }
                    System.out.println("Numero de clientes asigandos: " + empleado.compradores.size());
                    System.out.print("Cedula del nuevo cliente: ");
                    String cliente = input.nextLine();
                    if (!cliente.equals("")) {
                        Cliente clienteAux;
                        for (Cliente cliente1 : clientes) {
                            if (cliente1.cedula == Integer.parseInt(cliente)) {
                                clienteAux = cliente1;
                                clienteAux.vendedor = empleado;
                                empleadoAux.compradores = empleado.compradores;
                                empleadoAux.compradores.add(cliente1);
                                System.out.println("¿Desea guardar los cambios?");
                                System.out.println("Si(Y)/No(N)");
                                String optionGuardado = input.next();
                                switch (optionGuardado) {
                                    case "Y":
                                        int indicecliente = clientes.indexOf(cliente1);
                                        int indiceEmpleado = empleados.indexOf(empleado);
                                        clientes.remove(cliente1);
                                        clientes.add(indicecliente, clienteAux);
                                        empleados.remove(empleado);
                                        empleados.add(indiceEmpleado, empleadoAux);
                                        return;
                                    case "N":
                                        return;
                                }
                            }
                        }
                        System.out.println("No se encuentra cliente con esta cedula");
                        EditarEmpleado();
                        return;
                    } else {
                        empleadoAux.compradores = empleado.compradores;
                    }
                    System.out.println("¿Desea guardar los cambios?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            int indice = empleados.indexOf(empleado);
                            empleados.remove(empleado);
                            empleados.add(indice, empleadoAux);
                            System.out.println("Guardado con exito");
                            return;
                        case "N":
                            return;
                    }
                }
            }
            System.out.println("No se encontro empelado con esta cedula");

        }
    }
    private static void EliminarEmpleado() {
        if(empleados.isEmpty()){
            System.out.println("No existe ningun empleado");
            return;
        }
        while(true) {
            System.out.println("Ingrese la cedula de el empleado");
            String empleadoStringCedula = input.next();
            String empleadoStringCedulaDepurada = empleadoStringCedula.replace(".", "");
            int empleadoCedulaDepurada = Integer.parseInt(empleadoStringCedulaDepurada);
            for (Empleado empleado : empleados) {
                if (empleado.cedula == empleadoCedulaDepurada) {
                    System.out.println("Cedula: " + empleado.cedula);
                    System.out.println("¿Esta seguro que desea borrarlo?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            empleados.remove(empleado);
                            System.out.println("Empleado borrado con exito");
                            return;
                        case "N":
                            return;
                    }
                }

            }
            System.out.println("No se encuentro el empleado");
        }
    }



    private static void VerCliente() {
        if(clientes.isEmpty()){
            System.out.println("No se encuentra ningun cliente");
            System.out.println("¿Desea crearla?");
            System.out.println("1. Si");
            System.out.println("2. No");
            String option= input.next();
            switch (option){
                case "1":
                    CrearCliente();
                    return;
                case"2":
                    return;
            }
        }
        System.out.println("Lista de multinacionales");
        for (Cliente cliente:clientes) {
            System.out.println(cliente);
        }
    }

    private static void CrearCliente() {
        System.out.println("Ingrese los datos del cliente");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre=input.next();

        while(nombre.equals("")) {
            System.out.println("nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombre= input.next();
        }
        System.out.print("Ingrese la cedula: ");
        int cedula=input.nextInt();
        while(cedula<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Cedula: ");
            cedula=input.nextInt();
        }
        for(Cliente cliente:clientes){
            if(cliente.cedula==cedula){
                System.out.println("Cliente ya existe");
                CrearCliente();
                return;
            }
        }
        System.out.print("Ingrese el efectivo: ");
        int efectivo=input.nextInt();
        while(efectivo<=0){
            System.out.println("valor invalido, ingreselo de nuevo");
            System.out.print("Efectivo: ");
            efectivo=input.nextInt();
        }
        System.out.print("Ingrese el nombre del area de consumo: ");
        String nombreArea=input.next();
        while(nombreArea.equals("")) {
            System.out.println("Nombre invalido, ingreselo de nuevo");
            System.out.print("Nombre: ");
            nombreArea= input.next();
        }
        for (Area area:areas) {
            if(area.nombreDelArea.equals(nombreArea)){
                Cliente NuevoCliente=new Cliente(nombre,cedula,efectivo,area);
                clientes.add(NuevoCliente);
                area.clientes.add(NuevoCliente);
                System.out.println("Cliente creado con exito");
                return;
            }
        }
        System.out.println("No se encontro area de consumo del cliente");
        System.out.println("¿Desea crearla?");
        System.out.println("1. si");
        System.out.println("2. no");
        String option= input.next();
        switch (option){
            case "1":
                CrearArea();
                break;
            case "2":
                System.out.println("¿Desea continuar creando un cliente?");
                System.out.println("1. si");
                System.out.println("2. no");
                String option2=input.next();
                switch (option2){
                    case "1":
                        CrearCliente();
                        return;
                    case "2":
                        return;
                }
                break;
        }
    }

    private static void EditarCliente() {
        Cliente clienteAux = new Cliente(null, 0, 0, null);
        while (true) {
            System.out.println("Ingrese la cedula del cliente");
            int cedula = input.nextInt();
            for (Cliente cliente : clientes) {
                if (cliente.cedula == cedula) {
                    clienteAux.AreaConsumo = cliente.AreaConsumo;
                    System.out.println("Nombre: " + cliente.nombre);
                    System.out.print("Nuevo nombre: ");
                    input.nextLine();
                    String nombreCliente = input.nextLine();
                    if (!nombreCliente.equals("")) {
                        cliente.nombre = nombreCliente;
                    } else {
                        clienteAux.nombre = cliente.nombre;
                    }
                    System.out.println("Cedula: " + cliente.cedula);
                    System.out.print("Nueva cedula: ");
                    String cedulaCliente = input.nextLine();
                    if (!cedulaCliente.equals("")) {
                        clienteAux.cedula = Integer.parseInt(cedulaCliente);
                    } else {
                        clienteAux.cedula = cliente.cedula;
                    }
                    System.out.println("Dinero: " + cliente.dinero);
                    System.out.print("Nuevo dinero: ");
                    String dinero = input.nextLine();
                    if (!dinero.equals("")) {
                        clienteAux.dinero = Integer.parseInt(dinero);
                    } else {
                        clienteAux.dinero = cliente.dinero;
                    }
                    System.out.println("¿Desea guardar los cambios?");
                    System.out.println("Si(Y)/No(N)");
                    String optionGuardado = input.next();
                    switch (optionGuardado) {
                        case "Y":
                            int indice = clientes.indexOf(cliente);
                            clientes.remove(cliente);
                            clientes.add(indice, clienteAux);
                            System.out.println("Guardado con exito");
                            return;
                        case "N":
                            return;
                    }
                }
            }
            System.out.println("No se encontro cliente con esta cedula");
        }
    }
    private static void EliminarCliente() {
        if(clientes.isEmpty()){
            System.out.println("No existe ningun cliente");
            return;
        }
        while (true){
        System.out.println("Ingrese la cedula de el cliente");
        String clienteStringCedula = input.next();
        String clienteStringCedulaDepurada = clienteStringCedula.replace(".", "");
        int clienteCedulaDepurada = Integer.parseInt(clienteStringCedulaDepurada);
        for (Cliente cliente : clientes) {
            if (cliente.cedula == clienteCedulaDepurada) {
                System.out.println("Cedula: "+cliente.cedula);
                System.out.println("¿Esta seguro que desea borrarlo?");
                System.out.println("Si(Y)/No(N)");
                String optionGuardado = input.next();
                switch (optionGuardado) {
                    case "Y":
                        clientes.remove(cliente);
                        System.out.println("cliente borrado con exito");
                        return;
                    case "N":
                        return;
                }
            }

        }
        System.out.println("No se encuentro el cliente");
    }}

}