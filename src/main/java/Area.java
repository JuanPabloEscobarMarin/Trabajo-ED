public class Area {

    public String nombreDelArea;
    public Empleado empleados;
    public  Cliente clientes;
    public double ingresoArea;
    public Sede sede;
    public  double gastoArea;

    public Area (String nombreDelArea, double ingresoArea,double gastoArea,Sede sede) {
        this.nombreDelArea = nombreDelArea ;
        this.ingresoArea = ingresoArea;
        this.gastoArea= gastoArea;
        this.sede = sede;
        this.clientes = null;
        this.empleados = null;
    }

    @Override
    public String toString(){
        return "Nombre del area: "+nombreDelArea+", fondos: "+ingresoArea+", gastos: "+gastoArea+", sede: "+sede.nombre;
    }

}