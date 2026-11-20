public class Results {

    private String name;
    private long duracion;
    private int sample;

    public Results(String name,long duracion,int sample) {
        this.name = name;
        this.duracion = duracion;
        this.sample = sample;
    }

    public String getName() {
        return name;
    }

    public long getDuracion() {
        return duracion;
    }

    public int getSample() {
        return sample;
    }

    public double getDuracionMilisegundos() {
        return duracion / 1_000_000.0;
    }

    @Override
    public String toString() {
        return "Resultados [" + name+ ", duracion=" + duracion + "ns"+ ", " + getDuracionMilisegundos() + "ms"+ ", sample=" + sample + "]";
    }
}


