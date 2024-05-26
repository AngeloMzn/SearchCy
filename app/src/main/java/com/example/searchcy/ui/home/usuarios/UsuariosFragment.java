package com.example.searchcy.ui.home.usuarios;

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
import com.example.searchcy.databinding.FragmentUsuariosBinding;

import java.util.ArrayList;
import java.util.List;


public class UsuariosFragment extends Fragment {

    private FragmentUsuariosBinding binding;
    private ListView listViewUsuarios;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        UsuarioViewModel usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        binding = FragmentUsuariosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewUsuarios = root.findViewById(R.id.listViewUsuarios);
        List<String> nomesUsuarios = new ArrayList<String>();

        List<Usuario> usuarios =  usuarioViewModel.listarUsuarios(requireActivity().getApplication());
        for (Usuario usuario : usuarios) {
            nomesUsuarios.add(usuario.getNome());
        }

        ArrayAdapter<String> listViewUsuariosAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, nomesUsuarios);
        listViewUsuarios.setAdapter(listViewUsuariosAdapter);

        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioSelecionado = usuarios.get(position);
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                Bundle bundle = new Bundle();
                bundle.putLong("usuarioId", usuarioSelecionado.getId());
                navController.navigate(R.id.action_navigation_home_to_editarUsuarioFragment, bundle);
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