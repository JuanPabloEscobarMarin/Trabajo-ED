public class Sede {
    public String nombre;
    public String gerente;
    public double ingresoSede;
    public double gastosSede;
    public Area areas;
    public Inversionista inversionistas;
    public Multinacional multinacional;

    public Sede (String nombre, String gerente, double ingresoSede, double gastosSede,Multinacional multinacional) {
        this.nombre = nombre;
        this.gerente = gerente;
        this.ingresoSede = ingresoSede;
        this.gastosSede = gastosSede;
        this.multinacional=multinacional;
        this.areas = null;
        this.inversionistas = null;
    }

    @Override
    public String toString(){
        return "Multinacional: "+multinacional.nombre+", nombre: "+nombre+", gerente: "+gerente+", fondos:"+ingresoSede+", gastos:"+gastosSede;
    }
}