public class ItemCardapio {
    private int id; // Código numérico único gerado pelo sistema [cite: 87]
    private String nome;
    private double preco;

    public ItemCardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Cod: " + id + ", Item: " + nome + ", Preço: R$" + String.format("%.2f", preco);
    }


}
