package com.corenetworks.modelo;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precio;
    private double cantidadExistencia;

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", cantidadExistencia=" + cantidadExistencia +
                '}'+ "\n";
    }

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, double precio, double cantidadExistencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadExistencia = cantidadExistencia;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(double cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
}
