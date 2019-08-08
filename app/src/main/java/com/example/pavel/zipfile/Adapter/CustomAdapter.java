package com.example.pavel.zipfile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.pavel.zipfile.Model.Model;
import com.example.pavel.zipfile.R;
import com.example.pavel.zipfile.SecondActivity;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.EventsHolder> {

    private List<Model> list;
    private final String TAG = "myLog";
    private Context context;


    public CustomAdapter(List<Model> list,Context context) {
        this.list = list;
        this.context =context;
    }

    @NonNull
    @Override
    public CustomAdapter.EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model,parent,false);
        return new EventsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
        Model model = list.get(position);
        holder.txt_adress.setText(model.getAdress());
        holder.txt_fio.setText((!model.getFio().isEmpty()) ? model.getFio():"NoName");
        holder.txt_count.setText(Long.toString(model.getId()));
        holder.cardView.setBackgroundColor(Color.parseColor(color()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("value",model);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_fio)
        TextView txt_fio;
        @BindView(R.id.txt_adress)
        TextView txt_adress;
        @BindView(R.id.txt_count)
        TextView txt_count;
        @BindView(R.id.card_view)
        CardView cardView;


        public EventsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public String color(){
        Random random = new Random();
        String [] colors = {"#f06292","#aed582","#80c783","#4cb6ac",
                "#4dd0e2","#64b5f4","#a0887e","#90a4ad",
                "#ffb64d","#ffd54f","#ff8b66","#9675ce","#e57373"};
        String str = "";
        str = colors[random.nextInt(colors.length)];
        return str;
    }
}
