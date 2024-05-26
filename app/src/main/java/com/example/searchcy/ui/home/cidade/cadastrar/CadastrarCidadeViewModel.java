package com.example.searchcy.ui.home.cidade.cadastrar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarCidadeViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CadastrarCidadeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}