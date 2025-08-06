import java.util.HashMap;
import java.util.Map;

public abstract class Armazem<Item> implements Armazenavel<Item> {
    private Map<String, Item> itens;

    public Armazem(){
        this.itens = new HashMap<String,Item>();
    }

    @Override
    public void adicionarAoInventario(String nome, Item valor) {
        itens.put(nome, valor);
    }

    @Override
    public Item obterDoInventario(String nome) {
        return itens.get(nome);
    }
    
}
