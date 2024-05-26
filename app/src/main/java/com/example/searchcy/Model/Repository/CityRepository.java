package com.example.searchcy.Model.Repository;

import android.app.Application;

import com.example.searchcy.Core.AppDatabase;
import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Dao.CidadeDao;
import com.example.searchcy.Model.Usuario;

import java.util.List;

public class CityRepository {
    CidadeDao cidadeDao;
    public CityRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        cidadeDao = db.cidadeDao();
    }

    public void inserirCidade(Cidade cidade) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            cidadeDao.insertAll(cidade);
        });
    }

    public void atualizarCidade(Cidade cidade){
        cidadeDao.update(cidade);
    }

    public void deletarCidade(Cidade cidade){
        cidadeDao.delete(cidade);
    }

    public Cidade listarCidadePeloId(int id){
        return  cidadeDao.listCityById(id);
    }


    public List<Cidade> listarCidades(){
        return cidadeDao.getAll();
    }

}

