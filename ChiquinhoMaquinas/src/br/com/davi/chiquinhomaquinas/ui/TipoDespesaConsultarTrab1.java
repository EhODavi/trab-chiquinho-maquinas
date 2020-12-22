package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TipoDespesaConsultarTrab1 extends javax.swing.JDialog {

    private TipoDespesa td = null;

    public TipoDespesa getTipoDespesa() {
        return this.td;
    }

    public TipoDespesaConsultarTrab1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        TipoDespesaControle tdControle = new TipoDespesaControle();

        List<TipoDespesa> tdList = null;

        try {
            tdList = tdControle.consultarTodos();
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        preencheTabela(tdList);
    }

    public void preencheTabela(List<TipoDespesa> tdList) {
        if (tdList != null) {
            String[] strTVet = new String[]{"Código", "Nome", "Destino"};
            String[][] strTDMat = new String[tdList.size()][3];

            for (int i = 0; i < tdList.size(); i++) {
                TipoDespesa td = tdList.get(i);
                strTDMat[i][0] = td.getCDTIPODESPESA() + "";
                strTDMat[i][1] = td.getNOME();
                if (td.getTIPO().equals("V")) {
                    strTDMat[i][2] = "Veículo";
                } else if (td.getTIPO().equals("F")) {
                    strTDMat[i][2] = "Funcionário";
                } else if (td.getTIPO().equals("C")) {
                    strTDMat[i][2] = "Casa";
                } else if (td.getTIPO().equals("O")) {
                    strTDMat[i][2] = "Outros";
                }
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
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private void consultarPorNome() {
        try {
            TipoDespesaControle tdControle = new TipoDespesaControle();
            List<TipoDespesa> tdList = null;
            tdList = tdControle.consultarPorNome(tfNome.getText());
            preencheTabela(tdList);
            botaoConfirmar.setEnabled(false);
        } catch (DaoException de) {
            JOptionPane.showMessageDialog(this, de.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Tipo de Despesa por Nome: " + e.getMessage());
        }
    }

    public TipoDespesa getTipoDespesaFromTable() {
        TipoDespesa tdRet = null;
        TipoDespesaControle tdc = new TipoDespesaControle();
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            TableModel m = tabela.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);
            try {
                tdRet = tdc.consultarPorId(id);
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        return tdRet;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitle = new javax.swing.JPanel();
        tfTitulo = new javax.swing.JLabel();
        painelPesquisa = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Tipo de Despesa");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 600));
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

        painelTitle.setBackground(new java.awt.Color(255, 255, 255));
        painelTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelTitle.setLayout(new java.awt.BorderLayout());

        tfTitulo.setBackground(new java.awt.Color(255, 255, 255));
        tfTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tfTitulo.setForeground(new java.awt.Color(255, 153, 51));
        tfTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfTitulo.setText("Consultar Tipo de Despesa");
        tfTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        painelTitle.add(tfTitulo, java.awt.BorderLayout.NORTH);

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
        tfNome.setPreferredSize(new java.awt.Dimension(130, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });
        painelPesquisa.add(tfNome);

        painelTitle.add(painelPesquisa, java.awt.BorderLayout.WEST);

        getContentPane().add(painelTitle, java.awt.BorderLayout.PAGE_START);

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
        this.td = null;
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
        TipoDespesa td = this.getTipoDespesaFromTable();
        this.td = td;
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
            java.util.logging.Logger.getLogger(TipoDespesaConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoDespesaConsultarTrab1 dialog = new TipoDespesaConsultarTrab1(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel painelTitle;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    private javax.swing.JLabel tfTitulo;
    // End of variables declaration//GEN-END:variables
}