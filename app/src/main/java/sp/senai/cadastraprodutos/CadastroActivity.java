package sp.senai.cadastraprodutos;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

public class CadastroActivity extends AppCompatActivity {
    private ImageView imageViewFoto;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        imageViewFoto = (ImageView) findViewById(R.id.imageView5);
        findViewById(R.id.buttonCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

        btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, Listagem.class);
                startActivity(intent);
            }
        });
    }

    public void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
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