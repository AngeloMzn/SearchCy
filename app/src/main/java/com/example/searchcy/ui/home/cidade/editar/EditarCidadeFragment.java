package com.example.searchcy.ui.home.cidade.editar;

import androidx.lifecycle.ViewModelProvider;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchcy.Core.Util;
import com.example.searchcy.Model.Cidade;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarCidadeBinding;
import com.example.searchcy.databinding.FragmentEditarCidadeBinding;
import com.example.searchcy.ui.home.cidade.cadastrar.CadastrarCidadeViewModel;

import java.util.ArrayList;

public class EditarCidadeFragment extends Fragment {

    private FragmentEditarCidadeBinding binding;
    private EditText editTextCityEditar;
    private EditText editTextStateEditar;
    private Button btnSalvarCidade;
    private Button btnDeletarCidade;

    public static EditarCidadeFragment newInstance() {
        return new EditarCidadeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        EditarCidadeViewModel editarCidadeViewModel = new ViewModelProvider(this).get(EditarCidadeViewModel.class);
        binding = FragmentEditarCidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Cidade city = editarCidadeViewModel.listarCidadePeloId(getArguments().getInt("cidadeId"), requireActivity().getApplication());

        editTextCityEditar = root.findViewById(R.id.editTextCityEditar);
        editTextStateEditar = root.findViewById(R.id.editTextStateEditar);
        btnSalvarCidade = root.findViewById(R.id.btnSalvarCidade);
        btnDeletarCidade = root.findViewById(R.id.btnDeletarCidade);

        editTextCityEditar.setText(city.getCidade());
        editTextStateEditar.setText(city.getEstado());

        btnSalvarCidade.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cidade = editTextCityEditar.getText().toString();
                        String estado = editTextStateEditar.getText().toString();

                        ArrayList<Object> infoList = new ArrayList<>();
                        infoList.add(cidade);
                        infoList.add(estado);

                        Util util = new Util();

                        if (util.validateInfo(infoList)) {

                            city.setCidade(cidade);
                            city.setEstado(estado);

                            editarCidadeViewModel.atualizarCidade(city, requireActivity().getApplication());
                            Toast.makeText(getActivity(), "Endereco atualizado com sucesso !", Toast.LENGTH_SHORT).show();

                            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                            navController.popBackStack();
                        }else {
                            Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btnDeletarCidade.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editarCidadeViewModel.excluirCidade(city, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Cidade excluída com sucesso !", Toast.LENGTH_SHORT).show();
                        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                        navController.popBackStack();
                    }
                }
        );

        return root;

    }

}