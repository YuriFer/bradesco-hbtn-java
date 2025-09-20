public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fila) {
                while (fila.getFila().isEmpty()) {
                    try {
                        System.out.println("Fila vazia, consumidor aguardando...");
                        fila.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                final int valorRetirado = fila.retirar();
                System.out.println("Consumiu um item: " + valorRetirado);
                    fila.notifyAll();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
