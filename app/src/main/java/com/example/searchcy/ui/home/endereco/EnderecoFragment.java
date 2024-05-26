package com.example.searchcy.ui.home.endereco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Usuario;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentEnderecoBinding;

import java.util.ArrayList;
import java.util.List;


public class EnderecoFragment extends Fragment {

    private ListView listViewEndereco;
    private FragmentEnderecoBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EnderecoViewModel enderecoViewModel = new ViewModelProvider(this).get(EnderecoViewModel.class);

        binding = FragmentEnderecoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewEndereco = root.findViewById(R.id.listViewEndereco);
        List<String> descricaoEnderecos = new ArrayList<String>();

        List<Endereco> enderecos =  enderecoViewModel.listarEnderecos(requireActivity().getApplication());
        for (Endereco endereco : enderecos) {
            descricaoEnderecos.add(endereco.getDescricao());
        }

        ArrayAdapter<String> listViewEnderecoAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, descricaoEnderecos);
        listViewEndereco.setAdapter(listViewEnderecoAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}