import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id; // Número de pedido sequencial [cite: 88]
    private Cliente cliente; // Associado a um Cliente [cite: 136]
    private LocalDateTime data;
    private StatusPedido status;
    private List<ItemPedido> itens;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        // Data e status são definidos no método 'confirmar()' [cite: 93]
        this.status = null;
        this.data = null;
    }

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public StatusPedido getStatus() { return status; }
    public List<ItemPedido> getItens() { return itens; }

    // Adiciona um item ao pedido
    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    // Regra de Negócio: Confirma o pedido
    public void confirmar() {
        if (this.status != null) {
            throw new IllegalStateException("Pedido já foi confirmado.");
        }
        this.data = LocalDateTime.now();
        this.status = StatusPedido.ACEITO; // Status inicial após confirmação [cite: 93]
    }

    // Método de Negócio: Avança o status com lógica de transição rígida [cite: 94, 101]
    public void avancarStatus() {
        if (status == null) {
            throw new IllegalStateException("Pedido precisa ser confirmado antes de mudar de status.");
        }

        // Lógica de transição rígida [cite: 97, 98, 99]
        switch (status) {
            case ACEITO:
                status = StatusPedido.PREPARANDO;
                break;
            case PREPARANDO:
                status = StatusPedido.FEITO;
                break;
            case FEITO:
                status = StatusPedido.AGUARDANDO_ENTREGADOR;
                break;
            case AGUARDANDO_ENTREGADOR:
                status = StatusPedido.SAIU_PARA_ENTREGA;
                break;
            case SAIU_PARA_ENTREGA:
                status = StatusPedido.ENTREGUE;
                break;
            case ENTREGUE:
                throw new IllegalStateException("Pedido já foi ENTREGUE e não pode ser alterado.");
        }
    }

    // Calcula o valor total do pedido
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }
}
