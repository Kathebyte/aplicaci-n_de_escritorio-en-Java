import backend.Series;
import backend.SeriesDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfazSeries extends JDialog {
    private JLabel lbCodigo;
    private JButton buscarButton;
    private JTextField txtTemporadas;
    private JButton limpiarButton;
    private JButton guardarButton;
    private JTextField txtFechaLanzamiento;
    private JTextField txtActores;
    private JLabel lbFechaLanzamiento;
    private JLabel lbTemporadas;
    private JLabel lbGenero;
    private JLabel lbActores;
    private JButton eliminarButton;
    private JLabel lbTitulo;
    private JTextField txtCodigo;
    private JButton editarButton;
    private JTextField txtTitulo;
    private JLabel panel;
    private JComboBox comboGnero;
    private JTextField txtSinopsis;
    private JPanel SeriesForm;

    public InterfazSeries(JFrame parents) {
        super(parents);
        setTitle("Series Tv");
        setContentPane(SeriesForm);
        setMaximumSize(new Dimension(1000, 800));
        setMinimumSize(new Dimension(700, 900));
        setModal(true);
        setLocationRelativeTo(parents);


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String titulo = txtTitulo.getText();
                String fecha = txtFechaLanzamiento.getText();
                String temporadas = txtTemporadas.getText();
                String genero = (String) comboGnero.getSelectedItem();
                String actores = txtActores.getText();
                String sinopsis = txtSinopsis.getText();

                Series registro = new Series(codigo,titulo,fecha,temporadas,genero,actores,sinopsis);
                SeriesDao.crearSerieDb(registro);

                limpiarFormulario();

            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encontrarSerie();
            }
        });

        eliminarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String codigoEliminar= txtCodigo.getText();
                SeriesDao.eliminarSerieDb(codigoEliminar);

                limpiarFormulario();

            }
        });

        editarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                encontrarSerie();

                String codigo = txtCodigo.getText();
                String fecha = txtFechaLanzamiento.getText();
                String temporadas = txtTemporadas.getText();
                String genero = (String) comboGnero.getSelectedItem();
                String actores = txtActores.getText();
                String sinopsis = txtSinopsis.getText();

                Series registro = new Series(codigo,titulo,fecha,temporadas,genero,actores,sinopsis);
                SeriesDao.editarSerieDb(registro);

                txtTitulo.setText(titulo);
            }
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        InterfazSeries form = new InterfazSeries(null);
    }

    private void limpiarFormulario() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtFechaLanzamiento.setText("");
        txtTemporadas.setText("");
        comboGnero.setSelectedItem(0);
        txtActores.setText("");
        txtSinopsis.setText("");
    }

    private void encontrarSerie() {
        String codigo= txtCodigo.getText();
        Series serieEncontrada = SeriesDao.buscarSerie(codigo);

        String titulo = serieEncontrada.getTi??tulo();
        String fecha = serieEncontrada.getFechaLanzamiento();
        String temporadas =serieEncontrada.getTemporadas();
        String genero = (String) serieEncontrada.getGenero();
        String actores = serieEncontrada.getActoresPrincipales();
        String sinopsis = serieEncontrada.getSinopsisSerie();

        txtTitulo.setText(titulo);
        txtCodigo.setText(codigo);
        txtFechaLanzamiento.setText(fecha);
        txtTemporadas.setText(temporadas);
        comboGnero.setSelectedItem(genero);
        txtActores.setText(actores);
        txtSinopsis.setText(sinopsis);
    }
}
