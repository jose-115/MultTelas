package com.example.multiplastelas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sobre extends AppCompatActivity {
    Button voltar, ufms, gith, gitj, editar;
    EditText editTexto;
    TextView sobreTxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);

        voltar = findViewById(R.id.btVoltar);
        ufms = findViewById(R.id.btUfms);
        gith = findViewById(R.id.btGith);
        gitj = findViewById(R.id.btGitj);
        editTexto = findViewById(R.id.editTexto);
        sobreTxt = findViewById(R.id.tvSobreTxt);
        editar = findViewById(R.id.btEditar);

        editTexto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                EditText plainText = (EditText) editTexto;
                if(hasWindowFocus() && editTexto instanceof EditText){
                    if (plainText.getText().toString().equals("Editar o sobre")) {
                        plainText.setText("");
                    }

                    if (!hasFocus) {
                        String text = editTexto.getText().toString().trim();
                        if (text.isEmpty()) {
                            editTexto.setText("Editar o sobre");
                        }
                    }
                }
            }
        });

        gith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/Higor335");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plainText = (EditText) editTexto;
                String novoTexto = plainText.getText().toString();
                if (!novoTexto.equals("Editar o sobre")) {
                    sobreTxt.setText(novoTexto);
                }
            }
        });

        gitj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/jose-115");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ufms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.ufms.br/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });

        //Verifica se há uma instancia salva
        if (savedInstanceState != null) {
            String textoSobre = savedInstanceState.getString(TEXTO_SOBRE);
            sobreTxt.setText(textoSobre);
        }

    }

    //Salvar estado da tela
    private static final String TEXTO_SOBRE = "textoSobre";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String textoSobre = sobreTxt.getText().toString();
        outState.putString(TEXTO_SOBRE, textoSobre);
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
