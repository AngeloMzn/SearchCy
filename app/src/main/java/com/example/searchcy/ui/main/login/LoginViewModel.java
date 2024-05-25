package com.example.searchcy.ui.main.login;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LoginViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public Usuario listarUsuarioPeloEmail(String email, Application context) {
        UserRepository repository = new UserRepository(context);
        return repository.listarUsuarioPeloEmail(email);
    }

}