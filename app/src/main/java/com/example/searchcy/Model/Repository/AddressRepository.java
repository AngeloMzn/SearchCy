package com.example.searchcy.Model.Repository;

import android.app.Application;

import com.example.searchcy.Core.AppDatabase;
import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Dao.CidadeDao;
import com.example.searchcy.Model.Dao.EnderecoDao;
import com.example.searchcy.Model.Endereco;

import java.util.List;

public class AddressRepository {
    EnderecoDao enderecoDao;
    public AddressRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        enderecoDao = db.enderecoDao();
    }

    public void inserirEndereco(Endereco endereco) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            enderecoDao.insertAll(endereco);
        });
    }

    public Endereco listarEnderecoPeloId(int id){
        return enderecoDao.listAddressById(id);
    }

    public void atualizarEndereco(Endereco endereco){
        enderecoDao.update(endereco);
    }

    public void deletarEndereco(Endereco endereco){
        enderecoDao.delete(endereco);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoDao.getAll();
    }
}

