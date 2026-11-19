/*import java.util.ArrayList;
import java.util.List;

public class Generador {

    //Generar un listado de tamaño size
    //con numeros aleatorios entre 0 y size
    public static List<Integer> generate (int size){
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < size; i++ ) {
            list.add((int) ((Math.random() * size)));
        }
        return list;  
    }
}*/

import java.util.Random;

public class Generador {

    public static int[] generate(int sample) {

        int[] arreglo = new int[sample];
        Random random = new Random();

        for (int i = 0; i < sample; i++) {
            arreglo[i] = random.nextInt(sample + 1);
        }
        return arreglo;
    }
}




