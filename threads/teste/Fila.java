package threads.teste;

import java.util.LinkedList;

public class Fila {
    private LinkedList<Integer> fila;
    private final int capacidade;

    public Fila(int capacidade) {
        this.fila = new LinkedList<>();
        this.capacidade = capacidade;
    }

    public LinkedList<Integer> getFila() {
        return fila;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void adicionar(Integer item) {
        fila.add(item);
    }

    public Integer retirar() {
        return fila.removeFirst();
    }


}