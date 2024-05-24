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
        // Assuming this operation should be done in a background thread
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usuarioDao.insertAll(usuario);
        });
    }

    public Usuario listarUsuario(int id){
        return  usuarioDao.getUser(id);
    }
}
