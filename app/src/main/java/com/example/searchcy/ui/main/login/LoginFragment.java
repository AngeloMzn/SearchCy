package com.example.searchcy.ui.main.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.searchcy.R;
import com.example.searchcy.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private Button btn_login;
    private LoginViewModel vmLogin;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        vmLogin = new LoginViewModel();

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

        edtxt_Password = view.findViewById(R.id.edtxt_Password);
        edtxt_Username = view.findViewById(R.id.edtxt_Username);
        btn_login = view.findViewById(R.id.btn_login);

        btn_login.buttonRegister.setOnClickListener(new View.OnClickListener() {
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
                            usuario = vmLogin.listarUsuarioPeloEmail(email);
                            if(usuario != null && usuario.getEmail() == email && usuario.getPassword() == password){
                                Toast.makeText(getActivity(), "Login realizado com sucesso !", Toast.LENGTH_SHORT).show();
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
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtxtPassword.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}