package com.example.searchcy.ui.home.cidade.editar;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Repository.CityRepository;

import java.util.List;

public class EditarCidadeViewModel extends ViewModel {
    private CityRepository repository;

    public EditarCidadeViewModel() {

    }

    public Cidade listarCidadePeloId(int cityId, Application context){
        repository = new CityRepository(context);
        return repository.listarCidadePeloId(cityId);
    }
    public void atualizarCidade(Cidade city, Application context){
        repository = new CityRepository(context);
        repository.atualizarCidade(city);
    }

    public void excluirCidade(Cidade city, Application context){
        repository = new CityRepository(context);
        repository.deletarCidade(city);
    }

    public List<Cidade> listarCidades(Application context){
        repository = new CityRepository(context);
        return repository.listarCidades();
    }
}