import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int opc=0;

        do {
            System.out.println("::::::SERIES TV:::::");
            System.out.println("Aplicacion series de tv");
            System.out.println("1. Crear serie");
            System.out.println("2. Listar series");
            System.out.println("3. Eliminar series");
            System.out.println("4. Actualizar informacion");
            System.out.println("5. Salir");

            opc= teclado.nextInt();

            switch(opc){
                case 1:
                    SeriesServicios.crearSerie();
                break;
                case 2:
                    SeriesServicios.listarSerie();
                break;
                case 3:
                    SeriesServicios.borrarSerie();
                break;
                case 4:
                    SeriesServicios.editarSerie();
                break;
                default:
                    break;
            }

        } while (opc!= 5);

        Conexion conexion = new Conexion();
         try(Connection cnx = conexion.getConnection())
         {
        } catch (Exception e) {
            System.out.println(e);
        }
        Series serie = new Series();
        System.out.println(serie.getActoresPrincipales());

    }
}
