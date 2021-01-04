package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WordItemListBinding;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder>{
    private List<String> wordList;
    private PasarElemento pasarElemento;



    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding wBinding){
            super(wBinding.getRoot());
            textView = wBinding.textView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = wordList.get(position);
            //Toast.makeText(v.getContext(), element, Toast.LENGTH_SHORT).show();
            wordList.set(position, element + " clic!");
            notifyDataSetChanged();

            pasarElemento.passElement(element);
        }
    }

    public interface PasarElemento{
        void passElement(String elemento);
    }

    public WordsAdapter(List<String> wordList, PasarElemento pasarElemento){
        this.wordList = wordList;
        this.pasarElemento = pasarElemento;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding wBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(wBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String palabra = wordList.get(position);
        holder.textView.setText(palabra);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }
}
