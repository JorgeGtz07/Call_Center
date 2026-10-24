package call_center;

public class Llamada {

    public enum tipo {
        normal, prioritaria
    }

    private int id;
    private String cliente;
    private tipo tipo;
    private double duracion;

    public Llamada(int id, String cliente, tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public int obtenerPuntuacion() {
        return (int) (Math.random() * 10) + 1;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public tipo getTipo() {
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }
}