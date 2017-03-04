package br.senac.tads.pi3a.agenda.Principal;
import br.senac.tads.pi3a.agenda.connection.Connectionfactory;
import br.senac.tads.pi3a.agenda.model.bean.Cliente;
import br.senac.tads.pi3a.agenda.model.bean.ModeloTabela;
import br.senac.tads.pi3a.agenda.model.dao.ClienteDAO;
import br.senac.tads.pi3a.agenda.services.cliente.ServicoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DANILO&PAULA
 */
public class Principal extends javax.swing.JFrame {

    Connectionfactory con = new Connectionfactory();
    ClienteDAO dao = new ClienteDAO();
    Cliente cliente = new Cliente();

    /**
     * Creates new form View
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelData = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDataNasc = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jButtonConsultar = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JTextField();
        try{ 
            javax.swing.text.MaskFormatter mask= new javax.swing.text.MaskFormatter("(##)#####-####");
            txtTelefone = new javax.swing.JFormattedTextField(mask);
        }
        catch (Exception e){
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabelData.setText("Data:");

        jLabelNome.setText("Nome:");

        jLabelDataNasc.setText("Data Nasc:");

        jLabelTelefone.setText("Telefone:");

        jLabelEmail.setText("Email:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data", "Nome", "Data Nasc", "Telefone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableDados.setMaximumSize(new java.awt.Dimension(500, 900));
        jTableDados.setMinimumSize(new java.awt.Dimension(900, 900));
        jTableDados.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableDados);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDataNasc)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEmail)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButtonSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jLabelNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataNasc)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonConsultar))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // Validar numeros 

    private void validarNumerosKeyTyped(java.awt.event.KeyEvent evt) {
        char validarNumeros = evt.getKeyChar();
        if ((validarNumeros < '0' || validarNumeros > '9')
                && (validarNumeros < '(' || validarNumeros > '(')
                && (validarNumeros < ')' || validarNumeros > ')')
                && (validarNumeros < ' ' || validarNumeros > ' ')
                && (validarNumeros < '-' || validarNumeros > '-')
                && (validarNumeros < '.' || validarNumeros > '.')) {
            evt.consume();
        }

    }

    // Validar Letras 
    private void validarLetrasKeyTyped(java.awt.event.KeyEvent evt) {
        char validarLetras = evt.getKeyChar();
        if ((validarLetras < 'a' || validarLetras > 'z')
                && (validarLetras < 'A' || validarLetras > 'Z')
                && (validarLetras < ' ' || validarLetras > ' ')) {
            evt.consume();
        }
    }

    // Validar Email 
    private void validarEmailKeyTyped(java.awt.event.KeyEvent evt) {
        char validarEmail = evt.getKeyChar();

        if ((validarEmail < 'a' || validarEmail > 'z')
                && (validarEmail < 'A' || validarEmail > 'Z')
                && (validarEmail < '0' || validarEmail > '9')
                && (validarEmail < '-' || validarEmail > '-')
                && (validarEmail < '_' || validarEmail > '_')
                && (validarEmail < '@' || validarEmail > '@')
                && (validarEmail < ' ' || validarEmail > ' ')
                && (validarEmail < '.' || validarEmail > '.')) {
            evt.consume();
        }
    }

    public void read() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTableDados.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();

        for (Cliente consulta : dao.retornaTodas()) {
            modelo.addRow(new Object[]{
                consulta.getData(),
                consulta.getNome(),
                consulta.getDataNasc(),
                consulta.getTelCelular(),
                consulta.getEmail(),});

        }

    }

    public void readDesc(String desc) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTableDados.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();

        for (Cliente consulta : dao.retornadesc(desc)) {
            modelo.addRow(new Object[]{
                consulta.getData(),
                consulta.getNome(),
                consulta.getDataNasc(),
                consulta.getTelCelular(),
                consulta.getEmail(),});

        }
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        //Data do formulario de venda
        cliente.setData(txtData.getText());
        cliente.setNome(txtNome.getText());
        cliente.setDataNasc(txtDataNasc.getText());
        cliente.setTelCelular(txtTelefone.getText());
        cliente.setEmail(txtEmail.getText());

        try {
            //Chama o serviço para cadastro do cliente
            ServicoCliente.cadastrarCliente(cliente);
        } catch (Exception e) {
            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Caso tenha chegado até aqui, o cliente foi inserido com sucesso
        //Então exibe uma mensagem de sucesso para o usuário
//        JOptionPane.showMessageDialog(rootPane, "Cliente inserido com sucesso",
//                "Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
        //Limpa os campos da tela após realizar a inserção
        txtData.setText("");
        txtNome.setText("");
        txtDataNasc.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        int Confirm = JOptionPane.showConfirmDialog(null, "Deseja Sair do Sistema?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);

        if (Confirm == JOptionPane.YES_OPTION) {
            con.closeConnection();
            dispose();
        } else if (Confirm == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:
        validarLetrasKeyTyped(evt);
        // TODO add your handling code here:
        int numCaracteres = 45;
        if (txtNome.getText().length() >= numCaracteres) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        validarEmailKeyTyped(evt);
        // TODO add your handling code here:
        int numCaracteres = 30;
        if (txtEmail.getText().length() >= numCaracteres) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        if (!txtNome.getText().equals("")) {
            try {
                readDesc(txtNome.getText());
            } catch (SQLException ex) {

            }
        } else {
            try {
                read();
            } catch (SQLException ex) {

            }
        }


    }//GEN-LAST:event_jButtonConsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "DATA", "NOME", "DATANASC", "TELEFONE", "EMAIL"};
        con.Connection();
        ResultSet rs = executaSql(sql);
        try {
            rs.first();
            do {

                // Preenchemdo o arrayList com os dados retornados do BD atraves da variavel rs do Tipo ResultSet
                dados.add(new Object[]{rs.getString("id_cliente"), rs.getString("cli_data"), rs.getString("cli_nome"),
                     rs.getString("cli_data_nasc"), rs.getString("cli_telefone_movel"), rs.getString("cli_email")});
            } while (rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Preencher Tabela Relatório! " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableDados.setModel(modelo); // recebendo o modelo da tabela que foi criada
        jTableDados.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableDados.getColumnModel().getColumn(0).setResizable(false);
        jTableDados.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableDados.getColumnModel().getColumn(1).setResizable(false);
        jTableDados.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableDados.getColumnModel().getColumn(2).setResizable(false);
        jTableDados.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableDados.getColumnModel().getColumn(3).setResizable(false);
        jTableDados.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableDados.getColumnModel().getColumn(4).setResizable(false);
        jTableDados.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTableDados.getColumnModel().getColumn(5).setResizable(false);

        jTableDados.getTableHeader().setReorderingAllowed(false);
        jTableDados.setAutoResizeMode(jTableDados.AUTO_RESIZE_OFF);// Tabela não pode ser reaorganizada
        jTableDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public ResultSet executaSql(String sql) {
        // Abrindo venda assim que selecionar um produto no formulario de venda e setando seu com valor de venda zerado
        try {
            //PreparedStatement pst =con.con.prepareStatement("insert into venda (vl_ven) values (?)"); linha abaixo
            PreparedStatement pst = con.con.prepareStatement(sql);

            Date dataNascimento = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                dataNascimento = format.parse(txtDataNasc.getText());

            } catch (Exception e) {

            }
            format.format(dataNascimento);
            pst.setTimestamp(1, new Timestamp(dataNascimento.getTime()));

            return pst.executeQuery();
        } catch (SQLException ex) {

        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDataNasc;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
