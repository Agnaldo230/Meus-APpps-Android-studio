package com.agnaldo.calculeitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numero_zero,numero_um,numero_dois,numero_tres,numero_quatro,numero_cinco,numero_seis,
            numero_sete,numero_oito,numero_nove,ponto,soma,subtracao,divisao,multiplicacao,igual,botao_limpar;
    private TextView textExpressao,textResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar() .hide();
        numero_zero.setOnClickListener(this);
        numero_um.setOnClickListener(this);
        numero_dois.setOnClickListener(this);
        numero_tres.setOnClickListener(this);
        numero_quatro.setOnClickListener(this);
        numero_quatro.setOnClickListener(this);
        numero_cinco.setOnClickListener(this);
        numero_seis.setOnClickListener(this);
        numero_sete.setOnClickListener(this);
        numero_oito.setOnClickListener(this);
        numero_nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textExpressao.setText(" ");
                textResultado.setText(" ");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.text_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtEspressao = string.substring(var0,var1);
                    expressao.setText(txtEspressao);
                }
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(textExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longresult = (long) resultado;

                    if (resultado == (double) longresult){
                        textResultado.setText((CharSequence) String.valueOf(longresult));
                    }else{
                        textResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }

            }
        });
    }
    private void IniciarComponentes(){
        numero_zero = findViewById(R.id.numero_zero);
        numero_um = findViewById(R.id.numero_um);
        numero_dois = findViewById(R.id.numero_dois);
        numero_tres = findViewById(R.id.numero_tres);
        numero_quatro = findViewById(R.id.numero_quatro);
        numero_cinco = findViewById(R.id.numero_cinco);
        numero_seis = findViewById(R.id.numero_seis);
        numero_sete = findViewById(R.id.numero_sete);
        numero_oito = findViewById(R.id.numero_oito);
        numero_nove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        textExpressao = findViewById(R.id.text_expressao);
        textResultado = findViewById(R.id.text_resultado);
        backspace = findViewById(R.id.backspace);

    }
    public void AcresentarUmaExpresao (String String,boolean limpar_dados){
        if (textResultado.getText().equals("")){
            textExpressao.setText(" ");
        }
        if (limpar_dados){
            textResultado.setText(" ");
            textExpressao.append(String);
        }else {
            textExpressao.append(textResultado.getText());
            textExpressao.append(String);
            textResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcresentarUmaExpresao("0",true);
                break;
            case R.id.numero_um:
                AcresentarUmaExpresao("1",true);
                break;
            case R.id.numero_dois:
                AcresentarUmaExpresao("2",true);
                break;
            case R.id.numero_tres:
                AcresentarUmaExpresao("3",true);
                break;
            case R.id.numero_quatro:
                AcresentarUmaExpresao("4",true);
                break;
            case R.id.numero_cinco:
                AcresentarUmaExpresao("5",true);
                break;
            case R.id.numero_seis:
                AcresentarUmaExpresao("6",true);
                break;
            case R.id.numero_sete:
                AcresentarUmaExpresao("7",true);
                break;
            case R.id.numero_oito:
                AcresentarUmaExpresao("8",true);
                break;
            case R.id.numero_nove:
                AcresentarUmaExpresao("9",true);
                break;
            case R.id.ponto:
                AcresentarUmaExpresao(".",true);
                break;
            case R.id.soma:
                AcresentarUmaExpresao("+",false);
                break;
            case R.id.subtracao:
                AcresentarUmaExpresao("-",false);
                break;
            case R.id.divisao:
                AcresentarUmaExpresao("/",false);
                break;
            case R.id.multiplicacao:
                AcresentarUmaExpresao("*",false);
                break;
        }
    }
}