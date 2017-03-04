package br.senac.tads.pi3a.agenda.services.cliente;

import java.util.List;
import br.senac.tads.pi3a.agenda.model.bean.Cliente;
import br.senac.tads.pi3a.agenda.model.dao.ClienteDAO;
import br.senac.tads.pi3a.agenda.exceptions.ClienteException;
import br.senac.tads.pi3a.agenda.exceptions.DataSourceException;

/**
 * Classe de serviço de cliente *
 */
public class ServicoCliente {
       
    Cliente cliente = new Cliente();
    ClienteDAO cliDAO = new ClienteDAO();

    //Insere um cliente na fonte de dados
    public static void cadastrarCliente(Cliente cliente)
            throws ClienteException, DataSourceException {

        //Realização de validações de negócio
        
         if (cliente.getData() == null || cliente.getData().equals("  /  /    ")) {
            throw new ClienteException("É necessário informar um"
                    + "a data de nascimento");
        }
        if (cliente == null) {
            throw new ClienteException("Não foi informado um cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar "
                    + "um nome de cliente");
        }
        if (cliente.getDataNasc() == null || cliente.getDataNasc().equals("  /  /    ")) {
            throw new ClienteException("É necessário informar um"
                    + "a data de nascimento");
        }
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClienteException("É necessário informar o e-mail");
        } 
        if (cliente.getTelCelular() == null || (cliente.getTelCelular().equals("(  )     -    "))) {
            throw new ClienteException("É necessário informar o telefone celular");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            ClienteDAO cliDAO = new ClienteDAO();
            cliDAO.cadastrar(cliente);

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    
    
    //Atualiza um cliente na fonte de dados
    public static void atualizarCliente(Cliente cliente, String cpf)
            throws ClienteException, DataSourceException {
         //Realização de validações de negócio
      if (cliente.getData() == null || cliente.getData().equals("  /  /    ")) {
            throw new ClienteException("É necessário informar um"
                    + "a data de nascimento");
        }
        if (cliente == null) {
            throw new ClienteException("Não foi informado um cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar "
                    + "um nome de cliente");
        }
        if (cliente.getDataNasc() == null || cliente.getDataNasc().equals("  /  /    ")) {
            throw new ClienteException("É necessário informar um"
                    + "a data de nascimento");
        }
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClienteException("É necessário informar o e-mail");
        } 
        if (cliente.getTelCelular() == null || (cliente.getTelCelular().equals("(  )     -    "))) {
            throw new ClienteException("É necessário informar o telefone celular");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            ClienteDAO cliDAO = new ClienteDAO();
            cliDAO.update(cliente,cpf);

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("1Erro na fonte de dados", e);
        }
    }

    //Obtem o cliente com ID informado do banco de dados
    public static void obterCliente(String nome, Cliente Cliente)
            throws ClienteException, DataSourceException {
        try {
            //Retorna o cliente obtido com o DAO
              ClienteDAO cliDAO = new ClienteDAO();
            cliDAO.buscar(Cliente, nome);

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }


    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public static List<Cliente> procurarCliente(String nome)
            throws ClienteException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return ClienteDAO.listar();
            } else {
                return ClienteDAO.procurar(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
