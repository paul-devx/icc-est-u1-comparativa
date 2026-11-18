public class Results {

    private String funcionName;
    private long duracion;
    private String sample;

    public Results(String funcionName, long duracion, String sample) {
        this.funcionName = funcionName;
        this.duracion = duracion;
        this.sample = sample;
    }

    public String getFuncionName() {
        return funcionName;
    }

    public void setFuncionName(String funcionName) {
        this.funcionName = funcionName;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        long duracionSegundos = duracion / 1000000000;
        return "Results [funcionName=" + funcionName + ", duracion=" + duracionSegundos + " s, sample=" + sample + "]";
    }

}
