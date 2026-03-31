package com.luu.trabajopractico1.model;

public class Conversor {

    private double tipoCambio;
    public Conversor(){
        tipoCambio = 0.92; //valor inicila
    }

    public double getTipoCambio(){
        return tipoCambio;
    }

    public void setTipoCambio(double TipoCambio){
        this.tipoCambio = tipoCambio;
    }

    public double convertirAEuros(double euros){
        return euros / tipoCambio;
    }

    public double convertirADolaresEuros (double dolares){
        return dolares * tipoCambio;
    }
}
