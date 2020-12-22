package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Funcionario;
import br.com.davi.chiquinhomaquinas.negocio.FuncionarioControle;
import javax.swing.JOptionPane;

public class FuncionarioAlterarJDialog extends javax.swing.JDialog {

    private Funcionario f = null;

    public Funcionario getFuncionario() {
        return this.f;
    }

    public FuncionarioAlterarJDialog(java.awt.Frame parent, boolean modal, int CDPESSOA) {
        super(parent, modal);
        initComponents();

        try {
            FuncionarioControle fControle = new FuncionarioControle();
            Funcionario f = fControle.consultarPorId(CDPESSOA);
            tfNome.setText(f.getNOME());
            tfTelefoneCelular.setText(f.getTELEFONE());
            tfEndereco.setText(f.getENDERECO());
            ftfCPF.setText(f.getCPF());
            tfEmail.setText(f.getEMAIL());
            tfValor.setText(f.getVALORHORA() + "");
            this.f = f;
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        botaoAlterar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        labelTelefoneCelular = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfTelefoneCelular = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        ftfCPF = new javax.swing.JFormattedTextField();
        tfValor = new javax.swing.JTextField();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        labelAsterisco4 = new javax.swing.JLabel();
        labelAsterisco5 = new javax.swing.JLabel();
        labelAsterisco6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Funcionário");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(505, 355));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Alteração de Funcionário");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoAlterar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAlterar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAlterar);

        botaoCancelar.setBackground(new java.awt.Color(255, 255, 255));
        botaoCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/cancel.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoCancelar);

        getContentPane().add(painelBotoes, java.awt.BorderLayout.PAGE_END);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        painelPrincipal.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        labelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        labelEndereco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEndereco.setText("Endereço");
        painelPrincipal.add(labelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        labelTelefoneCelular.setBackground(new java.awt.Color(255, 255, 255));
        labelTelefoneCelular.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTelefoneCelular.setText("Telefone/Celular");
        painelPrincipal.add(labelTelefoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 100, -1));

        labelEmail.setBackground(new java.awt.Color(255, 255, 255));
        labelEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmail.setText("E-mail");
        painelPrincipal.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        labelCPF.setBackground(new java.awt.Color(255, 255, 255));
        labelCPF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCPF.setText("CPF");
        painelPrincipal.add(labelCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        labelValor.setBackground(new java.awt.Color(255, 255, 255));
        labelValor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelValor.setText("Valor/Hora");
        painelPrincipal.add(labelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNome.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNome.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, -1));

        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEndereco.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEndereco.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 190, -1));

        tfTelefoneCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTelefoneCelular.setCaretColor(new java.awt.Color(255, 153, 51));
        tfTelefoneCelular.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfTelefoneCelular.setPreferredSize(new java.awt.Dimension(65, 30));
        tfTelefoneCelular.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfTelefoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 130, -1));

        tfEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEmail.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEmail.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEmail.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEmail.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 190, -1));

        try {
            ftfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCPF.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfCPF.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfCPF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfCPF.setPreferredSize(new java.awt.Dimension(49, 30));
        ftfCPF.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, -1));

        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValor.setCaretColor(new java.awt.Color(255, 153, 51));
        tfValor.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfValor.setPreferredSize(new java.awt.Dimension(59, 30));
        tfValor.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 130, -1));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        painelPrincipal.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 10, -1));

        labelAsterisco5.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco5.setText("*");
        painelPrincipal.add(labelAsterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 10, -1));

        labelAsterisco6.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco6.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco6.setText("*");
        painelPrincipal.add(labelAsterisco6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 10, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.f = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        FuncionarioControle fControle = new FuncionarioControle();
        if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfNome.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome] deve possuir no máximo 45 caracteres! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfNome.getText().matches("[A-Z a-z Çç]{" + tfNome.getText().length() + "}") == false) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome] não deve conter valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Endereço] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEndereco.getText().length() > 255) {
            JOptionPane.showMessageDialog(null, "O Campo [Endereço] deve possuir no máximo 255 caracteres! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [E-mail] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEmail.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "O Campo [E-mail] deve possuir no máximo 45 caracteres! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (fControle.validarEmail(tfEmail.getText()) == false) {
            JOptionPane.showMessageDialog(null, "O E-mail digitado não é valido! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfTelefoneCelular.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Telefone/Celular] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfTelefoneCelular.getText().length() != 8 && tfTelefoneCelular.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "O Campo [Telefone/Celular] deve possuir 8 ou 9 caracteres! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i = 0; i < tfTelefoneCelular.getText().length(); i++) {
            try {
                Double.parseDouble(tfTelefoneCelular.getText().substring(i));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O Campo [Telefone/Celular] deve conter apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if (ftfCPF.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "O Campo [CPF] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String cpf = ftfCPF.getText().substring(0, 3) + ftfCPF.getText().substring(4, 7) + ftfCPF.getText().substring(8, 11) + ftfCPF.getText().substring(12, 14);
        if (fControle.isCPF(cpf) == false) {
            JOptionPane.showMessageDialog(null, "O CPF digitado não é valido! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor/Hora] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfValor.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Campo [Valor/Hora] deve ser maior que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor/Hora] deve conter apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.f.setNOME(tfNome.getText());
        this.f.setTELEFONE(tfTelefoneCelular.getText());
        this.f.setENDERECO(tfEndereco.getText());
        this.f.setEMAIL(tfEmail.getText());
        this.f.setVALORHORA(Double.parseDouble(tfValor.getText()));
        this.f.setCPF(ftfCPF.getText().substring(0, 3) + ftfCPF.getText().substring(4, 7) + ftfCPF.getText().substring(8, 11) + ftfCPF.getText().substring(12, 14));
        try {
            fControle.alterar(this.f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Alteração de Funcionário realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_botaoAlterarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FuncionarioAlterarJDialog dialog = new FuncionarioAlterarJDialog(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JFormattedTextField ftfCPF;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelAsterisco4;
    private javax.swing.JLabel labelAsterisco5;
    private javax.swing.JLabel labelAsterisco6;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefoneCelular;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefoneCelular;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}