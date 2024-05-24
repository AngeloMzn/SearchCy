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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, Cidade.class, Endereco.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "UserRepository")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public abstract UsuarioDao usuarioDao();
    public abstract CidadeDao cidadeDao();
    public abstract EnderecoDao enderecoDao();
}

