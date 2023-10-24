package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroRacoes extends AppCompatActivity {

    EditText descricao;
    EditText quantidade;
    EditText pesoanimal;
    Button   salvarracao;
    Databasehelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_racoes);

        descricao = (EditText) findViewById(R.id.editTextDescricaoRacao);
        quantidade = (EditText) findViewById(R.id.editTextQuantidadeRacao);
        pesoanimal = (EditText) findViewById(R.id.editTextPesoAnimal);
        salvarracao = (Button) findViewById(R.id.buttonNovaRacao);

        helper = new Databasehelper(this);





    }

    public void CriarRacao(View view){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valuesracoes = new ContentValues();
        valuesracoes.put("tipo", pesoanimal.getText().toString());
        valuesracoes.put("pesopet", pesoanimal.getText().toString());
        valuesracoes.put("quantidade",quantidade.getText().toString());

        long resultado = db.insert("racoes",null,valuesracoes);

        if (resultado != -1) {
            Toast.makeText(this,"Racao Salva",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"falha ao salvar",Toast.LENGTH_SHORT).show();
        }



    }



}