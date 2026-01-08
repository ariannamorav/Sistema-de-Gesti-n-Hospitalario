package caso_hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Pacientes extends javax.swing.JFrame {

  
    public Pacientes() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        registros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 240, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Kefa", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 131, 190));
        jLabel1.setText("PACIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 72, 178, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Paciente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Numero de Seguro:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 182, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 237, -1, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 30));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 177, 140, -1));

        jButton3.setText("Volver al inicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, -1));

        registros.setText("Registros");
        registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrosActionPerformed(evt);
            }
        });
        jPanel1.add(registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || 
        jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }
    
       
    try {
        int idPaciente = Integer.parseInt(jTextField1.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El ID del paciente debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    
    if (!jTextField2.getText().matches("[a-zA-Z\\s]+")) {
        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }
    
    
    try {
        int numeroSeguro = Integer.parseInt(jTextField3.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El número de seguro debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }

 
    String fechaTexto = jTextField4.getText();
    SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy-MM-dd"); 
    formatoEntrada.setLenient(false); // Para asegurar que el formato sea estricto

    try {
        Date fecha = formatoEntrada.parse(fechaTexto); 
        String fechaFormateada = formatoSQL.format(fecha); 
        
        CLASSX CD = new CLASSX();
        CD.insertarPaciente(Integer.parseInt(jTextField1.getText()), jTextField2.getText(), Integer.parseInt(jTextField3.getText()), fechaFormateada);
        JOptionPane.showMessageDialog(null, "Paciente registrado con éxito");
    } catch (ParseException e) {
     
        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Debe ser dd-MM-yyyy", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Inicio inc = new Inicio();
        inc.setVisible(true);
        inc.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void registrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrosActionPerformed
    CLASSX CD = new CLASSX();
    
    // Obtener la lista de pacientes
    ArrayList<String> pacientes = CD.obtenerPacientes();
    
    if (pacientes.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay registros de pacientes", "Información", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    StringBuilder sb = new StringBuilder();
    for (String paciente : pacientes) {
        sb.append(paciente).append("\n");
    }
        JOptionPane.showMessageDialog(null, sb.toString(), "Registros de Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_registrosActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton registros;
    // End of variables declaration//GEN-END:variables
}
