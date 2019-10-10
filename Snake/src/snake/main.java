/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javax.swing.JFrame;

/**
 *
 * @author junio
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        //Crear un formulario
        JFrame frm = new JFrame("Snake v.01");
        //Asignar la función de cierre del formulario
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Agregar un panel (propio) al formulario
        frm.add(new MiPanel());
        //Validar Interfaz
        frm.pack();
        //Centrar la ventana 
        frm.setLocationRelativeTo(null);
        //Opcional - Evitar que cambie de tamaño - Extra
        //frm.setResizable(false);
        //Hacer visible el formulario
        frm.setVisible(true);
        while (true) {
            frm.repaint();
            Thread.sleep(200);
        }
    }
}
