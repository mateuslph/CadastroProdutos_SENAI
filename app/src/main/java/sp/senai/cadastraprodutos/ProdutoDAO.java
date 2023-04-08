package sp.senai.cadastraprodutos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> obterTodos() {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produtos", new String[] {"id", "nome", "quantidade", "preco"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setQuantidade(cursor.getFloat(2));
            p.setPreco(cursor.getFloat(3));

            produtos.add(p);
        }
        return produtos;
    }
}
