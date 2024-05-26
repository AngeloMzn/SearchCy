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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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
        editTextLatitude = root.findViewById(R.id.editTextLatitude);
        editTextLongitude = root.findViewById(R.id.editTextLongitude);
        spinnerCidade = root.findViewById(R.id.spinnerCidade);

        List<Cidade> cidades = cadastrarEnderecoViewModel.listarCidades(requireActivity().getApplication());
        if(!cidades.isEmpty()){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, getCidadeNomes(cidades));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCidade.setAdapter(adapter);

        }else{
            List<String> nenhumaCidade = new ArrayList<String>();
            nenhumaCidade.add("Nenhuma cidade encontrada");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,nenhumaCidade);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCidade.setAdapter(adapter);
        }

        btnCadastrarEndereco.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String descricao = editTextDescricao.getText().toString();
                        Double latitude = Double.parseDouble(editTextLatitude.getText().toString());
                        Double longitude = Double.parseDouble(editTextLongitude.getText().toString());
                        String cidadeNome = (String) spinnerCidade.getSelectedItem();

                        Cidade cidadeSelecionada = null;
                        for (Cidade cidade : cidades) {
                            if (cidade.getCidade().equals(cidadeNome)) {
                                cidadeSelecionada = cidade;
                                break;
                            }
                        }

                        if (cidadeSelecionada != null) {
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
                                Toast.makeText(getActivity(), "Endereco cadastrado com sucesso !", Toast.LENGTH_SHORT).show();
                                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                                navController.popBackStack();
                            } else {
                                Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private List<String> getCidadeNomes(List<Cidade> cidades) {
        List<String> nomes = new ArrayList<>();
        for (Cidade cidade : cidades) {
            nomes.add(cidade.getCidade());
        }
        return nomes;
    }

}