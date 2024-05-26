package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarEnderecoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CadastrarEnderecoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }
}