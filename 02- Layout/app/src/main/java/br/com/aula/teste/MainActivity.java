package br.com.aula.teste;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view){
        // Instânciamento dos elementos View do meu Arquivo XML
        TextInputEditText campoNome = findViewById(R.id.TextInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.TextInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.TextInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        // Limpando o resultado
        resultado1.setText("");
        resultado2.setText("");
        campoNome.setText("");
        campoPeso.setText("");
        campoAltura.setText("");

        // Extrai dos objetos, recuperando a string que compõem
        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();

        // Convertendo string para númerico
        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numInc = numPeso/(numAltura*numAltura);

        // Converter o resultado numInc para uma String
        String inc = String.valueOf(numInc);

        // Formatação para apresentação do resultado
        DecimalFormat df = new DecimalFormat("#.##");
        inc = df.format(numInc);

        // Apresentando o resultado para o app já formatado
        resultado1.setText(inc);

    }

    public void limpar(){

    }
}