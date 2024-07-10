package com.corenetworks.persistencia;

import com.corenetworks.modelo.DetalleOrden;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoTablaDetalleOrdenes extends Conexion{
    public List<DetalleOrden> consultaDeOrden(int idOrden ) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<DetalleOrden> resultado = new ArrayList<>();
        String sql = "select * from order_details where order_id = ?";
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        comando.setInt(1,idOrden);
        //4. Ejecutar la sentencia
        rejilla = comando.executeQuery();
        //5. Obtener el resultado
        while(rejilla.next()){
            //En caso de que si traiga resultados
            int id = rejilla.getInt("order_id");
            int idProducto = rejilla.getInt("product_id");
            float precio = rejilla.getFloat("unit_price");
            int cantidad = rejilla.getInt("quantity");
            float descuento = rejilla.getFloat("discount");
            DetalleOrden dt1= new DetalleOrden(id,idProducto,precio,cantidad,descuento);
            resultado.add(dt1);
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }
}
