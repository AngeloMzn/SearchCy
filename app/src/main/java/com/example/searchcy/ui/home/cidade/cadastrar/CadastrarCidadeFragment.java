package com.example.searchcy.ui.home.cidade.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchcy.databinding.FragmentCadastrarCidadeBinding;

public class CadastrarCidadeFragment extends Fragment {

    private CadastrarCidadeViewModel mViewModel;
    private FragmentCadastrarCidadeBinding binding;
    public static CadastrarCidadeFragment newInstance() {
        return new CadastrarCidadeFragment();
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