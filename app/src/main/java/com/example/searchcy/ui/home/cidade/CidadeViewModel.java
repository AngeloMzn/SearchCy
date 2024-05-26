package com.example.searchcy.ui.home.cidade;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Repository.AddressRepository;
import com.example.searchcy.Model.Repository.CityRepository;

import java.util.List;

public class CidadeViewModel extends ViewModel {

    private CityRepository repository;

    public CidadeViewModel() {

    }

    public List<Cidade> listarCidades(Application context){
        repository = new CityRepository(context);
        return repository.listarCidades();
    }

}