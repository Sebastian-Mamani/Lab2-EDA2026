/**
use booleanos por que se me hacia simple para comparar si estaba vacio o no
creo que la prueba esta bien 
*/
public class EstructurasTest {
  public static void main(String[] args) {
    System.out.println("Iniciando pruebas");
    pruebaPilaVacia();
    pruebaPilaLIFO();
    pruebaFilaFIFO();
  }
  public static void pruebaPilaVacia(){
    Pila<Integer> pila= new PilaEnlazada<>();
    boolean vacia = pila.isEmpty();

  if (vacia){
    System.out.println("La pila esta vacia correctamente");
  }else{
    System.out.println("La pila no esta vacia");
  }
  }
  public statis void pruebaPilaLIFO(){
    Pila<Integer> pila= new PilaEnlazada<>();
    pila.push(1);
    pila.push(2);
    Integer resultado = pila.pop();
    if(resultado != null && resultado==2){
      System.out.println("La pila sigue el orden LIFO");
    }else{
      System.out.println("La pila no siguio el orden FIFO");
    }
  }
  public static void testFilaFIFO(){
    Fila<Integer> fila = new FilEnlazada<>();
    fila.enqueue(1);
    fila.enqueue(2);
    Integer resultado = fila.enqueue();
    if(resultado != null && resultado==1){
      System.out.println("La fila siguio el orden FIFO");
    }else{
      System.out.println("La fila no siguio el orden FIFO");
    }
  }
}
