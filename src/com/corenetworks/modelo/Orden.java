package com.corenetworks.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Orden {

    private int ordenId;
    private int empleadoId;
    private String clienteId;
    private LocalDate fOrden;

    @Override
    public String toString() {
        return "Orden{" +
                "ordenId=" + ordenId +
                ", empleadoId=" + empleadoId +
                ", clienteId='" + clienteId + '\'' +
                ", fOrden=" + fOrden +
                '}';
    }

    public Orden() {
    }

    public Orden(int ordenId, int empleadoId, String clienteId, LocalDate fOrden) {
        this.ordenId = ordenId;
        this.empleadoId = empleadoId;
        this.clienteId = clienteId;
        this.fOrden = fOrden;
    }

    public int getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(int ordenId) {
        this.ordenId = ordenId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getfOrden() {
        return fOrden;
    }

    public void setfOrden(LocalDate fOrden) {
        this.fOrden = fOrden;
    }
}
