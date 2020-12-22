package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.ClienteInadimplente;
import br.com.davi.chiquinhomaquinas.negocio.ClienteFisicoControle;
import br.com.davi.chiquinhomaquinas.negocio.ClienteJuridicoControle;
import br.com.davi.chiquinhomaquinas.relatorios.RelatorioClienteInadimplente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ClienteInadimplenteRelatorio extends javax.swing.JFrame {

    List<ClienteInadimplente> ciListAtual = new ArrayList<>();

    public ClienteInadimplenteRelatorio() {
        initComponents();
        try {

            ClienteFisicoControle cfControle = new ClienteFisicoControle();
            ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
            String[][] strCFMat = cfControle.consultarPorInadimplencia();
            String[][] strCJMat = cjControle.consultarPorInadimplencia();

            List<ClienteInadimplente> ciList = new ArrayList<>();

            for (int i = 0; i < strCFMat.length; i++) {
                ClienteInadimplente ci = new ClienteInadimplente();
                ci.setCDCLIENTEINADIMPLENTE(Integer.parseInt(strCFMat[i][0]));
                ci.setNOME(strCFMat[i][1]);
                ci.setENDERECO(strCFMat[i][2]);
                ci.setTELEFONE(strCFMat[i][3]);
                ci.setEMAIL(strCFMat[i][4]);
                ci.setVALOR(Double.parseDouble(strCFMat[i][6]));
                ciList.add(ci);
            }

            for (int i = 0; i < strCJMat.length; i++) {
                ClienteInadimplente ci = new ClienteInadimplente();
                ci.setCDCLIENTEINADIMPLENTE(Integer.parseInt(strCJMat[i][0]));
                ci.setNOME(strCJMat[i][1]);
                ci.setENDERECO(strCJMat[i][2]);
                ci.setTELEFONE(strCJMat[i][3]);
                ci.setEMAIL(strCJMat[i][4]);
                ci.setVALOR(Double.parseDouble(strCJMat[i][7]));
                ciList.add(ci);
            }
            ciListAtual = ciList;

            preencheTabela(ciList);
            
            if (ciList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum Cliente Inadimplente foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro no Banco de Dados!", JOptionPane.HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar Clientes Inadimplentes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelBotao = new javax.swing.JPanel();
        botaoGerar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        labelPrevia = new javax.swing.JLabel();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        labelTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório dos Clientes Inadimplentes");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Relatório dos Clientes Inadimplentes");
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

        labelPrevia.setBackground(new java.awt.Color(255, 255, 255));
        labelPrevia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrevia.setText("Prévia:");
        painelPrincipal.add(labelPrevia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Telefone", "E-mail", "Valor"
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

        painelPrincipal.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 750, 370));

        labelTotal.setBackground(new java.awt.Color(255, 255, 255));
        labelTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotal.setText("Total");
        painelPrincipal.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 30, -1));

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotal.setCaretColor(new java.awt.Color(255, 153, 51));
        tfTotal.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfTotal.setPreferredSize(new java.awt.Dimension(14, 30));
        tfTotal.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 70, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        if (ciListAtual.size() != 0) {
            RelatorioClienteInadimplente rci = new RelatorioClienteInadimplente();
            rci.emitirRelatorio(ciListAtual);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Cliente Inadimplente foi encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    public void preencheTabela(List<ClienteInadimplente> ciList) {
        if (ciList != null) {
            String[] strCIVet = new String[]{"Código", "Nome", "Endereço", "Telefone", "E-mail", "Valor"};
            String[][] strCIMat = new String[ciList.size()][6];
            double total = 0;
            for (int i = 0; i < ciList.size(); i++) {
                ClienteInadimplente ci = ciList.get(i);
                strCIMat[i][0] = Integer.toString(ci.getCDCLIENTEINADIMPLENTE());
                strCIMat[i][1] = ci.getNOME();
                strCIMat[i][2] = ci.getENDERECO();
                strCIMat[i][3] = ci.getTelefoneStr();
                strCIMat[i][4] = ci.getEMAIL();
                strCIMat[i][5] = ci.getValorStr();
                total = total + ci.getVALOR();
            }

            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strCIMat, strCIVet) {
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
            tfTotal.setText("R$" + total);
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
            java.util.logging.Logger.getLogger(ClienteInadimplenteRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInadimplenteRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInadimplenteRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInadimplenteRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ClienteInadimplenteRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerar;
    private javax.swing.JLabel labelPrevia;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel painelBotao;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
