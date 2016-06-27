package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.persistencia.dao.AeroportoDao;
import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import java.util.List;
import javax.swing.JFrame;

public class SelecionarAeroportoDialog extends javax.swing.JDialog {
    
    private final AeroportoDao dao;
    private JFrame parent;
    
    public SelecionarAeroportoDialog(JFrame parent, AeroportoDao dao) {
        super(parent);
        this.dao = dao;
        this.parent = parent;
        
        initComponents();
        tableAeroportos.setModel(new AeroportoTableModel(dao.todos()));
        
        System.out.println(parent);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAeroportos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        selecionarAeroporto = new javax.swing.JButton();
        textoBusca = new javax.swing.JTextField();
        botaoBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableAeroportos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAeroportos);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Selecione o aeroporto de partida:");

        selecionarAeroporto.setText("Selecionar");
        selecionarAeroporto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarAeroportoActionPerformed(evt);
            }
        });

        botaoBusca.setText("Buscar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar aeroporto por nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selecionarAeroporto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoBusca))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selecionarAeroporto)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        List<Aeroporto> resultado = dao.buscarPorNome(textoBusca.getText());
        tableAeroportos.setModel(new AeroportoTableModel(resultado));
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void selecionarAeroportoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarAeroportoActionPerformed
        
        Aeroporto aeroportoPartida = new Aeroporto(
                (String) tableAeroportos.getModel().getValueAt(tableAeroportos.getSelectedRow(),0), 
                (String) tableAeroportos.getModel().getValueAt(tableAeroportos.getSelectedRow(),1));
        
        ((Pesquisa) parent).setAeroportoPartida(aeroportoPartida);
        
        dispose();
        
    }//GEN-LAST:event_selecionarAeroportoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selecionarAeroporto;
    private javax.swing.JTable tableAeroportos;
    private javax.swing.JTextField textoBusca;
    // End of variables declaration//GEN-END:variables
}
