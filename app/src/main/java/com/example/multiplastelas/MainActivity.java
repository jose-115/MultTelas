package com.example.multiplastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login, cadastro, sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btLogin);
        cadastro = findViewById(R.id.btCadastro);
        sobre = findViewById(R.id.btSobre);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Login.class);
                startActivity(it);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(it);
            }
        });

        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Sobre.class);
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