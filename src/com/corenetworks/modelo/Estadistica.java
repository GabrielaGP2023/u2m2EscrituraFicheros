package com.corenetworks.modelo;

public class Estadistica {

    private int productoId;
    private double venta;
    private int totalCantidad;

    @Override
    public String toString() {
        return "Estadistica{" +
                "productoId=" + productoId +
                ", venta=" + venta +
                ", totalCantidad=" + totalCantidad +
                '}';
    }

    public Estadistica() {
    }

    public Estadistica(int productoId, double venta, int totalCantidad) {
        this.productoId = productoId;
        this.venta = venta;
        this.totalCantidad = totalCantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public int getTotalCantidad() {
        return totalCantidad;
    }

    public void setTotalCantidad(int totalCantidad) {
        this.totalCantidad = totalCantidad;
    }
}
