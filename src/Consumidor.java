public class Consumidor extends Thread{

    private ColaPedidos colaPedidos;

    public Consumidor(ColaPedidos colaPedidos) {
        this.colaPedidos = colaPedidos;
    }

    public void run() {
        try {
            System.out.println(getName() + " Iniciado");
            for (int i = 0; i < 10; i++) { // Cada consumidor consume 10 items
                //TODO consumir
                String pedido = colaPedidos.procesarPedido();
                //TODO Simula tiempo de consumo
                Thread.sleep(1000);
            }
            System.out.println(getName() + " Finalizado");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
