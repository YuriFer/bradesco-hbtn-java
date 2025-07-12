import java.util.Arrays;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = Arrays.stream(itens)
            .mapToDouble(item -> item.getProduto().obterPrecoLiquido() * item.getQuantidade())
            .sum();

        if (percentualDesconto > 0) {
            total *= (1 - percentualDesconto / 100.0);
        }

        return total;
    }
}
