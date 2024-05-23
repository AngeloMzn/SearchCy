package com.example.searchcy.Core;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.searchcy.Model.Cidade;
import com.example.searchcy.Model.Dao.CidadeDao;
import com.example.searchcy.Model.Dao.EnderecoDao;
import com.example.searchcy.Model.Dao.UsuarioDao;
import com.example.searchcy.Model.Endereco;
import com.example.searchcy.Model.Usuario;

@Database(entities = {Usuario.class, Cidade.class, Endereco.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    public static AppDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,"AppDataBase")
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract UsuarioDao usuarioDao();
    public abstract CidadeDao cidadeDao();
    public abstract EnderecoDao enderecoDao();
}

