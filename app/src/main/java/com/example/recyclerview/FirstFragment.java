package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements WordsAdapter.PasarElemento{
    private FragmentFirstBinding binding;
    private List<String> listado = new ArrayList<>();
    private Bundle bundle = new Bundle();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WordsAdapter adapter = new WordsAdapter(wordList(), this);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listado.add("Palabra " + listado.size());
                binding.rv.getAdapter().notifyItemInserted(listado.size());
                binding.rv.smoothScrollToPosition(listado.size());
            }
        });
    }

    private List<String> wordList(){
        for (int i = 0; i < 50; i++ ){
            listado.add("Palabra " + i);
        }
        return listado;
    }

    @Override
    public void passElement(String elemento) {
        Log.d("PASARELEMENTO", elemento);
        bundle.putString("param1", elemento);
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}