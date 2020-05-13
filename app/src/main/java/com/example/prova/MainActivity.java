package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
        ch2 = findViewById(R.id.ch2);
        edtRendimento = findViewById(R.id.edtRedimento);
        txtResposta1 = findViewById(R.id.txtResposta1);
        txtResposta2 = findViewById(R.id.txtResposta2);
        edtPreco = findViewById(R.id.edtPreco);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch1.isChecked())
                    ch2.setChecked(false);
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch2.isChecked())
                    ch1.setChecked(false);
            }
        });

    }

        public void calcular(View view) {

                int ValorDemao=1, lata;
                float metroq;
                double area, ValorTeto = 0, janela;
                double janela1, valorReal;
                float largura, preco, rendimento, comprimento, altura;

                comprimento = Float.parseFloat(edtComprimento.getText().toString());
                largura = Float.parseFloat(edtLargura.getText().toString());
                janela1 = Double.parseDouble(edtJanelas.getText().toString());
                rendimento = Float.parseFloat((edtRendimento.getText().toString()));
                preco = Float.parseFloat((edtPreco.getText().toString()));
                altura = Float.parseFloat(edtAltura.getText().toString());

                metroq = (float) ((2*((largura*altura)+(altura*comprimento)))-(2.10*0.70));

                if (ch1.isChecked())
                    ValorDemao = 1;

                if (ch2.isChecked())
                    ValorDemao = 2;

                if (rbsim.isChecked())
                    ValorTeto = largura*comprimento;
                    metroq = (float) (metroq+ValorTeto);

                if (janela1>0)
                    janela1 = janela1*(1.40*1.00);
                    metroq = (float) (metroq-janela1);

                lata = (int) ((metroq*ValorDemao)/rendimento);
                valorReal = lata*preco;

                txtResposta1.setText(String.valueOf(lata));
                txtResposta2.setText(String.valueOf(valorReal));
            }
        }
