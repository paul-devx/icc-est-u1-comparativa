/*public class Benchmark {

    public static Results medir (Runnable accion, String nombre, String sample) {
        //Tiempo actual
        long tiempoActual = System.nanoTime();
        //accion
        accion.run();
        //Tiempo final 
        long tiempoFinal = System.nanoTime();
        //Retornar el tiempo de duracion 
        Results results = new Results(nombre, tiempoFinal-tiempoActual, sample);

        return results;
    }    
}*/
public class Benchmark {
    public static Results medir(Runnable accion,String nombre,int sample) {

        long inicio = System.nanoTime();
        accion.run();
        long fin = System.nanoTime();
        long duracion = fin - inicio;

        return new Results(nombre,duracion,sample);
    }
}

