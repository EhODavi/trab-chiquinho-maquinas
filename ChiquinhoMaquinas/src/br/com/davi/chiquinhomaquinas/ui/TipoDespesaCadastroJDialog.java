package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import javax.swing.JOptionPane;

public class TipoDespesaCadastroJDialog extends javax.swing.JDialog {

    private TipoDespesa td = null;

    public TipoDespesa getTipoDespesa() {
        return this.td;
    }

    public TipoDespesaCadastroJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public TipoDespesaCadastroJDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        labelDestino = new javax.swing.JLabel();
        boxDestino = new javax.swing.JComboBox<>();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo de Despesa");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(365, 242));
        setPreferredSize(new java.awt.Dimension(370, 270));
        setResizable(false);

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

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Cadastro de Tipo de Despesa");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        painelPrincipal.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNome.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNome.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, -1));

        labelDestino.setBackground(new java.awt.Color(255, 255, 255));
        labelDestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDestino.setText("Destino");
        painelPrincipal.add(labelDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        boxDestino.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veículo", "Funcionário", "Casa", "Outros" }));
        boxDestino.setPreferredSize(new java.awt.Dimension(91, 30));
        painelPrincipal.add(boxDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 120, -1));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfNome.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "O Campo [Nome] deve possuir no máximo 45 caracteres. Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TipoDespesa td = new TipoDespesa();
        td.setNOME(tfNome.getText());
        Object o = boxDestino.getSelectedItem();
        String tipo = (String) o;
        if (tipo.equals("Veículo")) {
            td.setTIPO("V");
        } else if (tipo.equals("Funcionário")) {
            td.setTIPO("F");
        } else if (tipo.equals("Casa")) {
            td.setTIPO("C");
        } else if (tipo.equals("Outros")) {
            td.setTIPO("O");
        }
        try {
            TipoDespesaControle tdControle = new TipoDespesaControle();
            int k = tdControle.inserir(td);
            td.setCDTIPODESPESA(k);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Cadastro de Tipo de Despesa realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.td = td;
        this.dispose();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.td = null;
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
            java.util.logging.Logger.getLogger(TipoDespesaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaCadastroJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoDespesaCadastroJDialog dialog = new TipoDespesaCadastroJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> boxDestino;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelDestino;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}