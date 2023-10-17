package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaListagemAnimais extends AppCompatActivity {

    Button cadastrarAnimal;

    ListView listaAnimais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listagem_animais);

        cadastrarAnimal = (Button) findViewById(R.id.buttonCadastrarAnimal);

        listaAnimais = (ListView) findViewById(R.id.listViewAnimais);

        String[] animais = new String []{"Tonico", "Tião", "Caramelo", "Brusk", "Satanás"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,animais);

        listaAnimais.setAdapter(adapter);

        listaAnimais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TelaListagemAnimais.this,"teste "+animais[i], Toast.LENGTH_SHORT).show();
            }
        });


        cadastrarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListagemAnimais.this, TelaCadastroAnimais.class));
            }
        });
    }
}