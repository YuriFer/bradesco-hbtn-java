import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        while (true) {
            final int valorAleatorio = random.nextInt(100);

            synchronized (fila) {
                while (fila.getFila().size() == fila.getCapacidade()) {
                    try {
                        System.out.println("Fila cheia, produtor aguardando...");
                        fila.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                fila.adicionar(valorAleatorio);
                System.out.println("Produziu: " + valorAleatorio);
                fila.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
