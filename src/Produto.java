import java.sql.Date;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int qntEstoque;
    private String categoria;

    public Produto(int id, String nome, String descricao, double preco,
                   int qntEstoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", qntEstoque=" + qntEstoque +
                ", categoria='" + categoria + '\'' +
                '}';
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidadeEstoque() {
        return this.qntEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.qntEstoque = quantidadeEstoque;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
