package sp.senai.cadastraprodutos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// classe para manipulacao do banco de dados
public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("quantidade", produto.getQuantidade());
        values.put("preco", produto.getPreco());
        return banco.insert("produtos", null, values);
    }
}
