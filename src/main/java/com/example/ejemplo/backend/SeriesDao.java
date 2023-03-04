package com.example.ejemplo.backend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SeriesDao {

    public static void crearSerieDb(Series serie){
        Conexion db_Conexion = new Conexion();

        try (Connection conexion = db_Conexion.getConnection()){
            PreparedStatement ps=null;

            String query="INSERT INTO series(codigo,titulo,fecha,temporada,genero,actores,sinopsis) VALUES(?,?,?,?,?,?,?)";
            ps= conexion.prepareStatement(query);
            ps.setString(1,serie.getCodigo());
            ps.setString(2, serie.getTitulo());
            ps.setDate(3, Date.valueOf(serie.getFechaLanzamiento()));
            ps.setInt(4, serie.getTemporadas());
            ps.setString(5, serie.getGenero());
            ps.setString(6, String.join(",", serie.getActoresPrincipales()));
            ps.setString(7, serie.getSinopsisSerie());
            ps.executeUpdate();
            System.out.println("Serie creada Exitosamente");

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ListView<ArrayList<String>> leerSeriesDb()  {
        Conexion db_Conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;
        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();

        try(Connection conexion = db_Conexion.getConnection()) {
            String query = "SELECT * FROM series";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();

                row.add("Id " + rs.getInt("id"));
                row.add("Codigo " + rs.getInt("codigo"));
                row.add("Titulo de la serie " + rs.getString("titulo"));
                row.add("Fecha Estreno " + rs.getDate("fecha"));
                row.add("Temporadas " + rs.getString("temporada"));
                row.add("Genero " + rs.getString("genero"));
                row.add("Actores principales " + rs.getString("actores"));
                row.add("Sinopsis " + rs.getString("sinopsis"));

                data.add(row);

            }

        }catch (SQLException e){
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }

        ListView<ArrayList<String>> listView = new ListView<>(data);

        return listView;
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
            ps.setString(1,series.getTitulo());
            ps.setInt(2, series.getId());
            ps.executeUpdate();
            System.out.println("El Titulo ha sido actualizado");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }



}
