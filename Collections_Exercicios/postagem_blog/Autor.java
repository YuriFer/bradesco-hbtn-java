public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor autor) {
        int comparacaoSobrenome = this.sobrenome.compareTo(autor.sobrenome);
        if (comparacaoSobrenome != 0) {
            return comparacaoSobrenome;
        }
        return this.nome.compareTo(autor.nome);
    }
}
