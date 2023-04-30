package vista;

import javax.swing.*;

public class VistaEspecialidadGui extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelCentro;
    private JPanel panelNorte;
    private JPanel panelSur;
    public JTextField jtfClave;
    public JButton btnNuevo;
    public JButton btnGuardar;
    public JButton btnSalir;
    public JTextField jtxNombre;
    private JLabel lblNombre;
    private JLabel lblClave;
    public JButton btnConsultar;
    public JButton btnEliminar;

    public VistaEspecialidadGui(){
        super("Ventana Especialidad");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(435,140);
       // this.jtfClave.setText("1");
       // this.jtxNombre.setText("Programacion");
        setVisible(true);
    }
}
//E