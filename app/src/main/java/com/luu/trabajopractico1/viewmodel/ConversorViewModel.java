package com.luu.trabajopractico1.viewmodel;

import com.luu.trabajopractico1.model.Conversor;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.luu.trabajopractico1.model.Conversor;

public class ConversorViewModel extends ViewModel {

    private Conversor conversor;

    private MutableLiveData<String> resultado = new MutableLiveData<>();
    private MutableLiveData<String> valorConversion = new MutableLiveData<>();

    public ConversorViewModel() {
        conversor = new Conversor();
        actualizarTextoConversion();
    }

    public LiveData<String> getResultado() {
        return resultado;
    }

    public LiveData<String> getValorConversion() {
        return valorConversion;
    }

    private void actualizarTextoConversion() {
        valorConversion.setValue("1 USD = " + conversor.getTipoCambio() + " EUR");
    }

    public void convertirAEuros(double dolares) {
        double res = conversor.convertirADolaresEuros(dolares);
        resultado.setValue(String.valueOf(res));
    }

    public void convertirADolares(double euros) {
        double res = conversor.convertirADolaresEuros(euros);
        resultado.setValue(String.valueOf(res));
    }

    public void cambiarTipoCambio(double nuevoValor) {
        conversor.setTipoCambio(nuevoValor);
        actualizarTextoConversion();
    }
}
