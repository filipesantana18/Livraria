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
public class Compra {
public String vet[]=new String[20];
int i=0;
int min;
int est;
private String Nome_editora;
private String Nome_produto;
private int item_compra;
private int cod_compra;
private int quantidade;
private int cod_produto;
private int cod_editora;
private String data_compra;
private float preco;
private String status;

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getNome_editora() {
        return Nome_editora;
    }
    public void setNome_editora(String Nome_editora) {
        this.Nome_editora = Nome_editora;
    }
    public String getNome_produto() {
        return Nome_produto;
    }
    public void setNome_produto(String Nome_produto) {
        this.Nome_produto = Nome_produto;
    }
    public int getCod_compra() {
        return cod_compra;
    }
    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }
    public int getCod_editora() {
        return cod_editora;
    }
    public void setCod_editora(int cod_editora) {
        this.cod_editora = cod_editora;
    }
    public int getCod_produto() {
        return cod_produto;
    }
    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }
    public String getData_compra() {
        return data_compra;
    }
    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }
    public int getItem_compra() {
        return item_compra;
    }
    public void setItem_compra(int item_compra) {
        this.item_compra = item_compra;
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
       data_compra = DF1.format(agora);
 }

 public void buscar(){
    String Q="select cod_editora from editora";
    Q+=" where nome_editora='"+Nome_editora+"'";
     Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_editora=rs.getInt("cod_editora");
          System.out.println(cod_editora);
                status="OK";
    }
    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }


 public void compra(){
    String Q="select cod_compra from compra order by cod_compra desc";
     Connection cn=conexao.getConnection();
   //  System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_compra=rs.getInt("cod_compra");
        cod_compra=cod_compra+1;
                  status="OK";
    }
   else{
   cod_compra=1;
                  }

    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }

public void incluir_compra(){
quantidade=0;
item_compra=0;
String Q="";
    Q="insert into compra(cod_compra,cod_editora,data_compra)";
    Q+=" values("+cod_compra+","+cod_editora+"";
    Q+=",'"+data_compra;
    Q+="')";

    Connection cn=conexao.getConnection();
     System.out.println(Q);
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="Incluido com sucesso!";
}
catch(SQLException e){
    status=e.getMessage();
}

}

public void auteditora(){
    String Q="select nome_editora from editora";
     Connection cn=conexao.getConnection();
    //System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
   while(rs.next()!=false){
        vet[i]=rs.getString("nome_editora");
          System.out.println(vet[i]);
        i++;
        status="OK";
    }
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


      String Q="update produto set quantidade_est=quantidade_est+"+quantidade;
    Q+=" where cod_produto="+cod_produto;
      //  System.out.println(Q);
 Connection cn=conexao.getConnection();
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
   // System.out.println("alterado !!!");
}
catch(SQLException e){
    status=e.getMessage();
}


}

public void incluir_item(){
    String Q="";
    Q="insert into item_compra(item_compra,cod_compra,cod_produto,quantidade,preco_compra)";
    Q+=" values("+item_compra+","+cod_compra;
    Q+=","+cod_produto+","+quantidade+","+preco;
    Q+=")";

    Connection cn=conexao.getConnection();
     System.out.println(Q);
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="Incluido com sucesso!";
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