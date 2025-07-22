import java.util.ArrayList;
import java.util.List;

import atividades.Atividade;

public class Workflow {
    private ArrayList<Atividade> atividades;

    public void registrarAtividade(Atividade atividade) {
        if (atividades == null) {
            atividades = new ArrayList<>();
        }
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}
