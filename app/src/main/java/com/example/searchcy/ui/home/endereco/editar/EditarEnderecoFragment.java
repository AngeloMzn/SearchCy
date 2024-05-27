package com.example.searchcy.ui.home.endereco.editar;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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
import com.example.searchcy.databinding.FragmentEditarEnderecoBinding;
import java.util.ArrayList;
import java.util.List;

public class EditarEnderecoFragment extends Fragment {

    private FragmentEditarEnderecoBinding binding;
    private EditText editTextDescricaoEditar;
    private EditText editTextLatitudeEditar;
    private EditText editTextLongitudeEditar;
    private Spinner spinnerCidadeEditar;
    private Button btnSalvarEndereco;
    private Button btnDeletarEndereco;

    public static EditarEnderecoFragment newInstance() {
        return new EditarEnderecoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        EditarEnderecoViewModel editarEnderecoViewModel = new ViewModelProvider(this).get(EditarEnderecoViewModel.class);
        int enderecoId = getArguments().getInt("enderecoId");

        binding = FragmentEditarEnderecoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Endereco endereco = editarEnderecoViewModel.listarEnderecoPeloId(enderecoId, requireActivity().getApplication());

        editTextDescricaoEditar = root.findViewById(R.id.editTextDescricaoEditar);
        editTextLatitudeEditar = root.findViewById(R.id.editTextLatitudeEditar);
        editTextLongitudeEditar = root.findViewById(R.id.editTextLongitudeEditar);
        spinnerCidadeEditar = root.findViewById(R.id.spinnerCidadeEditar);
        btnSalvarEndereco = root.findViewById(R.id.btnSalvarEndereco);
        btnDeletarEndereco = root.findViewById(R.id.btnDeletarEndereco);

        editTextDescricaoEditar.setText(endereco.getDescricao());
        editTextLatitudeEditar.setText(Double.toString(endereco.getLatitude()));
        editTextLongitudeEditar.setText(Double.toString(endereco.getLongitude()));

        List<Cidade> cidades = editarEnderecoViewModel.listarCidades(requireActivity().getApplication());
        if (!cidades.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, getCidadeNomes(cidades));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCidadeEditar.setAdapter(adapter);

            int cidadeId = endereco.getCidadeId();
            int posicaoCidade = getCidadePosition(cidadeId, cidades);
            spinnerCidadeEditar.setSelection(posicaoCidade);
        } else {
            List<String> nenhumaCidade = new ArrayList<>();
            nenhumaCidade.add("Nenhuma cidade encontrada");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, nenhumaCidade);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCidadeEditar.setAdapter(adapter);
        }

        btnSalvarEndereco.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String descricao = editTextDescricaoEditar.getText().toString();
                        Double latitude = Double.parseDouble(editTextLatitudeEditar.getText().toString());
                        Double longitude = Double.parseDouble(editTextLongitudeEditar.getText().toString());
                        String cidadeNome = (String) spinnerCidadeEditar.getSelectedItem();

                        Cidade cidadeSelecionada = null;
                        for (Cidade cidade : cidades) {
                            if (cidade.getCidade().equals(cidadeNome)) {
                                cidadeSelecionada = cidade;
                                break;
                            }
                        }

                        int cidadeId = 0;
                        if (cidadeSelecionada != null) {
                            cidadeId = cidadeSelecionada.getId();
                        }

                        ArrayList<Object> infoList = new ArrayList<>();
                        infoList.add(descricao);
                        infoList.add(latitude);
                        infoList.add(longitude);
                        infoList.add(cidadeId);

                        Util util = new Util();

                        if (util.validateInfo(infoList)) {
                            endereco.setDescricao(descricao);
                            endereco.setLatitude(latitude);
                            endereco.setLongitude(longitude);
                            endereco.setCidadeId(cidadeId);
                            editarEnderecoViewModel.atualizarEndereco(endereco, requireActivity().getApplication());
                            Toast.makeText(getActivity(), "Endereco atualizado com sucesso !", Toast.LENGTH_SHORT).show();
                            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                            navController.popBackStack();
                        } else {
                            Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btnDeletarEndereco.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editarEnderecoViewModel.excluirEndereco(endereco, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Endereco excluído com sucesso !", Toast.LENGTH_SHORT).show();
                        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                        navController.popBackStack();
                    }
                }
        );

        return root;
    }

    private List<String> getCidadeNomes(List<Cidade> cidades) {
        List<String> nomes = new ArrayList<>();
        for (Cidade cidade : cidades) {
            nomes.add(cidade.getCidade());
        }
        return nomes;
    }

    private int getCidadePosition(int cidadeId, List<Cidade> cidades) {
        for (int i = 0; i < cidades.size(); i++) {
            if (cidades.get(i).getId() == cidadeId) {
                return i;
            }
        }
        return 0;
    }
}
