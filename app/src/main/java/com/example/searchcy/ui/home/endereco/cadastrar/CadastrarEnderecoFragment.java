package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.searchcy.Core.Util;
import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentCadastrarEnderecoBinding;

import java.util.ArrayList;
import java.util.List;

public class CadastrarEnderecoFragment extends Fragment {

    private CadastrarEnderecoViewModel mViewModel;
    private EditText editTextDescricao;
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    private Button btnCadastrarEndereco;
    private Spinner spinnerCidade;

    public static CadastrarEnderecoFragment newInstance() {
        return new CadastrarEnderecoFragment();
    }

    private FragmentCadastrarEnderecoBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CadastrarEnderecoViewModel cadastrarEnderecoViewModel = new ViewModelProvider(this).get(CadastrarEnderecoViewModel.class);

        binding = FragmentCadastrarEnderecoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        btnCadastrarEndereco = root.findViewById(R.id.btnCadastrarEndereco);
        editTextDescricao = root.findViewById(R.id.editTextDescricao);
        editTextLatitude = root.findViewById(R.id.editTextState);
        editTextLongitude = root.findViewById(R.id.editTextLongitude);
        spinnerCidade = root.findViewById(R.id.spinnerCidade);

        List<Cidade> cidades = cadastrarEnderecoViewModel.listarCidades();
        ArrayAdapter<Cidade> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCidade.setAdapter(adapter);

        btnCadastrarEndereco.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String descricao = editTextDescricao.getText().toString();
                        Double latitude = Double.parseDouble(editTextLatitude.getText().toString());
                        Double longitude = Double.parseDouble(editTextLongitude.getText().toString());
                        Cidade cidadeSelecionada = (Cidade) spinnerCidade.getSelectedItem();
                        int cidadeId = cidadeSelecionada.getId();

                        ArrayList<Object> infoList = new ArrayList<>();
                        infoList.add(descricao);
                        infoList.add(latitude);
                        infoList.add(longitude);
                        infoList.add(cidadeId);

                        Util util = new Util();

                        if (util.validateInfo(infoList)) {

                            Endereco address = new Endereco(descricao, latitude, longitude, cidadeId);
                            cadastrarEnderecoViewModel.registrarEndereco(address, requireActivity().getApplication());

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