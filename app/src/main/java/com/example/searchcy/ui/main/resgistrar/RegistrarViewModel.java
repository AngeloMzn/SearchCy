package com.example.searchcy.ui.main.resgistrar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

public class RegistrarViewModel extends ViewModel {

    private UserRepository repository;
    private final MutableLiveData<String> mText;

    public RegistrarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }
    public void registrarUsuario(Usuario usuario){
        repository.inserirUsuario(usuario);
    }
    public LiveData<String> getText() {
        return mText;
    }
}