package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtComprimento , edtLargura, edtJanelas, edtAltura, edtRendimento, edtPreco;
    TextView txtResposta1, txtResposta2;
    RadioGroup rbgrupo;
    RadioButton rbsim, rbnao;
    CheckBox ch1, ch2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtComprimento = findViewById(R.id.edtComprimento);
        edtLargura = findViewById(R.id.edtLargura);
        edtJanelas = findViewById(R.id.edtJanelas);
        edtAltura = findViewById(R.id.edtAltura);
        rbgrupo = findViewById(R.id.rbgrupo);
        rbsim = findViewById(R.id.rbsim);
        rbnao = findViewById(R.id.rbnao);
        ch1 = findViewById(R.id.ch1);
        ch1 = findViewById(R.id.ch2);
        edtRendimento = findViewById(R.id.edtRedimento);
        txtResposta1 = findViewById(R.id.txtResposta1);
        txtResposta2 = findViewById(R.id.txtResposta2);
        edtPreco = findViewById(R.id.edtPreco);

    }

        public void calcular(View view) {

                int ValorTeto, ValorDemao=1, janela;
                float metroq;
                double area;
                double janela1;
                float largura, preco, rendimento, comprimento, altura;

                comprimento = Float.parseFloat(edtComprimento.getText().toString());
                largura = Float.parseFloat(edtLargura.getText().toString());
                janela1 = Double.parseDouble(edtJanelas.getText().toString());
                rendimento = Float.parseFloat((edtRendimento.getText().toString()));
                preco = Float.parseFloat((edtPreco.getText().toString()));
                altura = Float.parseFloat(edtAltura.getText().toString());

                if (rbsim.isChecked())
                    ValorTeto = 1;
                else

                if(rbnao.isChecked())
                    ValorTeto = 0;

                if (ch1.isChecked())
                    ValorDemao = 1;
                else

                if (ch2.isChecked())
                    ValorDemao = 2;

                metroq = comprimento * largura;
                area = ValorDemao*((metroq/rendimento) - 1.47 - (janela1=1.40));

                txtResposta1.setText(String.format("%.2f", area));
            }
        }
