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

    public static Series buscarSerie (String codigoABuscar)  {
        Conexion db_Conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;
        Series serieEncontrada= null;

        try(Connection conexion = db_Conexion.getConnection()) {
            String query = "SELECT * FROM series WHERE codigo = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, codigoABuscar);
            rs = ps.executeQuery();

            while (rs.next()) {
                String codigo= rs.getString("codigo");
                String titulo = rs.getString("titulo");
                String fecha = rs.getString("fecha");
                String temporada= rs.getString("temporada");
                String genero = rs.getString("genero");
                String actores = rs.getString("actores");
                String sinopsis = rs.getString("sinopsis");

                serieEncontrada = new Series(codigo,titulo,fecha,temporada,genero,actores,sinopsis);
            }

        }catch (SQLException e){
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }
        return serieEncontrada;
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