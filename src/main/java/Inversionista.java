public class Inversionista {

    public String firma;
    public double ganancias;
    public  double inversionSede;
    public Sede sedes;
    public Multinacional multinacional;
    public  double inversionMN;

    public Inversionista(String firma, double inversionMN,double inversionSede,double ganancias) {
        this.firma =firma ;
        this.ganancias = ganancias;
        this.inversionMN = inversionMN;
        this.inversionSede = inversionSede;
        this.multinacional = null;
        this.sedes= null;

    }
    @Override
    public String toString(){
        return "Firma: "+firma+", inversion: "+(inversionMN+inversionSede)+", ganancias"+ganancias;
    }

}