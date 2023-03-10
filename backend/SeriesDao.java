package backend;

import java.sql.*;

public class SeriesDao {

    public static void crearSerieDb(Series serie){
        Conexion db_Conexion = new Conexion();

        try (Connection conexion = db_Conexion.getConnection()){
            PreparedStatement ps=null;

            String query="INSERT INTO series(codigo,titulo,fecha,temporada,genero,actores,sinopsis) VALUES(?,?,?,?,?,?,?)";
            ps= conexion.prepareStatement(query);
            ps.setString(1,serie.getCodigo());
            ps.setString(2, serie.getTítulo());
            ps.setDate(3, Date.valueOf(serie.getFechaLanzamiento()));
            ps.setString(4, serie.getTemporadas());
            ps.setString(5, serie.getGenero());
            ps.setString(6, String.join(",", serie.getActoresPrincipales()));
            ps.setString(7, serie.getSinopsisSerie());
            ps.executeUpdate();
            System.out.println("Serie creada Exitosamente");

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void leerSeriesDb()  {
        Conexion db_Conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;

        try(Connection conexion = db_Conexion.getConnection()) {
            String query = "SELECT * FROM series";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id"));
                System.out.println("Codigo " + rs.getInt("codigo"));
                System.out.println("Titulo de la serie " + rs.getString("titulo"));
                System.out.println("Fecha Estreno " + rs.getDate("fecha"));
                System.out.println("Temporadas " + rs.getString("temporada"));
                System.out.println("Genero " + rs.getString("genero"));
                System.out.println("Actores principales " + rs.getString("actores"));
                System.out.println("Sinopsis " + rs.getString("sinopsis"));
                System.out.println("");
            }
        }catch (SQLException e){
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }
    }

    public static void eliminarSerieDb(int id){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.getConnection()){
            PreparedStatement ps= null;

            String query = "DELETE FROM series WHERE id = ?";
            ps=conexion.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("La serie ha sido Eliminada correctamente.");

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void editarSerieDb(Series series){
        Conexion db_connect = new Conexion();
        PreparedStatement ps= null;

        try(Connection conexion = db_connect.getConnection()){

            String query= "Update series SET titulo = ? WHERE id = ?";
            ps= conexion.prepareStatement(query);
            ps.setString(1,series.getTítulo());
            ps.setInt(2, series.getId());
            ps.executeUpdate();
            System.out.println("El Titulo ha sido actualizado");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }



}