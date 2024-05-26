package com.example.searchcy.ui.home.cidade.cadastrar;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Repository.CityRepository;

public class CadastrarCidadeViewModel extends ViewModel {
    CityRepository repository;
    public CadastrarCidadeViewModel() {

    }

    public void registrarCidade(Cidade cidade, Application context) {
        repository = new CityRepository(context);
        repository.inserirCidade(cidade);
    }
}