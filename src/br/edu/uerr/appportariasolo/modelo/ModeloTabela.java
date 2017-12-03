/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Diego_Note
 */
public class ModeloTabela implements TableModel{

    @Override
    public int getRowCount() {
        return conteudo.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
    switch(columnIndex){
        case 0:
            return String.class;
        case 1:
            return String.class;
        case 2:
            return String.class;
        case 3:
            return String.class;
        default:
            return null;
    }    
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return conteudo.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    List<StatusPessoa> conteudo=new ArrayList<>();

    public List<StatusPessoa> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<StatusPessoa> conteudo) {
        this.conteudo = conteudo;
    }
    
    
    String[] colunas = new String[]{
        "NOME",
        "CPF",
        "TIPO",
        "SETOR"
        
    };
    
}
