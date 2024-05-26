package com.example.searchcy.ui.home.endereco.cadastrar;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Repository.AddressRepository;
import com.example.searchcy.Model.Repository.CityRepository;
import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

import java.util.List;

public class CadastrarEnderecoViewModel extends ViewModel {

    CityRepository cityRepository;
    AddressRepository addressRepository;

    public CadastrarEnderecoViewModel() {

    }

    public void registrarEndereco(Endereco endereco, Application context) {
        addressRepository = new AddressRepository(context);
        addressRepository.inserirEndereco(endereco);
    }

    public List<Cidade> listarCidades(Application context){
        cityRepository = new CityRepository(context);
        return cityRepository.listarCidades();
    }

}