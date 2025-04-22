
package Data;

import Conexion.Conexion;//Se llama la clase de otro paquete
import Crud.Datos_interfaz;
import Entidades.Contrato;//Se llama la clase de otro paquete
import java.util.List;//Se llama la libreria de listas
import java.util.ArrayList;//LLama libreria de vectores
import javax.swing.JOptionPane;//Se llama la libreria para mostrar ventanas
import java.sql.PreparedStatement;//Prepara la base de datos
import java.sql.ResultSet; //Obtiene los resultados de la base de datos
import java.sql.SQLException;//Comprobar errores


public class ContratoDao implements Datos_interfaz<Contrato> {
    private final Conexion CON;//Se crea el objeto
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    public ContratoDao()//llama a la clase
    {
        CON = Conexion.getInstancia();
    }


    @Override
    public List<Contrato> listar(String texto)
{
    List<Contrato> registros = new ArrayList();
    try
    {
        ps=CON.conectar().prepareStatement("SELECT * FROM Contrato WHERE id_Detalles LIKE ?");
        ps.setString(1,"%" + texto +"%");
        rs=ps.executeQuery();
        while(rs.next())
        {
            registros.add(new Contrato(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getBoolean(5),rs.getString(6)));
        }
        ps.close();
        rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    @Override
    public boolean insertar(Contrato obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO Contrato (Observacion,activo) VALUES (?,1)");//Solo los var char de la base de dato, el ? es por cada valos var char
            ps.setString(1, obj.getObservacion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }
    
    @Override
    public boolean actualizar(Contrato obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE Contrato SET Observacion=? WHERE id=?");
            ps.setString(1, obj.getObservacion());
            ps.setInt(3, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    
    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    
    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

   
    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM ");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

   
    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT Observacion FROM Contrato WHERE Observacion=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
}
