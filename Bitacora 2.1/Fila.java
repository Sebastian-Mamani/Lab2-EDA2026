/**
Interfaz que define el metodo FIFO de una Fila
@param <T> Tipo de elemento a almacenar
  */
public interface Fila<T> {
void enqueue(T item);
T dequeue();
T peek();
boolean isEmpty();
int size();
}
