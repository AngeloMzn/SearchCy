package com.example.searchcy.ui.home.endereco;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnderecoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EnderecoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}