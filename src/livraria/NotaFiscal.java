/*
 * NotaFiscal.java
 * Created on 10 de Julho de 2005, 16:19
 * @author  Ivan Mecenas
 */

package livraria;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;


public class NotaFiscal extends javax.swing.JDialog {
   private int cod_venda;

    public int getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    private Connection cn;
    private String CodMateria = "";
    
    /** Creates new form NotaFiscal */
    
  public  NotaFiscal(java.awt.Frame parent, boolean modal) {
         super(parent, modal);
        initComponents();
	// Recupera arquivo de propriedades
	 Connection cn = conexao.getConnection();
    }
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        tabela1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nota Fiscal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                nota(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        pnlSuperior.add(btnSair);

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela1.setEnabled(false);
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicaGrid(evt);
            }
        });
        getContentPane().add(tabela1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-611)/2, (screenSize.height-530)/2, 611, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        CodMateria = "";
		 Connection cn = conexao.getConnection();
                 try {
                 cn.close();
                 }catch(SQLException e) {
                     e.printStackTrace();
                 }
	setVisible(false);
	dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void clicaGrid(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicaGrid
        // TODO add your handling code here:
        pegaValor();
    }//GEN-LAST:event_clicaGrid

    private void nota(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_nota
        String  query="select p.nome,p.preco,i.quantidade,p.preco*i.quantidade as total_item from produto as p, item_venda as i,";
query+="venda as v where i.cod_venda=v.cod_venda and i.cod_produto=p.cod_produto and i.cod_venda="+(cod_venda);
query+=" order by i.item_venda";
        System.out.println(query);
        System.out.println(cod_venda);
        pesquisaTabela(query);
    }//GEN-LAST:event_nota

    private void pesquisaTabela(String query) {
        Statement comm;
	ResultSet resultSet;
         Connection cn = conexao.getConnection();
	try {
           
            comm=cn.createStatement();
          //  comm = cn.createStatement();
            resultSet = comm.executeQuery(query);
            exibeDados(resultSet);
            comm.close();
        }
	catch (SQLException sqlex) {
            sqlex.printStackTrace();
	}
    }

    private void exibeDados(ResultSet rs) throws SQLException {
        // Posiciona para o primeiro registro
	boolean registros = rs.next();
	// Verifica se a tabela cont�m registros
	if (!registros) {
            JOptionPane.showMessageDialog(this, "Tabela vazia!" );
            setTitle("Sem registros para exibir" );
            return;
	}
	setTitle("Materias");
	Vector colunas = new Vector();
	Vector linhas = new Vector();
       
	try {
            // Monta cabe�alhos das colunas
           ResultSetMetaData rsmd = rs.getMetaData();
           for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
             // colunas.addElement(trataNomeColuna(rsmd.getColumnName(i)));
              colunas.addElement(rsmd.getColumnName(i));
              
           }
            do { 
         
                linhas.addElement(recuperaDados(rs, rsmd));
                System.out.println(linhas+""+colunas);
            } while (rs.next());
System.out.println(linhas+""+colunas);
            // Exibe os dados
            tabela1 = new JTable(linhas, colunas);
            JScrollPane scroller = new JScrollPane(tabela1);
            getContentPane().add(scroller, BorderLayout.CENTER);
            validate();
        }
	catch (SQLException sqlex) {
            sqlex.printStackTrace();
	}
    }

    private Vector recuperaDados(ResultSet rs, ResultSetMetaData rsmd)
        throws SQLException	{
	Vector dadosTabela = new Vector();
	for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
            dadosTabela.addElement(rs.getString(i));
	}	
	return dadosTabela;
    }
    
    private void fechaConexao() {
        try {
            cn.close();
	}
	catch (SQLException sqlex) {
            System.err.println( "N�o foi poss�vel encerrar a conex�o." );
            sqlex.printStackTrace();
	}
    }

    private void pegaValor() {
        int row=0;
	int col = 0;
        System.out.println("to no pegavalor");
	try {
            row = tabela1.getSelectedRow();
            if (row >= 0) {
                Object data = tabela1.getValueAt(row, col);
		CodMateria = data.toString();
                System.out.println(CodMateria);
            }    
	}
	catch(Exception e) {
            CodMateria = "";
	}
        System.out.println("row " + CodMateria);
    }
	
 

      
	
    public String getCodMateria() {
        return CodMateria;
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
