/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectogui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author edgar
 */
public class VentanaObserver extends javax.swing.JFrame {
    private JPanel panelFondo;
    private Reproductor R1 = new Reproductor();
    private JFrame ventanaPrincipal;
    
    /**
     * Creates new form VentanaObserver
     * @param imagen
     * @param audio
     * @param _ventana
     */
    public VentanaObserver(String imagen, String audio, JFrame _ventana) {
        crearPanel(imagen);
        R1.reproducir(audio, 0.95f);
        ventanaPrincipal = _ventana;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Ocultar la ventana en lugar de cerrarla
                dispose();
                R1.detener();
                _ventana.setVisible(true);
                
            }
        });    
     
        initComponents();  
    }

    public void crearPanel(String ruta){
        panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String rutaRelativa = ruta;
                ImageIcon icon = new ImageIcon(getClass().getResource(rutaRelativa));
                Image imagen = icon.getImage();
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
            }
        };
        panelFondo.setLayout(null);
        setContentPane(panelFondo);        
    } 
    
    public void cambiarFondo(){
        panelFondo.repaint();
   
    }    
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
