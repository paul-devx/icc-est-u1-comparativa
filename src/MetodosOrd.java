
import java.util.Arrays;
import java.util.Comparator;

public class MetodosOrd {

    // V1: METODO BURBUJA
    public void sortBubble(int[] arreglo) {

        for (int i = 0; i < arreglo.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // V2: QUICK SORT
    public void sortQuick(int[] arreglo) {

        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private void quickSort(int[] arreglo, int inicio, int fin) {

        while (inicio < fin) {
            int izquierda = inicio;
            int derecha = fin;
            int pivote = arreglo[inicio + (fin - inicio) / 2];
            while (izquierda <= derecha) {
                while (arreglo[izquierda] < pivote) {
                    izquierda++;
                }
                while (arreglo[derecha] > pivote) {
                    derecha--;
                }
                if (izquierda <= derecha) {
                    int temp = arreglo[izquierda];
                    arreglo[izquierda] = arreglo[derecha];
                    arreglo[derecha] = temp;
                    izquierda++;
                    derecha--;
                }
            }
            if (derecha - inicio < fin - izquierda) {
                if (inicio < derecha) {
                    quickSort(arreglo, inicio, derecha);
                }
                inicio = izquierda;
            } else {
                if (izquierda < fin) {
                    quickSort(arreglo, izquierda, fin);
                }
                fin = derecha;
            }
        }
    }

    // V3: ARRAYS.SORT CON int[]
    public void sortArrays(int[] arreglo) {
        Arrays.sort(arreglo);
    }

    // V4: ARRAYS.SORT CON Integer[] Y COMPARATOR
    public void sortComparator(
            Integer[] arreglo,
            Comparator<Integer> comparador) {
        Arrays.sort(arreglo, comparador);
    }
}




