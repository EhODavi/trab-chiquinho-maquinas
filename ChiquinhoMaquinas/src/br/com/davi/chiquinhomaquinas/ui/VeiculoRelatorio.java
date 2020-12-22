package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;
import br.com.davi.chiquinhomaquinas.negocio.VeiculoControle;
import br.com.davi.chiquinhomaquinas.relatorios.RelatorioVeiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VeiculoRelatorio extends javax.swing.JFrame {

    public VeiculoRelatorio() {
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
        boxTipo = new javax.swing.JComboBox<>();
        labelTipo = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        botaoConsultar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório dos Veículos");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Relatório dos Veículos");
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
                "Código", "Nome", "Tipo", "Placa", "Tipo de Cobrança", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        boxTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pá Carregadeira", "Caminhão", "Retroescavadeira" }));
        boxTipo.setPreferredSize(new java.awt.Dimension(90, 30));
        painelPrincipal.add(boxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 120, -1));

        labelTipo.setBackground(new java.awt.Color(255, 255, 255));
        labelTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipo.setText("Tipo");
        painelPrincipal.add(labelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 10, -1));

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
            VeiculoControle vControle = new VeiculoControle();
            List<Veiculo> vList = null;

            Object o = boxTipo.getSelectedItem();
            String tipo = (String) o;
            if (tipo.equals("Todos")) {
                vList = vControle.consultarPorNomeOrdenado(tfNome.getText());
            } else if (tipo.equals("Pá Carregadeira")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "P");
            } else if (tipo.equals("Caminhão")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "C");
            } else if (tipo.equals("Retroescavadeira")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "R");
            }

            if (vList.size() != 0) {
                RelatorioVeiculo rv = new RelatorioVeiculo();
                rv.emitirRelatorio(vList);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Veículo foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Veículo: " + e.getMessage());
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void consultar() {
        try {

            VeiculoControle vControle = new VeiculoControle();
            List<Veiculo> vList = null;

            Object o = boxTipo.getSelectedItem();
            String tipo = (String) o;
            if (tipo.equals("Todos")) {
                vList = vControle.consultarPorNomeOrdenado(tfNome.getText());
            } else if (tipo.equals("Pá Carregadeira")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "P");
            } else if (tipo.equals("Caminhão")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "C");
            } else if (tipo.equals("Retroescavadeira")) {
                vList = vControle.consultarPorNomeETipo(tfNome.getText(), "R");
            }

            if (vList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum Veículo foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            preencheTabela(vList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Veículo: " + e.getMessage());
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
                strVMat[i][2] = v.getTipoStr();
                strVMat[i][3] = v.getPlacaStr();
                strVMat[i][4] = v.getTipoCobrancaStr();
                strVMat[i][5] = v.getPrecoStr();
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
            java.util.logging.Logger.getLogger(VeiculoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculoRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoGerar;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPrevia;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotao;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
