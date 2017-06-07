package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {	

    public static Connection getConection(String username, String password, String database) throws SQLException{
        Connection connection = null;
         try{
             String url = "jdbc:postgresql://localhost:5432/"+database; // "//localhost:5432" porta pad�o de instala��o do postgre

             connection = DriverManager.getConnection(url,username,password);

             if(connection != null){
                 System.out.println("STATUS--->Conectado com sucesso!");
             }else{
            	 System.out.println("STATUS--->N�o foi possivel realizar conex�o");
             }

         } catch (SQLException e){
            System.out.println("erro ao se conectar");
            System.out.println(e);
        }

      return connection;
     }	

}
