package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.app.config.guice.GuiceConfig;
import br.pucrs.sisinfo.negocio.controller.AeroportoController;
import br.pucrs.sisinfo.negocio.controller.PassagemController;
import br.pucrs.sisinfo.negocio.controller.RotaController;
import br.pucrs.sisinfo.negocio.controller.VooController;
import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Calendar;
import java.util.Date;

public class ConsultaPassagem extends javax.swing.JFrame {

    private final PassagemController controller;
    private MapaAssentos mapaAssentos;
    
    @Inject
    public ConsultaPassagem(PassagemController controller, MapaAssentos mapaAssentos) {
        this.controller = controller;
        this.mapaAssentos = mapaAssentos;
        initComponents();
        botaoCheckin.setEnabled(false);
        campoOrigem.setEditable(false);
        campoDestino.setEditable(false);
        campoData.setEditable(false);
        campoStatus.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNumeroPassagem = new javax.swing.JTextField();
        campoOrigem = new javax.swing.JTextField();
        campoDestino = new javax.swing.JTextField();
        campoData = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoStatus = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        botaoCheckin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Passagens");

        jLabel2.setText("Numero da passagem:");

        jLabel3.setText("Origem:");

        jLabel4.setText("Destino:");

        jLabel5.setText("Data da viagem:");

        jLabel6.setText("Status:");

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        botaoCheckin.setText("Check in");
        botaoCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCheckinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNumeroPassagem)
                            .addComponent(campoOrigem)
                            .addComponent(campoDestino)
                            .addComponent(campoData, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(campoStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNumeroPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCheckin))
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        if (!campoNumeroPassagem.getText().isEmpty()) {
            String textoPassagem = campoNumeroPassagem.getText();
            Passagem p = controller.buscarPassagem(textoPassagem);
            Injector injector = Guice.createInjector(new GuiceConfig());
            VooController vc = injector.getInstance(VooController.class);
            Calendar dataEmbarque = vc.dataEmbarque(controller.buscarVooPorPassagem(textoPassagem));
            String[] origemDestino = injector.getInstance(RotaController.class).buscarOrigemDestino(vc.buscarRota(controller.buscarVooPorPassagem(textoPassagem)));
            AeroportoController ac = injector.getInstance(AeroportoController.class);
            campoOrigem.setText(ac.buscarPorID(origemDestino[0]));
            campoDestino.setText(ac.buscarPorID(origemDestino[1]));
            campoData.setText(new Date(dataEmbarque.getTimeInMillis()).toString());
            campoStatus.setText(p.getStatus());
            if(p.getStatus().equalsIgnoreCase("Check-in aberto")){
                botaoCheckin.setEnabled(true);
            }else{
                botaoCheckin.setEnabled(false);
            }
        }

    }//GEN-LAST:event_pesquisarActionPerformed

    private void botaoCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCheckinActionPerformed
        mapaAssentos.setVisible(true);
    }//GEN-LAST:event_botaoCheckinActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Injector injector = Guice.createInjector(new GuiceConfig());

                ConsultaPassagem consultaPassagem = injector.getInstance(ConsultaPassagem.class);

                consultaPassagem.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCheckin;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoDestino;
    private javax.swing.JTextField campoNumeroPassagem;
    private javax.swing.JTextField campoOrigem;
    private javax.swing.JTextField campoStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton pesquisar;
    // End of variables declaration//GEN-END:variables
}
