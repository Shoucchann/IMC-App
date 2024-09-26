package br.com.aula.teste;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void calcular(View view){
        // Instâncionamento dos elementos Views do meu Arquivo XML;
        TextInputEditText campoNome = findViewById(R.id.textoInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.textoInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.textoInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        // extrai dos Objetos, recuperando a String que pompões:
        String nome = Objects.requireNonNull(campoNome.getText()).toString();
        String peso = Objects.requireNonNull(campoPeso.getText()).toString();
        String altura = Objects.requireNonNull(campoAltura.getText()).toString();

        // VALIDAÇÃO ENTRADA ZERADA
        if(TextUtils.isEmpty(nome)||TextUtils.isEmpty(peso) || TextUtils.isEmpty(altura)){
            resultado1.setText("ERRO!");
            resultado2.setText("ENTRADA INVALIDA!");
            return;
        }else {
            // limpar erro
            resultado1.setText("");
            resultado2.setText("");

            // Converter String para Numérico
            Double numPeso = Double.parseDouble(peso);
            Double numAltura = Double.parseDouble(altura);

            // Calcular IMC
            Double numImc = numPeso/(numAltura * numAltura);

            // Converter o resultado nunmImc para String
            String imc = String.valueOf(numImc);

            // Formatação para apresentação do resultado:
            DecimalFormat df = new DecimalFormat("#.##");
            imc = df.format(numImc);

            // Apresentando o resultado para o app já formatado e validação dos dados:
            if(numPeso <= 0 || numPeso >= 595 || numAltura <= 0 || numAltura >= 2.5){
                resultado1.setText("ERRO!");
                resultado2.setText("ENTRADA INVÁLIDA!");
                return;
            }

            // limpar erro
            resultado1.setText("");
            resultado2.setText("");

            // Verificando a classificação do peso
            if(numImc < 18.5) {
                //Chama tela 2
                Intent intent = new Intent(this, BaixoPeso.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Baixo Peso");

                startActivity(intent);

            } else if(numImc >= 18.5 && numImc <= 24.9 ){
                // chama tela 3
                Intent intent = new Intent(this, PesoNormal.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Peso Normal");

                startActivity(intent);
            } else if(numImc>=25 && numImc<=29.9){
                //Chama tela 4
                Intent intent = new Intent(this, Sobrepeso.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Sobrepeso");

                startActivity(intent);
            } else if(numImc>30 && numImc<=34.9){
                //Chamar tela 5
                Intent intent = new Intent(this, ObesidadeI.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Obesidade grau 1");

                startActivity(intent);

            } else if(numImc>35 && numImc<=39.9){
                //Chamar tela 6

                Intent intent = new Intent(this, ObesidadeII.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Obesidade grau 2");

                startActivity(intent);

            }else if(numImc>40){
                //Chamar tela 7
                Intent intent = new Intent(this, ObesidadeExtrema.class);

                // Definição de variável e receber o conteúdo para serem transferidos
                intent.putExtra("resultado1", imc);
                intent.putExtra("resultado2", "Obesidade extrema");

                startActivity(intent);

            }
        }
    }

    public void limpar (View view){
        TextInputEditText campoNome = findViewById(R.id.textoInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.textoInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.textoInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        resultado1.setText("");
        resultado2.setText("");

        campoNome.setText("");
        campoPeso.setText("");
        campoAltura.setText("");
    }

}

