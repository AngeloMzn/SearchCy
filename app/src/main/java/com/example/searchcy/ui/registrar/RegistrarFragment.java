package com.example.searchcy.ui.registrar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.searchcy.databinding.FragmentRegistrarBinding;

public class RegistrarFragment extends Fragment {

private FragmentRegistrarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        RegistrarViewModel registrarViewModel =
                new ViewModelProvider(this).get(RegistrarViewModel.class);

    binding = FragmentRegistrarBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        registrarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}