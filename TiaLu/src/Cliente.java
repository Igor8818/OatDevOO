public class Cliente {
    private int id; // Código numérico único gerado pelo sistema [cite: 86]
    private String nome;
    private String telefone;

    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Tel: " + telefone;
    }
}
