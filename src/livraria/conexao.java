/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class conexao {
    public static String status="";
    public static Connection getConnection(){
        Connection con=null;
        try{ //cria uma área protegida para verificação de erro
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/proj_livraria?user=root";
            
            con = DriverManager.getConnection(url);
            status = "Conexão aberta!";
           
        }
        catch(SQLException e){
            status = e.getMessage();
        }
        catch(ClassNotFoundException e){
            status = e.getMessage();
        }
        catch(Exception e){
            status = e.getMessage();
        }
        System.out.println(status);
        return con;
    }
}