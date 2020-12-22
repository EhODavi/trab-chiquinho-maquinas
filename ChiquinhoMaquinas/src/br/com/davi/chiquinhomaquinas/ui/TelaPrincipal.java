package br.com.davi.chiquinhomaquinas.ui;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal(String login) {
        initComponents();
        labelUsuario.setText("Bem-vindo, " + login + "!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLogo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        painelAcessoRapido = new javax.swing.JPanel();
        botaoLucrosTotais = new javax.swing.JButton();
        botaoDespesasTotais = new javax.swing.JButton();
        botaoClientesInadimplentes = new javax.swing.JButton();
        botaoSaldosTotais = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuGerenciamento = new javax.swing.JMenu();
        menuServicos = new javax.swing.JMenuItem();
        menuDespesas = new javax.swing.JMenuItem();
        menuClientesFisicos = new javax.swing.JMenuItem();
        menuClientesJuridicos = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuVeiculos = new javax.swing.JMenuItem();
        menuTiposDespesas = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuClientesInadimplentes = new javax.swing.JMenuItem();
        menuDespesasTotais = new javax.swing.JMenuItem();
        menuLucrosTotais = new javax.swing.JMenuItem();
        menuSaldosTotais = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        painelLogo.setBackground(new java.awt.Color(255, 255, 255));
        painelLogo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png"))); // NOI18N
        painelLogo.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 350, 250));

        labelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        labelUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        painelLogo.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 20));

        getContentPane().add(painelLogo, java.awt.BorderLayout.PAGE_START);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelAcessoRapido.setBackground(new java.awt.Color(255, 255, 255));
        painelAcessoRapido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acesso Rápido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        painelAcessoRapido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoLucrosTotais.setBackground(new java.awt.Color(255, 255, 255));
        botaoLucrosTotais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoLucrosTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/icons8-harvester-50.png"))); // NOI18N
        botaoLucrosTotais.setText("Lucros Totais");
        botaoLucrosTotais.setMinimumSize(new java.awt.Dimension(132, 70));
        botaoLucrosTotais.setPreferredSize(new java.awt.Dimension(240, 102));
        botaoLucrosTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLucrosTotaisActionPerformed(evt);
            }
        });
        painelAcessoRapido.add(botaoLucrosTotais);

        botaoDespesasTotais.setBackground(new java.awt.Color(255, 255, 255));
        botaoDespesasTotais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoDespesasTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/icons8-carteira-filled-50.png"))); // NOI18N
        botaoDespesasTotais.setText("Despesas Totais");
        botaoDespesasTotais.setPreferredSize(new java.awt.Dimension(240, 102));
        botaoDespesasTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDespesasTotaisActionPerformed(evt);
            }
        });
        painelAcessoRapido.add(botaoDespesasTotais);

        botaoClientesInadimplentes.setBackground(new java.awt.Color(255, 255, 255));
        botaoClientesInadimplentes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoClientesInadimplentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/icons8-usuário-50.png"))); // NOI18N
        botaoClientesInadimplentes.setText("Clientes Inadimplentes");
        botaoClientesInadimplentes.setPreferredSize(new java.awt.Dimension(240, 102));
        botaoClientesInadimplentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoClientesInadimplentesActionPerformed(evt);
            }
        });
        painelAcessoRapido.add(botaoClientesInadimplentes);

        botaoSaldosTotais.setBackground(new java.awt.Color(255, 255, 255));
        botaoSaldosTotais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoSaldosTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/icons8-pilha-de-dinheiro-50.png"))); // NOI18N
        botaoSaldosTotais.setText("Saldos Totais");
        botaoSaldosTotais.setPreferredSize(new java.awt.Dimension(240, 102));
        botaoSaldosTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSaldosTotaisActionPerformed(evt);
            }
        });
        painelAcessoRapido.add(botaoSaldosTotais);

        painelBotoes.add(painelAcessoRapido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 730, 250));

        getContentPane().add(painelBotoes, java.awt.BorderLayout.CENTER);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        menuGerenciamento.setBackground(new java.awt.Color(255, 255, 255));
        menuGerenciamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/database.png"))); // NOI18N
        menuGerenciamento.setText("Gerenciamento");
        menuGerenciamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        menuServicos.setBackground(new java.awt.Color(255, 255, 255));
        menuServicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/money_add.png"))); // NOI18N
        menuServicos.setText("Serviços");
        menuServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServicosActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuServicos);

        menuDespesas.setBackground(new java.awt.Color(255, 255, 255));
        menuDespesas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/money_delete.png"))); // NOI18N
        menuDespesas.setText("Despesas");
        menuDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDespesasActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuDespesas);

        menuClientesFisicos.setBackground(new java.awt.Color(255, 255, 255));
        menuClientesFisicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuClientesFisicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user.png"))); // NOI18N
        menuClientesFisicos.setText("Clientes Físicos");
        menuClientesFisicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesFisicosActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuClientesFisicos);

        menuClientesJuridicos.setBackground(new java.awt.Color(255, 255, 255));
        menuClientesJuridicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuClientesJuridicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user_gray.png"))); // NOI18N
        menuClientesJuridicos.setText("Clientes Jurídicos");
        menuClientesJuridicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesJuridicosActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuClientesJuridicos);

        menuFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        menuFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user_orange.png"))); // NOI18N
        menuFuncionarios.setText("Funcionários");
        menuFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionariosActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuFuncionarios);

        menuVeiculos.setBackground(new java.awt.Color(255, 255, 255));
        menuVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/lorry.png"))); // NOI18N
        menuVeiculos.setText("Veículos");
        menuVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVeiculosActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuVeiculos);

        menuTiposDespesas.setBackground(new java.awt.Color(255, 255, 255));
        menuTiposDespesas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuTiposDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/application.png"))); // NOI18N
        menuTiposDespesas.setText("Tipos de Despesas");
        menuTiposDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTiposDespesasActionPerformed(evt);
            }
        });
        menuGerenciamento.add(menuTiposDespesas);

        menu.add(menuGerenciamento);

        menuRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        menuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_acrobat.png"))); // NOI18N
        menuRelatorio.setText("Relatório");
        menuRelatorio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        menuClientesInadimplentes.setBackground(new java.awt.Color(255, 255, 255));
        menuClientesInadimplentes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuClientesInadimplentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user.png"))); // NOI18N
        menuClientesInadimplentes.setText("Clientes Inadimplentes");
        menuClientesInadimplentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesInadimplentesActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuClientesInadimplentes);

        menuDespesasTotais.setBackground(new java.awt.Color(255, 255, 255));
        menuDespesasTotais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuDespesasTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/money_delete.png"))); // NOI18N
        menuDespesasTotais.setText("Despesas Totais");
        menuDespesasTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDespesasTotaisActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuDespesasTotais);

        menuLucrosTotais.setBackground(new java.awt.Color(255, 255, 255));
        menuLucrosTotais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuLucrosTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/money_add.png"))); // NOI18N
        menuLucrosTotais.setText("Lucros Totais");
        menuLucrosTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLucrosTotaisActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuLucrosTotais);

        menuSaldosTotais.setBackground(new java.awt.Color(255, 255, 255));
        menuSaldosTotais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuSaldosTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/calculator.png"))); // NOI18N
        menuSaldosTotais.setText("Saldos Totais");
        menuSaldosTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaldosTotaisActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuSaldosTotais);

        menu.add(menuRelatorio);

        menuSair.setBackground(new java.awt.Color(255, 255, 255));
        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/arrow_right.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menu.add(menuSair);

        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLucrosTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLucrosTotaisActionPerformed
        LucroRelatorio lRelatorio = new LucroRelatorio();
        lRelatorio.setVisible(true);
    }//GEN-LAST:event_botaoLucrosTotaisActionPerformed

    private void botaoDespesasTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDespesasTotaisActionPerformed
        DespesaRelatorio dRelatorio = new DespesaRelatorio();
        dRelatorio.setVisible(true);
    }//GEN-LAST:event_botaoDespesasTotaisActionPerformed

    private void botaoClientesInadimplentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoClientesInadimplentesActionPerformed
        ClienteInadimplenteRelatorio ciRelatorio = new ClienteInadimplenteRelatorio();
        ciRelatorio.setVisible(true);
    }//GEN-LAST:event_botaoClientesInadimplentesActionPerformed

    private void botaoSaldosTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSaldosTotaisActionPerformed
        SaldoRelatorio sRelatorio = new SaldoRelatorio();
        sRelatorio.setVisible(true);
    }//GEN-LAST:event_botaoSaldosTotaisActionPerformed

    private void menuServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServicosActionPerformed
        ServicoCRUD sCRUD = new ServicoCRUD();
        sCRUD.setVisible(true);
    }//GEN-LAST:event_menuServicosActionPerformed

    private void menuDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesasActionPerformed
        DespesaCRUD dCRUD = new DespesaCRUD();
        dCRUD.setVisible(true);
    }//GEN-LAST:event_menuDespesasActionPerformed

    private void menuClientesFisicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesFisicosActionPerformed
        ClienteFisicoCRUD cfCRUD = new ClienteFisicoCRUD();
        cfCRUD.setVisible(true);
    }//GEN-LAST:event_menuClientesFisicosActionPerformed

    private void menuClientesJuridicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesJuridicosActionPerformed
        ClienteJuridicoCRUD cjCRUD = new ClienteJuridicoCRUD();
        cjCRUD.setVisible(true);
    }//GEN-LAST:event_menuClientesJuridicosActionPerformed

    private void menuFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionariosActionPerformed
        FuncionarioCRUD fCRUD = new FuncionarioCRUD();
        fCRUD.setVisible(true);
    }//GEN-LAST:event_menuFuncionariosActionPerformed

    private void menuVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVeiculosActionPerformed
        VeiculoCRUD vCRUD = new VeiculoCRUD();
        vCRUD.setVisible(true);
    }//GEN-LAST:event_menuVeiculosActionPerformed

    private void menuTiposDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTiposDespesasActionPerformed
        TipoDespesaCRUD tdCRUD = new TipoDespesaCRUD();
        tdCRUD.setVisible(true);
    }//GEN-LAST:event_menuTiposDespesasActionPerformed

    private void menuClientesInadimplentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesInadimplentesActionPerformed
        ClienteInadimplenteRelatorio ciRelatorio = new ClienteInadimplenteRelatorio();
        ciRelatorio.setVisible(true);
    }//GEN-LAST:event_menuClientesInadimplentesActionPerformed

    private void menuDespesasTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesasTotaisActionPerformed
        DespesaRelatorio dRelatorio = new DespesaRelatorio();
        dRelatorio.setVisible(true);
    }//GEN-LAST:event_menuDespesasTotaisActionPerformed

    private void menuLucrosTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLucrosTotaisActionPerformed
        LucroRelatorio lRelatorio = new LucroRelatorio();
        lRelatorio.setVisible(true);
    }//GEN-LAST:event_menuLucrosTotaisActionPerformed

    private void menuSaldosTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaldosTotaisActionPerformed
        SaldoRelatorio sRelatorio = new SaldoRelatorio();
        sRelatorio.setVisible(true);
    }//GEN-LAST:event_menuSaldosTotaisActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_menuSairMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoClientesInadimplentes;
    private javax.swing.JButton botaoDespesasTotais;
    private javax.swing.JButton botaoLucrosTotais;
    private javax.swing.JButton botaoSaldosTotais;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuClientesFisicos;
    private javax.swing.JMenuItem menuClientesInadimplentes;
    private javax.swing.JMenuItem menuClientesJuridicos;
    private javax.swing.JMenuItem menuDespesas;
    private javax.swing.JMenuItem menuDespesasTotais;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenu menuGerenciamento;
    private javax.swing.JMenuItem menuLucrosTotais;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem menuSaldosTotais;
    private javax.swing.JMenuItem menuServicos;
    private javax.swing.JMenuItem menuTiposDespesas;
    private javax.swing.JMenuItem menuVeiculos;
    private javax.swing.JPanel painelAcessoRapido;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelLogo;
    // End of variables declaration//GEN-END:variables
}
