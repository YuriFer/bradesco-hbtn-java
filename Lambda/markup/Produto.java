import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private double preco;
    private int percentualMarkup;
    public Supplier<Double> precoComMarkup;
    public Consumer<Double> atualizarMarkup;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
        this.percentualMarkup = 10;

        this.precoComMarkup = () -> preco + (preco * percentualMarkup / 100);

        this.atualizarMarkup = novoMarkup -> percentualMarkup = novoMarkup.intValue();
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Supplier<Double> precoComMarkup() {
        return precoComMarkup;
    }

    public Consumer<Double> atualizarMarkup() {
        return atualizarMarkup;
    }
    

}
