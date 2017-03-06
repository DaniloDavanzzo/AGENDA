package br.senac.tads.pi3a.agenda.model.dao;

import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.management.RuntimeErrorException;
import br.senac.tads.pi3a.agenda.model.bean.Cliente;
import br.senac.tads.pi3a.agenda.connection.ConnectionUtils;
import br.senac.tads.pi3a.agenda.exceptions.ClienteException;
import java.util.Date;
import javafx.scene.chart.PieChart;


/**
 *
 * @author Danilo
 */
public class ClienteDAO {

    ConnectionUtils con = new ConnectionUtils();
    Cliente mod = new Cliente();
    public void cadastrar(Cliente cliente) {
        con.Connection();
        try {

              
            PreparedStatement pst = con.con.prepareStatement("INSERT INTO AGENDA"
                    + " (cli_data,cli_nome,cli_data_nasc,cli_telefone_movel,cli_email)"
                    + " VALUES(?,?,?,?,?)");
          
            pst.setString(1, cliente.getData());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getDataNasc());                  
            pst.setString(4, cliente.getTelCelular());
            pst.setString(5, cliente.getEmail());
            pst.execute();

            JOptionPane.showMessageDialog(null, " Dados Salvos com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " 1Erro ao Salvar!\n " + ex);
        }
        con.closeConnection();
    }
    public void update(Cliente cliente, String nome) {
        con.Connection();
        try {

            PreparedStatement pst = con.con.prepareStatement("update AGENDA set cli_data=?,cli_nome=?, "
                    + "cli_data_nasc=?,cli_telefone_movel=?,cli_email=? where cli_nome = ?");

            pst.setString(1, cliente.getData());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getDataNasc());                  
            pst.setString(4, cliente.getTelCelular());
            pst.setString(5, cliente.getEmail());
//            pst.setString(2,nome);
            pst.execute();

            JOptionPane.showMessageDialog(null, " Dados Salvos com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " 2Erro ao Salvar!\n " + ex);
        }
        con.closeConnection();
        
    }
    public  Cliente buscar(Cliente cliente, String nome) {
        con.Connection();
        try {

            PreparedStatement pst = con.con.prepareStatement("select * from AGENDA where cli_nome = ?");
            pst.setString(2, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,  "Cliente encontrado");
                cliente.setData(rs.getString("cli_data"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setDataNasc(rs.getString("cli_data_nasc"));
                cliente.setTelCelular(rs.getString("cli_telefone_movel"));
                cliente.setEmail(rs.getString("cli_email"));

            }
            else{
                JOptionPane.showMessageDialog(null, "Cliente Não encontrado");
            }
            pst.execute();         
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado" + ex);
        }
        con.closeConnection();
        return cliente;
    }
    public List<Cliente> retornaTodas() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        try {
            ConnectionUtils con = new ConnectionUtils();
            con.Connection();
            String sql = "select * from AGENDA";
            PreparedStatement stmt = con.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setData(rs.getString("cli_data"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setDataNasc(rs.getString("cli_data_nasc"));
                cliente.setTelCelular(rs.getString("cli_telefone_movel"));
                cliente.setEmail(rs.getString("cli_email"));
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
        return clientes;
    }
    public List<Cliente> retornadesc(String desc) throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        try {
            ConnectionUtils con = new ConnectionUtils();
            con.Connection();

            PreparedStatement stmt = con.con.prepareStatement("select * from AGENDA Where cli_nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setData(rs.getString("cli_data"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setDataNasc(rs.getString("cli_data_nasc"));
                cliente.setTelCelular(rs.getString("cli_telefone_movel"));
                cliente.setEmail(rs.getString("cli_email"));
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
        return clientes;
    }
    
  
    //Lista todos os clientes da tabela clientes
    public static List<Cliente> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM AGENDA WHERE enabled=true";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    //Procura um cliente no banco de dados, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Cliente> procurar(String valor)
            throws SQLException, Exception {
        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou cpf (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM AGENDA WHERE ((UPPER(nome) LIKE UPPER('%"
                + valor + "%') OR UPPER(cliente.Nome) "
                + "LIKE UPPER('%" + valor + "%')) AND enabled=true)";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    //Obtém uma instância da classe "Cliente" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Cliente obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM AGENDA WHERE (cliente_id=" + id
                + " AND enabled=true)";

        //Armazena o valor da consulta numa lista temporária
        List<Cliente> listaClientes = executarConsulta(sql);

        //Verifica se a lista de resposta não é nula e contém resultados
        if (listaClientes != null && listaClientes.size() > 0) {
            //Como a consulta foi feita por ID, este é uma chave
            //primária (só pode haver um) e a verificação de tamanho
            //da lista foi maior que zero, deve significar que há
            //apenas um item de resultado. Retornaremos este primeiro
            //e único item, já que ele é o que se deseja obter.
            return listaClientes.get(0);
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados e a lista estava nula ou vazia.
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }

    //Executa um comando SQL não-consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários.
    private static void executarSQL(String sql) throws
            ClienteException, SQLException, Exception {
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        try {
            //Abre uma conexão com o banco de dados
          // connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute(sql);
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Executa um comando SQL de consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários e a iteração de elementos de resultado
    //para composição de uma lista de clientes para retorno.
    public static List<Cliente> executarConsulta(String sql) throws
            ClienteException, SQLException, Exception {
        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
           // connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id_cliente"));
                cliente.setData(result.getString("cli_data"));  
                cliente.setNome(result.getString("cli_nome"));
                cliente.setDataNasc(result.getString("cli_data_nasc"));             
                cliente.setTelCelular(result.getString("cli_telefone_movel"));
                cliente.setEmail(result.getString("cli_email"));  

                
                //Adiciona a instância na lista
                listaClientes.add(cliente);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }
}
    