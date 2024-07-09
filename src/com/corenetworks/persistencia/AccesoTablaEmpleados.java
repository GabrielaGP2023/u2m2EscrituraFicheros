package com.corenetworks.persistencia;

import com.corenetworks.modelo.Empleado;
import com.corenetworks.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccesoTablaEmpleados extends Conexion{

    public int insertar(Empleado e) throws SQLException {
        //1. Declarar variables
        Statement comando;
        int resultado;
        String sql = "insert into employees " +
                "(employee_id, first_name, last_name) " +
                "values ( " + e.getId() +", '" +
                e.getNombre() + "', '" +
                e.getApellido() + "');";
        //2. Abrir conexion
        abrirConexion();
        //3. Obtener el Statement de la conexion
        comando = miConexion.createStatement();
        resultado = comando.executeUpdate(sql);
        comando.close();
        cerrarConexion();
        //4. devolver el resultado
        return resultado;
    }

    public int insertarP(Empleado e) throws SQLException {
        //1. Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = "insert into employees " +
                "(employee_id, first_name, last_name) " +
                "values ( ?,?,?);";
        //2. Abrir conexion
        abrirConexion();
        //3. Obtener el Statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //Dar valor a los parámetros
        comando.setInt(1,e.getId());
        comando.setString(2,e.getNombre());
        comando.setString(3,e.getApellido());
        resultado = comando.executeUpdate();
        comando.close();
        cerrarConexion();
        //4. devolver el resultado
        return resultado;
    }

    public int modificar(Empleado e) throws SQLException {
        //1. Declarar variables
        PreparedStatement comando;
        int resultado=0;
        String sql = "update employees set first_name=? "+
                ", last_name =? where employee_id = ?" ;

        //2. Abrir conexion
        abrirConexion();
        //3. Obtener el Statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //Asignar los valores a los parámetros
        comando.setString(1,e.getNombre());
        comando.setString(2,e.getApellido());
        comando.setInt(3,e.getId());
        resultado = comando.executeUpdate();
        comando.close();
        cerrarConexion();
        //4. devolver el resultado
        return resultado;
    }

    public List<Empleado> consultarPorNombre(String entrada) throws SQLException {
        Statement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select employee_id, first_name, last_name from employees "+
                "where first_name like '"+ entrada + "%'";
        List<Empleado> resultado = new ArrayList<>();
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.createStatement();
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery(sqlSentencia);
        //4. Verificar si hay resultado
        while(rejilla.next()){
            Empleado e1 = new Empleado(
                    rejilla.getInt("employee_id"),
                    rejilla.getString("first_name"),
                    rejilla.getString("last_name"));
            resultado.add(e1);
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }
    public List<Empleado> consultarTodos() throws SQLException {
        Statement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select * from employees;";
        List<Empleado> resultado = new ArrayList<>();
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.createStatement();
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery(sqlSentencia);
        //4. Verificar si hay resultado
        while(rejilla.next()){
            Empleado e1 = new Empleado(
                    rejilla.getInt("employee_id"),
                    rejilla.getString("first_name"),
                    rejilla.getString("last_name"));
            resultado.add(e1);
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public int obtenerTotal() throws SQLException {
        Statement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select count(*) as contador from employees;";
        int resultado=0;
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.createStatement();
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery(sqlSentencia);
        //4. Verificar si hay resultado
        if(rejilla.next()){
            resultado = rejilla.getInt("contador");
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }





    public int eliminar(int id) throws SQLException {
        //1. Declarar variables
        Statement comando;
        int resultado;
        String sql = "delete from products where product_id = " +
               id;
        //2. Abrir conexion
        abrirConexion();
        //3. Obtener el Statement de la conexion
        comando = miConexion.createStatement();
        resultado = comando.executeUpdate(sql);
        comando.close();
        cerrarConexion();
        //4. devolver el resultado
        return resultado;
    }
}
