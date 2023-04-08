package sp.senai.cadastraprodutos;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroActivity extends AppCompatActivity {

    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, Listagem.class);
                startActivity(intent);
            }
        });
    }

    public void inserir(View view) {
        EditText etNome = findViewById(R.id.editTextNome);
        String nome = etNome.getText().toString();

        EditText etQuantidade = findViewById(R.id.editTextQuantidade);
        float quantidade = Float.valueOf(etQuantidade.getText().toString());

        EditText etPreco = findViewById(R.id.editTextPreco);
        float preco = Float.valueOf(etPreco.getText().toString());

        Produto produto = new Produto(nome, quantidade, preco);
        ProdutoDAO dao = new ProdutoDAO(this);
        long id = dao.inserir(produto);
        Toast.makeText(this, "Produto inserido com id " + id, Toast.LENGTH_SHORT).show();
    }
}