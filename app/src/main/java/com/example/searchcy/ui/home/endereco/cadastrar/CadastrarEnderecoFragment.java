package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchcy.databinding.FragmentCadastrarEnderecoBinding;

public class CadastrarEnderecoFragment extends Fragment {

    private CadastrarEnderecoViewModel mViewModel;

    public static CadastrarEnderecoFragment newInstance() {
        return new CadastrarEnderecoFragment();
    }

    private FragmentCadastrarEnderecoBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CadastrarEnderecoViewModel cadastrarEnderecoViewModel = new ViewModelProvider(this).get(CadastrarEnderecoViewModel.class);

        binding = FragmentCadastrarEnderecoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textViewEndereco;
        //cadastrarEnderecoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}