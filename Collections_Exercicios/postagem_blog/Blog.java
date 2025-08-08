import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        for (Post p : postagens) {
            if (p.getTitulo().equals(post.getTitulo()) && p.getAutor().equals(post.getAutor())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        postagens.add(post);
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return postagens.stream()
                .filter(post -> post.getAutor().getNome().equals(autor.getNome()) && post.getAutor().getSobrenome().equals(autor.getSobrenome()))
                .sorted(Comparator.comparing(Post::getTitulo))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return postagens.stream()
                .filter(post -> post.getCategoria().equals(categoria))
                .sorted(Comparator.comparing(Post::getTitulo))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        return postagens.stream()
            .sorted(Comparator.comparing(Post::getCategoria).thenComparing(Post::getTitulo))
            .collect(Collectors.groupingBy(
                Post::getCategoria,
                LinkedHashMap::new,
                Collectors.collectingAndThen(
                    Collectors.toCollection(() -> new LinkedHashSet<>()),
                    set -> set.stream()
                              .sorted(Comparator.comparing(Post::getTitulo))
                              .collect(Collectors.toCollection(LinkedHashSet::new))
                )
            ));
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        return postagens.stream()
            .sorted(Comparator.comparing(Post::getAutor, Comparator.comparing(Autor::getNome).thenComparing(Autor::getSobrenome))
                              .thenComparing(Post::getTitulo))
            .collect(Collectors.groupingBy(
                Post::getAutor,
                LinkedHashMap::new,
                Collectors.collectingAndThen(
                    Collectors.toCollection(LinkedHashSet::new),
                    set -> set.stream()
                              .sorted(Comparator.comparing(Post::getTitulo))
                              .collect(Collectors.toCollection(LinkedHashSet::new))
                )
            ));
    }

    public Set<Autor> obterTodosAutores() {
        return postagens.stream()
                .map(Post::getAutor)
                .distinct()
                .sorted(Comparator.comparing(Autor::getNome))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        return postagens.stream()
                .collect(Collectors.groupingBy(
                        Post::getCategoria,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}

