package com.example.searchcy.Model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.searchcy.Model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM Usuario WHERE id=:idUser LIMIT 1")
    Usuario getUser(int idUser);

    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuario WHERE nome like :userLogin")
    Usuario getUserByLogin(String userLogin);

    @Insert
    void insertAll(Usuario user);
    @Update
    void update(Usuario user);
    @Delete
    void delete(Usuario user);
}
