package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.DateParse;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import br.com.davi.chiquinhomaquinas.entidade.Saldo;
import br.com.davi.chiquinhomaquinas.entidade.Servico;
import br.com.davi.chiquinhomaquinas.negocio.DespesaControle;
import br.com.davi.chiquinhomaquinas.negocio.ServicoControle;
import br.com.davi.chiquinhomaquinas.relatorios.RelatorioSaldo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class SaldoRelatorio extends javax.swing.JFrame {

    public SaldoRelatorio() {
        initComponents();
        tfSaldo.setText("R$0.0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelBotao = new javax.swing.JPanel();
        botaoGerar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelDtInicial = new javax.swing.JLabel();
        labelDtFim = new javax.swing.JLabel();
        labelPrevia = new javax.swing.JLabel();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        ftfDtInicio = new javax.swing.JFormattedTextField();
        ftfDtFim = new javax.swing.JFormattedTextField();
        labelSaldo = new javax.swing.JLabel();
        tfSaldo = new javax.swing.JTextField();
        boxSituacao = new javax.swing.JComboBox<>();
        labelSituacao = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        botaoConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório dos Saldos Totais");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Relatório dos Saldos Totais");
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

        labelDtInicial.setBackground(new java.awt.Color(255, 255, 255));
        labelDtInicial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDtInicial.setText("Data Inicial");
        painelPrincipal.add(labelDtInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        labelDtFim.setBackground(new java.awt.Color(255, 255, 255));
        labelDtFim.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDtFim.setText("Data Final");
        painelPrincipal.add(labelDtFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        labelPrevia.setBackground(new java.awt.Color(255, 255, 255));
        labelPrevia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrevia.setText("Prévia:");
        painelPrincipal.add(labelPrevia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Situação", "Data", "Tipo", "Valor"
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

        painelPrincipal.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 750, 300));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painelPrincipal.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painelPrincipal.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        try {
            ftfDtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDtInicio.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfDtInicio.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfDtInicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfDtInicio.setPreferredSize(new java.awt.Dimension(90, 30));
        ftfDtInicio.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfDtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 90, -1));

        try {
            ftfDtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDtFim.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfDtFim.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfDtFim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfDtFim.setPreferredSize(new java.awt.Dimension(90, 30));
        ftfDtFim.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(ftfDtFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, -1));

        labelSaldo.setBackground(new java.awt.Color(255, 255, 255));
        labelSaldo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSaldo.setText("Saldo");
        painelPrincipal.add(labelSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 40, -1));

        tfSaldo.setEditable(false);
        tfSaldo.setBackground(new java.awt.Color(255, 255, 255));
        tfSaldo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfSaldo.setCaretColor(new java.awt.Color(255, 153, 51));
        tfSaldo.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfSaldo.setPreferredSize(new java.awt.Dimension(14, 30));
        tfSaldo.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 70, -1));

        boxSituacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Paga", "Não Paga" }));
        boxSituacao.setPreferredSize(new java.awt.Dimension(90, 30));
        painelPrincipal.add(boxSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 120, -1));

        labelSituacao.setBackground(new java.awt.Color(255, 255, 255));
        labelSituacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSituacao.setText("Situação");
        painelPrincipal.add(labelSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelPrincipal.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 20, 10, -1));

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

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        if (ftfDtInicio.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Data Inicial] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            DateParse dp = new DateParse();
            dp.parseDate(ftfDtInicio.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "A Data Inicial informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (ftfDtFim.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Data Final] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            DateParse dp = new DateParse();
            dp.parseDate(ftfDtFim.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "A Data Final informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            DespesaControle dControle = new DespesaControle();
            List<Despesa> dList = null;
            ServicoControle sControle = new ServicoControle();
            List<Servico> sList = null;
            DateParse dp = new DateParse();

            Object o = boxSituacao.getSelectedItem();
            String situacao = (String) o;
            if (situacao.equals("Todas")) {
                dList = dControle.consultarPorPeriodo(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()));
                sList = sControle.consultarPorPeriodo(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()));
            } else if (situacao.equals("Paga")) {
                dList = dControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "P");
                sList = sControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "P");
            } else if (situacao.equals("Não Paga")) {
                dList = dControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "N");
                sList = sControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "N");
            }

            List<Saldo> saldoList = new ArrayList<>();

            for (int i = 0; i < dList.size(); i++) {
                Saldo s = new Saldo();
                s.setCDSALDOTOTAL(dList.get(i).getCDDESPESA());
                s.setDESCRICAO(dList.get(i).getDESCRICAO());
                s.setSITUACAO(dList.get(i).getSituacaoStr());
                s.setDATA(dList.get(i).getDataStr());
                s.setTIPO("Despesa");
                s.setVALOR(dList.get(i).getValorStr());
                saldoList.add(s);
            }

            for (int i = 0; i < sList.size(); i++) {
                Saldo s = new Saldo();
                s.setCDSALDOTOTAL(sList.get(i).getCDSERVICO());
                s.setDESCRICAO(sList.get(i).getDESCRICAO());
                s.setSITUACAO(sList.get(i).getSituacaoStr());
                s.setDATA(sList.get(i).getDataPagStr());
                s.setTIPO("Serviço");
                s.setVALOR(sList.get(i).getPrecoTotalStr());
                saldoList.add(s);
            }

            if (saldoList.size() != 0) {
                RelatorioSaldo rs = new RelatorioSaldo();
                rs.emitirRelatorio(saldoList);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Saldo foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Saldo por Periodo: " + e.getMessage());
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        consultarPorPeriodo();
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void consultarPorPeriodo() {
        try {

            if (ftfDtInicio.getText().equals("  /  /    ")) {
                JOptionPane.showMessageDialog(null, "O Campo [Data Inicial] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                DateParse dp = new DateParse();
                dp.parseDate(ftfDtInicio.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "A Data Inicial informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (ftfDtFim.getText().equals("  /  /    ")) {
                JOptionPane.showMessageDialog(null, "O Campo [Data Final] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                DateParse dp = new DateParse();
                dp.parseDate(ftfDtFim.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "A Data Final informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            DespesaControle dControle = new DespesaControle();
            List<Despesa> dList = null;
            ServicoControle sControle = new ServicoControle();
            List<Servico> sList = null;
            DateParse dp = new DateParse();

            Object o = boxSituacao.getSelectedItem();
            String situacao = (String) o;
            if (situacao.equals("Todas")) {
                dList = dControle.consultarPorPeriodo(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()));
                sList = sControle.consultarPorPeriodo(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()));
            } else if (situacao.equals("Paga")) {
                dList = dControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "P");
                sList = sControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "P");
            } else if (situacao.equals("Não Paga")) {
                dList = dControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "N");
                sList = sControle.consultarPorPeriodoESituacao(dp.parseDate(ftfDtInicio.getText()), dp.parseDate(ftfDtFim.getText()), "N");
            }

            List<Saldo> saldoList = new ArrayList<>();

            for (int i = 0; i < dList.size(); i++) {
                Saldo s = new Saldo();
                s.setCDSALDOTOTAL(dList.get(i).getCDDESPESA());
                s.setDESCRICAO(dList.get(i).getDESCRICAO());
                s.setSITUACAO(dList.get(i).getSituacaoStr());
                s.setDATA(dList.get(i).getDataStr());
                s.setTIPO("Despesa");
                s.setVALOR(dList.get(i).getValorStr());
                saldoList.add(s);
            }

            for (int i = 0; i < sList.size(); i++) {
                Saldo s = new Saldo();
                s.setCDSALDOTOTAL(sList.get(i).getCDSERVICO());
                s.setDESCRICAO(sList.get(i).getDESCRICAO());
                s.setSITUACAO(sList.get(i).getSituacaoStr());
                s.setDATA(sList.get(i).getDataPagStr());
                s.setTIPO("Serviço");
                s.setVALOR(sList.get(i).getPrecoTotalStr());
                saldoList.add(s);
            }

            if (saldoList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum Saldo foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            preencheTabela(saldoList);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Saldo por Periodo: " + e.getMessage());
        }
    }

    public void preencheTabela(List<Saldo> sList) {
        if (sList != null) {
            String[] strSVet = new String[]{"Código", "Descrição", "Situação", "Data", "Tipo", "Valor"};
            String[][] strSMat = new String[sList.size()][6];
            double totalPositivo = 0;
            double totalNegativo = 0;
            for (int i = 0; i < sList.size(); i++) {
                Saldo s = sList.get(i);
                strSMat[i][0] = Integer.toString(s.getCDSALDOTOTAL());
                strSMat[i][1] = s.getDESCRICAO();
                strSMat[i][2] = s.getSITUACAO();
                strSMat[i][3] = s.getDATA();
                strSMat[i][4] = s.getTIPO();
                strSMat[i][5] = s.getVALOR();
                if (s.getTIPO().equals("Despesa")) {
                    totalNegativo = totalNegativo + Double.parseDouble(s.getVALOR().substring(2, s.getVALOR().length()));
                } else {
                    totalPositivo = totalPositivo + Double.parseDouble(s.getVALOR().substring(2, s.getVALOR().length()));
                }
            }
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strSMat, strSVet) {
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
            tfSaldo.setText("R$" + (totalPositivo - totalNegativo));
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
            java.util.logging.Logger.getLogger(SaldoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaldoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaldoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaldoRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SaldoRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoGerar;
    private javax.swing.JComboBox<String> boxSituacao;
    private javax.swing.JFormattedTextField ftfDtFim;
    private javax.swing.JFormattedTextField ftfDtInicio;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelDtFim;
    private javax.swing.JLabel labelDtInicial;
    private javax.swing.JLabel labelPrevia;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotao;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfSaldo;
    // End of variables declaration//GEN-END:variables
}
