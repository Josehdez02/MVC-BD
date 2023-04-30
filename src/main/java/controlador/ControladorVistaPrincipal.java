package controlador;

import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;
import vista.ConsultarEspecialidad;
import vista.VistaEspecialidadGui;
import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVistaPrincipal implements ActionListener {
    private final VistaPrincipal vistaPrincipal;

    public ControladorVistaPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.btnConsultar.addActionListener(this);
        this.vistaPrincipal.btnAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaPrincipal.btnConsultar) {
            String opcion = vistaPrincipal.cbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                DAOEspecialidad d1=new DAOEspecialidad();
                d1.consultar();

            }
        } else {
            String opcion = vistaPrincipal.cbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                VistaEspecialidadGui ve = new VistaEspecialidadGui();
                ModeloEspecialidad me = new ModeloEspecialidad();
                ControladorEspecialidadGui ce = new ControladorEspecialidadGui(me, ve);
            }

        }
    }
}
//HELP