package sp.senai.cadastraprodutos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

// classe para criacao do banco de dados
public class Conexao extends SQLiteOpenHelper {
    private static final String name = "bancoDadosCadPro.db";
    public static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    // query SQL para criacao da tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table produtos(id integer primary key autoincrement," +
                "nome varchar(50), quantidade float, preco float)");
    }

    // nescessita reescrever para usar o SQLite
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
