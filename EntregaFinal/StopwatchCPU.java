import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

/**
 * The {@code StopwatchCPU} data type is for measuring
 * the CPU time used during a programming task.
 * <p>
  Codigo base obtenido de algs4 (Sedgewick & Wayne).
  Modificacion propia: Se omitio la declaracion de paquete original y el metodo main
  de prueba para integrarlo en el paquete por defecto del proyecto.
  * @author Josh Hug
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public StopwatchCPU() {
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }
}
