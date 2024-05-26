package com.example.searchcy.ui.home.endereco;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Repository.AddressRepository;
import com.example.searchcy.Model.Repository.UserRepository;
import com.example.searchcy.Model.Usuario;

import java.util.List;

public class EnderecoViewModel extends ViewModel {

    private AddressRepository repository;
    public EnderecoViewModel() {
    }
    public List<Endereco> listarEnderecos(Application context){
        repository = new AddressRepository(context);
        return repository.listarEnderecos();
    }
}