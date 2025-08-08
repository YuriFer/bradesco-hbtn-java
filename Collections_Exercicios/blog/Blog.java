import java.util.ArrayList;
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
        postagens.add(post);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new LinkedHashSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new LinkedHashMap<>();
        for (Post post : postagens) {
            String categoria = post.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }

        return contagem.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
