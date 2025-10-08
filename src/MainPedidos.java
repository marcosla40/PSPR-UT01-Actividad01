public class MainPedidos {
    final static int CAPACIDAD_MAX = 5;

    public static void main(String[] args) {
        ColaPedidos colaPedidos = new ColaPedidos(CAPACIDAD_MAX);

        // Crear productores
        Productor[] productores = new Productor[10];
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Productor(colaPedidos);
            productores[i].setName("Productor" + i);
        }
        // Crear consumidores
        Consumidor[] consumidores = new Consumidor[10];
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Consumidor(colaPedidos);
            consumidores[i].setName("Consumidor" + i);
        }

        //TODO configurar e iniciar hilos
        for (Productor p : productores) {
            p.start();
        }
        for (Consumidor c : consumidores) {
            c.start();
        }

        //TODO Esperar a que terminen los hilos
        try {
            for (Productor p : productores) {
                p.join();
            }
            for (Consumidor c : consumidores) {
                c.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ha terminado");
    }
}

