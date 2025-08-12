public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(double salario) {
        this.nome = "Fulano";
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}
