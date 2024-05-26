package com.example.searchcy.ui.home.endereco.editar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchcy.R;

public class EditarEnderecoFragment extends Fragment {

    private EditarEnderecoViewModel mViewModel;

    public static EditarEnderecoFragment newInstance() {
        return new EditarEnderecoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editar_endereco, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditarEnderecoViewModel.class);
        // TODO: Use the ViewModel
    }

}