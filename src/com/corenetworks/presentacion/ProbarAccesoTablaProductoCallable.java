package com.corenetworks.presentacion;

import com.corenetworks.persistencia.AccesoTablaProducto;

import java.sql.SQLException;

public class ProbarAccesoTablaProductoCallable {
    private static AccesoTablaProducto atp1 = new AccesoTablaProducto();
    public static void main(String[] args) {
        try {
            System.out.println(atp1.consultarResumenCategoria(3));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
