import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 Genera la topologia de un sitio web y documentos simulados.
 */
public class GeneradorWeb {
    private int numPaginas;
    private List<List<Integer>> adyacencia;

    /**
      Construye un sitio web con n paginas y genera sus enlaces
      garantizando alcanzabilidad desde la pagina 0.
      @param n Cantidad total de paginas en el sitio
      @param seed Semilla para garantizar la aleatoriedad
     */
    public GeneradorWeb(int n, long seed) {
        this.numPaginas = n;
        this.adyacencia = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adyacencia.add(new ArrayList<Integer>());
        }
        Random rnd = new Random(seed);
        for (int i = 1; i < n; i++) {
            int padre = rnd.nextInt(i); // padre aleatorio en el rango [0, i)
            adyacencia.get(padre).add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                int destino = rnd.nextInt(n);
                adyacencia.get(i).add(destino);
            }
        }
    }
    /**
     * @return La cantidad total de paginas generadas en el sitio
     */
    public int cantidadPaginas() {
        return numPaginas;
    }
     /**
     * Devuelve la lista de enlaces que salen de una pagina especifica en O(1)
     * @param paginaId El identificador de la pagina que se investiga
     * @return Lista de identificadores de las paginas destino
     */
    public List<Integer> obtenerEnlaces(int paginaId) {
        return adyacencia.get(paginaId);
    }
     /**
     * Genera una secuencia valida de etiquetas simuladas (apertura y cierre).
     * @param n Cantidad de etiquetas de apertura
     * @return Arreglo de strings con la secuencia generada
     */
    public static String[] generarDocumentoAnidado(int n) {
        String[] tokens = new String[2 * n];
        for (int i = 0; i < n; i++) {
            tokens[i] = "<etiqueta" + i + ">";          // Apertura al inicio
            tokens[2 * n - 1 - i] = "</etiqueta" + i + ">"; // Cierre al final (espejo)
        }
        return tokens;
    }
}
