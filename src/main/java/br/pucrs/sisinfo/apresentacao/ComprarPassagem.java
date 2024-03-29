/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.app.config.guice.GuiceConfig;
import br.pucrs.sisinfo.negocio.controller.PassageiroController;
import br.pucrs.sisinfo.negocio.controller.PassagemController;
import br.pucrs.sisinfo.negocio.controller.VooController;
import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Calendar;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author William
 */
public class ComprarPassagem extends javax.swing.JFrame {

    VooController vooController;

    @Inject
    public ComprarPassagem(VooController vooController) {
        this.vooController = vooController;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoComprar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoVoo = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoPassaporte = new javax.swing.JTextField();
        campoRGCPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoData = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoComprar.setText("Compra");
        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });

        jLabel1.setText("Voo:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Passaporte:");

        jLabel4.setText("RG/CPF:");

        jLabel5.setText("Data:");

        campoData.setEditable(false);
        campoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataActionPerformed(evt);
            }
        });

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botaoComprar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoData)
                            .addComponent(campoNome)
                            .addComponent(campoPassaporte)
                            .addComponent(campoVoo)
                            .addComponent(campoRGCPF))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPassaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRGCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoComprar)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataActionPerformed

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarActionPerformed
        Injector injector = Guice.createInjector(new GuiceConfig());
        PassageiroController lc = injector.getInstance(PassageiroController.class);
        PassagemController pc = injector.getInstance(PassagemController.class);
        if (Integer.parseInt(campoVoo.getText()) % 2 == 0) {
            campoRGCPF.setEnabled(false);
            if (!campoPassaporte.getText().isEmpty()) {
                boolean pass = lc.checkPassaporte(campoPassaporte.getText());
                if (pass) {
                    pc.realizarCompra(new Passagem(Integer.parseInt(campoVoo.getText()), String.valueOf(lc.getID()), pc.checarStatus(vooController.dataEmbarque(Integer.parseInt(campoVoo.getText())))));
                    JOptionPane.showMessageDialog(rootPane, "Passagem adquirida", "Passagem", INFORMATION_MESSAGE);
                }
            }
        } else if (!campoPassaporte.getText().isEmpty()) {
            boolean pass = lc.checkPassaporte(campoPassaporte.getText());
            if (pass) {
                pc.realizarCompra(new Passagem(Integer.parseInt(campoVoo.getText()), String.valueOf(lc.getID()), pc.checarStatus(vooController.dataEmbarque(Integer.parseInt(campoVoo.getText())))));
                JOptionPane.showMessageDialog(rootPane, "Passagem adquirida", "Passagem", INFORMATION_MESSAGE);
            }
        } else if (!campoRGCPF.getText().isEmpty()) {
            boolean pass = lc.checkRG(campoRGCPF.getText());
            if (pass) {
                pc.realizarCompra(new Passagem(Integer.parseInt(campoVoo.getText()), String.valueOf(lc.getID()), pc.checarStatus(vooController.dataEmbarque(Integer.parseInt(campoVoo.getText())))));
                JOptionPane.showMessageDialog(rootPane, "Passagem adquirida", "Passagem", INFORMATION_MESSAGE);
            } else {
                pass = lc.checkCPF(campoRGCPF.getText());
                if (pass) {
                    pc.realizarCompra(new Passagem(Integer.parseInt(campoVoo.getText()), String.valueOf(lc.getID()), pc.checarStatus(vooController.dataEmbarque(Integer.parseInt(campoVoo.getText())))));
                    JOptionPane.showMessageDialog(rootPane, "Passagem adquirida", "Passagem", INFORMATION_MESSAGE);
                }
            }
        }
        campoRGCPF.setEnabled(true);
    }//GEN-LAST:event_botaoComprarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        if (!campoVoo.getText().isEmpty()) {
            Calendar c = vooController.dataEmbarque(Integer.parseInt(campoVoo.getText()));
            campoData.setText(c.getTime().toString());
        }


    }//GEN-LAST:event_pesquisarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComprarPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Injector injector = Guice.createInjector(new GuiceConfig());
                ComprarPassagem comprarPassagem = injector.getInstance(ComprarPassagem.class);
                comprarPassagem.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoComprar;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPassaporte;
    private javax.swing.JTextField campoRGCPF;
    private javax.swing.JTextField campoVoo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton pesquisar;
    // End of variables declaration//GEN-END:variables
}
