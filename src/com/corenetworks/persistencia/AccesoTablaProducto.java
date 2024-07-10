package com.corenetworks.persistencia;

import com.corenetworks.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccesoTablaProducto extends Conexion{

    public Producto consultarUno(int id) throws SQLException {
        Statement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select * from products where product_id = "+ id;
        Producto p1;
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.createStatement();
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery(sqlSentencia);
        //4. Verificar si hay resultado
        if(rejilla.next()==true){
            //Se pudo leer una fila
            int idProducto;
            String nombreProducto;
            double precio;
            double cantidadExistencia;
            idProducto = rejilla.getInt("product_id");
            nombreProducto = rejilla.getString("product_name");
            precio = rejilla.getDouble("unit_price");
            cantidadExistencia = rejilla.getDouble("units_in_stock");
            p1 = new Producto(idProducto,nombreProducto,precio,cantidadExistencia);
        }else{
            //cuando no leyó una fila - significa que no hay datos en BBDD
            p1 = null;
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return p1;
    }
    public List<Producto> consultarTodos() throws SQLException {
        Statement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select * from products;";
        List<Producto> resultado = new ArrayList<>();
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.createStatement();
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery(sqlSentencia);
        //4. Verificar si hay resultado
        while(rejilla.next()){
            //Se pudo leer una fila
//            int idProducto;
//            String nombreProducto;
//            double precio;
//            double cantidadExistencia;
//            idProducto = rejilla.getInt("product_id");
//            nombreProducto = rejilla.getString("product_name");
//            precio = rejilla.getDouble("unit_price");
//            cantidadExistencia = rejilla.getDouble("units_in_stock");
            Producto p1 = new Producto(
                    rejilla.getInt("product_id"),
                    rejilla.getString("product_name"),
                    rejilla.getDouble("unit_price"),
                    rejilla.getDouble("units_in_stock"));
            resultado.add(p1);
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public int insertar(Producto p) throws SQLException {
        //1. Declarar variables
        Statement comando;
        int resultado;
        String sql = "insert into products (product_id,product_name, discontinued) " +
                "values ( " + p.getIdProducto() +", '" +
                p.getNombreProducto()+ "', 1);";
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

    public int actualizar(Producto p) throws SQLException {
        //1. Declarar variables
        Statement comando;
        int resultado;
        String sql = "update products set product_name='" + p.getNombreProducto() + "' where product_id = " +
                p.getIdProducto();
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
