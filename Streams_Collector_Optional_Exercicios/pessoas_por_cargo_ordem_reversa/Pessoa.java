public class Pessoa implements Comparable<Pessoa>{
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
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

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ ", codigo, nome, cargo, idade) + String.format(java.util.Locale.FRANCE, "%f", salario);
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return Double.compare(this.salario, pessoa.salario);
    }
}
