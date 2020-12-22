package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.entidade.Pessoa;

public class OpcaoPessoaCadastroJDialog extends javax.swing.JDialog {

    private Pessoa p = null;

    public Pessoa getPessoa() {
        return this.p;
    }

    public OpcaoPessoaCadastroJDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        labelTipoPessoa = new javax.swing.JLabel();
        labelAsterisco = new javax.swing.JLabel();
        radioF = new javax.swing.JRadioButton();
        radioJ = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoa");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(316, 190));
        setResizable(false);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        botaoConfirmar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoConfirmar);

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

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Cadastro de Pessoa");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTipoPessoa.setBackground(new java.awt.Color(255, 255, 255));
        labelTipoPessoa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipoPessoa.setText("Tipo de Pessoa");
        labelTipoPessoa.setPreferredSize(new java.awt.Dimension(50, 30));
        painelPrincipal.add(labelTipoPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 90, -1));

        labelAsterisco.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco.setText("*");
        labelAsterisco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 20, -1));

        radioF.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioF);
        radioF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioF.setSelected(true);
        radioF.setText("Física");
        radioF.setPreferredSize(new java.awt.Dimension(61, 30));
        painelPrincipal.add(radioF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, -1));

        radioJ.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioJ);
        radioJ.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioJ.setText("Jurídica");
        radioJ.setPreferredSize(new java.awt.Dimension(86, 30));
        painelPrincipal.add(radioJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 70, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        if (radioF.isSelected() == true) {
            ClienteFisicoCadastroJDialog clCadastro = new ClienteFisicoCadastroJDialog(this, true);
            clCadastro.setVisible(true);

            Pessoa p = clCadastro.getClienteFisico();
            this.p = p;
        } else {
            ClienteJuridicoCadastroJDialog cjCadastro = new ClienteJuridicoCadastroJDialog(this, true);
            cjCadastro.setVisible(true);

            Pessoa p = cjCadastro.getClienteJuridico();
            this.p = p;
        }
        if (this.p != null) {
            this.dispose();
        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.p = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(OpcaoPessoaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcaoPessoaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcaoPessoaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcaoPessoaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OpcaoPessoaCadastroJDialog dialog = new OpcaoPessoaCadastroJDialog(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JLabel labelAsterisco;
    private javax.swing.JLabel labelTipoPessoa;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JRadioButton radioF;
    private javax.swing.JRadioButton radioJ;
    // End of variables declaration//GEN-END:variables
}
