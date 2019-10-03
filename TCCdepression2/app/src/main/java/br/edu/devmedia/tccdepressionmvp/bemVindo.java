package br.edu.devmedia.tccdepressionmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class bemVindo extends AppCompatActivity {
    private TextView tv_bemVindo;
    private ImageButton ibt_chat, ibt_quiz, ibt_info, ibt_contro;
    private Button btn_sair;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            Toast.makeText(getApplicationContext(), "Bem vindo" + user.getEmail() + "!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent( this, telaLogin.class);
            startActivity(intent);
            finish();
        }

        inicializaComponentes();
        eventoClicks();
    }

    private void eventoClicks() {
        tv_bemVindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bemVindo.this, info.class);
                startActivity(intent);

                finish();
            }
        });

        ibt_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bemVindo.this, info.class);
                startActivity(intent);

                finish();
            }
        });

        ibt_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bemVindo.this, info.class);
                startActivity(intent);

                finish();
            }
        });

        ibt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bemVindo.this, info.class);
                startActivity(intent);

                finish();
            }
        });

        ibt_contro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bemVindo.this, info.class);
                startActivity(intent);

                finish();
            }
        });

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao.logout();
                finish();
            }
        });
    }

    private void inicializaComponentes() {
        tv_bemVindo = (TextView) findViewById(R.id.tv_bemVindo);
        ibt_chat = (ImageButton) findViewById(R.id.ibt_chat);
        ibt_quiz = (ImageButton) findViewById(R.id.ibt_quiz);
        ibt_info = (ImageButton) findViewById(R.id.ibt_info);
        ibt_contro = (ImageButton) findViewById(R.id.ibt_contro);
        btn_sair = (Button) findViewById(R.id.btn_sair);

    }
}
