package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;
import br.com.davi.chiquinhomaquinas.negocio.VeiculoControle;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VeiculoCRUD extends javax.swing.JFrame {

    public VeiculoCRUD() {
        initComponents();

        VeiculoControle vControle = new VeiculoControle();

        List<Veiculo> vList = null;

        try {
            vList = vControle.consultarTodos();
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        preencheTabela(vList);
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
        labelNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Veículos");
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
        labelTitulo.setText("Gerenciamento de Veículos");
        painelTitulo.add(labelTitulo, java.awt.BorderLayout.NORTH);

        painelPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        painelPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        labelNome.setPreferredSize(new java.awt.Dimension(35, 30));
        labelNome.setRequestFocusEnabled(false);
        painelPesquisar.add(labelNome);

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
        painelPesquisar.add(tfNome);

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
        int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Exclusão de Veiculo", WIDTH);
        if (opt == JOptionPane.OK_OPTION) {
            try {
                Veiculo v = getVeiculoFromTable();
                VeiculoControle vControle = new VeiculoControle();
                vControle.excluir(v.getCDVEICULO());
                int linha = tabela.getSelectedRow();
                DefaultTableModel m = (DefaultTableModel) tabela.getModel();
                m.removeRow(linha);
                desabilitarBotoes();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro na Exclusão de Veiculo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        botaoExcluir.setEnabled(true);
        botaoAlterar.setEnabled(true);
        botaoVisualizar.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        Veiculo v = getVeiculoFromTable();
        VeiculoAlterarJDialog vAlt = new VeiculoAlterarJDialog(this, true, v.getCDVEICULO());
        vAlt.setVisible(true);

        v = vAlt.getVeiculo();
        if (v != null) {
            int linha = tabela.getSelectedRow();
            tabela.setValueAt(v.getNOME(), linha, 1);
            if (v.getTIPO().equals("P")) {
                tabela.setValueAt("Pá Carregadeira", linha, 2);
            } else if (v.getTIPO().equals("R")) {
                tabela.setValueAt("Retroescavadeira", linha, 2);
            } else if (v.getTIPO().equals("C")) {
                tabela.setValueAt("Caminhão", linha, 2);
            }
            tabela.setValueAt(v.getPLACA().substring(0,3) + "-" + v.getPLACA().substring(4,7), linha, 3);
            if (v.getTIPOCOBRANCA().equals("H")) {
                tabela.setValueAt("Por Hora", linha, 4);
            } else if (v.getTIPOCOBRANCA().equals("V")) {
                tabela.setValueAt("Por Viagem", linha, 4);
            }
            tabela.setValueAt("R$" + v.getPRECO() + "", linha, 5);
        }
        desabilitarBotoes();
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        VeiculoCadastroJDialog vCadastro = new VeiculoCadastroJDialog(this, true);
        vCadastro.setVisible(true);

        Veiculo v = vCadastro.getVeiculo();
        if (v != null) {
            tfNome.setText(v.getNOME());
            consultarPorNome();
        }
        desabilitarBotoes();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if (evt.getKeyCode() == 10) {
            consultarPorNome();
        }
    }//GEN-LAST:event_tfNomeKeyPressed

    private void botaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarActionPerformed
        Veiculo v = getVeiculoFromTable();
        VeiculoVisualizarJDialog vVis = new VeiculoVisualizarJDialog(this, true, v.getCDVEICULO());
        vVis.setVisible(true);
        desabilitarBotoes();
    }//GEN-LAST:event_botaoVisualizarActionPerformed
    public Veiculo getVeiculoFromTable() {
        Veiculo vRet = null;
        VeiculoControle vControle = new VeiculoControle();
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            TableModel m = tabela.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);
            try {
                vRet = vControle.consultarPorId(id);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return vRet;
    }

    private void consultarPorNome() {
        try {
            VeiculoControle vControle = new VeiculoControle();
            List<Veiculo> vList = null;
            vList = vControle.consultarPorNome(tfNome.getText());
            preencheTabela(vList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Veiculo por Nome: " + e.getMessage());
        }
    }

    public void preencheTabela(List<Veiculo> vList) {
        if (vList != null) {
            String[] strVVet = new String[]{"Código", "Nome", "Tipo", "Placa", "Tipo de Cobrança", "Preço"};
            String[][] strVMat = new String[vList.size()][6];

            for (int i = 0; i < vList.size(); i++) {
                Veiculo v = vList.get(i);
                strVMat[i][0] = v.getCDVEICULO() + "";
                strVMat[i][1] = v.getNOME();
                if (v.getTIPO().equals("P")) {
                    strVMat[i][2] = "Pá Carregadeira";
                } else if (v.getTIPO().equals("R")) {
                    strVMat[i][2] = "Retroescavadeira";
                } else if (v.getTIPO().equals("C")) {
                    strVMat[i][2] = "Caminhão";
                }
                strVMat[i][3] = v.getPLACA().substring(0,3) + "-" + v.getPLACA().substring(4,7);
                if (v.getTIPOCOBRANCA().equals("H")) {
                    strVMat[i][4] = "Por Hora";
                } else if (v.getTIPOCOBRANCA().equals("V")) {
                    strVMat[i][4] = "Por Viagem";
                }
                strVMat[i][5] = "R$" + v.getPRECO() + "";
            }
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strVMat, strVVet) {
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
            java.util.logging.Logger.getLogger(VeiculoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VeiculoCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPesquisar;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}