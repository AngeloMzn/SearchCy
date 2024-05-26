package com.example.searchcy.ui.home.cidade.editar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchcy.R;

public class EditarCidadeFragment extends Fragment {

    private EditarCidadeViewModel mViewModel;

    public static EditarCidadeFragment newInstance() {
        return new EditarCidadeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editar_cidade, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditarCidadeViewModel.class);
        // TODO: Use the ViewModel
    }

}