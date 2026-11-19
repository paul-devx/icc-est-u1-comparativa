
import java.util.Locale;

public class Results {

    private String funcionName;
    private long duracion;
    private int sample;

    public Results(
            String funcionName,
            long duracion,
            int sample) {

        this.funcionName = funcionName;
        this.duracion = duracion;
        this.sample = sample;
    }

    public String getFuncionName() {
        return funcionName;
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

        return String.format(Locale.US,
            "Results [%s, duration=%dns, %.6fms, sample=%s]",
            funcionName,
            duracion,
            getDuracionMilisegundos(),
            String.format(Locale.US, "%,d", sample)
                    .replace(',', '.')
        );
    }
}


