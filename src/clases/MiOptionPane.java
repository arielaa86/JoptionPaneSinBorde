/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class MiOptionPane {

    JDialog dialogo;

    String mensaje;
    int tipo_mesaje;
    int opciones_mensaje;
    ImageIcon icono;

    JOptionPane op;

    public MiOptionPane(String mensaje) {

        this.mensaje = mensaje;
        this.icono = new ImageIcon(getClass().getResource("/img/ok.jpg"));

        dialogo = new JDialog((JFrame) null, "");

        op = new JOptionPane(mensaje);
        op.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        op.setIcon(icono);

        preparar_ventana();

    }

    public MiOptionPane(String mensaje, int tipo_mensaje) {

        this.mensaje = mensaje;
        dialogo = new JDialog((JFrame) null, "");

        op = new JOptionPane(mensaje);
        

        switch (tipo_mensaje) {

            case JOptionPane.INFORMATION_MESSAGE:
                op.setIcon(new ImageIcon(getClass().getResource("/img/ok.jpg")));
                preparar_ventana();
                return;

            case JOptionPane.WARNING_MESSAGE:
                op.setIcon(new ImageIcon(getClass().getResource("/img/warning.jpg")));
                preparar_ventana();
                return;

            case JOptionPane.QUESTION_MESSAGE:
                op.setIcon(new ImageIcon(getClass().getResource("/img/question.jpg")));
                preparar_ventana();
                op.setOptionType(JOptionPane.YES_NO_OPTION);
                return;

            case JOptionPane.ERROR_MESSAGE:
                op.setIcon(new ImageIcon(getClass().getResource("/img/danger.jpg")));
                preparar_ventana();
                return;

        }

    }

    public MiOptionPane(String mensaje, int tipo_mensaje, ImageIcon icono) {

        this.mensaje = mensaje;
        this.icono = icono;

        dialogo = new JDialog((JFrame) null, "");

        op = new JOptionPane(mensaje);
        op.setMessageType(tipo_mensaje);
        op.setIcon(icono);

        preparar_ventana();

    }

    public MiOptionPane(String mensaje, int tipo_mensaje, int opciones_mensaje, ImageIcon icono) {

        this.mensaje = mensaje;
        this.opciones_mensaje = opciones_mensaje;
        this.icono = icono;

        dialogo = new JDialog((JFrame) null, "");

        op = new JOptionPane(mensaje);

        op.setMessageType(tipo_mensaje);
        op.setIcon(icono);
        op.setOptionType(opciones_mensaje);

        preparar_ventana();

    }

    private void preparar_ventana() {

        this.op.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if ("value".equals(name)) {
                    dialogo.dispose();
                }
            }
        });

    }

    public void mostrar() {


        dialogo.setUndecorated(true);
        dialogo.add(op);
        
        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        dialogo.setModal(true);
        dialogo.setVisible(true);

    }



}
