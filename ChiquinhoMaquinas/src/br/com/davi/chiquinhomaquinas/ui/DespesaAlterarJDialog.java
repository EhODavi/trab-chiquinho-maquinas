package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.DateParse;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.negocio.DespesaControle;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import java.text.ParseException;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class DespesaAlterarJDialog extends javax.swing.JDialog {

    private Despesa d = null;

    public Despesa getDespesa() {
        return this.d;
    }

    public DespesaAlterarJDialog(java.awt.Frame parent, boolean modal, int CDDESPESA) {
        super(parent, modal);
        initComponents();

        try {
            List<TipoDespesa> tdList = null;
            TipoDespesaControle tdControle = new TipoDespesaControle();
            tdList = tdControle.consultarTodos();
            ComboBoxModel<TipoDespesa> tdModel = new DefaultComboBoxModel<TipoDespesa>();
            boxTipoDespesa.setModel(tdModel);
            for (int i = 0; i < tdList.size(); i++) {
                boxTipoDespesa.addItem(tdList.get(i));
            }

            DespesaControle dControle = new DespesaControle();
            Despesa d = dControle.consultarPorId(CDDESPESA);
            DateParse dp = new DateParse();
            taDescricao.setText(d.getDESCRICAO());
            TipoDespesa td = tdControle.consultarPorId(d.getCDTIPODESPESAFK());
            int index = -1;
            for (int i = 0; i < tdList.size(); i++) {
                if (td.getCDTIPODESPESA() == tdList.get(i).getCDTIPODESPESA()) {
                    index = i;
                }
            }
            boxTipoDespesa.setSelectedIndex(index);

            tfValor.setText(d.getVALOR() + "");
            if (d.getSITUACAO().equals("P")) {
                radioP.setSelected(true);
            } else {
                radioN.setSelected(true);
            }

            ftfData.setText(dp.dateToString(d.getDATA()));
            this.d = d;
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        painelBotoes = new javax.swing.JPanel();
        botaoAlterar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        labelTipoDespesa = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelSituacao = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        boxTipoDespesa = new javax.swing.JComboBox<>();
        tfValor = new javax.swing.JTextField();
        radioP = new javax.swing.JRadioButton();
        radioN = new javax.swing.JRadioButton();
        painelDescricao = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        ftfData = new javax.swing.JFormattedTextField();
        botaoAdicionar = new javax.swing.JButton();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        labelAsterisco4 = new javax.swing.JLabel();
        labelAsterisco5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Despesa");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(565, 370));
        setResizable(false);
        setSize(new java.awt.Dimension(515, 329));

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

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Alteração de Despesa");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        labelTipoDespesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipoDespesa.setText("Tipo");
        labelTipoDespesa.setPreferredSize(new java.awt.Dimension(94, 30));
        painelPrincipal.add(labelTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 30));

        labelData.setBackground(new java.awt.Color(255, 255, 255));
        labelData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelData.setText("Data");
        labelData.setPreferredSize(new java.awt.Dimension(26, 30));
        painelPrincipal.add(labelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        labelValor.setBackground(new java.awt.Color(255, 255, 255));
        labelValor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelValor.setText("Valor");
        labelValor.setPreferredSize(new java.awt.Dimension(30, 30));
        painelPrincipal.add(labelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        labelSituacao.setBackground(new java.awt.Color(255, 255, 255));
        labelSituacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSituacao.setText("Situação");
        labelSituacao.setPreferredSize(new java.awt.Dimension(50, 30));
        painelPrincipal.add(labelSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        labelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        labelDescricao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDescricao.setText("Descrição");
        labelDescricao.setPreferredSize(new java.awt.Dimension(58, 30));
        painelPrincipal.add(labelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        boxTipoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxTipoDespesa.setPreferredSize(new java.awt.Dimension(65, 30));
        painelPrincipal.add(boxTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValor.setCaretColor(new java.awt.Color(255, 153, 51));
        tfValor.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfValor.setPreferredSize(new java.awt.Dimension(14, 30));
        tfValor.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 100, -1));

        radioP.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioP);
        radioP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioP.setSelected(true);
        radioP.setText("Paga");
        radioP.setPreferredSize(new java.awt.Dimension(61, 30));
        painelPrincipal.add(radioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        radioN.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioN);
        radioN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioN.setText("Não Paga");
        radioN.setPreferredSize(new java.awt.Dimension(86, 30));
        painelPrincipal.add(radioN, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 90, -1));

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        painelDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        taDescricao.setRows(5);
        taDescricao.setCaretColor(new java.awt.Color(255, 153, 51));
        taDescricao.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        taDescricao.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelDescricao.setViewportView(taDescricao);

        painelPrincipal.add(painelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 240, 110));

        try {
            ftfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfData.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfData.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfData.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfData.setPreferredSize(new java.awt.Dimension(109, 30));
        ftfData.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 100, -1));

        botaoAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(41, 30));
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        painelPrincipal.add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        labelAsterisco1.setToolTipText("");
        labelAsterisco1.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        labelAsterisco2.setToolTipText("");
        labelAsterisco2.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        labelAsterisco3.setToolTipText("");
        labelAsterisco3.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        labelAsterisco4.setToolTipText("");
        labelAsterisco4.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        labelAsterisco5.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco5.setText("*");
        labelAsterisco5.setToolTipText("");
        labelAsterisco5.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 10, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        TipoDespesaCadastroJDialog tdCadastro = new TipoDespesaCadastroJDialog(this, true);
        tdCadastro.setVisible(true);

        TipoDespesa td = tdCadastro.getTipoDespesa();
        if (td != null) {
            boxTipoDespesa.addItem(td);
            boxTipoDespesa.setSelectedItem(td);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.d = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        if (boxTipoDespesa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo [Tipo] é obrigatório! Por favor, selecione-o [Caso não exista, cadastre um novo].", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Descrição] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taDescricao.getText().length() > 255) {
            JOptionPane.showMessageDialog(null, "O Campo [Descrição] deve possuir no máximo 255 caracteres. Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ftfData.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Data] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            DateParse dp = new DateParse();
            this.d.setDATA(dp.parseDate(ftfData.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "A Data informada é inválida! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfValor.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Valor informado deve ser um número maior do que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor] deve receber apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.d.setDESCRICAO(taDescricao.getText());
        Object o = boxTipoDespesa.getSelectedItem();
        TipoDespesa td = (TipoDespesa) o;
        this.d.setCDTIPODESPESAFK(td.getCDTIPODESPESA());
        this.d.setVALOR(Double.parseDouble(tfValor.getText()));
        if (radioP.isSelected() == true) {
            this.d.setSITUACAO("P");
        } else {
            this.d.setSITUACAO("N");
        }
        try {
            DateParse dp = new DateParse();
            DespesaControle dControle = new DespesaControle();
            dControle.alterar(this.d);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Alteração de Despesa realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(DespesaAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DespesaAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DespesaAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DespesaAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DespesaAlterarJDialog dialog = new DespesaAlterarJDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<TipoDespesa> boxTipoDespesa;
    private javax.swing.JFormattedTextField ftfData;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelAsterisco4;
    private javax.swing.JLabel labelAsterisco5;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTipoDespesa;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JScrollPane painelDescricao;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JRadioButton radioN;
    private javax.swing.JRadioButton radioP;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
