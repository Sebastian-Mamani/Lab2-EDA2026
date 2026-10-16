/**
Interfaz que define el metodo LIFO de una pila
  */
public interface Pila<T>{
void push(T item);
T pop();
T peek();
boolean isEmpty();
int size();
}
