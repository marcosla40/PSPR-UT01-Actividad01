public class Productor extends Thread{

    private ColaPedidos colaPedidos;

    public Productor(ColaPedidos colaPedidos) {
        this.colaPedidos = colaPedidos;
    }
}
