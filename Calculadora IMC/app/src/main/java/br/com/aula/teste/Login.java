package br.com.aula.teste;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Validação de Entrada

    public void Entrar(View view){

        // Condição de Entrada: Não pode estar vazio

        TextView campoEmail = findViewById(R.id.editTextEmail);
        TextView campoSenha = findViewById(R.id.editTextSenha);
        TextView textErro = findViewById(R.id.textErro);

        String email = Objects.requireNonNull(campoEmail.getText()).toString();
        String senha = Objects.requireNonNull(campoSenha.getText()).toString();

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(senha))
        {
            textErro.setText("ENTRADA INVALIDA!");
        }
        else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
}

}