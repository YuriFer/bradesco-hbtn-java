import java.util.List;

public class Pessoa implements Comparable<Pessoa>{
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ ", codigo, nome, cargo, idade) + String.format(java.util.Locale.FRANCE, "%f", salario);
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return this.nome.compareTo(pessoa.getNome());
    }
}
