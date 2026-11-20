import java.util.Random;

public class Generador {

    /**
     * Generar un sample conb numeros aleatorios (10K, 50k, 100k)
     * entre 0 y sample
     *
     * Rango admitido:
     * 0 hasta Integer.MAX_VALUE
     */
    public static int[] generate(int sample) {

        if (sample < 0) {
            throw new IllegalArgumentException("El sample no puede ser negativo.");
        }

        if (sample == Integer.MAX_VALUE) {throw new IllegalArgumentException("El sample supera el limite permitido.");
        }

        int[] arreglo = new int[sample];
        Random random = new Random();

        for (int i = 0; i < sample; i++) {
            arreglo[i] = random.nextInt(sample + 1);
        }
        return arreglo;
    }
}

