package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaListaRacoes extends AppCompatActivity {

    Button novaracao;
    ListView listaracoes;
    Databasehelper helper;
    String [] racoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_racoes);

        listaracoes = (ListView) findViewById(R.id.ListViewListaRacoes);
        novaracao = (Button) findViewById(R.id.buttonNovaRacao);

        //String [] racoes = new String[]{"Premium","Oqsobrou","Filhotes"};
        racoes = listarRacoes();

        ArrayAdapter <String> racoesadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,racoes);

        listaracoes.setAdapter(racoesadapter);

        novaracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaRacoes.this,TelaCadastroRacoes.class));
            }
        });
    }

    protected String[] listarRacoes(){
        try{
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT _id,tipo,quantidade,pesopet FROM racoes",null);
            String [] resultado = new String[cursor.getCount()];
            cursor.moveToFirst();
            for(int i=0; i < cursor.getCount();i++)
            {
                resultado[i] = cursor.getString(1);
                cursor.moveToNext();
            }
            cursor.close();
            return resultado;
        }
        finally {
            String [] falha = new String[]{"falha","falha2","falha3"};
            return falha;
        }

    }
}