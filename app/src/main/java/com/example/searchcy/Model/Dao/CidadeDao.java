package com.example.searchcy.Model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bdroom24.entities.Usuario;
import com.example.searchcy.Model.Cidade;

import java.util.List;

@Dao
public interface CidadeDao {
    @Query("SELECT * FROM cidade WHERE id=:idCity LIMIT 1")
    Cidade getUser(int idCity);

    @Query("SELECT * FROM cidade")
    List<Cidade> getAll();

    @Insert
    void insertAll(Cidade city);
    @Update
    void update(Cidade city);
    @Delete
    void delete(Cidade city);
}
