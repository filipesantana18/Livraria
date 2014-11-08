
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livraria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aluno
 */
public class Cliente {
private Integer cod_cliente;
private String Nome;
private int cpf;
private String cidade;
private String bairro;
private String estado;
private int rg;
private int cep;
private int telefone;
private String endereco;
private String status;

  

  

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
    public Integer getCod_cliente() {
        return cod_cliente;
    }
    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    

    public void incluir(){
    String Q="";
    Q="insert into cliente(cod_cliente,nome,cpf,cidade,Bairro,Estado,RG,CEP,Telefone,Endereco)";
    Q+=" values("+cod_cliente+",'"+Nome+"'";
    Q+=","+cpf+",'"+cidade+"'" ;
    Q+=",'"+bairro+"','"+estado+"'" ;
    Q+=","+rg+","+cep+"" ;
    Q+=","+telefone+",'"+endereco+"'" ;
    
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
System.out.println(status);
}
    }
    public void alterar(){
    String Q="";
    Q="update cliente set ";
    Q+="nome='"+Nome+"'";
    Q+=",cpf="+cpf;
    Q+=",cidade='"+cidade+"'";
    Q+=",Bairro='"+bairro+"'";
    Q+=",Estado='"+estado+"'";
    Q+=",RG="+rg;
    Q+=",CEP="+cep;
    Q+=",Telefone="+telefone;
    Q+=",Endereco='"+endereco+"'";
    Q+=" where cod_cliente="+cod_cliente;
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
    public boolean excluir(){
        boolean retorno;
String Q="delete from cliente";
Q+=" where cod_cliente="+cod_cliente;
Connection cn=conexao.getConnection();
try{
     Statement st=cn.createStatement();
    st.executeUpdate(Q);
     status="Excluido com sucesso!";
     retorno = true;
}
catch(SQLException e){
    status=e.getMessage();
    retorno = false;
}
return retorno;
}
    public void consultar(){
    String Q="select * from";
    Q+=" cliente where cod_cliente=";
    Q+=cod_cliente;
    Connection cn=conexao.getConnection();
    System.out.println(Q);
    try{
     Statement st=cn.createStatement();
    ResultSet rs =st.executeQuery(Q);
    if(rs.next()){
        Nome=rs.getString("nome");
        cpf=rs.getInt("cpf");
        cidade=rs.getString("cidade");
        bairro=rs.getString("Bairro");
        estado=rs.getString("estado");
        rg=rs.getInt("RG");
        cep=rs.getInt("CEP");
        telefone=rs.getInt("Telefone");
        endereco=rs.getString("Endereco");
        status="localizado com sucesso";
         }else{
        status="nao existe";}
        }
    catch(SQLException e){
        status=e.getMessage();
    }
}    
      public List<Cliente> listarTodos() {  
     String sql="select * from cliente";  
    List<Cliente> listAll = new ArrayList<Cliente>();  
    Cliente n;        
    try {  
        Connection con = conexao.getConnection();  
        Statement stm = con.createStatement();  
          ResultSet rs = stm.executeQuery(sql);  
       while (rs.next()) {  
              n = new Cliente();  
            n.setNome(rs.getString("Nome"));  
            n.setTelefone(Integer.parseInt(rs.getString("Telefone")));  
            listAll.add(n);  
            
              
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
    