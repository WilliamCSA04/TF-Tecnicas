package br.pucrs.sisinfo.view;

import br.pucrs.sisinfo.model.Voo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VooTableModel extends AbstractTableModel{
    
    private List<Voo> voos;

    public VooTableModel(List<Voo> voos) {
        this.voos = voos;
    }
    
    @Override
    public int getRowCount() {
        return voos.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Nome";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
