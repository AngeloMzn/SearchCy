package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarEnderecoBinding;
import com.example.searchcy.ui.home.endereco.EnderecoViewModel;

public class CadastrarEndereco extends Fragment {

    private CadastrarEnderecoViewModel mViewModel;

    public static CadastrarEndereco newInstance() {
        return new CadastrarEndereco();
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