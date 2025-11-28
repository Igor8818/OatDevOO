public class ItemPedido {
    private ItemCardapio itemCardapio; // Referência ao item
    private int quantidade;
    private double precoUnit; // Preço do item no momento que o pedido foi registrado [cite: 129]

    public ItemPedido(ItemCardapio itemCardapio, int quantidade) {
        this.itemCardapio = itemCardapio;
        this.quantidade = quantidade;
        this.precoUnit = itemCardapio.getPreco(); // Captura o preço atual
    }

    // Getters
    public ItemCardapio getItemCardapio() { return itemCardapio; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnit() { return precoUnit; }

    // Calcula o subtotal deste item
    public double calcularSubtotal() {
        return precoUnit * quantidade;
    }
}
