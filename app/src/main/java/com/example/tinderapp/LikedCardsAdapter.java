package com.example.tinderapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LikedCardsAdapter extends RecyclerView.Adapter<LikedCardsAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Card> cards;

    LikedCardsAdapter(Context context, List<Card> cards) {
        this.layoutInflater = LayoutInflater.from(context);
        this.cards = cards;
        Log.i("LinkedCardsAdapter", "Constructor");
    }

    @Override
    public LikedCardsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.liked_item, parent, false);
        Log.i("LinkedCardsAdapter", "onCreateViewHolder");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Card card = cards.get(position);
        Log.i("Image", "onBindViewHolder");
        holder.imageView.setImageResource(card.image);
    }

    @Override
    public int getItemCount () {
        Log.i("LikedCardsAdapter", "getItemCount");
        Log.i("LikedCardsAdapter", " " + cards.size());
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            Log.i("ViewHolder", "constructor");
            imageView = (ImageView) view.findViewById(R.id.liked_image);
        }
    }
}
