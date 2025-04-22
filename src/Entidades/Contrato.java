 
package Entidades;

public class Contrato 
{
    private int id;
    private int id_Detalles;
    private int id_Comunicacion;
    private int id_Datos;
    private boolean activo;
    private String Observacion; 
    
    //constructores

    public Contrato(int id, int id_Detalles, int id_Comunicacion, int id_Datos, boolean activo, String Observacion) {
        this.id = id;
        this.id_Detalles = id_Detalles;
        this.id_Comunicacion = id_Comunicacion;
        this.id_Datos = id_Datos;
        this.activo = activo;
        this.Observacion = Observacion;
    }

    public Contrato() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //Se muestra el valor
    public int getId() {
        return id;
    }
    //Se establese el valor 
    public void setId(int id) {
        this.id = id;
    }

    public int getId_Detalles() {
        return id_Detalles;
    }

    public void setId_Detalles(int id_Detalles) {
        this.id_Detalles = id_Detalles;
    }

    public int getId_Comunicacion() {
        return id_Comunicacion;
    }

    public void setId_Comunicacion(int id_Comunicacion) {
        this.id_Comunicacion = id_Comunicacion;
    }

    public int getId_Datos() {
        return id_Datos;
    }

    public void setId_Datos(int id_Datos) {
        this.id_Datos = id_Datos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", id_Detalles=" + id_Detalles + ", id_Comunicacion=" + id_Comunicacion + ", id_Datos=" + id_Datos + ", activo=" + activo + ", Observacion=" + Observacion + '}';
    }
    
    
   
    
}
