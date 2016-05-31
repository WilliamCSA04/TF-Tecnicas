package br.pucrs.sisinfo.view;

import br.pucrs.sisinfo.config.guice.GuiceConfig;
import br.pucrs.sisinfo.controller.PesquisaController;
import br.pucrs.sisinfo.interpretadores.Interpretador;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.GregorianCalendar;
import java.util.Optional;
import javax.inject.Named;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class Pesquisa extends javax.swing.JFrame {
    
    private final PesquisaController controller;
    private final Interpretador<Optional<GregorianCalendar>> interpretador;
    
    private TableModel tableModelVoos;
        
    @Inject
    public Pesquisa(
            
            PesquisaController controller, 
           
            @Named("interpretadorData") 
            Interpretador<Optional<GregorianCalendar>> interpretador) {
        
        this.controller = controller;
        this.interpretador = interpretador;

     
        tableModelVoos = new VooTableModel();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPesquisar = new javax.swing.JLabel();
        textFieldPesquisar = new javax.swing.JTextField();
        buttonPesquisar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVoos = new javax.swing.JTable(tableModelVoos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelPesquisar.setText("Data para pesquisa: ");

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        labelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        labelTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelTitulo.setText("Pesquisa de Voos");

        jScrollPane2.setViewportView(tabelaVoos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonPesquisar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(labelPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        
        Optional<GregorianCalendar> dataDigitada = interpretador.interpretar(textFieldPesquisar.getText());
        
        if (!dataDigitada.isPresent()) {
            JOptionPane.showMessageDialog(this, "Data inválida");
        } else {
            tabelaVoos.setModel(new VooTableModel(controller.buscaVoosPorData(dataDigitada)));
        }
        
    }//GEN-LAST:event_buttonPesquisarActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Injector injector = Guice.createInjector(new GuiceConfig());
                
                Pesquisa pesquisa = injector.getInstance(Pesquisa.class);
                        
                pesquisa.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPesquisar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tabelaVoos;
    private javax.swing.JTextField textFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
