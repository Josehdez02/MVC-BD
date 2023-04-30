package vista;

import dao.DAOEspecialidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultarEspecialidad extends JFrame{
    private JPanel panel1;
    private JTable tableEspecialidad;

    public ConsultarEspecialidad(){
        super("Especialidad");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);


        DefaultTableModel dtm = new DefaultTableModel(
                DAOEspecialidad.lista.stream()
                        .map(lista -> new Object[]{

                                lista.getNombre(),
                                lista.getId(),
                        }).toArray(Object[][]::new),
                new Object[]{"especialidad", "ID"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableEspecialidad.setModel(dtm);
        setVisible(true);
    }
}
//A