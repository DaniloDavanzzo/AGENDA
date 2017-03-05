package br.senac.tads.pi3a.agenda.connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Danilo
 */
public class ConnectionUtils {
    private static final String DRIVER = "con.jdbc.Driver";
    private static final String URL = "jdbc:derby://localhost:1527/jdbc_contato";
    private static final String USER = "root";
    private static final String PASS = "root";
//    private static final String DRIVER = "con.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
//    private static final String USER = "root";
//    private static final String PASS = "";
    public Statement stmt = null; //prepara sql e executar
    public ResultSet rs = null; // retornando na variavel rs
    public Connection con;

    public void Connection() {
        try {
            
            System.setProperty("jdbc.Drivers", DRIVER);
            con=DriverManager.getConnection(URL, USER, PASS);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro na Conexção: \n " + ex);
        }
    }    
    public void closeConnection(){
        try {
            
             con.close();
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro ao Fechar Conexão com Banco de Dados: \n " + ex.getMessage());
        }
    }    
    public void executaSql(String sql){
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro Executa Sql: \n " + ex.getMessage());
        }
    }
}