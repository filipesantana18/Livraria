/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * incluir_pedido.java
 *
 * Created on 07/12/2010, 14:39:13
 */
package livraria;

import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author aluno
 */
public class incluir_compra extends javax.swing.JFrame {

    int item = 0;
    int est = 0;
    private Connection cn;
    private String CodMateria = "";

    /**
     * Creates new form incluir_pedido
     */
    public incluir_compra() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        incluir_venda = new javax.swing.JButton();
        incluir = new javax.swing.JButton();
        codpro = new javax.swing.JTextField();
        quant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFechar1 = new javax.swing.JButton();
        tabela1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        incluir_venda.setText("Pesquisa de pedidos");
        incluir_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluir_vendaActionPerformed(evt);
            }
        });

        incluir.setText("Incluir pedido");
        incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo do produto");

        jLabel2.setText("Quantidade");

        btnFechar1.setText("Fechar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

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
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1clicaGrid(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codpro, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(quant))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incluir)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnFechar1))))
                    .addComponent(incluir_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabela1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(incluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(incluir_venda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabela1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela1clicaGrid(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1clicaGrid
        pegaValor();
    }//GEN-LAST:event_tabela1clicaGrid
    public void baixaestoque() {

        String q = "select * from";
        q += " produto where cod_produto=";
        q += codpro.getText();;
        Connection cn = conexao.getConnection();
        //  System.out.println(q);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {

                est = rs.getInt("quantidade_est");
                // System.out.println("estoque  !!!!!");
            } else {
                System.out.println("nao tem");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirActionPerformed
        baixaestoque();
        String q = "update produto set";
        int a = est + Integer.parseInt(quant.getText());
        q += " quantidade_est=" + a;
        q += " where cod_produto=" + codpro.getText();

        Connection cn = conexao.getConnection();
        //  System.out.println(q);
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(q);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String query = "select cod_produto, "
                + "nome,quantidade_est "
                + "from"
                + " produto where cod_produto=" + codpro.getText();
        pesquisaTabela(query);
    }//GEN-LAST:event_incluirActionPerformed

    private void incluir_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluir_vendaActionPerformed
        String query = "select cod_produto, "
                + "nome, quantidade_est "
                + "from"
                + " produto";
        System.out.println(query);
        pesquisaTabela(query);
}//GEN-LAST:event_incluir_vendaActionPerformed

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        Telas.TelaIncluirCompra.setVisible(false);
        Telas.TelaPrincipal.setVisible(true);
}//GEN-LAST:event_btnFechar1ActionPerformed
    private void pesquisaTabela(String query) {
        Statement comm;
        ResultSet resultSet;
        Connection cn = conexao.getConnection();
        try {

            comm = cn.createStatement();
            //  comm = cn.createStatement();
            resultSet = comm.executeQuery(query);
            exibeDados(resultSet);
            comm.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    private void exibeDados(ResultSet rs) throws SQLException {
        // Posiciona para o primeiro registro
        boolean registros = rs.next();
        // Verifica se a tabela cont�m registros
        if (!registros) {
            JOptionPane.showMessageDialog(this, "Tabela vazia!");
            setTitle("Sem registros para exibir");
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
                //   System.out.println(linhas+""+colunas);
            } while (rs.next());
//System.out.println(linhas+""+colunas);
            // Exibe os dados
            tabela1 = new JTable(linhas, colunas);
            JScrollPane scroller = new JScrollPane(tabela1);
            getContentPane().add(scroller, BorderLayout.CENTER);
            validate();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    private Vector recuperaDados(ResultSet rs, ResultSetMetaData rsmd)
            throws SQLException {
        Vector dadosTabela = new Vector();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
            dadosTabela.addElement(rs.getString(i));
        }
        return dadosTabela;
    }

    private void fechaConexao() {
        try {
            cn.close();
        } catch (SQLException sqlex) {
            System.err.println("N�o foi poss�vel encerrar a conex�o.");
            sqlex.printStackTrace();
        }
    }

    private void pegaValor() {
        int row = 0;
        int col = 0;
        System.out.println("to no pegavalor");
        try {
            row = tabela1.getSelectedRow();
            if (row >= 0) {
                Object data = tabela1.getValueAt(row, col);
                CodMateria = data.toString();
                System.out.println(CodMateria);
            }
        } catch (Exception e) {
            CodMateria = "";
        }
        System.out.println("row " + CodMateria);
    }

    public String getCodMateria() {
        return CodMateria;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new incluir_compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar1;
    private javax.swing.JTextField codpro;
    private javax.swing.JButton incluir;
    private javax.swing.JButton incluir_venda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField quant;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables

}
