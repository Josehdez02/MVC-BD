package dao;

import conexion.Conexion;
import modelo.ModeloEspecialidad;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEspecialidad implements  DAOGeneral<Integer, ModeloEspecialidad> {
    private Conexion conexion;
    public final static List<ModeloEspecialidad> lista= new ArrayList<>();
    public DAOEspecialidad(){
        conexion=new Conexion();
    }

    @Override
    public boolean agregar(ModeloEspecialidad element) {
        if (conexion.abrir()) {
            String sql = "INSERT INTO especialidad(id, nombre) VALUES(?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, element.getId());
                pstm.setString(2, element.getNombre());
                pstm.execute();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR");
                return false;
            } finally {
                conexion.cerrar();
            }
        }
        return false;
    }
    @Override
    public List<ModeloEspecialidad> consultar() {
       // List<ModeloEspecialidad> lista= new ArrayList<>();
        if (conexion.abrir()){
            String sql = "SELECT * FROM especialidad";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloEspecialidad especialidad=new ModeloEspecialidad();
                    especialidad.setId(resultados.getInt("id"));
                    especialidad.setNombre(resultados.getString("nombre"));
                    lista.add(especialidad);
                }
                System.out.println("SII");
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }

    @Override
    public boolean actualizar(Integer id, ModeloEspecialidad nuevo) {
        if (conexion.abrir()){
            String sql="UPDATE especialidad SET nombre=? WHERE id=?";
            Connection enlace= conexion.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1,nuevo.getNombre());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer id) {
        if (conexion.abrir()){
            String sql="DELETE FROM especialidad WHERE id=?";
            Connection con= conexion.obtener();
            try {
                PreparedStatement statement= con.prepareStatement(sql);
                statement.setInt(1,id);
                statement.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return false;
    }
}
//NOOOO