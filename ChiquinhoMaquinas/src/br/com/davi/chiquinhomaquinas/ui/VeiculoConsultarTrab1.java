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

public class VeiculoConsultarTrab1 extends javax.swing.JDialog {

    private Veiculo v = null;

    public Veiculo getVeiculo() {
        return this.v;
    }

    public VeiculoConsultarTrab1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

    public void preencheTabela(List<Veiculo> vList) {
        if (vList != null) {
            String[] strTVet = new String[]{"Código", "Nome", "Placa", "Tipo", "Tipo de Cobrança", "Preço"};
            String[][] strTDMat = new String[vList.size()][6];
            for (int i = 0; i < vList.size(); i++) {
                Veiculo v = vList.get(i);
                strTDMat[i][0] = v.getCDVEICULO() + "";
                strTDMat[i][1] = v.getNOME();
                strTDMat[i][2] = v.getPLACA();
                if (v.getTIPO().equals("C")) {
                    strTDMat[i][3] = "Caminhão";
                } else if (v.getTIPO().equals("P")) {
                    strTDMat[i][3] = "Pá Carregadeira";
                } else if (v.getTIPO().equals("R")) {
                    strTDMat[i][3] = "Retroescavadeira";
                }
                if (v.getTIPOCOBRANCA().equals("H")) {
                    strTDMat[i][4] = "Por Hora";
                } else if (v.getTIPOCOBRANCA().equals("V")) {
                    strTDMat[i][4] = "Por Viagem";
                }
                strTDMat[i][5] = Double.toString(v.getPRECO());
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
        }
    }

    private void consultarPorNome() {
        try {
            VeiculoControle vControle = new VeiculoControle();
            List<Veiculo> vList = null;
            vList = vControle.consultarPorNome(tfNome.getText());
            preencheTabela(vList);
            botaoConfirmar.setEnabled(false);
        } catch (DaoException de) {
            JOptionPane.showMessageDialog(this, de.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Veículo por Nome: " + e.getMessage());
        }
    }

    public Veiculo getVeiculoFromTable() {
        Veiculo vRet = null;
        VeiculoControle vc = new VeiculoControle();
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            TableModel m = tabela.getModel();
            String idStr = m.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(idStr);
            try {
                vRet = vc.consultarPorId(id);
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        return vRet;
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
        setTitle("Consultar Veículo");
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
        tfTitulo.setText("Consultar Veículo");
        tfTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        painelTitle.add(tfTitulo, java.awt.BorderLayout.NORTH);

        painelPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        painelPesquisa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        labelNome.setPreferredSize(new java.awt.Dimension(40, 30));
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
        this.v = null;
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
        Veiculo v = this.getVeiculoFromTable();
        this.v = v;
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
            java.util.logging.Logger.getLogger(VeiculoConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoConsultarTrab1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                VeiculoConsultarTrab1 dialog = new VeiculoConsultarTrab1(new javax.swing.JFrame(), true);
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
