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

import java.util.ArrayList;

public class TelaListaRacoes extends AppCompatActivity {

    Button novaracao;
    ListView listaracoes;
    Databasehelper helper;
    ArrayList <Racao> racoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_racoes);

        listaracoes = (ListView) findViewById(R.id.ListViewListaRacoes);
        novaracao = (Button) findViewById(R.id.buttonNovaRacao);
        racoes = new ArrayList<>();
        helper = new Databasehelper(this);


        ArrayAdapter <String> racoesadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listarRacoes());

        listaracoes.setAdapter(racoesadapter);

        novaracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaRacoes.this,TelaCadastroRacoes.class));
            }
        });
    }

    protected String[] listarRacoes(){

            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT _id,marca,quantidade,tipo,porte FROM racoes",null);
            String [] resultado = new String[cursor.getCount()];
            cursor.moveToFirst();
            for(int i=0; i < cursor.getCount();i++)
            {
                //racoes.add(new Racao(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4)));
                resultado[i] = cursor.getString(1);
                cursor.moveToNext();
            }
            cursor.close();
            return resultado;
    }

    @Override
    protected void onDestroy(){
        helper.close();
        super.onDestroy();
    }
}