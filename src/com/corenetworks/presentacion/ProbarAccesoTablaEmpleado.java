package com.corenetworks.presentacion;

import com.corenetworks.modelo.Empleado;
import com.corenetworks.persistencia.AccesoTablaEmpleados;

import java.sql.SQLException;
import java.util.Scanner;

public class ProbarAccesoTablaEmpleado {
    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaEmpleados ate = new AccesoTablaEmpleados();

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch (opcion){
                case 1-> altaEmpleado();
                case 2-> modificarEmpleado();
                case 3-> {
                    try {
                        System.out.println(ate.consultarTodos());
                    } catch (SQLException e) {
                        e.getMessage();
                    }}
                case 4-> {
                    try {
                        System.out.println( ate.obtenerTotal());
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5-> consultaPorNombre();
                }

        }while (opcion>=1 && opcion <= 5);
    }

    private static void consultaPorNombre() {
        System.out.println("---Consultar por nombre ");
        System.out.println("Escriba las letras del inicio del nombre del empleado");
        String entrada = s1.next();
        try {
            System.out.println(ate.consultarPorNombre(entrada));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarEmpleado() {
        Empleado e1 ;
        System.out.println("---Modificar Empleado ---");
        e1 = pedirDatosEmpleado();
        try {
            System.out.println("Se ha modificado   " + ate.modificar(e1) + " empleado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void altaEmpleado() {
        Empleado e1 ;
        System.out.println("---Alta de Empleado ---");
        e1 = pedirDatosEmpleado();
        try {
            System.out.println("Se ha insertado " + ate.insertar(e1) + " empleado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Empleado pedirDatosEmpleado() {
        Empleado e1 = new Empleado();
        System.out.println("Escriba el id del empleado -> ");
        e1.setId(s1.nextInt());
        s1.nextLine();
        System.out.println("Escriba el nombre del empleado ->");
        e1.setNombre(s1.nextLine());
        System.out.println("Escriba el apellido del empleado -> ");
        e1.setApellido(s1.nextLine());
        return e1;
    }

    private static void mostrarMenu() {

        System.out.println("--- Menu Empleados ---");
        System.out.println("1) Insertar un empleado");
        System.out.println("2) Modificar un empleado");
        System.out.println("3) Consultar todos los empleados");
        System.out.println("4) Obtener el total de los empleados");
        System.out.println("5) Consultar un empleado por nombre (o parte del nombre)");
        System.out.println("6) Salir");
        System.out.println("Escriba una opcion");
    }

}
