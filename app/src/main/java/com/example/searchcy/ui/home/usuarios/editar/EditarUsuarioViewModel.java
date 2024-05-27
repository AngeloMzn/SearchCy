package com.example.searchcy.ui.home.usuarios.editar;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

import java.util.List;

public class EditarUsuarioViewModel extends ViewModel {

    private UserRepository repository;

    public EditarUsuarioViewModel() {

    }
    public Usuario listarUsuarioPeloId(int userId, Application context){
        repository = new UserRepository(context);
        return repository.listarUsuarioPeloId(userId);
    }
    public List<Usuario> listarUsuarios(Application context){
        repository = new UserRepository(context);
        return repository.listarUsuarios();
    }
    public void atualizarUsuario(Usuario user, Application context){
        repository = new UserRepository(context);
        repository.atualizarUsuario(user);
    }
    public void excluirUsuario(Usuario user, Application context){
        repository = new UserRepository(context);
        repository.deletarUsuario(user);
    }
}
