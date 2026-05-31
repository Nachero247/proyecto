/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.vista;

import java.sql.Connection;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import proyecto.logica.Ayuda;

/**
 *
 * @author DAM2Alu9
 */
public class JFrameMenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrameMenuPrincipal.class.getName());
    
    private String rol;
    

    /**
     * Creates new form JFrameMenuPrincipal
     */
    public JFrameMenuPrincipal(String rol) {
        this.rol = rol;
        initComponents();
        setLocationRelativeTo(null);
        icono1();
        icono2();
        icono3();
        icono4();
        icono5();
        icono6();
        icono7();
        icono8();
        icono9();
        
        configurarBotones(jButtonAsistencias);
        configurarBotones(jButtonAyuda);
        configurarBotones(jButtonCerrarSesion);
        configurarBotones(jButtonPagos);
        configurarBotones(jButtonPlanes);
        configurarBotones(jButtonSocios);
        configurarBotones(jButtonUsuarios);
        configurarBotones(jButtonCargarDatos);
        configurarMenu();
        
        // Abrir ayuda con F1
        this.getRootPane().registerKeyboardAction(
            e -> {
                new Ayuda().mostrarAyuda();
            },
            javax.swing.KeyStroke.getKeyStroke("F1"),
            javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    
    }
    
    
    
public void icono1() {
    ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/logo_GymManager.png"));

    int imgW = original.getIconWidth();
    int imgH = original.getIconHeight();

    // Tamaño fijo del JLabel (mejor que depender del layout dinámico)
    int labelW = 510;
    int labelH = 170;

    double scale = Math.min((double) labelW / imgW, (double) labelH / imgH);

    int newW = Math.max(1, (int) (imgW * scale));
    int newH = Math.max(1, (int) (imgH * scale));

    Image scaled = original.getImage().getScaledInstance(newW, newH, Image.SCALE_SMOOTH);

    jLabelTitulo.setIcon(new ImageIcon(scaled));
    jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
}
    
    public void icono2(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonSocios.setIcon(new ImageIcon(imagenEscalada));
    }
    
    public void icono3(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/credit-cards-payment.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonPagos.setIcon(new ImageIcon(imagenEscalada));
    }
    
    public void icono4(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/available.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonAsistencias.setIcon(new ImageIcon(imagenEscalada));
    }
    
    public void icono5(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/weight.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonPlanes.setIcon(new ImageIcon(imagenEscalada));
    }
    
    public void icono6(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonUsuarios.setIcon(new ImageIcon(imagenEscalada));
    }
    public void icono7(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/simbolo ayuda.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonAyuda.setIcon(new ImageIcon(imagenEscalada));
    }
    public void icono8(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/logout.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonCerrarSesion.setIcon(new ImageIcon(imagenEscalada));
    }
    
    public void icono9(){
        ImageIcon original = new ImageIcon(getClass().getResource("/imagenes/cargaDatos.png"));
        Image imagenEscalada = original.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButtonCargarDatos.setIcon(new ImageIcon(imagenEscalada));
    }
    
    private void configurarBotones(JButton b){
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setHorizontalTextPosition(SwingConstants.RIGHT);
        b.setIconTextGap(10);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setOpaque(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanelLateral = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonSocios = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonPagos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonAsistencias = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButtonPlanes = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jButtonUsuarios = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        jButtonCargarDatos = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jButtonAyuda = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jButtonCerrarSesion = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelLateral.setBackground(new java.awt.Color(153, 153, 153));
        jPanelLateral.setPreferredSize(new java.awt.Dimension(220, 415));
        jPanelLateral.setLayout(new javax.swing.BoxLayout(jPanelLateral, javax.swing.BoxLayout.Y_AXIS));

        jLabelTitulo.setMaximumSize(new java.awt.Dimension(510, 170));
        jLabelTitulo.setMinimumSize(new java.awt.Dimension(120, 16));
        jLabelTitulo.setName(""); // NOI18N
        jPanelLateral.add(jLabelTitulo);

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator1);

        jButtonSocios.setBackground(new java.awt.Color(153, 153, 153));
        jButtonSocios.setText("Socios");
        jButtonSocios.setActionCommand("");
        jButtonSocios.setAlignmentY(0.0F);
        jButtonSocios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSocios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSocios.setIconTextGap(10);
        jButtonSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSociosActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonSocios);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator2);

        jButtonPagos.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPagos.setText("Pagos");
        jButtonPagos.setActionCommand("");
        jButtonPagos.setAlignmentY(0.0F);
        jButtonPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonPagos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonPagos.setIconTextGap(10);
        jButtonPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagosActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonPagos);

        jSeparator3.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator3);

        jButtonAsistencias.setBackground(new java.awt.Color(153, 153, 153));
        jButtonAsistencias.setText("Asistencias");
        jButtonAsistencias.setActionCommand("");
        jButtonAsistencias.setAlignmentY(0.0F);
        jButtonAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsistenciasActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonAsistencias);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator4);

        jButtonPlanes.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPlanes.setText("Planes");
        jButtonPlanes.setActionCommand("");
        jButtonPlanes.setAlignmentY(0.0F);
        jButtonPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlanesActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonPlanes);

        jSeparator5.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator5);

        jButtonUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.setActionCommand("");
        jButtonUsuarios.setAlignmentY(0.0F);
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonUsuarios);

        jSeparator.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator);

        jButtonCargarDatos.setBackground(new java.awt.Color(153, 153, 153));
        jButtonCargarDatos.setText("Cargar Datos");
        jButtonCargarDatos.setActionCommand("");
        jButtonCargarDatos.setAlignmentY(0.0F);
        jButtonCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarDatosActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonCargarDatos);

        jSeparator7.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator7);

        jButtonAyuda.setBackground(new java.awt.Color(153, 153, 153));
        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.setActionCommand("");
        jButtonAyuda.setAlignmentY(0.0F);
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonAyuda);

        jSeparator10.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanelLateral.add(jSeparator10);

        jButtonCerrarSesion.setBackground(new java.awt.Color(153, 153, 153));
        jButtonCerrarSesion.setText("Cerrar Sesión");
        jButtonCerrarSesion.setActionCommand("");
        jButtonCerrarSesion.setAlignmentY(0.0F);
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        jPanelLateral.add(jButtonCerrarSesion);

        getContentPane().add(jPanelLateral, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSociosActionPerformed
        // TODO add your handling code here:
        JFrameGestionSocios ventanaSocios = new JFrameGestionSocios(rol);
        ventanaSocios.setVisible(true);
        ventanaSocios.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_jButtonSociosActionPerformed

    private void jButtonAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsistenciasActionPerformed
        // TODO add your handling code here:
        
        JFrameGestionAsistencias asistencias = new JFrameGestionAsistencias(rol);
        asistencias.setVisible(true);
        asistencias.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonAsistenciasActionPerformed

    private void jButtonPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagosActionPerformed
        // TODO add your handling code here:
        JFrameGestionPagos pagos = new JFrameGestionPagos(rol);
        pagos.setVisible(true);
        pagos.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonPagosActionPerformed

    private void jButtonPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlanesActionPerformed
        // TODO add your handling code here:
        JFrameGestionPlanes planes = new JFrameGestionPlanes(rol);
        planes.setVisible(true);
        planes.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonPlanesActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que quieres cerrar sesión?",
                "Cerrar sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if(opcion == JOptionPane.YES_OPTION){
            JFrameLogin login = new JFrameLogin();
            login.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed
        // TODO add your handling code here:
        new Ayuda().mostrarAyuda("login");
    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        // TODO add your handling code here:
        JFrameGestionUsuarios usuario = new JFrameGestionUsuarios(rol);
        usuario.setVisible(true);
        usuario.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarDatosActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona fichero de datos de prueba");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(
            new javax.swing.filechooser.FileNameExtensionFilter(
                "XML y JSON (*.xml, *.json)", "xml", "json"));
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                String resumen = new proyecto.logica.CargaDatosPrueba()
                                     .cargar(chooser.getSelectedFile());
                JOptionPane.showMessageDialog(this,
                    "Datos cargados correctamente:\n\n" + resumen,
                    "Carga completada", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonCargarDatosActionPerformed

    
    public void configurarMenu() {
        // TERMINAR Profesor
        //if (rolUsuario == "Entrenador") {
        if (rol.equals("Entrenador")) {
            // Desactivar botones que NO deben usarse
            jButtonSocios.setEnabled(false);
            jButtonPagos.setEnabled(false);
            jButtonUsuarios.setEnabled(false);

            // Mantener activados los permitidos
            jButtonAsistencias.setEnabled(true);
            jButtonAyuda.setEnabled(true);
            jButtonCerrarSesion.setEnabled(true);
            jButtonPlanes.setEnabled(true);
        } else if(rol.equals("Administrador")){ // Es un admin
            // Mantener activados los permitidos
            jButtonSocios.setEnabled(true);
            jButtonPagos.setEnabled(true);
            jButtonUsuarios.setEnabled(true);
            jButtonAsistencias.setEnabled(true);
            jButtonAyuda.setEnabled(true);
            jButtonCerrarSesion.setEnabled(true);
            jButtonPlanes.setEnabled(true);
        } else { // Es un profesor
            // Desactivar botones que NO deben usarse
            jButtonSocios.setEnabled(false);
            jButtonPagos.setEnabled(false);
            jButtonUsuarios.setEnabled(false);
            jButtonPlanes.setEnabled(false);
            
            // Mantener activados los permitidos
            jButtonAsistencias.setEnabled(true);
            jButtonAyuda.setEnabled(true);
            jButtonCerrarSesion.setEnabled(true);
            
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new JFrameMenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAsistencias;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonCargarDatos;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonPagos;
    private javax.swing.JButton jButtonPlanes;
    private javax.swing.JButton jButtonSocios;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
