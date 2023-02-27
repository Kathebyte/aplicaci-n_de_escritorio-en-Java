import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Series{
    private int id;
    private String codigo;
    private String título;
    private String fechaLanzamiento;
    private int temporadas;
    private String genero;
    private List<String> actoresPrincipales;  
    private String sinopsisSerie;
    
    
    public Series(String codigo, String titulo, String fechaLanzamiento, int temporadas, String genero,
            List<String> actoresPrincipales, String sinopsisSerie) {
        this.codigo=codigo;
        this.título = título;
        this.fechaLanzamiento = fechaLanzamiento;
        this.temporadas = temporadas;
        this.genero = genero;
        this.actoresPrincipales = actoresPrincipales;
        this.sinopsisSerie = sinopsisSerie;
    }

    public Series(){}

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getTítulo() {
        return título;
    }


    public void setTítulo(String título) {
        this.título = título;
    }


    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }


    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }


    public int getTemporadas() {
        return temporadas;
    }


    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public List<String> getActoresPrincipales() {
        return actoresPrincipales;
    }


    public void setActoresPrincipale(List<String> actoresPrincipales) {
        this.actoresPrincipales = actoresPrincipales;
    }


    public String getSinopsisSerie() {
        return sinopsisSerie;
    }


    public void setSinopsisSerie(String sinopsisSerie) {
        this.sinopsisSerie = sinopsisSerie;
    }
    
    
}