package br.com.aula.teste;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sobrepeso extends AppCompatActivity {

    private TextView textResultado1, textResultado2;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);

        // Recupera os valores passados pela Intent
        // Recupera os valores passados pela Intent
        String resultado1 = getIntent().getStringExtra("resultado1");
        String resultado2 = getIntent().getStringExtra("resultado2");

        // Atualiza os TextViews com os resultados
        textResultado1 = findViewById(R.id.textResultado1);
        textResultado2 = findViewById(R.id.textResultado2);

        textResultado1.setText(resultado1);
        textResultado2.setText(resultado2);

        // Fechar Activity4
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view ->{
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}