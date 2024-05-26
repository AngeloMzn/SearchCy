package com.example.searchcy.ui.home.cidade.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchcy.Core.Util;
import com.example.searchcy.Model.Cidade;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarCidadeBinding;

import java.util.ArrayList;

public class CadastrarCidadeFragment extends Fragment {

    private CadastrarCidadeViewModel mViewModel;
    private FragmentCadastrarCidadeBinding binding;
    private Button btnCadastrarCidade;
    private EditText editTextCity;
    private EditText editTextState;
    public static CadastrarCidadeFragment newInstance() {
        return new CadastrarCidadeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CadastrarCidadeViewModel cadastrarCidadeViewModel = new ViewModelProvider(this).get(CadastrarCidadeViewModel.class);

        binding = FragmentCadastrarCidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnCadastrarCidade = root.findViewById(R.id.btnCadastrarCidade);
        editTextCity = root.findViewById(R.id.editTextCity);
        editTextState = root.findViewById(R.id.editTextState);

        btnCadastrarCidade.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cidade = editTextCity.getText().toString();
                        String estado = editTextState.getText().toString();

                        ArrayList<Object> infoList = new ArrayList<>();
                        infoList.add(cidade);
                        infoList.add(estado);

                        Util util = new Util();

                        if (util.validateInfo(infoList)) {

                            Cidade city = new Cidade(cidade, estado);
                            cadastrarCidadeViewModel.registrarCidade(city, requireActivity().getApplication());
                            Toast.makeText(getActivity(), "Endereco cadastrado com sucesso !", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}