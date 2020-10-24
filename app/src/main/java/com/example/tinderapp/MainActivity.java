package com.example.tinderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(R.drawable.pic1, "Ingener"));
        cards.add(new Card(R.drawable.pic2, "Roza Robot"));
        cards.add(new Card(R.drawable.pic3, "Zhilin"));
        cards.add(new Card(R.drawable.pic4, "Sapogov"));
        cards.add(new Card(R.drawable.pic5, "Zhyrnalist"));
        cards.add(new Card(R.drawable.pic6, "Shershnyaga"));
        cards.add(new Card(R.drawable.pic7, "Vosmiglazova"));
        cards.add(new Card(R.drawable.pic8, "Lalalei"));
        cards.add(new Card(R.drawable.pic9, "Strelnikova"));
        cards.add(new Card(R.drawable.pic10, "Asoba"));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cards_holder);
        recyclerView.setLayoutManager(new TinderLayoutManager(this));
        CardsAdapter adapter = new CardsAdapter(this, cards);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new TinderCardTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }
}