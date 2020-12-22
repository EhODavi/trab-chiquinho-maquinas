package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.DateParse;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import br.com.davi.chiquinhomaquinas.negocio.DespesaControle;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DespesaCRUD extends javax.swing.JFrame {

    public DespesaCRUD() {
        initComponents();

        DespesaControle dControle = new DespesaControle();

        List<Despesa> dList = null;

        try {
            dList = dControle.consultarTodos();
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        preencheTabela(dList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoCadastrar = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPesquisar = new javax.swing.JPanel();
        labelDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Despesas");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        botaoCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        botaoCadastrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoCadastrar);

        botaoAlterar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAlterar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_edit.png"))); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.setEnabled(false);
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAlterar);

        botaoExcluir.setBackground(new java.awt.Color(255, 255, 255));
        botaoExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_delete.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoExcluir);

        botaoVisualizar.setBackground(new java.awt.Color(255, 255, 255));
        botaoVisualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_magnify.png"))); // NOI18N
        botaoVisualizar.setText("Visualizar");
        botaoVisualizar.setEnabled(false);
        botaoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoVisualizar);

        getContentPane().add(painelBotoes, java.awt.BorderLayout.SOUTH);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelTitulo.setLayout(new java.awt.BorderLayout());

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Gerenciamento de Despesas");
        painelTitulo.add(labelTitulo, java.awt.BorderLayout.NORTH);

        painelPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        painelPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        labelDescricao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDescricao.setText("Descrição");
        labelDescricao.setPreferredSize(new java.awt.Dimension(60, 30));
        labelDescricao.setRequestFocusEnabled(false);
        painelPesquisar.add(labelDescricao);

        tfDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfDescricao.setCaretColor(new java.awt.Color(255, 153, 51));
        tfDescricao.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfDescricao.setPreferredSize(new java.awt.Dimension(150, 30));
        tfDescricao.setSelectionColor(new java.awt.Color(255, 153, 51));
        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyPressed(evt);
            }
        });
        painelPesquisar.add(tfDescricao);

        painelTitulo.add(painelPesquisar, java.awt.BorderLayout.WEST);

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

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Exclusão de Despesa", WIDTH);

        if (opt == JOptionPane.OK_OPTION) {
            try {
                Despesa d = getDespesaFromTable();
                DespesaControle dControle = new DespesaControle();
                dControle.excluir(d.getCDDESPESA());
                int linha = tabela.getSelectedRow();
                DefaultTableModel m = (DefaultTableModel) tabela.getModel();
                m.removeRow(linha);
                desabilitarBotoes();
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro na Exclusão de Despesa: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        botaoExcluir.setEnabled(true);
        botaoAlterar.setEnabled(true);
        botaoVisualizar.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        Despesa d = getDespesaFromTable();
        DespesaAlterarJDialog dAlt = new DespesaAlterarJDialog(this, true, d.getCDDESPESA());
        dAlt.setVisible(true);

        d = dAlt.getDespesa();
        if (d != null) {
            DateParse dp = new DateParse();
            TipoDespesaControle tdControle = new TipoDespesaControle();
            int linha = tabela.getSelectedRow();
            tabela.setValueAt(d.getDESCRICAO(), linha, 1);
            tabela.setValueAt(dp.dateToString(d.getDATA()), linha, 2);
            if (d.getSITUACAO().equals("P")) {
                tabela.setValueAt("Paga", linha, 3);
            } else {
                tabela.setValueAt("Não Paga", linha, 3);
            }
            try {
                tabela.setValueAt(tdControle.consultarPorId(d.getCDTIPODESPESAFK()).getNOME(), linha, 4);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            tabela.setValueAt("R$" + Double.toString(d.getVALOR()), linha, 5);
        }
        desabilitarBotoes();
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        DespesaCadastroJDialog dCadastro = new DespesaCadastroJDialog(this, true);
        dCadastro.setVisible(true);

        Despesa d = dCadastro.getDespesa();
        if (d != null) {
            tfDescricao.setText(d.getDESCRICAO());
            consultarPorDescricao();
        }
        desabilitarBotoes();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void tfDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescricaoKeyPressed
        if (evt.getKeyCode() == 10) {
            consultarPorDescricao();
        }
    }//GEN-LAST:event_tfDescricaoKeyPressed

    private void botaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarActionPerformed
        Despesa d = getDespesaFromTable();
        DespesaVisualizarJDialog dVis = new DespesaVisualizarJDialog(this, true, d.getCDDESPESA());
        dVis.setVisible(true);
        desabilitarBotoes();
    }//GEN-LAST:event_botaoVisualizarActionPerformed
    public Despesa getDespesaFromTable() {
        Despesa dRet = null;
        DespesaControle dControle = new DespesaControle();
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            TableModel m = tabela.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);
            try {
                dRet = dControle.consultarPorId(id);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return dRet;
    }

    private void consultarPorDescricao() {
        try {
            DespesaControle dControle = new DespesaControle();
            List<Despesa> dList = null;
            dList = dControle.consultarPorDescricao(tfDescricao.getText());
            preencheTabela(dList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Despesa por Descrição: " + e.getMessage());
        }
    }

    public void preencheTabela(List<Despesa> tdList) {
        if (tdList != null) {
            String[] strTVet = new String[]{"Código", "Descrição", "Data", "Situação", "Tipo", "Valor"};
            String[][] strTDMat = new String[tdList.size()][6];
            DateParse dp = new DateParse();
            TipoDespesaControle tdControle = new TipoDespesaControle();
            for (int i = 0; i < tdList.size(); i++) {
                Despesa d = tdList.get(i);
                strTDMat[i][0] = d.getCDDESPESA() + "";
                strTDMat[i][1] = d.getDESCRICAO();
                strTDMat[i][2] = dp.dateToString(d.getDATA());
                if (d.getSITUACAO().equals("P")) {
                    strTDMat[i][3] = "Paga";
                } else if (d.getSITUACAO().equals("N")) {
                    strTDMat[i][3] = "Não Paga";
                }
                try {
                    strTDMat[i][4] = tdControle.consultarPorId(d.getCDTIPODESPESAFK()).getNOME();
                } catch (DaoException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                strTDMat[i][5] = "R$" + Double.toString(d.getVALOR());
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
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            desabilitarBotoes();
        }
    }

    public void desabilitarBotoes() {
        botaoExcluir.setEnabled(false);
        botaoAlterar.setEnabled(false);
        botaoVisualizar.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(DespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DespesaCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPesquisar;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfDescricao;
    // End of variables declaration//GEN-END:variables
}
