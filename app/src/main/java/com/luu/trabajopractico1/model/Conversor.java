package com.luu.trabajopractico1.model;

public class Conversor {

    private double tipoCambio;

    public Conversor(){
        tipoCambio = 0.92;
    }

    public double getTipoCambio(){
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio){
        this.tipoCambio = tipoCambio;
    }

    public double convertirAEuros(double euros){
        return euros / tipoCambio;
    }

    public double convertirADolaresEuros(double dolares){
        return dolares * tipoCambio;
    }
}