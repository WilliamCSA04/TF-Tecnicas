package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.app.config.guice.GuiceConfig;
import br.pucrs.sisinfo.negocio.controller.MapaAssentoController;
import br.pucrs.sisinfo.negocio.controller.PassagemController;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class MapaAssentos extends javax.swing.JFrame {

    private MapaAssentoController controller;
    private static int passagemID;
    @Inject
    public MapaAssentos(MapaAssentoController controller) {
        this.controller = controller;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poltrona1 = new javax.swing.JCheckBox();
        poltrona2 = new javax.swing.JCheckBox();
        poltrona3 = new javax.swing.JCheckBox();
        poltrona4 = new javax.swing.JCheckBox();
        poltrona6 = new javax.swing.JCheckBox();
        poltrona7 = new javax.swing.JCheckBox();
        poltrona8 = new javax.swing.JCheckBox();
        poltrona9 = new javax.swing.JCheckBox();
        poltrona5 = new javax.swing.JCheckBox();
        poltrona10 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        poltrona1.setText("Poltrona 1");

        poltrona2.setText("Poltrona 2");

        poltrona3.setText("Poltrona 3");

        poltrona4.setText("Poltrona 4");

        poltrona6.setText("Poltrona 6");

        poltrona7.setText("Poltrona 7");

        poltrona8.setText("Poltrona 8");

        poltrona9.setText("Poltrona 9");

        poltrona5.setText("Poltrona 5");

        poltrona10.setText("Poltrona 10");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poltrona5)
                            .addComponent(poltrona4)
                            .addComponent(poltrona3)
                            .addComponent(poltrona2)
                            .addComponent(poltrona1))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(poltrona6)
                            .addComponent(poltrona7)
                            .addComponent(poltrona8)
                            .addComponent(poltrona9)
                            .addComponent(poltrona10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poltrona1)
                    .addComponent(poltrona6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poltrona2)
                    .addComponent(poltrona7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poltrona3)
                    .addComponent(poltrona8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poltrona4)
                    .addComponent(poltrona9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poltrona5)
                    .addComponent(poltrona10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarPoltronas(new boolean[10]);
        JOptionPane.showMessageDialog(rootPane, "Poltrona Adquirida", "Mapa", INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void updatePoltronas(int idMapa){
        boolean poltronas[] = controller.poltronasOcupadas(idMapa);
        poltrona1.setSelected(poltronas[0]);
        poltrona2.setSelected(poltronas[1]);
        poltrona3.setSelected(poltronas[2]);
        poltrona4.setSelected(poltronas[3]);
        poltrona5.setSelected(poltronas[4]);
        poltrona6.setSelected(poltronas[5]);
        poltrona7.setSelected(poltronas[6]);
        poltrona8.setSelected(poltronas[7]);
        poltrona9.setSelected(poltronas[8]);
        poltrona10.setSelected(poltronas[9]);
        
    }
    
    private void atualizarPoltronas(boolean poltronas[]){
        poltronas[0] = poltrona1.isSelected();
        poltronas[1] = poltrona2.isSelected();
        poltronas[2] = poltrona3.isSelected();
        poltronas[3] = poltrona4.isSelected();
        poltronas[4] = poltrona5.isSelected();
        poltronas[5] = poltrona6.isSelected();
        poltronas[6] = poltrona7.isSelected();
        poltronas[7] = poltrona8.isSelected();
        poltronas[8] = poltrona9.isSelected();
        poltronas[9] = poltrona10.isSelected();
        controller.atualizarPoltronas(poltronas);
        Injector injector = Guice.createInjector(new GuiceConfig());
        PassagemController pc = injector.getInstance(PassagemController.class);
        pc.atualizarStatus(passagemID);
    }
    
    public void saveID(int id) {
        passagemID=id;
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Injector injector = Guice.createInjector(new GuiceConfig());

                MapaAssentos ma = injector.getInstance(MapaAssentos.class);

                ma.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox poltrona1;
    private javax.swing.JCheckBox poltrona10;
    private javax.swing.JCheckBox poltrona2;
    private javax.swing.JCheckBox poltrona3;
    private javax.swing.JCheckBox poltrona4;
    private javax.swing.JCheckBox poltrona5;
    private javax.swing.JCheckBox poltrona6;
    private javax.swing.JCheckBox poltrona7;
    private javax.swing.JCheckBox poltrona8;
    private javax.swing.JCheckBox poltrona9;
    // End of variables declaration//GEN-END:variables

    
}
