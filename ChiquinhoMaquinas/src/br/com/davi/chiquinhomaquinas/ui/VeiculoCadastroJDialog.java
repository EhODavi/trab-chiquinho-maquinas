package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;
import br.com.davi.chiquinhomaquinas.negocio.VeiculoControle;
import javax.swing.JOptionPane;

public class VeiculoCadastroJDialog extends javax.swing.JDialog {

    private Veiculo v = null;

    public Veiculo getVeiculo() {
        return this.v;
    }

    public VeiculoCadastroJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VeiculoCadastroJDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelPlaca = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        boxTipo = new javax.swing.JComboBox<>();
        labelNomeModelo = new javax.swing.JLabel();
        labelTipoCobranca = new javax.swing.JLabel();
        boxTipoCobranca = new javax.swing.JComboBox<>();
        labelValor = new javax.swing.JLabel();
        ftfPlaca = new javax.swing.JFormattedTextField();
        tfNomeModelo = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        labelAsterisco4 = new javax.swing.JLabel();
        labelAsterisco5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Veículo");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(437, 341));
        setPreferredSize(new java.awt.Dimension(440, 370));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Cadastro de Veículo");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        botaoCadastrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoCadastrar);

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
        painelPrincipal.setMinimumSize(new java.awt.Dimension(327, 200));
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPlaca.setBackground(new java.awt.Color(255, 255, 255));
        labelPlaca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPlaca.setText("Placa");
        painelPrincipal.add(labelPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        labelTipo.setBackground(new java.awt.Color(255, 255, 255));
        labelTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipo.setText("Tipo");
        painelPrincipal.add(labelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        boxTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pá Carregadeira", "Retroescavadeira", "Caminhão" }));
        boxTipo.setPreferredSize(new java.awt.Dimension(60, 30));
        painelPrincipal.add(boxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 150, -1));

        labelNomeModelo.setBackground(new java.awt.Color(255, 255, 255));
        labelNomeModelo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNomeModelo.setText("Nome/Modelo");
        painelPrincipal.add(labelNomeModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        labelTipoCobranca.setBackground(new java.awt.Color(255, 255, 255));
        labelTipoCobranca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipoCobranca.setText("Tipo de Cobrança");
        painelPrincipal.add(labelTipoCobranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        boxTipoCobranca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxTipoCobranca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Hora", "Por Viagem" }));
        boxTipoCobranca.setPreferredSize(new java.awt.Dimension(60, 30));
        painelPrincipal.add(boxTipoCobranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, -1));

        labelValor.setBackground(new java.awt.Color(255, 255, 255));
        labelValor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelValor.setText("Valor da Cobrança");
        painelPrincipal.add(labelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        try {
            ftfPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfPlaca.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfPlaca.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfPlaca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfPlaca.setPreferredSize(new java.awt.Dimension(6, 30));
        ftfPlaca.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, -1));

        tfNomeModelo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeModelo.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeModelo.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeModelo.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNomeModelo.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 330, 30));

        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValor.setCaretColor(new java.awt.Color(255, 153, 51));
        tfValor.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfValor.setPreferredSize(new java.awt.Dimension(6, 30));
        tfValor.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 150, -1));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 10, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 10, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        painelPrincipal.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        labelAsterisco5.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco5.setText("*");
        painelPrincipal.add(labelAsterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 10, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (ftfPlaca.getText().equals("   -    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Placa] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tfNomeModelo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome/Modelo] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfNomeModelo.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome/Modelo] deve possuir no máximo 45 caracteres. Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor da Cobrança] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfValor.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Campo [Valor da Cobrança] deve ser maior que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor da Cobrança] deve receber apenas valores numéricos. Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Veiculo v = new Veiculo();
        v.setNOME(tfNomeModelo.getText());
        Object o = boxTipo.getSelectedItem();
        String tipo = (String) o;
        if (tipo.equals("Pá Carregadeira")) {
            v.setTIPO("P");
        } else if (tipo.equals("Retroescavadeira")) {
            v.setTIPO("R");
        } else if (tipo.equals("Caminhão")) {
            v.setTIPO("C");
        }

        v.setPLACA(ftfPlaca.getText().substring(0, 3) + ftfPlaca.getText().substring(4, 8));
        v.setPRECO(Double.parseDouble(tfValor.getText()));
        Object x = boxTipoCobranca.getSelectedItem();
        String tpCobranca = (String) x;
        if (tpCobranca.equals("Por Hora")) {
            v.setTIPOCOBRANCA("H");
        } else if (tpCobranca.equals("Por Viagem")) {
            v.setTIPOCOBRANCA("V");
        }
        try {
            VeiculoControle vControle = new VeiculoControle();
            v.setCDVEICULO(vControle.inserir(v));
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Cadastro de Veículo realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        
        this.v = v;
        this.dispose();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.v = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VeiculoCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VeiculoCadastroJDialog dialog = new VeiculoCadastroJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JComboBox<String> boxTipoCobranca;
    private javax.swing.JFormattedTextField ftfPlaca;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelAsterisco4;
    private javax.swing.JLabel labelAsterisco5;
    private javax.swing.JLabel labelNomeModelo;
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTipoCobranca;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextField tfNomeModelo;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
