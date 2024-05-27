package com.example.searchcy.ui.home.endereco.editar;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Repository.AddressRepository;
import com.example.searchcy.Model.Repository.CityRepository;

import java.util.List;

public class EditarEnderecoViewModel extends ViewModel {

    private AddressRepository repository;
    private CityRepository cityRepository;
    public EditarEnderecoViewModel() {
    }

    public Endereco listarEnderecoPeloId(int enderecoId, Application context){
        repository = new AddressRepository(context);
        return repository.listarEnderecoPeloId(enderecoId);
    }

    public List<Endereco> listarEnderecos(Application context){
        repository = new AddressRepository(context);
        return repository.listarEnderecos();
    }

    public void atualizarEndereco(Endereco endereco, Application context){
        repository = new AddressRepository(context);
        repository.atualizarEndereco(endereco);
    }

    public void excluirEndereco(Endereco endereco, Application context){
        repository = new AddressRepository(context);
        repository.deletarEndereco(endereco);
    }

    public List<Cidade> listarCidades(Application context){
        cityRepository = new CityRepository(context);
        return cityRepository.listarCidades();
    }

}