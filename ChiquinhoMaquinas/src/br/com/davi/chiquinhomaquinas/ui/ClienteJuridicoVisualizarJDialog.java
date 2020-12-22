package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import br.com.davi.chiquinhomaquinas.negocio.ClienteJuridicoControle;
import javax.swing.JOptionPane;

public class ClienteJuridicoVisualizarJDialog extends javax.swing.JDialog {

    public ClienteJuridicoVisualizarJDialog(java.awt.Frame parent, boolean modal, int CDPESSOA) {
        super(parent, modal);
        initComponents();

        try {
            ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
            ClienteJuridico cj = cjControle.consultarPorId(CDPESSOA);
            tfNome.setText(cj.getNOME());
            tfTelefoneCelular.setText(cj.getTELEFONE());
            tfEndereco.setText(cj.getENDERECO());
            ftfCNPJ.setText(cj.getCNPJ());
            tfEmail.setText(cj.getEMAIL());
            ftfInscricaoEstadual.setText(cj.getINSCRICAOESTADUAL());
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
        botaoConfirmar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        labelTelefoneCelular = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCNPJ = new javax.swing.JLabel();
        labelInscricaoEstadual = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfTelefoneCelular = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        ftfCNPJ = new javax.swing.JFormattedTextField();
        ftfInscricaoEstadual = new javax.swing.JFormattedTextField();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        labelAsterisco4 = new javax.swing.JLabel();
        labelAsterisco6 = new javax.swing.JLabel();
        labelAsterisco7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualização de Cliente Jurídico");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(505, 355));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Visualização de Cliente Jurídico");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

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

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        painelPrincipal.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 10));

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

        labelCNPJ.setBackground(new java.awt.Color(255, 255, 255));
        labelCNPJ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCNPJ.setText("CNPJ");
        painelPrincipal.add(labelCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        labelInscricaoEstadual.setBackground(new java.awt.Color(255, 255, 255));
        labelInscricaoEstadual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelInscricaoEstadual.setText("Inscrição Estadual");
        painelPrincipal.add(labelInscricaoEstadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        tfNome.setEditable(false);
        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNome.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNome.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, -1));

        tfEndereco.setEditable(false);
        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEndereco.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEndereco.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 190, -1));

        tfTelefoneCelular.setEditable(false);
        tfTelefoneCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTelefoneCelular.setCaretColor(new java.awt.Color(255, 153, 51));
        tfTelefoneCelular.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfTelefoneCelular.setPreferredSize(new java.awt.Dimension(65, 30));
        tfTelefoneCelular.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfTelefoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 130, -1));

        tfEmail.setEditable(false);
        tfEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEmail.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEmail.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEmail.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEmail.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 190, -1));

        ftfCNPJ.setEditable(false);
        try {
            ftfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCNPJ.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfCNPJ.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfCNPJ.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfCNPJ.setPreferredSize(new java.awt.Dimension(49, 30));
        ftfCNPJ.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, -1));

        ftfInscricaoEstadual.setEditable(false);
        try {
            ftfInscricaoEstadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfInscricaoEstadual.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfInscricaoEstadual.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfInscricaoEstadual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfInscricaoEstadual.setPreferredSize(new java.awt.Dimension(6, 30));
        ftfInscricaoEstadual.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfInscricaoEstadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 130, -1));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 10, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        painelPrincipal.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 10, -1));

        labelAsterisco6.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco6.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco6.setText("*");
        painelPrincipal.add(labelAsterisco6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        labelAsterisco7.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco7.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco7.setText("*");
        painelPrincipal.add(labelAsterisco7, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 180, 10, -1));

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
            java.util.logging.Logger.getLogger(ClienteJuridicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ClienteJuridicoVisualizarJDialog dialog = new ClienteJuridicoVisualizarJDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JFormattedTextField ftfCNPJ;
    private javax.swing.JFormattedTextField ftfInscricaoEstadual;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelAsterisco4;
    private javax.swing.JLabel labelAsterisco6;
    private javax.swing.JLabel labelAsterisco7;
    private javax.swing.JLabel labelCNPJ;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelInscricaoEstadual;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefoneCelular;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefoneCelular;
    // End of variables declaration//GEN-END:variables
}
