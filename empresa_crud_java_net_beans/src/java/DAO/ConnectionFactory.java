package DAO;
import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            Connection conexao = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/empresa",
            "nicolas_figueiredo",
            "admin");
            return conexao;
        } catch (SQLException ex){
            System.out.println("Falha na conexao ao banco de dados!"+ex);
        }
        return null;
    }
}
