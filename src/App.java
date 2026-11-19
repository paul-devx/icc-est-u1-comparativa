
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {

        MetodosOrd m = new MetodosOrd();

        List<Results> resultados = new ArrayList<>();

        int[] tamanos = {10000, 50000, 100000};

        // Los 3 arreglos base
        int[][] arreglosBase = new int[tamanos.length][];

        for (int i = 0; i < tamanos.length; i++) {
            arreglosBase[i] = Generador.generate(tamanos[i]);
        }

        // Crear el comparador antes de las mediciones
        Comparator<Integer> comparador =
            (a, b) -> Integer.compare(a, b);

        // V1: METODO BURBUJA
        for (int i = 0; i < tamanos.length; i++) {

            int sample = tamanos[i];

            int[] copia1 = arreglosBase[i].clone();

            Results r1 = Benchmark.medir(
                () -> m.sortBubble(copia1),
                "Burbuja",
                sample
            );

            validarResultado(arreglosBase[i], copia1);
            resultados.add(r1);
        }

        // V2: METODO QUICK SORT
        for (int i = 0; i < tamanos.length; i++) {

            int sample = tamanos[i];

            int[] copia2 = arreglosBase[i].clone();

            Results r2 = Benchmark.medir(
                () -> m.sortQuick(copia2),
                "QuickSort",
                sample
            );

            validarResultado(arreglosBase[i], copia2);
            resultados.add(r2);
        }

        // V3: ARRAYS.SORT CON int[]
        for (int i = 0; i < tamanos.length; i++) {

            int sample = tamanos[i];

            int[] copia3 = arreglosBase[i].clone();

            Results r3 = Benchmark.medir(
                () -> m.sortArrays(copia3),
                "Arrays.sort",
                sample
            );

            validarResultado(arreglosBase[i], copia3);
            resultados.add(r3);
        }

        // V4: ARRAYS.SORT CON Integer[] Y COMPARATOR
        for (int i = 0; i < tamanos.length; i++) {

            int sample = tamanos[i];

            Integer[] arregloInteger = new Integer[sample];

            for (int j = 0; j < sample; j++) {
                arregloInteger[j] = arreglosBase[i][j];
            }

            Integer[] copia4 = arregloInteger.clone();

            Results r4 = Benchmark.medir(
                () -> m.sortComparator(copia4, comparador),
                "Arrays.sort Comparator",
                sample
            );

            validarResultado(arreglosBase[i], copia4);
            resultados.add(r4);
        }

        // MOSTRAR RESULTADOS AL FINALIZAR
        System.out.println(
            "========== RESULTADOS DEL BENCHMARK =========="
        );

        for (Results resultado : resultados) {
            System.out.println(resultado);
        }

        System.out.println(
            "Total de mediciones: " + resultados.size()
        );
    }

    // VALIDAR ARREGLOS int[]
    private static void validarResultado(
            int[] original,
            int[] ordenado) {

        if (original.length != ordenado.length) {
            throw new IllegalStateException(
                "Cambio la cantidad de elementos."
            );
        }

        for (int i = 1; i < ordenado.length; i++) {

            if (ordenado[i - 1] > ordenado[i]) {
                throw new IllegalStateException(
                    "El arreglo no esta ordenado."
                );
            }
        }

        int[] copiaOriginal = original.clone();
        int[] copiaOrdenada = ordenado.clone();

        Arrays.sort(copiaOriginal);
        Arrays.sort(copiaOrdenada);

        if (!Arrays.equals(copiaOriginal, copiaOrdenada)) {
            throw new IllegalStateException(
                "No se conservaron todos los elementos."
            );
        }
    }

    // VALIDAR ARREGLOS Integer[]
    private static void validarResultado(
            int[] original,
            Integer[] ordenado) {

        if (original.length != ordenado.length) {
            throw new IllegalStateException(
                "Cambio la cantidad de elementos."
            );
        }

        for (int i = 1; i < ordenado.length; i++) {

            if (ordenado[i - 1] > ordenado[i]) {
                throw new IllegalStateException(
                    "El arreglo no esta ordenado."
                );
            }
        }

        int[] copiaOriginal = original.clone();
        int[] copiaOrdenada = new int[ordenado.length];

        for (int i = 0; i < ordenado.length; i++) {

            if (ordenado[i] == null) {
                throw new IllegalStateException(
                    "Se encontro un valor null."
                );
            }

            copiaOrdenada[i] = ordenado[i];
        }

        Arrays.sort(copiaOriginal);
        Arrays.sort(copiaOrdenada);

        if (!Arrays.equals(copiaOriginal, copiaOrdenada)) {
            throw new IllegalStateException(
                "No se conservaron todos los elementos."
            );
        }
    }
}