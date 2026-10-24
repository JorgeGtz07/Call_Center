package call_center;

public class Main {
    public static void main(String[] args) {

        CallCenter centro = new CallCenter();

        Llamada llamada1 = new Llamada(
                1, "Steve", Llamada.tipo.normal, 5.0);

        Llamada llamada2 = new Llamada(
                2, "Link", Llamada.tipo.prioritaria, 3.0);

        Llamada llamada3 = new Llamada(
                3, "Deacon", Llamada.tipo.normal, 4.0);

        centro.recibirLlamada(llamada1);
        centro.recibirLlamada(llamada2);
        centro.recibirLlamada(llamada3);

        System.out.println("--- CALL CENTER ---");

        System.out.println("\nLlamadas pendientes:");
        centro.mostrarCola();

        System.out.println("\nCantidad de llamadas: "
                + centro.llamadasPendientes());

        System.out.println("Tiempo pendiente: "
                + centro.tiempoTotalPendiente());

        System.out.println("\nPrimera llamada atendida:");
        Llamada atendida = centro.atenderLlamada();

        if (atendida != null) {
            System.out.println("Cliente: " + atendida.getCliente());
            System.out.println("Duracion: " + atendida.getDuracion());
        }

        System.out.println("\nCancelando una llamada");
        centro.cancelarLlamada();

        System.out.println("\nLlamadas restantes:");
        centro.mostrarCola();

        System.out.println("\nAtendiendo las demas llamadas:");
        centro.atenderTodas();

        System.out.println("\nTiempo total atendido: "
                + centro.getTiempoTotal());

        System.out.println("Promedio de puntuaciones: "
                + centro.obtenerpromedio());
    }
}