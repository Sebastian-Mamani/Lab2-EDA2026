/*
Clase principal para ejecutar los experimentos de Pila y Fila
Guarda los tiempos y redimensionamientos en archivos csv.
*/
public class Experimento {
  private Experimento() {}
  public static void main(String[] args) {
    System.out.println("empieza experimento");
    WebCrawlerOffline crawler = new WebCrawlerOffline();
  //esto es para PILA
  Out archivoPila = new Out("pila.csv");
    archivoPila.println("n,repeticion,tEnlazada,tArreglo,redimensionamientos,capacidadMaxima");
    for (int t=10; t <=13; t++){
      int n = 1<< t;

      String[] tokens = GeneradorWeb.generarDocumentoAnidado(n);

      //pasada de calentamiento sin registrar
      crawler.validarEtiquetas(tokens, new PilaEnlazada<String>());
      crawler.validarEtiquetas(tokens, new PilaArreglo<String>());

      for (int r = 0; r < 30; r++){
        PilaEnlazada<String> pilaEnlazada = new PilaEnlazada<String>(); // ambas
        PilaArreglo<String> pilaArreglo = new PilaArreglo<String>();    // vacias

        double tEnlazada =0.0;
        double tArreglo = 0.0;
        boolean okEnlazada = false;
        boolean okArreglo = false;
        // alternar orden segun si la repeticion es par o impar
        if (r%2 == 0){
          StopwatchCPU timer1 = new StopwatchCPU();
          okEnlazada = crawler.validarEtiquetas(tokens, pilaEnlazada);
          tEnlazada = timer1.elapsedTime();
          StopwatchCPU timer2 = new StopwatchCPU();
          okArreglo = crawler.validarEtiquetas(tokens, pilaArreglo);
          tArreglo = timer2.elapsedTime();
        }else{
          StopwatchCPU timer1 = new StopwatchCPU();
          okArreglo = crawler.validarEtiquetas(tokens, pilaArreglo);
          tArreglo = timer1.elapsedTime();
          StopwatchCPU timer2 = new StopwatchCPU();
          okEnlazada = crawler.validarEtiquetas(tokens, pilaEnlazada);
          tEnlazada = timer2.elapsedTime();
        }
        if (!okEnlazada || !okArreglo) {
          System.out.println("error validando etiquetas con n = " +n);
        }
        int redim = pilaArreglo.getCantidadRediensionamientos();
        int capMax = pilaArreglo.getCapacidadMaximaObservada();
        archivoPila.println(n + "," + r + "," + tEnlazada + "," tArreglo + "," + redim + "," + capMax);
      }
    }
    archivoPila.close();

    //esto es para FILA
    Out archivoFila = new Out("fila.csv");
    archivoFila.println("n, repeticion, seed, tEnlazada,tArreglo,redimensionamientos,capacidadMaxima");

    for (int t = 10; t <=13; t++){
      int n= 1<<t;
      //calentamiento para fila
      GeneradorWeb sitioCalentamentio = new GeneradorWeb( n, n+999L);
      crawler.recorrerSitio(sitioCalentamiento, 0, new FilaEnlazada<Integer>());
      crawler.recorrerSitio(sitioCalentamiento, 0, new FilArreglo<Integer>());
      
    for (int r = 0; r < 30; r++){
      long seed = (long) n + r;
      GeneradorWeb sitio = new GeneradorWeb(n, seed); // construye nueva instancia
      FilaEnlazada<Integer> filaEnlazada = new FilaEnlazada<Integer>(); // ambas
      FilaArreglo<Integer> filaArreglo = new FilaArreglo<Integer>(); //     vacias
      double  tEnlazada = 0.0;
      double tArreglo = 0.0;
      int paginasEnlazada = 0;
      int paginasArreglo = 0;
     
      if (r%2 == 0) {
        StopwatchCPU timer1 = new StopwatchCPU();
        paginasEnlazada = crawler.recorrerSitio(sitio, 0, filaEnlazada);
        tEnlazada = timer1.elapsedTime();
        StopwatchCPU timer2 = new StopwatchCPU();
        paginasArreglo = crawler.recorrerSitio(sitio, 0, filaArreglo);
        tArreglo = timer2.elapsedTime();
      }else{
        StopwatchCPU timer1 = new StopwatchCPU();
        paginasArreglo = crawler.recorrerSitio(sitio, 0, filaArreglo);
        tEnlazada = timer1.elapsedTime();
        StopwatchCPU timer2 = new StopwatchCPU();
        paginasEnlazada = crawler.recorrerSitio(sitio, 0, filaEnlazada);
        tEnlazada = timer2.elapsedTime();
      }
      if (paginasEnlazada != n || paginasArreglo != n){
        System.out.println("error en recorrido con n = " + n);
      }
       int redim = filaArreglo.getCantidadRediensionamientos();
       int capMax = filaArreglo.getCapacidadMaximaObservada();
       archivoPila.println(n + "," + r + "," + seed + "," + tEnlazada + "," tArreglo + "," + redim + "," + capMax);
    }
  }
  archivoFila.close();
System.out.println("termina experimento");
}
}
        
      
