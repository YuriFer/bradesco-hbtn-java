package threads.teste;

    public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        if (fila.getFila().size() == 0) {
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
                final int valorRetirado = fila.getFila().getFirst();
                fila.retirar();
                System.out.println("Consumiu um item: " + valorRetirado);
                Thread.sleep(500);
                synchronized (fila) {
                    fila.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
