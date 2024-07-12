package com.corenetworks.presentacion;

import com.corenetworks.modelo.DetalleOrden;
import com.corenetworks.persistencia.AccesoTablaDetalleOrdenes;
import com.corenetworks.persistencia.AccesoTablaOrdenes;
import com.corenetworks.persistencia.AccesoTablaProducto;

import java.sql.SQLException;
import java.util.Scanner;

public class ProbarAccesoTablaDettalleOrden {

    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaDetalleOrdenes atdo1 = new AccesoTablaDetalleOrdenes();
    private static AccesoTablaOrdenes ato1 = new AccesoTablaOrdenes();
    private static AccesoTablaProducto atp1 = new AccesoTablaProducto();

    public static void main(String[] args) {
        //Mostrar un menú
        //Solicitar los datos por el Scanner
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch (opcion){
                case 1-> consultaPorOrden();
                case 2-> consultaPorProducto();
                case 3-> altaDetalleOrden();
                case 4-> modificarDetalleOrden();
                case 5-> eliminarDetalleOrden();


            }

        }while (opcion>=1 && opcion <= 5);
    }

    private static void eliminarDetalleOrden() {
        System.out.println("Eliminar detalle de Orden");
        System.out.println("Escriba el id de la orden->");
        int idOrden = s1.nextInt();
        System.out.println("Escriba el id del producto");
        int idProducto = s1.nextInt();
        try {
            atdo1.eliminarDetalleOrden(idOrden,idProducto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarDetalleOrden() {
        System.out.println("---Modificar Detalle Orden ---");
        try {
            System.out.println("Se ha modificado "+ atdo1.modificarDetalleOrden(solicitarDatos()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static DetalleOrden solicitarDatos(){
        System.out.println("Escriba un número de orden -> ");
        int orderId = s1.nextInt();
        try {
            if(ato1.ConsultaUna(orderId)==null){
                System.out.println("La orden no existe, se va regrasar al menu principal");
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Escriba un número de producto ->");
        int productoId = s1.nextInt();
        try {
            if(atp1.consultarUno(productoId)==null){
                System.out.println("El producto no existe, se va regrasar al menu principal");
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Escriba un precio ->");
        float precio = s1.nextFloat();
        System.out.println("Escriba una cantidad -> ");
        int cantidad = s1.nextInt();
        System.out.println("Escriba el descuento-> ");
        float descuento = s1.nextFloat();
        DetalleOrden do1 = new DetalleOrden(orderId,productoId,precio,cantidad,descuento);
        return do1;
    }

    private static void altaDetalleOrden() {
        System.out.println("---Alta Detalle Orden---");
        try {
            System.out.println("Se ha insertado "+ atdo1.altaDetalleOrden(solicitarDatos()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void consultaPorProducto() {
        System.out.println("---Consulta por Producto ---");
        System.out.println("Escriba el producto para ver sus estadisticas ");
        int idProducto = s1.nextInt();
        try {
            System.out.println(atdo1.consultaPorProducto(idProducto));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void consultaPorOrden() {
        System.out.println("---Consulta por Orden ---");
        System.out.println("Escriba la orden de la cual quiere consultar sus productos ->");
        int idOrden = s1.nextInt();
        try {
            System.out.println(atdo1.consultaDeOrden(idOrden));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMenu() {

        System.out.println("--- Menu Detalle de Ordenes ---");
        System.out.println("1) Consultar el detalle por Ordenes ");
        System.out.println("2) Consultar estadisticas de venta por Producto ");
        System.out.println("3) Insertar detalle de orden ");
        System.out.println("4) Modificar detalle de orden ");
        System.out.println("5) Borrar detalle de orden ");

        System.out.println("6) Salir");
        System.out.println("Escriba una opcion");
    }
}
