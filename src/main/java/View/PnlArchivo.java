
package View;

import Controller.LogicaTarea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

public class PnlArchivo extends javax.swing.JPanel {

    public PnlArchivo() {
        initComponents();
        confTodo();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        btnCambiarRuta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbOpciones = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblExtension = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Configurar carpeta de guardado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setText("Ruta:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblRuta.setText("ruta");
        jPanel1.add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        btnCambiarRuta.setText("cambiar");
        btnCambiarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarRutaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 110));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Configurar extension de guardado");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setText("Extension:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        cmbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpcionesActionPerformed(evt);
            }
        });
        jPanel2.add(cmbOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 600, 160));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Configurar nombre de guardado");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setText("Nombre:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, -1));

        lblExtension.setText(".extension");
        jPanel3.add(lblExtension, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 600, 80));

        jButton1.setText("exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOpcionesActionPerformed
        itemSelec();
    }//GEN-LAST:event_cmbOpcionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exportar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCambiarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarRutaActionPerformed
        ventanaCambiarRuta();
    }//GEN-LAST:event_btnCambiarRutaActionPerformed

    private void exportar(){
        if(cmbOpciones.getSelectedIndex()!=0){
            LogicaTarea.exportarArchivo(cmbOpciones.getSelectedIndex());
        }else{
            JOptionPane.showMessageDialog(this, "Extension invalida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void itemSelec(){
        if(cmbOpciones.getSelectedIndex()!=0){
            lblExtension.setText(cmbOpciones.getSelectedItem().toString());
        }else{
            JOptionPane.showMessageDialog(this, "Extension invalida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void envDatos(String rt, String nmbr){
        ruta=rt;
        nombre=nmbr;
    }
    
    private static String ruta="";
    private static String nombre="";
     
    private void confTodo(){
        lblRuta.setText(ruta);
        txtNombre.setText(nombre);
        lblExtension.setText(null);
        
        final DefaultComboBoxModel<String> model=new DefaultComboBoxModel<>();
        model.addElement("");
        model.addElement(".txt");
        model.addElement(".pdf");
        model.addElement(".csv");
        cmbOpciones.setModel(model);
    }
    
    private void ventanaCambiarRuta(){
        //crear la ventana jfilechooser
        JFileChooser selecCarpeta=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        //configurar para seleccionar carpetas
        selecCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //configurar texto del boton
        UIManager.put("FileChooser.openDialogTitleText", "seleccionar-carpeta");
        UIManager.put("FileChooser.openButtonText", "seleccionar carpeta");
        
        //
        int respuesta=selecCarpeta.showOpenDialog(this);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            String rutaElegida=selecCarpeta.getSelectedFile().getAbsolutePath();
            actRuta(rutaElegida);
        }
        
    }
    
    private void actRuta(String paramRuta){
        ruta=paramRuta;
        
        lblRuta.setText(null);
        lblRuta.setText(paramRuta);
        
        LogicaTarea.setRuta(paramRuta);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarRuta;
    private javax.swing.JComboBox<String> cmbOpciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblExtension;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
