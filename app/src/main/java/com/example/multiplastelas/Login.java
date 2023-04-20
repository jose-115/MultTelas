package com.example.multiplastelas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity{

    Button voltar,logar;
    EditText nome,senha;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        voltar = findViewById(R.id.btVoltar);
        logar = findViewById(R.id.btLogar);
        nome  = findViewById(R.id.tvNome);
        senha = findViewById(R.id.tvSenha);



        nome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) nome;
                if(hasWindowFocus() && nome instanceof EditText){
                    if (plainText.getText().toString().equals("Nome")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = nome.getText().toString().trim();
                        if (text.isEmpty()) {
                            nome.setText("Nome");
                        }
                    }
                }
            }
        });

        senha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasWindowFocus() && senha instanceof EditText){
                    EditText plainText = (EditText) senha;
                    if (plainText.getText().toString().equals("Senha")) {
                        plainText.setText("");
                        plainText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }

                    if (!hasFocus) {
                        String text = senha.getText().toString().trim();
                        if (text.isEmpty()) {
                            plainText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                            senha.setText("Senha");
                        }
                    }
                }
            }
        });

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Usernome,Usersenha;
                Usernome = nome.getText().toString().trim();
                Usersenha = senha.getText().toString().trim();
                if(Usernome.isEmpty() || Usernome.equals("Name") || Usersenha.equals("Senha") || Usersenha.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login efetuado com Sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}
