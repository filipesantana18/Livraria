/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

/**
 *
 * @author Filipe Santana
 */
import java.util.*;
import javax.swing.table.*;

public class TabelaHelper extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public TabelaHelper(ArrayList dados, String[] colunas) {
        setLinhas(dados);
        setColunas(colunas);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList getLinhas() {
        return linhas;
    }
         
    @Override
    public String getColumnName(int num){
        return this.colunas[num];
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    public void setLinhas(ArrayList list) {
        linhas = list;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtem a linha, que é uma String []  
        String[] linha = (String[]) getLinhas().get(rowIndex);
        // Retorna o objeto que esta na coluna  
        return linha[columnIndex];
    }

    public int getColumnCount() {
        return getColunas().length;
    }

    public int getRowCount() {
        return getLinhas().size();
    }
    
    public Object getValueLinha(int rowIndex) {
        // Obtem a linha, que é uma String []  
        String[] linha = (String[]) getLinhas().get(rowIndex);
        // Retorna o objeto que esta na coluna  
        return linha[3];
    }
}
