package br.pucrs.sisinfo.view;

import br.pucrs.sisinfo.model.domain.Voo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VooTableModel extends AbstractTableModel{
    
    private static final String [] NOMES_COLUNAS = { "Nome" };
    
    private List<Voo> voos;

    public VooTableModel(List<Voo> voos) {
        this.voos = voos;
    }

    public VooTableModel() {
        this.voos = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return voos.size();
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
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return voos.get(rowIndex).getNome();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
