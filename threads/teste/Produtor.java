package threads.teste;

import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        final int valorAleatorio = random.nextInt(100);
        if (fila.getFila().size() == fila.getCapacidade()) {
            synchronized (fila) {
                try {
                    fila.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        while (true) {
            try {
                fila.adicionar(valorAleatorio);
                System.out.println("Produziu: " + valorAleatorio);
                synchronized (fila) {
                    fila.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
