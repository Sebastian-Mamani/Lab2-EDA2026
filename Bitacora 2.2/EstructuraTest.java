/**
Clase de pruebas para verificar las implementaciones de Pila y Fila
Valida el comportamiento de estructuras vacias y el funcionamiento Lifo y Fifo 
*/
public class EstructurasTest {
  public static void main(String[] args) {
    //Prueba de estructura vacia, metodos FIFO y LIFO
    System.out.println("Iniciando pruebas");
    pruebaPilaEnlazadaVacia();
    pruebaPilaArregloVacia();
    pruebaFilaEnlazadaVacia();
    pruebaFilaArregloVacia();
    pruebaPilaEnlazadaLIFO();
    pruebaPilaArregloLIFO();
    pruebaFilaEnlazadaFIFO();
    pruebaFilaArregloFIFO();

    // Pruebas de estres y casos borde 
    System.out.println("Iniciando pruebas de estres");
    pruebaSacarPilaVacia();
    pruebaCrecimientoDinamicoDeArreglo();
    pruebaPopPush();
  }
  public static void pruebaPilaEnlazadaVacia(){
    Pila<Integer> pila= new PilaEnlazada<>();
    boolean vacia = pila.isEmpty();

  if (vacia){
    System.out.println("La pila enlazada esta vacia correctamente");
  }else{
    System.out.println("La pila enlazada no esta vacia");
  }
  }
  public static void pruebaPilaArregloVacia(){
    Pila<Integer> pila = new PilaArreglo<>();
    boolean vacia = pila.isEmpty();
     if (vacia){
    System.out.println("La pila arreglo esta vacia correctamente");
  }else{
    System.out.println("La pila arreglo no esta vacia");
  }
  }
  public static void pruebaFilaEnlazadaVacia(){
    Fila<Integer> fila= new FilaEnlazada<>();
    boolean vacia = fila.isEmpty();

  if (vacia){
    System.out.println("La fila enlazada esta vacia correctamente");
  }else{
    System.out.println("La fila enlazada no esta vacia");
  }
  }
   public static void pruebaFilaArregloVacia(){
    Fila<Integer> fila = new FilaArreglo<>();
    boolean vacia = fila.isEmpty();
     if (vacia){
    System.out.println("La fila arreglo esta vacia correctamente");
  }else{
    System.out.println("La fila arreglo no esta vacia");
  }
  }
// pruebas para lifo y fifo
  public static void pruebaPilaEnlazadaLIFO(){
    Pila<Integer> pila= new PilaEnlazada<>();
    pila.push(1);
    pila.push(2);
    Integer resultado = pila.pop();
    if(resultado != null && resultado==2){
      System.out.println("La pila enlazada sigue el orden LIFO");
    }else{
      System.out.println("La pila enlazada no siguio el orden LIFO");
    }
  }
  public static void pruebaPilaArregloLIFO(){
    Pila<Integer> pila= new PilaArreglo<>();
    pila.push(1);
    pila.push(2);
    Integer resultado = pila.pop();
    if(resultado != null && resultado==2){
      System.out.println("La pila con arreglo sigue el orden LIFO");
    }else{
      System.out.println("La pila con arreglo no siguio el orden LIFO");
    }
  }
  public static void pruebaFilaEnlazadaFIFO(){
    Fila<Integer> fila = new FilaEnlazada<>();
    fila.enqueue(1);
    fila.enqueue(2);
    Integer resultado = fila.dequeue();
    if(resultado != null && resultado==1){
      System.out.println("La fila enlazada siguio el orden FIFO");
    }else{
      System.out.println("La fila enlazada no siguio el orden FIFO");
    }
  }
  public static void pruebaFilaArregloFIFO(){
    Fila<Integer> fila = new FilaArreglo<>();
    fila.enqueue(1);
    fila.enqueue(2);
    Integer resultado = fila.dequeue();
    if(resultado != null && resultado==1){
      System.out.println("La fila con arreglo siguio el orden FIFO");
    }else{
      System.out.println("La fila con arreglo no siguio el orden FIFO");
    }
  }
  public static void pruebaSacarPilaVacia(){
    Pila<Integer> pila = new PilaEnlazada<>();
    System.out.println("Prueba para sacar de pila vacia");
    try{
      Integer resultado = pila.pop();
      if (resultado==null){
        System.out.println("pop() devolvio null por estar vacia");
      }else{
        System.out.println("Hubo un error, pop() devolvio un valor, pero deberia estar vacia");
      }
    } catch (Exception e){
      System.out.println("Se atrapo la excepcion que se esperaba (" +e.getClass().getSimpleName()+")");
    }
  }
  public static void pruebaCrecimientoDinamicoDeArreglo(){
    Fila<Integer> fila = new FilaArreglo<>();
    System.out.println("Prueba de crecimeinto dinamico (10000 inserciones)");
    try{
      for (int i=0; i<10000 ; i++){
        fila.enqueue(i);
      }
      if(fila.size()==10000){
    System.out.println("El arreglo fue redimensionado correctamente");
  }else{
        System.out.println("Se presento un fallo en el redimensionamiento. Tamaño actual de " +fila.size());
      }
    }catch (Exception e){
      System.out.println("El arreglo no soporto la carga");
    }
  }
  public static void pruebaPopPush(){
    Pila<Integer> pila = new PilaEnlazada<>();
    System.out.println("Prueba de pop y push intercalados");
    pila.push(10);
    pila.push(20);
    pila.pop();
    pila.push(30);
    if(pila.size()==2 && pila.peek() !=null && pila.peek()==30){
      System.out.println("Puntero y tamaño sincronizados despues de operaciones intercaladas");
    }else{
      System.out.println("Hubo un error al mezclar push y pop");
    }
  }
}
