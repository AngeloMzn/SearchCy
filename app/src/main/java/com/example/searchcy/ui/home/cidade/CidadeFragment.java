package com.example.searchcy.ui.home.cidade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.searchcy.databinding.FragmentCidadeBinding;

public class CidadeFragment extends Fragment {

private FragmentCidadeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        CidadeViewModel cidadeViewModel =
                new ViewModelProvider(this).get(CidadeViewModel.class);

    binding = FragmentCidadeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}