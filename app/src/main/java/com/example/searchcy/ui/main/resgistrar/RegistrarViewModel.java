package com.example.searchcy.ui.main.resgistrar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Core.AppDatabase;
import com.example.searchcy.Model.Dao.UsuarioDao;
import com.example.searchcy.Model.Usuario;

public class RegistrarViewModel extends ViewModel {

    private AppDatabase db;
    private final MutableLiveData<String> mText;

    public RegistrarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }
    public void registrarUsuario(Usuario usuario){
        db.usuarioDao().insertAll(usuario);
    }
    public LiveData<String> getText() {
        return mText;
    }
}