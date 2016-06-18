package br.pucrs.sisinfo.apresentacao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AeroportoTableModel extends AbstractTableModel {
    
    private static final String NOMES_COLUNAS [] = {"Id", "Nome"};
    
    private List<Aeroporto> aeroportos;

    public AeroportoTableModel(List<Aeroporto> aeroportos) {
        this.aeroportos = aeroportos;
    }

    AeroportoTableModel() {
        this.aeroportos = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount() {
        return NOMES_COLUNAS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NOMES_COLUNAS[columnIndex];
    }

    @Override
    public int getRowCount() {
        return aeroportos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if (columnIndex == 0) {
            return aeroportos.get(rowIndex).getId();
        }
        
        return aeroportos.get(rowIndex).getNome();
    }
    
}
