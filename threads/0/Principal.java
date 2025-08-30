public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        ThreadContador[] threads = new ThreadContador[2];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadContador(contador);
            threads[i].start();
        }

        for (ThreadContador thread : threads) {
            thread.join();
        }

        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
