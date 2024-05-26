package com.example.searchcy.ui.home.cidade.editar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarCidadeBinding;
import com.example.searchcy.databinding.FragmentEditarCidadeBinding;
import com.example.searchcy.ui.home.cidade.cadastrar.CadastrarCidadeViewModel;

public class EditarCidadeFragment extends Fragment {

    private FragmentEditarCidadeBinding binding;
    public static EditarCidadeFragment newInstance() {
        return new EditarCidadeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        EditarCidadeViewModel editarCidadeViewModel = new ViewModelProvider(this).get(EditarCidadeViewModel.class);
        binding = FragmentEditarCidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Log.i("sla", "Valor da minhaVariavel: " + getArguments().getInt("cidadeId"));
        return inflater.inflate(R.layout.fragment_editar_cidade, container, false);

    }

}