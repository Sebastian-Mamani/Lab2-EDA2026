/**
Interfaz que define el metodo LIFO de una pila
@param <T> Tipo de elemento a almacenar
  */
public interface Pila<T>{
void push(T item);
T pop();
T peek();
boolean isEmpty();
int size();
}
