package com.example.searchcy.ui.main.registrar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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
import com.example.searchcy.ui.main.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistarFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextName;
    private Usuario usuario;

    public RegistarFragment() {
        // Required empty public constructor
    }

    public static RegistarFragment newInstance(String param1, String param2) {
        RegistarFragment fragment = new RegistarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registar, container, false);

        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextName = view.findViewById(R.id.editTextName);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        RegistrarViewModel registrarViewModel = new ViewModelProvider(this).get(RegistrarViewModel.class);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String email = editTextEmail.getText().toString();
                String nome = editTextName.getText().toString();

                ArrayList<Object> infoList = new ArrayList<>();
                infoList.add(password);
                infoList.add(email);
                infoList.add(nome);

                Util util = new Util();

                if (util.validateInfo(infoList)) {
                    if(util.validateEmail(email) ){
                        usuario = new Usuario(nome, email, password);
                        registrarViewModel.registrarUsuario(usuario, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Usuario registrado com sucesso !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(), "O email está com um formato incorreto, por favor insira um email válido.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
