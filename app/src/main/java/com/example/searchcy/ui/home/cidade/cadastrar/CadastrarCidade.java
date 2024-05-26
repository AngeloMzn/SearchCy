package com.example.searchcy.ui.home.cidade.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarCidadeBinding;
import com.example.searchcy.ui.home.cidade.cadastrar.CadastrarCidadeViewModel;

public class CadastrarCidade extends Fragment {

    private CadastrarCidadeViewModel mViewModel;
    private FragmentCadastrarCidadeBinding binding;
    public static CadastrarCidade newInstance() {
        return new CadastrarCidade();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CadastrarCidadeViewModel cadastrarCidadeViewModel = new ViewModelProvider(this).get(CadastrarCidadeViewModel.class);

        binding = FragmentCadastrarCidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}