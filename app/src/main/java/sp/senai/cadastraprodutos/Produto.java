package sp.senai.cadastraprodutos;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;

public class Produto {
    private int id;
    private String nome;
    private float quantidade;
    private float preco;

    // metodo construtor
    public Produto(String nome, float quantidade, float preco) {
//        this.nome = nome;
//        this.quantidade = quantidade;
//        this.preco = preco;

        setNome(nome);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    // construtor vazio
    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }


    @Override
    public String toString() {
        return nome;
    }
}
