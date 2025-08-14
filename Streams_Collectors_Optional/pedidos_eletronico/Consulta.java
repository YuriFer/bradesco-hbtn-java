import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == CategoriaProduto.LIVRO)
                .collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream().sorted(Comparator.comparingDouble(Produto::getPreco).reversed()).collect(Collectors.toList()).get(0);
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream().filter(pedido -> pedido.getProdutos().stream().anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO)).toList();
    }
}
