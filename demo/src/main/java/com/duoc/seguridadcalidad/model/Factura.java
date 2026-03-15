package com.duoc.seguridadcalidad.model;

public class Factura {

    private int id;
    private String paciente;
    private String servicio;
    private String medicamento;
    private double costoServicio;
    private double costoMedicamento;
    private double otrosCargos;

    // Constructor vacío
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(int id, String paciente, String servicio, String medicamento,
            double costoServicio, double costoMedicamento, double otrosCargos) {
        this.id = id;
        this.paciente = paciente;
        this.servicio = servicio;
        this.medicamento = medicamento;
        this.costoServicio = costoServicio;
        this.costoMedicamento = costoMedicamento;
        this.otrosCargos = otrosCargos;
    }

    // Método para calcular el total
    public double getTotal() {
        return costoServicio + costoMedicamento + otrosCargos;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public double getCostoMedicamento() {
        return costoMedicamento;
    }

    public void setCostoMedicamento(double costoMedicamento) {
        this.costoMedicamento = costoMedicamento;
    }

    public double getOtrosCargos() {
        return otrosCargos;
    }

    public void setOtrosCargos(double otrosCargos) {
        this.otrosCargos = otrosCargos;
    }

}