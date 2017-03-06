package br.senac.tads.pi3a.agenda.Principal;
import br.senac.tads.pi3a.agenda.connection.ConnectionUtils;
import br.senac.tads.pi3a.agenda.model.bean.Cliente;
import br.senac.tads.pi3a.agenda.model.bean.ModeloTabela;
import br.senac.tads.pi3a.agenda.model.dao.ClienteDAO;
import br.senac.tads.pi3a.agenda.services.cliente.ServicoCliente;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class Principal extends javax.swing.JInternalFrame {
    ConnectionUtils con = new ConnectionUtils();
    ClienteDAO dao = new ClienteDAO();
    Cliente cliente = new Cliente();

    public Principal() {
        initComponents();
        con.Connection();

        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        jLData.setText(formato.format(dataSistema));
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTelefone = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jLabelData = new javax.swing.JLabel();
        jButtonConsultar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        txtDataNasc = new javax.swing.JFormattedTextField();
        jLabelDataNasc = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        try{ 
            javax.swing.text.MaskFormatter mask= new javax.swing.text.MaskFormatter("(##)#####-####");
            txtTelefone = new javax.swing.JFormattedTextField(mask);
        }
        catch (Exception e){
        }

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agenda");
        setOpaque(true);

        jLabelTelefone.setText("Telefone:");

        jLData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabelData.setText("Data:");

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelDataNasc.setText("Data Nasc:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataNasc)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(txtEmail)))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelData)
                        .addComponent(jLabelNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataNasc)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 726, 426);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

       try {            
//         
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
   
        //Limpa os campos da tela após realizar a inserção
        jLData.setText("");
        txtNome.setText("");
        txtDataNasc.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(rootPane, "Nenhum campo pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        toFront();
        int Confirm = JOptionPane.showConfirmDialog(null, "Deseja Sair do Sistema?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);

        if (Confirm == JOptionPane.YES_OPTION) {
            con.closeConnection();
            dispose();

        } else if (Confirm == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

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
  public void read() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTableDados.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();

        for (Cliente consulta : dao.retornaTodas()) {
            modelo.addRow(new Object[]{
                consulta.getId(),
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
                consulta.getId(),
                consulta.getData(),
                consulta.getNome(),
                consulta.getDataNasc(),
                consulta.getTelCelular(),
                consulta.getEmail(),});
        }
    }
      public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","DATA","NOME","DATA_NASC","TELEFONE","EMAIL"};
        con.Connection();
        con.executaSql(sql);
        try {
            con.rs.first();
            do {
                // Preenchemdo o arrayList com os dados retornados do BD atraves da variavel rs do Tipo ResultSet
                dados.add(new Object[]{
                    con.rs.getString("id_cliente"),
                    con.rs.getString("cli_data"), 
                    con.rs.getString("cli_nome"),
                    con.rs.getString("cli_data_nasc"), 
                    con.rs.getString("cli_telefone_movel"), 
                    con.rs.getString("cli_email")});               
            } while (con.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher! " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableDados.setModel(modelo); // recebendo o modelo da tabela que foi criada
        jTableDados.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(0).setResizable(false);
        jTableDados.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(1).setResizable(false);
        jTableDados.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(2).setResizable(false);
        jTableDados.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(3).setResizable(false);
        jTableDados.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(4).setResizable(false);
        jTableDados.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableDados.getColumnModel().getColumn(5).setResizable(false);
        jTableDados.getTableHeader().setReorderingAllowed(false);
        jTableDados.setAutoResizeMode(jTableDados.AUTO_RESIZE_OFF);// Tabela não pode ser reaorganizada
        jTableDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDataNasc;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
