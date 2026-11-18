import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /*Long nanotime =System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Nano Time: " + nanotime);
        System.out.println("Current Time: " + currentTimeMillis);

        Runnable funcion = () -> {
            System.out.println("Ejecutando tarea");
            System.out.println("Ejecutando tarea2");
        };
        
        List<Integer> list = new ArrayList<>();
        MetodosOrd mO = new MetodosOrd();
        mO.ordenarBurbuja();

        Runnable burbujaOrden = () -> mO.burbuja(list);

        //Calliable
        System.out.println("Ejecucion de la funcion Runnable");
        funcion.run();*/

        //Generador de numero random clase generador
        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> list = g.generate(100000);
        System.out.println(list);

        Results benGeneList = b.medir(() -> g.generate(100000), "Generador Lista", "100");
        System.out.println(benGeneList);
    }
}

