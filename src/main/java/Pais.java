public class Pais {
    public String nombre;
    public String presidente;
    public Sede sedes;

    public Pais(String nombre,String presidente){
        this.nombre=nombre;
        this.presidente=presidente;
        this.sedes=null;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+", presidente: "+presidente;
    }

}