package backend;

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


        System.out.println("Escribe el numero de temporadas");
        String temporadas=teclado.nextLine();
        teclado.nextLine();

        System.out.println("Digite el genero");
        String genero = teclado.nextLine();

        System.out.println("Escribe los autores principales");
        String actoresPrincipales=teclado.nextLine();

        System.out.println("Escribe la sinopsis de la serie ");
        String sinopsis= teclado.nextLine();

        Series registro = new Series(codigo,titulo,inputfechaLanzamiento,temporadas,genero,actoresPrincipales,sinopsis);
        SeriesDao.crearSerieDb(registro);

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