package com.example.searchcy.ui.home.usuarios;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

import java.util.List;

public class UsuarioViewModel extends ViewModel {

    private UserRepository repository;

    public UsuarioViewModel() {

    }

    public List<Usuario> listarUsuarios(Application context){
        repository = new UserRepository(context);
        return repository.listarUsuarios();
    }
}