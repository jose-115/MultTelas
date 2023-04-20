package com.example.multiplastelas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    Button voltar, cad;
    EditText usuario, senhaCad, nome, sexo, data, telefone;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        voltar = findViewById(R.id.btVoltar);
        usuario = findViewById(R.id.tvUsuario);
        senhaCad = findViewById(R.id.tvSenha);
        cad = findViewById(R.id.btCad);
        nome = findViewById(R.id.tvNome3);
        data = findViewById(R.id.tvDate);
        telefone = findViewById(R.id.tvTelefone2);




        usuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) usuario;
                if(hasWindowFocus() && usuario instanceof EditText){
                    if (plainText.getText().toString().equals("Usuário")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = usuario.getText().toString().trim();
                        if (text.isEmpty()) {
                            usuario.setText("Usuário");
                        }
                    }
                }
            }
        });

        senhaCad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasWindowFocus() && senhaCad instanceof EditText){
                    EditText plainText = (EditText) senhaCad;
                    if (plainText.getText().toString().equals("Senha")) {
                        plainText.setText("");
                        plainText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }

                    if (!hasFocus) {
                        String text = senhaCad.getText().toString().trim();
                        if (text.isEmpty()) {
                            plainText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                            senhaCad.setText("Senha");
                        }
                    }
                }
            }
        });

        nome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) nome;
                if(hasWindowFocus() && nome instanceof EditText){
                    if (plainText.getText().toString().equals("Usuário")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = nome.getText().toString().trim();
                        if (text.isEmpty()) {
                            nome.setText("Usuário");
                        }
                    }
                }
            }
        });


        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserUser,Usersenha, UserName;
                UserUser = usuario.getText().toString().trim();
                Usersenha = senhaCad.getText().toString().trim();
                UserName = nome.getText().toString().trim();

                if(UserUser.isEmpty() || UserUser.equals("Name") || Usersenha.equals("Senha") || Usersenha.isEmpty() || UserName.isEmpty() || UserName.equals("Name")){
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Registro efetuado com Sucesso!", Toast.LENGTH_SHORT).show();
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
