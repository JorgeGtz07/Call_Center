package call_center;

import java.util.LinkedList;

public class Cola<T> {
    private LinkedList<T> elementos;

    public Cola() {
        elementos = new LinkedList<T>();
    }

    public void enqueue(T dato) {
        elementos.addLast(dato);
    }

    public T dequeue() {
        if (empty()) {
            return null;
        }

        return elementos.removeFirst();
    }

    public T peek() {
        if (empty()) {
            return null;
        }

        return elementos.getFirst();
    }

    public boolean empty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    public void enqueuePrioritario(T dato) {
        elementos.addFirst(dato);
    }
}