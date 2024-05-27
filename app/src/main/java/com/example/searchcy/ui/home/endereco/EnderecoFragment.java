package com.example.searchcy.ui.home.endereco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Usuario;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentEnderecoBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        listViewEndereco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Endereco enderecoSelecionado = enderecos.get(position);
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                Bundle bundle = new Bundle();
                bundle.putInt("enderecoId", enderecoSelecionado.getId());
                navController.navigate(R.id.action_navigation_home_to_editarEnderecoFragment, bundle);
            }
        });

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButtonEndereco);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.action_navigation_home_to_cadastrarEnderecoFragment);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}