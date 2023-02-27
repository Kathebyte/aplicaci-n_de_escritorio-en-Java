import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeriesServicios {

    public static void crearSerie(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el codigo de la serie: ");
        String codigo = teclado.nextLine();

        System.out.println("Escribe el titulo de la serie: ");
        String titulo = teclado.nextLine();
        
        System.out.println("Escribe la fecha de lanzamiento [yyyy-MM-dd]");
        String inputfechaLanzamiento = teclado.nextLine();
        LocalDate fechaLanzamiento = LocalDate.parse(inputfechaLanzamiento);

        System.out.println("Escribe el numero de temporadas");
        int temporadas=teclado.nextInt();
        teclado.nextLine();
        
        System.out.println("Digite el genero");
        String genero = teclado.nextLine();
        
        System.out.println("Cuantos actores principales tiene la serie");
        int numActoresPrin= teclado.nextInt();
        List<String> actoresPrincipales= new ArrayList<>();

        for (int i = 0; i < numActoresPrin; i++) {
            System.out.println("Escribe el nombre del actor Princial: "+ (i+1) + ":");
            String nombreActor=teclado.nextLine();
            actoresPrincipales.add(nombreActor);
        }
        String cadenaActores="";
        for (String actoresActores: actoresPrincipales) {
            cadenaActores += actoresActores + ",";
            System.out.println(cadenaActores);
        }

        System.out.println("Escribe la sinopsis de la serie ");
        String sinopsis= teclado.nextLine();

        Series registro = new Series(codigo,titulo,inputfechaLanzamiento,temporadas,genero,actoresPrincipales,sinopsis);
        SeriesDao.crearSerieDb(registro);


    }

    public static void listarSerie(){
        SeriesDao.leerSeriesDb();
    }

    public static void borrarSerie(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el Id que deseas eliminar");
        int id= teclado.nextInt();
        SeriesDao.eliminarSerieDb(id);
    }
    
    public static void editarSerie(){
        Scanner teclado= new Scanner(System.in);
        System.out.println("Escribe el nuevo titulo ");
        String titulo= teclado.nextLine();

        System.out.println("Indica el id que deseas editar ");
        int id= teclado.nextInt();
        Series actualizacion = new Series();
        actualizacion.setId(id);
        actualizacion.setTítulo(titulo);

        SeriesDao.editarSerieDb(actualizacion);
    }
    
}
