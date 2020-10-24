package com.example.tinderapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Card> cards;
    private List<Card> likedCards;
    private Context context;
    CardsAdapter(Context context, List<Card> cards) {
        this.layoutInflater = LayoutInflater.from(context);
        this.cards = cards;
        this.likedCards = new ArrayList<>();
        this.context = context;
        Log.i("CardsAdapter", "Constructor");
    }

    @Override
    public CardsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.tinder_card, parent, false);
        Log.i("CardsAdapter", "OnCreateViewHolder");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardsAdapter.ViewHolder holder, int position) {
        Card card = cards.get(position);
        Log.i("CardsAdapter", "onBindViewHolder");
        holder.imageView.setImageResource(card.image);
        holder.nameView.setText(card.title);
    }

    @Override
    public int getItemCount(){
        return cards.size();
    }

    public boolean onItemMove(int holderPosition, int targetPosition) {
        return true;
    }

    public void onItemDismiss(int holderPosition) {
        cards.remove(holderPosition);
        notifyItemRemoved(holderPosition);
        if (cards.size() == 0) {
            Intent intent = new Intent(context, LikedScreen.class);
            Log.i("Before new Activity", " " + likedCards.size());
            intent.putParcelableArrayListExtra("likedCards", (ArrayList) likedCards);
            context.startActivity(intent);
        }
    }

    public void addCardToLiked(int position) {
        Log.i("CardsAdapter", "AddCardToLiked " + position);
        likedCards.add(cards.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView;

        ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.card_image);
            nameView = (TextView) view.findViewById(R.id.card_text);
            Log.i("ViewHolder", "Constructor");
        }
    }

    public class DrawView extends View {
        public DrawView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.GREEN);
        }
    }
}
