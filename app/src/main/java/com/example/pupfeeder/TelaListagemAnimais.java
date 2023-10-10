package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaListagemAnimais extends AppCompatActivity {

    Button cadastrarAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listagem_animais);

        cadastrarAnimal = (Button) findViewById(R.id.buttonCadastrarAnimal);


        cadastrarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListagemAnimais.this, TelaCadastroAnimais.class));
            }
        });
    }
}