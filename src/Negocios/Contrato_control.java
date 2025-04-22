package Negocios;

import Data.ContratoDao;
import Entidades.Contrato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Contrato_control 
{
    private final ContratoDao DATOS;
    private Contrato obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    private final Contrato Contrato;
    
    public Contrato_control()
    {
       this.DATOS= new ContratoDao();
       this.Contrato = new Contrato();
       this.registrosMostrados=0;
    }
    public DefaultTableModel listar(String texto){
        List<Contrato> lista=new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos={"Id","Observacion"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[2];
        
        this.registrosMostrados=0;
        for (Contrato item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getObservacion();
            registro[2]=estado;
            
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String Observacion){
        if (DATOS.existe(Observacion)){
            return "El registro ya existe.";
        }else{
            obj.setObservacion(Observacion);
            if (DATOS.insertar(obj)){
                return "OK";
            }else{
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id, String Observacion, String ObservacionAnt){
        if (Observacion.equals(ObservacionAnt)){
            obj.setId(id);
            obj.setObservacion(Observacion);
            
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(Observacion)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setObservacion(Observacion);
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
