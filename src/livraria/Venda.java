/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livraria;
import java.text.*;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author aluno
 */
public class Venda {
public String vet[]=new String[20];
int i=0;
int min;
int est;
private String Nome_cliente;
private String Nome_produto;
private int item_venda;
private int cod_venda;
private int quantidade;
private int cod_produto;
private int cod_cliente;
private String data_venda;
private String status;

    public String getNome_cliente() {
        return Nome_cliente;
    }
    public void setNome_cliente(String Nome_cliente) {
        this.Nome_cliente = Nome_cliente;
    }
    public String getNome_produto() {
        return Nome_produto;
    }
    public void setNome_produto(String Nome_produto) {
        this.Nome_produto = Nome_produto;
    }
    public int getCod_cliente() {
        return cod_cliente;
    }
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    public int getCod_produto() {
        return cod_produto;
    }
    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }
    public int getCod_venda() {
        return cod_venda;
    }
    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }
    public String getData_venda() {
        return data_venda;
    }
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }
    public int getItem_venda() {
        return item_venda;
    }
    public void setItem_venda(int item_venda) {
        this.item_venda = item_venda;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


 public void Data(){
   Date agora=new Date();
     DateFormat DF1 = DateFormat.getDateInstance();
       data_venda = DF1.format(agora);
 }

 public void buscar(){
    String Q="select cod_cliente from cliente";
    Q+=" where nome='"+Nome_cliente+"'";
    Connection cn=conexao.getConnection();
   //  System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_cliente=rs.getInt("cod_cliente");
     //     System.out.println(cod_cliente);
                status="OK";
    }
    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }

public void venda(){
    String Q="select cod_venda from venda order by cod_venda desc";
     Connection cn=conexao.getConnection();
   //  System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_venda=rs.getInt("cod_venda");
        cod_venda=cod_venda+1;
                  status="OK";
    }
   else{
   cod_venda=1;
                  }

    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }

public void incluir_venda(){
quantidade=0;
item_venda=0;
String Q="";
    Q="insert into venda(cod_venda,cod_cliente,data_venda)";
    Q+=" values("+cod_venda+","+cod_cliente+"";
    Q+=",'"+data_venda;
    Q+="')";

    Connection cn=conexao.getConnection();
    // System.out.println(Q);
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="Incluido com sucesso!";
}
catch(SQLException e){
    status=e.getMessage();
}

}

public void busca_prod(){
        String Q="select cod_produto from produto";
    Q+=" where nome='"+Nome_produto+"'";
     Connection cn=conexao.getConnection();
   //  System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_produto=rs.getInt("cod_produto");
   //       System.out.println(cod_cliente);
                status="OK";
    }
    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }
public void baixaestoque(){

    String q="select * from";
    q+=" produto where cod_produto=";
    q+=cod_produto;
    Connection cn=conexao.getConnection();
  //  System.out.println(q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(q);
    if(rs.next()){
        min=rs.getInt("estoque_min");
        est=rs.getInt("quantidade_est");
       // System.out.println("estoque  !!!!!");
         }else{
        System.out.println("nao tem");}
        }
    catch(SQLException e){
        status=e.getMessage();
    }

if (est<=min && est>0){
    JOptionPane.showMessageDialog(null,"O estoque do "+Nome_produto+"está abaixo do minimo " +
            "/n A quantidade de livros desponiveis "+est);
      String Q="update produto set quantidade_est=quantidade_est-"+quantidade;
    Q+=" where cod_produto="+cod_produto;
      //  System.out.println(Q);
  try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
   // System.out.println("alterado !!!");
}
catch(SQLException e){
    status=e.getMessage();
}


}
else{

   if(est>min){
      String Q="update produto set quantidade_est=quantidade_est-"+quantidade;
    Q+=" where cod_produto="+cod_produto;
      //  System.out.println(Q);

try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
   // System.out.println("alterado !!!");
}
catch(SQLException e){
    status=e.getMessage();
}

    }else{
      if(est<=0){
            JOptionPane.showMessageDialog(null,"Nao contem livros na loja "+est);
        }
    }
}









}

public void incluir_item(){
    String Q="";
    Q="insert into item_venda(cod_venda,item_venda,cod_produto,quantidade)";
    Q+=" values("+cod_venda+","+item_venda;
    Q+=","+cod_produto+","+quantidade+"";
    Q+=")";

    Connection cn=conexao.getConnection();
  //   System.out.println(Q);
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="Incluida Venda!";
}
catch(SQLException e){
    status=e.getMessage();
}

}


public void autonomecli(){
    String Q="select nome from cliente";
     Connection cn=conexao.getConnection();
    //System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
   while(rs.next()!=false){
        vet[i]=rs.getString("nome");
       //   System.out.println(vet[i]);
        i++;
        status="OK";
    }
}
    catch(SQLException e){
        status=e.getMessage();
    }
}
public void autonomepro(){
    String Q="select nome from produto";

    Connection cn=conexao.getConnection();
    //System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
   while(rs.next()!=false){
        vet[i]=rs.getString("nome");
    //      System.out.println(vet[i]);
        i++;
        status="OK";
    }
}
    catch(SQLException e){
        status=e.getMessage();
    }
}
}
