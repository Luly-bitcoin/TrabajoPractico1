package com.luu.trabajopractico1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.luu.trabajopractico1.viewmodel.ConversorViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText etEuros, etDolares, etConversion;
    private Button btnConvertir, btnCambiar;
    private TextView txtResultado, txtConversion;
    private RadioButton rbDolares, rbEuros;
    private RadioGroup radioGroup;

    private ConversorViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        etEuros = findViewById(R.id.etEuros);
        etDolares = findViewById(R.id.etDolares);
        btnConvertir = findViewById(R.id.btnConvertir);
        txtResultado = findViewById(R.id.txtResultado);
        txtConversion = findViewById(R.id.etConversion);
        rbDolares = findViewById(R.id.rbDolares);
        rbEuros = findViewById(R.id.rbEuros);
        radioGroup = findViewById(R.id.radioGroup);
        etConversion = findViewById(R.id.etConversion);
        btnCambiar = findViewById(R.id.btnCambiar);

        viewModel = new ViewModelProvider(this).get(ConversorViewModel.class);

        viewModel.getResultado().observe(this, resultado -> {
            txtResultado.setText("Resultado: " + resultado);
        });

        viewModel.getValorConversion().observe(this, valor -> {
            txtConversion.setText(valor);
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == R.id.rbDolares) {
                etEuros.setEnabled(true);
                etDolares.setEnabled(false);
                etDolares.setText("");
            }

            if (checkedId == R.id.rbEuros) {
                etDolares.setEnabled(true);
                etEuros.setEnabled(false);
                etEuros.setText("");
            }
        });

        btnConvertir.setOnClickListener(v -> {

            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
                return;
            }

            if (rbDolares.isChecked()) {
                String valor = etEuros.getText().toString();

                if (valor.isEmpty()) {
                    Toast.makeText(this, "Ingrese valor en Euros", Toast.LENGTH_SHORT).show();
                    return;
                }

                double euros = Double.parseDouble(valor);
                viewModel.convertirADolares(euros);
            }

            if (rbEuros.isChecked()) {
                String valor = etDolares.getText().toString();

                if (valor.isEmpty()) {
                    Toast.makeText(this, "Ingrese valor en Dólares", Toast.LENGTH_SHORT).show();
                    return;
                }

                double dolares = Double.parseDouble(valor);
                viewModel.convertirAEuros(dolares);
            }

            btnCambiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String valor = etConversion.getText().toString();

                    if (valor.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Ingrese el nuevo valor", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {
                        double nuevoValor = Double.parseDouble(valor);
                        viewModel.cambiarTipoCambio(nuevoValor);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Valor inválido", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            viewModel.getValorConversion().observe(this, valor -> {
                etConversion.setText(valor.replace("1 USD = ", "").replace(" EUR", ""));
            });
        });
    }
}