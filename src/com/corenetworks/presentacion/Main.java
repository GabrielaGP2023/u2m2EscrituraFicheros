package com.corenetworks.presentacion;

import com.corenetworks.modelo.Producto;
import com.corenetworks.persistencia.AccesoTablaProducto;
import com.corenetworks.persistencia.Conexion;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int id;

//        Conexion c1 = new Conexion();
//        try {
//            c1.abrirConexion();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        AccesoTablaProducto atp1 = new AccesoTablaProducto();
//        do{
//            System.out.println("Escriba un número de id para consultar ->");
//            id = s1.nextInt();
//            try {
//                System.out.println(atp1.consultarUno(id));
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        } while (id >0);
//        try {
//            System.out.println(atp1.consultarTodos());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        Producto p = new Producto();
        System.out.println("Escriba el id del producto ");
        int id1 = s1.nextInt();
//        s1.nextLine();
//        System.out.println("Escriba el nombre del producto");
//        String nombre = s1.nextLine();

        p.setIdProducto(id1);
//        p.setNombreProducto(nombre);
        try {
            System.out.println(atp1.eliminar(id1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}