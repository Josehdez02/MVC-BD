package vista;

import javax.swing.*;

public class VistaPrincipal extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel PanelSur;
    private JLabel lblTitulo;
    public JComboBox cbxOpciones;
    private JLabel lblOpcion;
    public JButton btnAceptar;
    public JButton btnConsultar;
    public VistaPrincipal(){
        setTitle("Ventana Principal");
        setContentPane(panelPrincipal);
        setSize(500, 140);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//F