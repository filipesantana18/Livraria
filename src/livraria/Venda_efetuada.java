/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Venda_efetuada.java
 *
 * Created on 30/11/2010, 08:18:27
 */

package livraria;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author aluno
 */
public class Venda_efetuada extends javax.swing.JFrame {
 private String CodMateria = "";
int item=0;
 private Connection cn;
    /** Creates new form Venda_efetuada */
    public Venda_efetuada() {
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cboNome_cliente = new javax.swing.JComboBox();
        incluir_venda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcod_venda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboNome_livro = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        edtQuantidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        btnFechar1 = new javax.swing.JButton();
        tabela1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                ativarnomecliente(evt);
                ativarnomeproduto(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        incluir_venda.setText("incluir venda");
        incluir_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluir_vendaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do cliente:");

        txtcod_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcod_vendaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item de Venda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboNome_livro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboNome_livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(edtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(txtcod_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(incluir_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboNome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incluir_venda)
                    .addComponent(txtcod_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void edtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtQuantidadeActionPerformed

    private void ativarnomecliente(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ativarnomecliente
//        DefaultComboBoxModel listModel=new DefaultComboBoxModel();
//    cboNome_cliente.setModel(listModel);
//    if (listModel.getSize()==0){
//        Venda c=new Venda();
//    c.autonomecli();
//    int i=c.i;
//    int j=0;
//    while((j<=i)&&(c.vet[j]!=null)){
//      System.out.println(j);
//    cboNome_cliente.addItem(c.vet[j]);
 //      j++;
    }//GEN-LAST:event_ativarnomecliente
    
    
    
private void ativarnomeproduto(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ativarnomeproduto
 //DefaultComboBoxModel listModel=new DefaultComboBoxModel();
   // cboNome_livro.setModel(listModel);
 //   if (listModel.getSize()==0){
   // Venda c=new Venda();
  //  c.autonomepro();
   // int i=c.i;
//    int j=0;
  //  while((j<=i)&&(c.vet[j]!=null)){
    //  System.out.println(j);
    //   cboNome_livro.addItem(c.vet[j]);
    // j++;
     //  }}
}//GEN-LAST:event_ativarnomeproduto

private void incluir_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluir_vendaActionPerformed
   Venda A=new Venda();
    Object nome=cboNome_cliente.getSelectedItem();
    A.setNome_cliente(nome.toString());
    A.Data();
    A.buscar();
    A.venda();
    txtcod_venda.setText(Integer.toString(A.getCod_venda()));
    A.incluir_venda();
    status.setText(A.getStatus());
    item=0;

}//GEN-LAST:event_incluir_vendaActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if (item>0){
    item++;}
else{
    item=1;}
    Venda A=new Venda();
    Object nome=cboNome_livro.getSelectedItem();
    A.setNome_produto(nome.toString());
    A.setItem_venda(item);
    A.setQuantidade(Integer.parseInt(edtQuantidade.getText()));
    A.setCod_venda(Integer.parseInt(txtcod_venda.getText()));
    A.busca_prod();
    A.baixaestoque();
    A.incluir_item();
    status.setText(A.getStatus());
    String  query="select p.nome,p.preco,i.quantidade,p.preco*i.quantidade as total_item from produto as p, item_venda as i,";
query+="venda as v where i.cod_venda=v.cod_venda and i.cod_produto=p.cod_produto and i.cod_venda="+(Integer.parseInt(txtcod_venda.getText()));
query+=" order by i.item_venda";
        System.out.println(query);
        
        pesquisaTabela(query);

}//GEN-LAST:event_jButton1ActionPerformed

private void txtcod_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcod_vendaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtcod_vendaActionPerformed

private void tabela1clicaGrid(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1clicaGrid
pegaValor();

}//GEN-LAST:event_tabela1clicaGrid

private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        Telas.TelaVenda.setVisible(false);
        Telas.TelaPrincipal.setVisible(true);
}//GEN-LAST:event_btnFechar1ActionPerformed

 private void pesquisaTabela(String query) {
        Statement comm;
	ResultSet resultSet;
         Connection cn = conexao.getConnection();
	try {

            comm=cn.createStatement();
            comm = cn.createStatement();
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


    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda_efetuada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar1;
    private javax.swing.JComboBox cboNome_cliente;
    private javax.swing.JComboBox cboNome_livro;
    private javax.swing.JTextField edtQuantidade;
    private javax.swing.JButton incluir_venda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabela1;
    private javax.swing.JTextField txtcod_venda;
    // End of variables declaration//GEN-END:variables

}
