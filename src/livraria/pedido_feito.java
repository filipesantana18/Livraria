/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livraria;


import java.text.*;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author aluno
 */

public class pedido_feito {
    public String vet[]=new String[20];
int i=0;
private int cod_encomenda;
private int cod_cliente;
private String nome_produto;
private String nome_cliente;
private int quantidade;
private String Editora;
private int cod_editora;
private String data_ped;
public String status;

    

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_encomenda() {
        return cod_encomenda;
    }

    public void setCod_encomenda(int cod_encomenda) {
        this.cod_encomenda = cod_encomenda;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
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
       data_ped = DF1.format(agora);
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
public void buscar(){
    String Q="select cod_cliente from cliente";
    Q+=" where nome='"+nome_cliente+"'";
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
public void pedido(){
    String Q="select cod_encomenda from Encomenda_prov order by cod_encomenda desc";
     Connection cn=conexao.getConnection();
  // System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    
    if(rs.next()!=false){
        cod_encomenda=rs.getInt("cod_encomenda");
      
        cod_encomenda=cod_encomenda+1;
                  status="OK";
    }
   else{
   cod_encomenda=1;
                  }

    }
    catch(SQLException e){
        status=e.getMessage();
  //      System.out.println(status);
    }
    }
public void incluir_ped(){
    String Q="insert into Encomenda_prov(cod_encomenda,cod_cliente,nome_produto,quantidade,editora,data)";
    Q+=" values("+cod_encomenda+","+cod_cliente+",'"+nome_produto+"',"+quantidade
            +",'"+Editora+"','"+data_ped+"')";
     Connection cn=conexao.getConnection();
     //System.out.println(Q);
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="Incluido com sucesso!";
}
catch(SQLException e){
    status=e.getMessage();
}

}
public void pesquisar(){

    String Q="select * from";
    Q+=" produto where nome='";
    Q+=nome_produto+"'";
    Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        cod_editora=rs.getInt("cod_editora");
        //System.out.println(cod_editora);
        quantidade=rs.getInt("quantidade_est");
        status="localizado com sucesso";
         }else{
        status="nao existe";}
        }
    catch(SQLException e){
        status=e.getMessage();
    }
}
 public void incluir2(){
    String Q="select * from editora";
    Q+=" where cod_editora='"+cod_editora+"'";
     Connection cn=conexao.getConnection();
    // System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        Editora=rs.getString("nome_editora");
         
                status="OK";
    }
    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }

}
