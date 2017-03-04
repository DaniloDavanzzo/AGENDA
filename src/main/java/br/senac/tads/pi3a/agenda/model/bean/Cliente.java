package br.senac.tads.pi3a.agenda.model.bean;

/**
 *
 * @author Glebson
 */
public class Cliente {
    
    //Atributos
    private  int id;
    private String data;
    private String nome;
    private String dataNasc;
    private String email;
    private String telCelular;

    public Cliente() {
      
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the nome to id
     */
    public void setId(int id) {
        this.id = id;
    } 
     /**
     * @return the Data
     */
      public String getData() {
        return data;
    }    
    /**
     * @param data the nome to id
     */
    public void setData(String data) {
        this.data = data;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the dataNasc
     */
    public String getDataNasc() {
        return dataNasc;
    }
    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the telCelular
     */
    public String getTelCelular() {
        return telCelular;
    }
    /**
     * @param telCelular the telCelular to set
     */
    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }
}
