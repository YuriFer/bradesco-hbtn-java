import java.util.Arrays;

import produtos.Produto;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;
    private static final String SEPARADOR = "\n----------------------------";

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto / 100.0;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = Arrays.stream(itens)
            .mapToDouble(item -> item.getProduto().obterPrecoLiquido() * item.getQuantidade())
            .sum();

        if (percentualDesconto > 0) {
            total *= (1 - getPercentualDesconto());
        }

        return total;
    }

    public void apresentarResumoPedido() {
        StringBuilder resumo = new StringBuilder();

        resumo.append("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            double precoLiquido = produto.obterPrecoLiquido();
            double totalItem = precoLiquido * item.getQuantidade();
            totalProdutos += totalItem;
            resumo.append(String.format(
                "%nTipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f",
                produto.getClass().getSimpleName(),
                produto.getTitulo(),
                precoLiquido,
                item.getQuantidade(),
                totalItem
            ));
        }

        double desconto = totalProdutos * getPercentualDesconto();
        double totalPedido = totalProdutos - desconto;
        resumo.append(SEPARADOR);
        resumo.append("\nDESCONTO: ").append(String.format("%.2f", desconto));
        resumo.append("\nTOTAL PRODUTOS: ").append(String.format("%.2f", totalProdutos));
        resumo.append(SEPARADOR);
        resumo.append("\nTOTAL PEDIDO: ").append(String.format("%.2f", totalPedido));
        resumo.append(SEPARADOR);

        System.out.println(resumo);
    }

}
