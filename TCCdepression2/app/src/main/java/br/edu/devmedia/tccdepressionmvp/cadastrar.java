package br.edu.devmedia.tccdepressionmvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class cadastrar extends AppCompatActivity {
    private EditText cadastroNome, cadastroEmail, cadastroSenha;
    private Button btVoltar, btCadastrar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        inicializaComponentes();
        eventoClicks();
    }

    private void eventoClicks() {
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastrar.this, telaLogin.class);
                startActivity(intent);

                finish();
            }
        });


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = cadastroEmail.getText().toString().trim();
                String senha = cadastroSenha.getText().toString().trim();
                criarUser(email, senha);
            }

        });
    }

    private void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(cadastrar.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            alert("Usuário cadastrado com sucesso!");
                            Intent intent = new Intent(cadastrar.this, bemVindo.class);
                            startActivity(intent);
                            finish();
                        }else{
                            alert("Erro no cadastro!");
                        }
                    }
                });
    }

    private void alert(String msg){
        Toast.makeText(cadastrar.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void inicializaComponentes() {
        cadastroNome = (EditText) findViewById(R.id.cadastroNome);
        cadastroEmail = (EditText) findViewById(R.id.cadastroEmail);
        cadastroSenha = (EditText) findViewById(R.id.cadastroSenha);
        btVoltar = (Button) findViewById(R.id.btVoltar);
        btCadastrar = (Button) findViewById(R.id.btConfirmar);
    }

    @Override
    protected void onStart(){
        super.onStart();
        auth = conexao.getFirebaseAuth();
    }
}


