package com.example.searchcy.ui.home.usuarios.editar;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchcy.Core.Util;
import com.example.searchcy.Model.Usuario;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarEnderecoBinding;
import com.example.searchcy.databinding.FragmentEditarUsuarioBinding;
import com.example.searchcy.ui.home.usuarios.UsuarioViewModel;
import com.example.searchcy.ui.main.MainActivity;

import java.util.ArrayList;

public class EditarUsuarioFragment extends Fragment {

    private EditText editTextNameEditar;
    private EditText editTextEmailEditar;
    private EditText editTextPasswordEditar;
    private Button btn_salvarUsuario;
    private Button btn_excluirUsuario;
    private FragmentEditarUsuarioBinding binding;

    public static EditarUsuarioFragment newInstance() {
        return new EditarUsuarioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        EditarUsuarioViewModel editarUsuarioViewModel = new ViewModelProvider(this).get(EditarUsuarioViewModel.class);
        int userId = getArguments().getInt("usuarioId");

        binding = FragmentEditarUsuarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Usuario user = editarUsuarioViewModel.listarUsuarioPeloId(userId, requireActivity().getApplication());
        Log.i("sla", "Valor da minhaVariavel: " + userId);

        editTextNameEditar = root.findViewById(R.id.editTextNameEditar);
        editTextEmailEditar = root.findViewById(R.id.editTextEmailEditar);
        editTextPasswordEditar = root.findViewById(R.id.editTextPasswordEditar);
        btn_salvarUsuario = root.findViewById(R.id.btn_salvarUsuario);
        btn_excluirUsuario = root.findViewById(R.id.btn_excluirUsuario);

        editTextNameEditar.setText(user.getNome());
        editTextEmailEditar.setText(user.getEmail());
        editTextPasswordEditar.setText(user.getPassword());

        btn_salvarUsuario.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String password = editTextNameEditar.getText().toString();
                        String email = editTextEmailEditar.getText().toString();
                        String nome = editTextPasswordEditar.getText().toString();

                        ArrayList<Object> infoList = new ArrayList<>();
                        infoList.add(password);
                        infoList.add(email);
                        infoList.add(nome);

                        Util util = new Util();

                        if (util.validateInfo(infoList)) {
                            if(util.validateEmail(email) ){
                                user.setPassword(password);
                                user.setEmail(email);
                                user.setNome(nome);

                                editarUsuarioViewModel.atualizarUsuario(user, requireActivity().getApplication());
                                Toast.makeText(getActivity(), "Usuario atualizado com sucesso !", Toast.LENGTH_SHORT).show();

                                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                                navController.popBackStack();
                            }else{
                                Toast.makeText(getActivity(), "O email está com um formato incorreto, por favor insira um email válido.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btn_excluirUsuario.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editarUsuarioViewModel.excluirUsuario(user, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Usuario excluído com sucesso !", Toast.LENGTH_SHORT).show();
                        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                        navController.popBackStack();
                    }
                }
        );

        return root;
    }




}