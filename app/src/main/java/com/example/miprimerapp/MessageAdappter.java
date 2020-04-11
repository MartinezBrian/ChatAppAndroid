package com.example.miprimerapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;


import java.util.List;

public class MessageAdappter extends RecyclerView.Adapter<MessageAdappter.MessageViewHolder> {

        private List<Message> list;
        public MessageAdappter(List<Message> list) {
            super();
            this.list=list;
        }

        @NonNull
        @Override
        public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_messaa,parent,false);
            return new MessageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
            Message message = this.list.get(position);
            holder.text.setText(message.text);
        }

        @Override
        public int getItemCount() {
          return this.list.size();
        }

          public class MessageViewHolder extends RecyclerView.ViewHolder{

            public TextView text;
            public MessageViewHolder (View view){
                super(view);
                this.text = view.findViewById(R.id.Mensaje);

            }

        }
}
