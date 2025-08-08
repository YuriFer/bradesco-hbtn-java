public class Post implements Comparable<Post> {
    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categorias getCategoria() {
        return categoria;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post post) {
        int comparacaoTitulo = this.titulo.compareTo(post.titulo);
        if (comparacaoTitulo != 0) {
            return comparacaoTitulo;
        }
        return this.autor.compareTo(post.autor);
    }
}
