/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livraria;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class Produto {
public String vet[]=new String[20];
int i=0;
private int cod_produto;
private String Nome;
private String editora;
private double preco;
private String cronica;
private int cod_editora;
private int estoque=0;
private int estoque_min;
private String status;

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque_min() {
        return estoque_min;
    }

    public void setEstoque_min(int estoque_min) {
        this.estoque_min = estoque_min;
    }

    public int getCod_editora() {
        return cod_editora;
    }

    public void setCod_editora(int cod_editora) {
        this.cod_editora = cod_editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getCronica() {
        return cronica;
    }

    public void setCronica(String cronica) {
        this.cronica = cronica;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

        public void incluir2(){
    String Q="select cod_editora from editora";
    Q+=" where nome_editora='"+editora+"'";
     Connection cn=conexao.getConnection();
     System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()!=false){
        cod_editora=rs.getInt("cod_editora");
          //System.out.println(editora+" "+cod_editora);
                status="OK";
    }
    }
    catch(SQLException e){
        status=e.getMessage();
    }
    }

    public void incluir(){
    String Q="";
    Q="insert into produto(cod_produto,nome,cod_editora,preco,cronica,estoque_min,quantidade_est)";
    Q+=" values("+cod_produto+",'"+Nome+"'";
    Q+=","+cod_editora+","+preco;    
    Q+=",'"+cronica+"'";
    Q+=","+estoque_min+","+estoque ;
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

    public void alterar(){
    String Q="";
    Q="update produto set ";
    Q+="nome='"+Nome+"'";
    Q+=",cod_editora="+cod_editora;
    Q+=",preco="+preco;
    Q+=",Cronica='"+cronica+"'";
    Q+=",estoque_min="+estoque_min;
    Q+="quantidade_est="+estoque;
    Q+=" where cod_produto="+cod_produto;
     System.out.println(Q);
    Connection cn=conexao.getConnection();
try{
    Statement st=cn.createStatement();
    st.executeUpdate(Q);
    status="alterado com sucesso!";
}
catch(SQLException e){
    status=e.getMessage();
    }
}

public void excluir(){
String Q="delete from produto";
Q+=" where cod_produto="+cod_produto;
Connection cn=conexao.getConnection();
try{
     Statement st=cn.createStatement();
    st.executeUpdate(Q);
     status="Excluido com sucesso!";
}
catch(SQLException e){
    status=e.getMessage();
}
}

    public void consultar(){
    String Q="select * from";
    Q+=" produto where cod_produto=";
    Q+=cod_produto;
    Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        Nome=rs.getString("nome");
        cod_editora=rs.getInt("editora");
        preco=rs.getFloat("preco");
        cronica=rs.getString("Cronica");
        estoque_min=rs.getInt("estoque_min");
        status="localizado com sucesso";
         }else{
        status="nao existe";}
        }
    catch(SQLException e){
        status=e.getMessage();
    }
}

public void busca(){
     String Q="select p.nome,p.preco,p.cronica,p.estoque_min,e.nome_editora from produto p,";
     Q+="editora e where cod_produto="+cod_produto+" and p.cod_editora=e.cod_editora";
        Connection cn=conexao.getConnection();
        try{
            Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        Nome=rs.getString("p.nome");
        editora=rs.getString("e.nome_editora");
        preco=rs.getFloat("p.preco");
        cronica=rs.getString("p.Cronica");
        estoque_min=rs.getInt("p.estoque_min");
        status="localizado com sucesso";
         }else{
        status="nao existe";
    }
        }
        catch(SQLException e){
        status=e.getMessage();}
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
    
     public ArrayList listarTodos() {  
     String sql="select * from produtos";  
    ArrayList listAll = new ArrayList();  
       
    try {  
        Connection con = conexao.getConnection();  
        Statement stm = con.createStatement();  
        ResultSet rs = stm.executeQuery(sql);  
       while (rs.next()) {  
        listAll.add(new String[] {rs.getString("Codigo"),
                                  rs.getString("Nome"),
                                  rs.getString("Preço") 
                                 }); 
        }
        con.close();  
        rs.close();  
        stm.close();  
          
    } catch (Exception e) {  
        System.out.println("Listando... "+e.getMessage());  
    }  
  
    return listAll;  
  
} 
    
}
