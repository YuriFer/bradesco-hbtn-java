public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome) {
        System.out.println("Procurando o nome: \"" + nome + "\"");
        
        int inicio = 0;
        int fim = nomes.length - 1;

        while (inicio <= fim) {
            int metadeArray = (inicio + fim) / 2;
            System.out.println("Passando pelo indice: " + metadeArray);

            if (nomes[metadeArray].equals(nome)) {
                System.out.println("Nome " + nome + " encontrado na posição " + metadeArray);
                return;
            } else if (nomes[metadeArray].compareTo(nome) < 0) {
                inicio = metadeArray + 1;
            } else {
                fim = metadeArray - 1;
            }
        }
        
        
        throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
    }
}
