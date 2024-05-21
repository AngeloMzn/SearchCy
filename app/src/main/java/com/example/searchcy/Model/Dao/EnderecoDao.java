package com.example.searchcy.Model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bdroom24.entities.Usuario;
import com.example.searchcy.Model.Endereco;

import Model.Endereco;

import java.util.List;

@Dao
public interface EnderecoDao {
    @Query("SELECT * FROM endereco WHERE id=:idAddress LIMIT 1")
    Endereco getAddress(int idAddress);

    @Query("SELECT * FROM Usuario")
    List<Endereco> getAll();

    @Insert
    void insertAll(Endereco address);
    @Update
    void update(Endereco address);
    @Delete
    void delete(Endereco address);
}