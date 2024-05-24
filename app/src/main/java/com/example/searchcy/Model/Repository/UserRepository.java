package com.example.searchcy.Model.Repository;

import android.app.Application;

import com.example.searchcy.Core.AppDatabase;
import com.example.searchcy.Model.Dao.UsuarioDao;
import com.example.searchcy.Model.Usuario;

public class UserRepository {
    UsuarioDao usuarioDao;
    public UserRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        usuarioDao = db.usuarioDao();
    }

    public void inserirUsuario(Usuario usuario) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usuarioDao.insertAll(usuario);
        });
    }

    public Usuario listarUsuarioPeloId(int id){
        return  usuarioDao.getUser(id);
    }

    public Usuario listarUsuarioPeloEmail(String email){
        return  usuarioDao.getUserByEmail(email);
    }

}

