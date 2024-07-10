package com.corenetworks.persistencia;

import com.corenetworks.modelo.Orden;
import com.corenetworks.modelo.Producto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccesoTablaOrdenes extends Conexion{

    public Orden ConsultaUna(int id) throws SQLException {
        PreparedStatement comando;
        ResultSet rejilla;
        String sqlSentencia = "Select * from orders where order_id = ?";
        Orden o1;
        //1. Abrir la conexion
        abrirConexion();
        //2. Creo el statement - se obtiene de la conexión
        comando = miConexion.prepareStatement(sqlSentencia);
        //Asignar valor al parámetro
        comando.setInt(1,id);
        //3. Ejecuto la sentecia
        rejilla = comando.executeQuery();
        //4. Verificar si hay resultado
        if(rejilla.next()){
            //Se pudo leer una fila
             int idEmpleado = rejilla.getInt("employee_id");
             String idCliente = rejilla.getString("customer_id");
             Date fOrden = rejilla.getDate("order_date");
             LocalDate d1 = fOrden.toLocalDate();
             o1 = new Orden(id, idEmpleado, idCliente, d1);
        }else{
            //cuando no leyó una fila - significa que no hay datos en BBDD
            o1 = null;
        }
        //5. obtener cada valor de las columnas
        //6. devolver el resultado
        rejilla.close();
        comando.close();
        cerrarConexion();
        return o1;
    }
}
