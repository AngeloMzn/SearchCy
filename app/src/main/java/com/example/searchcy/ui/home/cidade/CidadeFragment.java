package com.example.searchcy.ui.home.cidade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCidadeBinding;

import java.util.ArrayList;
import java.util.List;

public class CidadeFragment extends Fragment {

    private FragmentCidadeBinding binding;

    private ListView listViewCidade;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        CidadeViewModel cidadeViewModel =
                new ViewModelProvider(this).get(CidadeViewModel.class);

        binding = FragmentCidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewCidade = root.findViewById(R.id.listViewCidade);
        List<String> descricaoCidades = new ArrayList<String>();

        List<Cidade> cidades =  cidadeViewModel.listarCidades(requireActivity().getApplication());
        for (Cidade cidade : cidades) {
            descricaoCidades.add(cidade.getCidade());
        }

        ArrayAdapter<String> listViewEnderecoAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, descricaoCidades);
        listViewCidade.setAdapter(listViewEnderecoAdapter);


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}