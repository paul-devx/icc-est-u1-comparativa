public class Benchmark {

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
}
