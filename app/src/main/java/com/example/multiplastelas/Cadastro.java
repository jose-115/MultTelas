package com.example.multiplastelas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
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
                    if (plainText.getText().toString().equals("Nome completo")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = nome.getText().toString().trim();
                        if (text.isEmpty()) {
                            nome.setText("Nome completo");
                        }
                    }
                }
            }
        });


        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) data;
                if(hasWindowFocus() && data instanceof EditText){
                    if (plainText.getText().toString().equals("Ex: 01/01/2001")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = data.getText().toString().trim();
                        if (text.isEmpty()) {
                            data.setText("Ex: 01/01/2001");
                        }
                    }
                }
            }
        });

        telefone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) telefone;
                if(hasWindowFocus() && telefone instanceof EditText){
                    if (plainText.getText().toString().equals("Ex: (67)9999-9999")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = telefone.getText().toString().trim();
                        if (text.isEmpty()) {
                            telefone.setText("Ex: (67)9999-9999");
                        }
                    }
                }
            }
        });


        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserUser,Usersenha, UserName, UserDate, UserTele;
                UserUser = usuario.getText().toString().trim();
                Usersenha = senhaCad.getText().toString().trim();
                UserName = nome.getText().toString().trim();
                UserDate = data.getText().toString().trim();
                UserTele = telefone.getText().toString().trim();
                if(UserUser.isEmpty() || UserUser.equals("Usuário") || Usersenha.equals("Senha") || Usersenha.isEmpty() || UserName.isEmpty() || UserName.equals("Nome completo") || UserName.isEmpty() || UserName.equals("Nome completo") || UserDate.isEmpty() || UserDate.equals("Ex: 01/01/2001") || UserTele.isEmpty() || UserTele.equals("Ex: (67)9999-9999")){
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

    protected void onStart(){
        super.onStart();
        Log.i("APP","ON START");
    }

    protected void onResume(){
        super.onResume();
        Log.i("APP","ON RESUME");
    }

    protected void onPause(){
        super.onPause();
        Log.i("APP","ON PAUSE");
    }

    protected void onStop(){
        super.onStop();
        Log.i("APP","ON STOP");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.w("APP","ON DESTROY");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("APP","ON RESTART");
    }
}
