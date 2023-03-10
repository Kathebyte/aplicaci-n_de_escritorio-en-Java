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

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        InterfazSeries form = new InterfazSeries(null);
    }
}
