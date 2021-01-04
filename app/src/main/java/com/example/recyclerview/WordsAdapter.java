package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WordItemListBinding;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder>{
    private List<String> wordList;

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding wBinding){
            super(wBinding.getRoot());
            textView = wBinding.textView;
        }
    }

    public WordsAdapter(List<String> wordList){
        this.wordList = wordList;
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
