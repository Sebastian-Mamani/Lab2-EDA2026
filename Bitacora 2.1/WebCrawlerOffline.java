/**
Clase que simula el rastreo y validacion de paginas web offline
  */
public class WebCrawlerOffline {
  /**
  Valida que las etiquetas de un documento HTML simulado se abran y cierren correctamente
  @param tokens Arreglo con la secuencia de etiquetas que se van a procesar
  @param pila Pila vacia que es utilizada para evalucar el orden LIFO de las etiquetas
  @return true si las etiquetas estan bien anidadas, y false en el caso contrario
  */
  public boolean validarEtiquetas (String[] tokens, Pila<String> pila){
    return false;
  }
  /**
  Recorre la topologia de un sitio web usando BFS
  @param sitio El sitio web generado con su topologia preprocesada
  @param paginaInicial El identificador de la pagina desde donde inciia el recorrido
  @param frontera Fila vacia para mantener el orden FIFO de las paginas descubiertas
  @return La cnatidad total de paginas procesadas
  */
  public int recorrerSitio (GeneradorWeb sitio, int paginaInicial, Fila<Integer> frontera) {
    return 0;
  }
