import java.util.LinkedList;

public class ColaPedidos{

    private final LinkedList<String> pedidos = new LinkedList<>();
    private final int capacidad;

    public ColaPedidos(int capacidad) {
        this.capacidad = capacidad;
    }

    public void nuevoPedido (String pedido) {
        //TODO Si la cola está llena, el cliente debe esperar ( wait() ).
        for (int i = 0; i < 4; i++) {
            
        }
        //TODO Si hay espacio, se añade el pedido a la cola.

        //TODO Al añadir un pedido, avisar a los trabajadores ( notifyAll() ).

    }

    public void procesarPedido() {

    }
}
