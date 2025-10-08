import java.util.LinkedList;

public class ColaPedidos{

    private final LinkedList<String> pedidos = new LinkedList<>();
    private final int capacidad;

    public ColaPedidos(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void nuevoPedido (String pedido) throws InterruptedException {
        //TODO Mientras la cola este llena, no se produce
        while (pedidos.size() == capacidad) {
            //TODO Espera
            wait();
        }
        //TODO Añadir a la cola el valor
        pedidos.add(pedido); // queda un hueco libre en la cola
        System.out.println("Producido valor: " + pedido);

        //TODO Avisamos a los consumidores una vez que ha quedado un hueco libre
        notifyAll();
    }

    public synchronized String procesarPedido() throws InterruptedException {
        //TODO Mientras la cola esta vacia no se consume //
        while (pedidos.isEmpty()) {
            //TODO Esperar
            wait();
            // Si la cola está vacía no hay nada que consumir
        }
        // Si la cola esta llena
        //TODO recuperar el valor de la cabeza de la cola poll()
        String valor = pedidos.poll();
        System.out.println("Consumido valor: " + valor);

        //TODO Avisamos a los productores
        notifyAll();

        return valor;
    }
}
