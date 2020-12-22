package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import br.com.davi.chiquinhomaquinas.relatorios.RelatorioTipoDespesa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TipoDespesaRelatorio extends javax.swing.JFrame {

    public TipoDespesaRelatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelBotao = new javax.swing.JPanel();
        botaoGerar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelPrevia = new javax.swing.JLabel();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        labelAsterisco1 = new javax.swing.JLabel();
        boxDestino = new javax.swing.JComboBox<>();
        labelDestino = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        botaoConsultar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório dos Tipos de Despesa");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Relatório dos Tipos de Despesa");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelBotao.setBackground(new java.awt.Color(255, 255, 255));
        painelBotao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoGerar.setBackground(new java.awt.Color(255, 255, 255));
        botaoGerar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_acrobat.png"))); // NOI18N
        botaoGerar.setText("Gerar Relatório");
        botaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarActionPerformed(evt);
            }
        });
        painelBotao.add(botaoGerar);

        getContentPane().add(painelBotao, java.awt.BorderLayout.PAGE_END);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNome.setText("Nome");
        painelPrincipal.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        labelPrevia.setBackground(new java.awt.Color(255, 255, 255));
        labelPrevia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrevia.setText("Prévia:");
        painelPrincipal.add(labelPrevia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(255, 153, 51));
        painelTabela.setViewportView(tabela);

        painelPrincipal.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 750, 330));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 10, -1));

        boxDestino.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Casa", "Funcionário", "Veículo" }));
        boxDestino.setPreferredSize(new java.awt.Dimension(90, 30));
        painelPrincipal.add(boxDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 120, -1));

        labelDestino.setBackground(new java.awt.Color(255, 255, 255));
        labelDestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDestino.setText("Destino");
        painelPrincipal.add(labelDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 10, -1));

        botaoConsultar.setBackground(new java.awt.Color(255, 255, 255));
        botaoConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoConsultar.setForeground(new java.awt.Color(255, 255, 255));
        botaoConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/magnifier.png"))); // NOI18N
        botaoConsultar.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });
        painelPrincipal.add(botaoConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 50, 30));

        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNome.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNome.setPreferredSize(new java.awt.Dimension(59, 30));
        tfNome.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 230, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        try {
            TipoDespesaControle tdControle = new TipoDespesaControle();
            List<TipoDespesa> tdList = null;

            Object o = boxDestino.getSelectedItem();
            String situacao = (String) o;
            if (situacao.equals("Todos")) {
                tdList = tdControle.consultarPorNomeOrdenado(tfNome.getText());
            } else if (situacao.equals("Casa")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "C");
            } else if (situacao.equals("Funcionário")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "F");
            } else if (situacao.equals("Veículo")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "V");
            }

            if (tdList.size() != 0) {
                RelatorioTipoDespesa rtd = new RelatorioTipoDespesa();
                rtd.emitirRelatorio(tdList);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Tipo de Despesa foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Tipo de Despesa: " + e.getMessage());
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void consultar() {
        try {

            TipoDespesaControle tdControle = new TipoDespesaControle();
            List<TipoDespesa> tdList = null;

            Object o = boxDestino.getSelectedItem();
            String situacao = (String) o;
            if (situacao.equals("Todos")) {
                tdList = tdControle.consultarPorNomeOrdenado(tfNome.getText());
            } else if (situacao.equals("Casa")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "C");
            } else if (situacao.equals("Funcionário")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "F");
            } else if (situacao.equals("Veículo")) {
                tdList = tdControle.consultarPorNomeEDestino(tfNome.getText(), "V");
            }

            if (tdList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum Tipo de Despesa foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            preencheTabela(tdList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Tipo de Despesa: " + e.getMessage());
        }
    }

    public void preencheTabela(List<TipoDespesa> tdList) {
        if (tdList != null) {
            String[] strTVet = new String[]{"Código", "Nome", "Destino"};
            String[][] strTDMat = new String[tdList.size()][3];
            for (int i = 0; i < tdList.size(); i++) {
                TipoDespesa td = tdList.get(i);
                strTDMat[i][0] = td.getCDTIPODESPESA() + "";
                strTDMat[i][1] = td.getNOME();
                strTDMat[i][2] = td.getTipoStr();
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
            java.util.logging.Logger.getLogger(TipoDespesaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoDespesaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TipoDespesaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoGerar;
    private javax.swing.JComboBox<String> boxDestino;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelDestino;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPrevia;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotao;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
