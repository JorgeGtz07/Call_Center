package call_center;

import java.util.LinkedList;

public class CallCenter {

    private Cola<Llamada> llamadas;
    private double tiempoTotal;
    private LinkedList<Integer> puntuaciones;

    public CallCenter() {
        llamadas = new Cola<Llamada>();
        tiempoTotal = 0;
        puntuaciones = new LinkedList<Integer>();
    }

    public void recibirLlamada(Llamada llamada) {
        if (llamada.getTipo() == Llamada.tipo.prioritaria) {
            llamadas.enqueuePrioritario(llamada);
        } else {
            llamadas.enqueue(llamada);
        }
    }

    public Llamada atenderLlamada() {
        Llamada llamada = llamadas.dequeue();

        if (llamada != null) {
            tiempoTotal = tiempoTotal + llamada.getDuracion();
            puntuaciones.add(llamada.obtenerPuntuacion());
        }

        return llamada;
    }

    public void cancelarLlamada() {
        llamadas.dequeue();
    }

    public void mostrarCola() {
        Cola<Llamada> auxiliar = new Cola<Llamada>();
        Llamada llamada;

        while (!llamadas.empty()) {
            llamada = llamadas.dequeue();

            System.out.println("Cliente: " + llamada.getCliente()
                    + ", Duracion: " + llamada.getDuracion());

            auxiliar.enqueue(llamada);
        }

        while (!auxiliar.empty()) {
            llamadas.enqueue(auxiliar.dequeue());
        }
    }

    public double tiempoTotalPendiente() {
        Cola<Llamada> auxiliar = new Cola<Llamada>();
        double tiempo = 0;
        Llamada llamada;

        while (!llamadas.empty()) {
            llamada = llamadas.dequeue();
            tiempo = tiempo + llamada.getDuracion();
            auxiliar.enqueue(llamada);
        }

        while (!auxiliar.empty()) {
            llamadas.enqueue(auxiliar.dequeue());
        }

        return tiempo;
    }

    public int llamadasPendientes() {
        return llamadas.size();
    }

    public void atenderTodas() {
        while (!llamadas.empty()) {
            Llamada llamada = atenderLlamada();

            if (llamada != null) {
                System.out.println("Cliente atendido: "
                        + llamada.getCliente());
                System.out.println("Duracion: "
                        + llamada.getDuracion());
                System.out.println("Puntuacion: "
                        + puntuaciones.getLast());
            }
        }
    }

    public int obtenerpromedio() {
        if (puntuaciones.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (int puntuacion : puntuaciones) {
            suma = suma + puntuacion;
        }

        return suma / puntuaciones.size();
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }
}