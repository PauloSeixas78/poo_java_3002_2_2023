package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroRacoes extends AppCompatActivity {

    EditText marca;
    EditText quantidade;
    Spinner tipo;
    Spinner porte;
    Button   salvarracao;
    Databasehelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_racoes);


        marca = (EditText) findViewById(R.id.editTextTelaCadastroRacaoMarca);
        quantidade = (EditText) findViewById(R.id.editTextTelaCadstroRacaoQuantidade);
        tipo = (Spinner) findViewById(R.id.spinnerTelaCadastroRacaoTipo);
        porte = (Spinner) findViewById(R.id.spinnerTelaCadastroRacaoPorte);
        salvarracao = (Button) findViewById(R.id.buttonNovaRacao);

        helper = new Databasehelper(this);


    }

    public void CriarRacao(View view){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("marca",marca.getText().toString());
        valores.put("quantidade",quantidade.getText().toString());
        valores.put("tipo", tipo.getSelectedItem().toString());
        valores.put("porte", porte.getSelectedItem().toString());

        long resultado = db.insert("racoes",null,valores);

        if (resultado != -1) {
            Toast.makeText(this,"Racao Salva",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"falha ao salvar",Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(TelaCadastroRacoes.this, TelaListaRacoes.class));

    }

    @Override
    protected void onDestroy(){
        helper.close();
        super.onDestroy();
    }



}