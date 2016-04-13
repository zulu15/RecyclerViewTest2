package com.zulu.recyclerviewtest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zulu.recyclerviewtest2.adapter.AnimeAdapter;
import com.zulu.recyclerviewtest2.models.Anime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    Declarar instancias globales
    */
    private List items;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Animes
        items = new ArrayList();

        items.add(new Anime(R.drawable.angel, "Angel Beats", 230));
        items.add(new Anime(R.drawable.death, "Death Note", 456));
        items.add(new Anime(R.drawable.fate, "Fate Stay Night", 342));
        items.add(new Anime(R.drawable.nhk, "Welcome to the NHK", 645));
        items.add(new Anime(R.drawable.suzumiya, "Suzumiya Haruhi", 459));

        recycler = (RecyclerView) findViewById(R.id.recycler_view);
       // recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //lManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(lManager);

        adapter = new AnimeAdapter(items);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());

    }

    public void agregar(View v){
        items.add(1,new Anime(R.drawable.suzumiya, "Suzumiya Haruhi", 459));
        adapter.notifyItemInserted(1);
    }
    public void modificar(View v){

        Anime animeAux = (Anime) items.get(1);
        items.set(1,items.get(2));
        items.set(2, animeAux);

        adapter.notifyItemMoved(1, 2);
    }
    public void eliminar(View v){
        items.remove(0);
        adapter.notifyItemRemoved(0);
    }
}
