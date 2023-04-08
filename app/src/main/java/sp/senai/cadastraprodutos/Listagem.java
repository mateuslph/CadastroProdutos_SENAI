package sp.senai.cadastraprodutos;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

// essa classe faz a listagem dos produtos e o vinculo com o front-end
public class Listagem extends AppCompatActivity {

    private ListView listView;
    private ProdutoDAO dao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        listView = findViewById(R.id.listaProdutos);
        dao = new ProdutoDAO(this);
        produtos = dao.obterTodos();
        produtosFiltrados.addAll(produtos);
        ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
        listView.setAdapter(adaptador);

    }
}