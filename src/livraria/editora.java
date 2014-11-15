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
public class editora {
private int cod_editora;
private String Nome;
private String endereco;
private int Cnpj;
private int telefone;
private String bairro;
private String cidade;
private String estado;
private String status;

    public int getCnpj() {
        return Cnpj;
    }

    public void setCnpj(int Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCod_editora() {
        return cod_editora;
    }

    public void setCod_editora(int cod_editora) {
        this.cod_editora = cod_editora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

public void incluir(){
    String Q="";
    Q="insert into editora(cod_editora,nome_editora,CNPJ,endereco,telefone,Bairro,Estado,Cidade)";
    Q+=" values("+cod_editora+",'"+Nome+"'";
    Q+=","+Cnpj+",'"+endereco+"'";
    Q+=","+telefone;
    Q+=",'"+bairro+"','"+estado+"'";
    Q+=",'"+cidade+"'";
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
    Q="update editora set ";
    Q+="nome_editora='"+Nome+"'";
    Q+=",CNPJ="+Cnpj;
    Q+=",endereco='"+endereco+"'";
    Q+=",telefone="+telefone;
    Q+=",Bairro='"+bairro+"'";
    Q+=",Estado='"+estado+"'";
    Q+=",cidade='"+cidade+"'";
    Q+=" where cod_editora="+cod_editora;
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
String Q="delete from editora";
Q+=" where cod_editora="+cod_editora;
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
    public void busca(){
    String Q="select * from";
    Q+=" editora where cod_editora=";
    Q+=cod_editora;
    Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        Nome=rs.getString("nome_editora");
        Cnpj=rs.getInt("CNPJ");
        endereco=rs.getString("endereco");
        telefone=rs.getInt("telefone");
        bairro=rs.getString("Bairro");
        estado=rs.getString("Estado");
        cidade=rs.getString("cidade");
        status="localizado com sucesso";
         }else{
        status="nao existe";}
        }
    catch(SQLException e){
        status=e.getMessage();
    }
}

     public void busca2(int codigo){
    String Q="select * from";
    Q+=" editora where cod_editora=";
    Q+=codigo;
    Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        Nome=rs.getString("nome_editora");
        Cnpj=rs.getInt("CNPJ");
        endereco=rs.getString("endereco");
        telefone=rs.getInt("telefone");
        bairro=rs.getString("Bairro");
        estado=rs.getString("Estado");
        cidade=rs.getString("cidade");
        status="localizado com sucesso";
         }else{
        status="nao existe";}
        }
    catch(SQLException e){
        status=e.getMessage();
    }
}
     
      public ArrayList listarTodos() {  
     String sql="select * from editora";  
    ArrayList listAll = new ArrayList();  
       
    try {  
        Connection con = conexao.getConnection();  
        Statement stm = con.createStatement();  
        ResultSet rs = stm.executeQuery(sql);  
       while (rs.next()) {  
        listAll.add(new String[] {rs.getString("nome"),
                                  rs.getString("telefone"),
                                  rs.getString("cod_cliente") 
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
