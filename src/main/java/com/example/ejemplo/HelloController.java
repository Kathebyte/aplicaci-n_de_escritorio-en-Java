package com.example.ejemplo;

import com.example.ejemplo.backend.SeriesServicios;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private VBox gridVbox;

    @FXML
    protected void onListarSeries() {
        welcomeText.setText("Se inicio la app");
        ListView<ArrayList<String>> listView = SeriesServicios.listarSeries();
        gridVbox.getChildren().add(listView);
    }
}