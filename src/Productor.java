public class Productor extends Thread{

    private ColaPedidos colaPedidos;

    public Productor(ColaPedidos colaPedidos) {
        this.colaPedidos = colaPedidos;
    }

    public void run() {
        try {
            System.out.println(getName() + " Iniciado"); // getName es un metodo del Thread
            // producir(valor), pasamos el valor incrementado del contador
            for (int i = 0; i < 10; i++) { // Cada productor genera 10 item
                //TODO producir
                colaPedidos.nuevoPedido("pedido");

                //Simula tiempo de producción
                Thread.sleep(1000);
            }
            System.out.println(getName() + " Finalizado");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
