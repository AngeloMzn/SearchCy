package com.example.searchcy.ui.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.searchcy.Core.Util;
import com.example.searchcy.Model.Usuario;
import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentLoginBinding;
import com.example.searchcy.ui.home.HomeActivity;
import com.example.searchcy.ui.main.login.LoginViewModel;
import com.example.searchcy.ui.main.registrar.RegistrarViewModel;

import java.util.ArrayList;
import java.util.Objects;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private Button btn_login;
    private LoginViewModel vmLogin;
    private EditText edtxt_Password;
    private EditText edtxt_Username;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        vmLogin = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        edtxt_Password = view.findViewById(R.id.edtxt_Password);
        edtxt_Username = view.findViewById(R.id.edtxt_Username);
        btn_login = view.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                    String email = edtxt_Username.getText().toString();
                    String password = edtxt_Password.getText().toString();
                   
                    ArrayList<Object> infoList = new ArrayList<>();
                    infoList.add(password);
                    infoList.add(email);
                    
                    Util util = new Util();
                    Usuario usuario;
                    
                    if (util.validateInfo(infoList)) {
                        if(util.validateEmail(email) ){
                            usuario = vmLogin.listarUsuarioPeloEmail(email, requireActivity().getApplication());

                            //Log.i("sla", "Valor da senha do usuario buscado: " + usuario.getPassword());
                            //Log.i("sla", "Valor do email digitado: " + email);
                            //Log.i("sla", "Valor da senha digitada: " + password);
                            if(usuario != null && Objects.equals(usuario.getEmail(), email) && Objects.equals(usuario.getPassword(), password)){
                                Toast.makeText(getActivity(), "Login realizado com sucesso !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), HomeActivity.class);
                                startActivity(intent);
                                requireActivity().finish();
                            }else{
                                Toast.makeText(getActivity(), "As credenciais estão incorretas", Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(getActivity(), "O email está com um formato incorreto, por favor insira um email válido.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );
        return view;
    }

    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtxtPassword.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}