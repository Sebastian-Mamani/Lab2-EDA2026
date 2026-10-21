import edu.princeton.cs.algs4.StopwatchCPU;

public class Experimento {
  private Experimento() {}
  public static void main(String[] args) {
    System.out.println("empieza experimento");
    //Cabecera para el archivo CSV para el excel
    System.out.println("N,PilaEnlazada,PilaArreglo,FilaEnlazada,FilaArreglo");
    WebCrawlerOffline crawler = new WebCrawlerOffline();
    int r = 10 //Este es el rango base para los enlaces

    //Evaluacion Doubling Ratio
      for (int n = 1000; n <= 64000; n *= 2){
      //Mediciones para LIFO
    String[] tokens = GeneradorWeb.generarDocumentoAnidado(n);
      Pila<String> pilaEnlazada = new PilaEnlazada
