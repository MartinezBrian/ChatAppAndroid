package com.example.miprimerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity<list> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent,1);

        RecyclerView lista1 = (RecyclerView)findViewById(R.id.lista1);

        lista1.setHasFixedSize(true);

        RecyclerView.LayoutManager LM = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        lista1.setLayoutManager(LM);

        MessageAdappter AD = new MessageAdappter(getlist());
        lista1.setAdapter((AD));


    }

    public List<Message> getlist (){
        List<Message> result = new ArrayList();
        for(int i= 0; i<1000; i++) {
            result.add(new Message("Mensaje:"+i));
        }
        return result;

    }

}
