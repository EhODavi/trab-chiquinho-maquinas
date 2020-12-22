package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import br.com.davi.chiquinhomaquinas.negocio.ClienteJuridicoControle;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ClienteJuridicoConsultarTrab extends javax.swing.JDialog {

    private ClienteJuridico cj = null;

    public ClienteJuridico getClienteJuridico() {
        return this.cj;
    }

    public ClienteJuridicoConsultarTrab(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ClienteJuridicoControle cjControle = new ClienteJuridicoControle();

        List<ClienteJuridico> cjList = null;

        try {
            cjList = cjControle.consultarTodos();
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        preencheTabela(cjList);
    }

    public void preencheTabela(List<ClienteJuridico> cjList) {
        if (cjList != null) {
            String[] strTVet = new String[]{"Código", "Nome", "Endereço", "Telefone", "E-mail", "CNPJ", "Inscrição Estadual"};
            String[][] strTDMat = new String[cjList.size()][7];
            for (int i = 0; i < cjList.size(); i++) {
                ClienteJuridico cj = cjList.get(i);
                strTDMat[i][0] = cj.getCDPESSOA() + "";
                strTDMat[i][1] = cj.getNOME();
                strTDMat[i][2] = cj.getENDERECO();
                if (cj.getTELEFONE().length() == 8) {
                    strTDMat[i][3] = "(31)" + cj.getTELEFONE().substring(0, 4) + "-" + cj.getTELEFONE().substring(4, 8);
                } else {
                    strTDMat[i][3] = "(31)" + cj.getTELEFONE().substring(0, 5) + "-" + cj.getTELEFONE().substring(5, 9);
                }
                strTDMat[i][4] = cj.getEMAIL();
                strTDMat[i][5] = cj.getCNPJ().substring(0, 2) + "." + cj.getCNPJ().substring(2, 5) + "." + cj.getCNPJ().substring(5, 8) + "/" + cj.getCNPJ().substring(8, 12) + "-" + cj.getCNPJ().substring(12, 14);
                strTDMat[i][6] = cj.getINSCRICAOESTADUAL().substring(0, 3) + "." + cj.getINSCRICAOESTADUAL().substring(3, 6) + "." + cj.getINSCRICAOESTADUAL().substring(6, 9) + "/" + cj.getINSCRICAOESTADUAL().substring(9, 13);
            }
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strTDMat, strTVet) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            tabela.setModel(modelo);
            tabela.setRowSorter(new TableRowSorter(modelo));
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(4).setResizable(false);
            tabela.getColumnModel().getColumn(5).setResizable(false);
            tabela.getColumnModel().getColumn(6).setResizable(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            botaoConfirmar.setEnabled(false);
        }
    }

    private void consultarPorNome() {
        try {
            ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
            List<ClienteJuridico> cjList = null;
            cjList = cjControle.consultarPorNome(tfNome.getText());
            preencheTabela(cjList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Cliente Jurídico por Nome: " + e.getMessage());
        }
    }

    public ClienteJuridico getClienteJuridicoFromTable() {
        ClienteJuridico cjRet = null;
        ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            TableModel m = tabela.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);
            try {
                cjRet = cjControle.consultarPorId(id);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return cjRet;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        tfTitulo = new javax.swing.JLabel();
        painelPesquisa = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cliente Jurídico ");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        botaoConfirmar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.setEnabled(false);
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
        painelTitulo.setLayout(new java.awt.BorderLayout());

        tfTitulo.setBackground(new java.awt.Color(255, 255, 255));
        tfTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tfTitulo.setForeground(new java.awt.Color(255, 153, 51));
        tfTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfTitulo.setText("Consultar Cliente Jurídico");
        tfTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        painelTitulo.add(tfTitulo, java.awt.BorderLayout.NORTH);

        painelPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        painelPesquisa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        labelNome.setPreferredSize(new java.awt.Dimension(33, 30));
        painelPesquisa.add(labelNome);

        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNome.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNome.setPreferredSize(new java.awt.Dimension(150, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });
        painelPesquisa.add(tfNome);

        painelTitulo.add(painelPesquisa, java.awt.BorderLayout.WEST);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelTabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(255, 153, 51));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        painelTabela.setViewportView(tabela);

        getContentPane().add(painelTabela, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.cj = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        botaoConfirmar.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if (evt.getKeyCode() == 10) {
            consultarPorNome();
        }
    }//GEN-LAST:event_tfNomeKeyPressed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        ClienteJuridico cj = this.getClienteJuridicoFromTable();
        this.cj = cj;
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
            java.util.logging.Logger.getLogger(ClienteJuridicoConsultarTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoConsultarTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoConsultarTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteJuridicoConsultarTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                ClienteJuridicoConsultarTrab dialog = new ClienteJuridicoConsultarTrab(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    private javax.swing.JLabel tfTitulo;
    // End of variables declaration//GEN-END:variables
}
