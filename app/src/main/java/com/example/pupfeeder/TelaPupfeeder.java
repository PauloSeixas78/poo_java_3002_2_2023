package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPupfeeder extends AppCompatActivity {

    Button racoes;
    Button animais;
    Button alimentadores;
    Button agendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pupfeeder);

        animais = (Button) findViewById(R.id.buttonAnimais);

        animais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaPupfeeder.this,TelaListagemAnimais.class));
            }
        });


    }
}