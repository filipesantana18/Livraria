/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * compra_feita.java
 *
 * Created on 01/01/2004, 04:18:36
 */
package livraria;

import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author aluno
 */
public class compra_feita extends javax.swing.JFrame {

    int item = 0;
    private Connection cn;
    private String CodMateria = "";

    /**
     * Creates new form compra_feita
     */
    public compra_feita() {
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
        cboNome_editora = new javax.swing.JComboBox();
        incluir_compra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcod_compra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboNome_livro = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        edtQuantidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        preco = new javax.swing.JTextField();
        btnFechar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tabela1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                achareditora(evt);
                acharproduto(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        incluir_compra.setText("incluir Compra");
        incluir_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluir_compraActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do cliente:");

        txtcod_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcod_compraActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item de Compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("Nome do Livro:");

        jLabel3.setText("Quantidade:");

        edtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtQuantidadeActionPerformed(evt);
            }
        });

        jButton1.setText("Incluir item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFechar1.setText("Fechar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Preço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btnFechar1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cboNome_livro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(preco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboNome_livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(preco)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btnFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboNome_editora, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(txtcod_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(incluir_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboNome_editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incluir_compra)
                    .addComponent(txtcod_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

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
        getContentPane().add(tabela1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void incluir_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluir_compraActionPerformed
        Compra A = new Compra();
        Object nome = cboNome_editora.getSelectedItem();
        A.setNome_editora(nome.toString());
        A.Data();
        A.buscar();
        A.compra();
        txtcod_compra.setText(Integer.toString(A.getCod_compra()));
        A.incluir_compra();
        status.setText(A.getStatus());
        item = 0;
    }//GEN-LAST:event_incluir_compraActionPerformed

    private void txtcod_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcod_compraActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtcod_compraActionPerformed

    private void edtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtQuantidadeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_edtQuantidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if (item>0){
            item++;
        } else{
            item=1;
        }
        Compra A=new Compra();
        Object nome=cboNome_livro.getSelectedItem();
        A.setNome_produto(nome.toString());
        A.setItem_compra(item);
        A.setQuantidade(Integer.parseInt(edtQuantidade.getText()));
        A.setCod_compra(Integer.parseInt(txtcod_compra.getText()));
        A.setPreco(Float.parseFloat(preco.getText()));
        A.busca_prod();
        A.incluir_item();
        status.setText(A.getStatus());
        //pesquisaTabela();
        String  query="select p.nome,i.quantidade,i.preco_compra,i.quantidade*i.preco_compra as total_item from produto as p, item_compra as i,";
query+="compra as v where i.cod_compra=v.cod_compra and i.cod_produto=p.cod_produto and i.cod_compra="+(Integer.toString(A.getCod_compra()));
query+=" order by i.item_compra";
        System.out.println(query);
        pesquisaTabela(query);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabela1clicaGrid(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1clicaGrid
        pegaValor();
    }//GEN-LAST:event_tabela1clicaGrid

    private void achareditora(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_achareditora
        // TODO add your handling code here:
        DefaultComboBoxModel listModel = new DefaultComboBoxModel();
        cboNome_editora.setModel(listModel);
        if (listModel.getSize() == 0) {
            Compra c = new Compra();
            c.auteditora();
            int i = c.i;
            int j = 0;
            while ((j <= i) && (c.vet[j] != null)) {
                System.out.println(j);
                cboNome_editora.addItem(c.vet[j]);
                j++;
            }
        }
    }//GEN-LAST:event_achareditora

    private void acharproduto(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_acharproduto
        // TODO add your handling code here:
        DefaultComboBoxModel listModel = new DefaultComboBoxModel();
        cboNome_livro.setModel(listModel);
        if (listModel.getSize() == 0) {
            Compra c = new Compra();
            c.autonomepro();
            int i = c.i;
            int j = 0;
            while ((j <= i) && (c.vet[j] != null)) {
                //   System.out.println(j);
                cboNome_livro.addItem(c.vet[j]);
                j++;
            }
        }
    }//GEN-LAST:event_acharproduto

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        Telas.TelaCompra.setVisible(false);
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
                System.out.println(linhas + "" + colunas);
            } while (rs.next());
            System.out.println(linhas + "" + colunas);
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
                new compra_feita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar1;
    private javax.swing.JComboBox cboNome_editora;
    private javax.swing.JComboBox cboNome_livro;
    private javax.swing.JTextField edtQuantidade;
    private javax.swing.JButton incluir_compra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField preco;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabela1;
    private javax.swing.JTextField txtcod_compra;
    // End of variables declaration//GEN-END:variables

}
