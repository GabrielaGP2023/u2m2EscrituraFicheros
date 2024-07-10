package com.corenetworks.modelo;

public class DetalleOrden {

    private int orderId;
    private int productoId;
    private float precio;
    private int cantidad;
    private float descuento;

    @Override
    public String toString() {
        return "DetalleOrden{" +
                "orderId=" + orderId +
                ", productoId=" + productoId +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", descuento=" + descuento +
                '}';
    }

    public DetalleOrden() {
    }

    public DetalleOrden(int orderId, int productoId, float precio, int cantidad, float descuento) {
        this.orderId = orderId;
        this.productoId = productoId;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
