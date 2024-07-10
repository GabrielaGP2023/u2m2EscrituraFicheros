package com.corenetworks.presentacion;

import com.corenetworks.persistencia.AccesoTablaDetalleOrdenes;

import java.sql.SQLException;

public class ProbarAccesoTablaDettalleOrden {
    public static void main(String[] args) {
        AccesoTablaDetalleOrdenes atdo1 = new AccesoTablaDetalleOrdenes();
        try {
            System.out.println(atdo1.consultaDeOrden(10248));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
