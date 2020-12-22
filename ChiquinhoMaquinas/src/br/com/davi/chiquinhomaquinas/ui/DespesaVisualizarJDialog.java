package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.entidade.DateParse;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.negocio.DespesaControle;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import javax.swing.JOptionPane;

public class DespesaVisualizarJDialog extends javax.swing.JDialog {

    public DespesaVisualizarJDialog(java.awt.Frame parent, boolean modal, int CDDESPESA) {
        super(parent, modal);
        initComponents();

        try {
            DespesaControle dControle = new DespesaControle();
            TipoDespesaControle tdControle = new TipoDespesaControle();
            DateParse dp = new DateParse();
            Despesa d = dControle.consultarPorId(CDDESPESA);
            taDescricao.setText(d.getDESCRICAO());
            TipoDespesa td = tdControle.consultarPorId(d.getCDTIPODESPESAFK());
            boxTipoDespesa.addItem(td);
            tfValor.setText(d.getVALOR() + "");
            if (d.getSITUACAO().equals("P")) {
                radioP.setSelected(true);
            } else {
                radioN.setSelected(true);
            }
            ftfData.setText(dp.dateToString(d.getDATA()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
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
        setTitle("Visualização de Despesa");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(565, 370));
        setResizable(false);
        setSize(new java.awt.Dimension(515, 329));

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

        getContentPane().add(painelBotoes, java.awt.BorderLayout.PAGE_END);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Visualização de Despesa");
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
        boxTipoDespesa.setEnabled(false);
        boxTipoDespesa.setPreferredSize(new java.awt.Dimension(65, 30));
        painelPrincipal.add(boxTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        tfValor.setEditable(false);
        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValor.setCaretColor(new java.awt.Color(255, 153, 51));
        tfValor.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfValor.setPreferredSize(new java.awt.Dimension(14, 30));
        tfValor.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 100, -1));

        radioP.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioP);
        radioP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioP.setText("Paga");
        radioP.setEnabled(false);
        radioP.setPreferredSize(new java.awt.Dimension(61, 30));
        painelPrincipal.add(radioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 60, -1));

        radioN.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(radioN);
        radioN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioN.setText("Não Paga");
        radioN.setEnabled(false);
        radioN.setPreferredSize(new java.awt.Dimension(86, 30));
        painelPrincipal.add(radioN, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 90, -1));

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        painelDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        taDescricao.setEditable(false);
        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        taDescricao.setRows(5);
        taDescricao.setCaretColor(new java.awt.Color(255, 153, 51));
        taDescricao.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        taDescricao.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelDescricao.setViewportView(taDescricao);

        painelPrincipal.add(painelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 240, 110));

        ftfData.setEditable(false);
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
        botaoAdicionar.setEnabled(false);
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(41, 30));
        painelPrincipal.add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        labelAsterisco1.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        labelAsterisco2.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 10, 10));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        labelAsterisco3.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        labelAsterisco4.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        labelAsterisco5.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco5.setText("*");
        labelAsterisco5.setPreferredSize(new java.awt.Dimension(10, 10));
        painelPrincipal.add(labelAsterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(DespesaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DespesaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DespesaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DespesaVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                DespesaVisualizarJDialog dialog = new DespesaVisualizarJDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton botaoConfirmar;
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
