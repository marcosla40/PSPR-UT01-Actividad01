public class MainPedidos {
    final static int CAPACIDAD_MAX = 5;

    public static void main(String[] args) {
        ColaPedidos buffer = new ColaPedidos(CAPACIDAD_MAX);

        // Crear productores
        Productor[] productores = new Productor[2];
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Productor();
            productores[i].setName("Productor" + i);
        }
        // Crear consumidores
        Consumidor[] consumidores = new Consumidor[2];
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Consumidor();
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
}
