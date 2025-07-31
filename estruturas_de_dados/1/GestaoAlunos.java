import java.util.ArrayList;

public class GestaoAlunos {
    private ArrayList<Aluno> listaAlunos;

    public GestaoAlunos() {
        this.listaAlunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno novoAluno = new Aluno(nome, idade);
        listaAlunos.add(novoAluno);
    }

    public void removerAluno(String nome) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(nome)) {
                listaAlunos.remove(aluno);
            }
        }
    }

    public String buscarAluno(String nome) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno.toString();
            }
        }
        return null;
    }

    public void listarAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("Joao", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Pedro", 19);

        gestao.listarAlunos();

        String alunoBuscado = gestao.buscarAluno("Joao");
        if (alunoBuscado != null) {
            System.out.println("Aluno encontrado: " + alunoBuscado);
        } else {
            System.out.println("Aluno nao encontrado.");
        }

        gestao.removerAluno("Maria");
        gestao.listarAlunos();
    }
}