package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.app.config.guice.GuiceConfig;
import br.pucrs.sisinfo.negocio.controller.MapaAssentoController;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class MapaAssentos extends javax.swing.JFrame {

    MapaAssentoController controller;
    
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
        botaoConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        botaoConfirmar.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoConfirmar)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(poltrona10))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoConfirmar)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MapaAssentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapaAssentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapaAssentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapaAssentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Injector injector = Guice.createInjector(new GuiceConfig());

                MapaAssentos ma = injector.getInstance(MapaAssentos.class);

                ma.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
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
