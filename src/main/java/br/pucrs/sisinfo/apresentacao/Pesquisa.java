package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.negocio.controller.PesquisaController;
import br.pucrs.sisinfo.negocio.services.interpretadores.Interpretador;
import br.pucrs.sisinfo.persistencia.dao.AeroportoDao;
import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import com.google.inject.Inject;
import java.util.GregorianCalendar;
import java.util.Optional;
import javax.inject.Named;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class Pesquisa extends javax.swing.JFrame {
    
    private final PesquisaController controller;
    private final Interpretador<Optional<GregorianCalendar>> interpretador;
    
    private TableModel tableModelVoos;
    private Aeroporto aeroportoPartida;
    
    private SelecionarAeroportoJFrame selecionarAeroporto;
    private AeroportoDao dao;

    public void setAeroportoPartida(Aeroporto aeroportoPartida) {
        this.aeroportoPartida = aeroportoPartida;
        labelAeroportoPartida.setText(this.aeroportoPartida.getNome());
    }
        
    @Inject
    public Pesquisa(
            
            PesquisaController controller, 
            
            AeroportoDao dao,
           
            @Named("interpretadorData") 
            Interpretador<Optional<GregorianCalendar>> interpretador
    ) {
        
        this.controller = controller;
        this.interpretador = interpretador;
        this.dao = dao;
     
        tableModelVoos = new VooTableModel();
        
        initComponents();
        
        selecionarAeroporto = new SelecionarAeroportoJFrame(dao,this);
        selecionarAeroporto.setResizable(false);
        selecionarAeroporto.setModal(true);
        selecionarAeroporto.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        labelAeroportoPartida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText("Aeroporto de partida: ");

        labelAeroportoPartida.setText("Nenhum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPesquisar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAeroportoPartida))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAeroportoPartida)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(labelPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        
        Optional<GregorianCalendar> dataDigitada = interpretador.interpretar(textFieldPesquisar.getText());
        
        if (!dataDigitada.isPresent()) {
            JOptionPane.showMessageDialog(this, "Data inválida");
        } else {
            tabelaVoos.setModel(new VooTableModel(controller.buscaVoosPorData(aeroportoPartida, dataDigitada.get())));
        }
        
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAeroportoPartida;
    private javax.swing.JLabel labelPesquisar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tabelaVoos;
    private javax.swing.JTextField textFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
