import javax.swing.*;
import java.awt.*;


class InterfazSeries extends JDialog {
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
        setTitle("Conexion.Series Tv");
        setContentPane(SeriesForm);
        //setMaximumSize(new Dimension(1000, 800));
        setMinimumSize(new Dimension(700, 900));
        setModal(true);
        setLocationRelativeTo(parents);

    }
}



