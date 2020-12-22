package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.entidade.ClienteFisico;
import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import br.com.davi.chiquinhomaquinas.entidade.Funcionario;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;

public class TelaPrincipalTrab extends javax.swing.JFrame {

    public TelaPrincipalTrab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        labelTipoDespesa = new javax.swing.JLabel();
        labelDespesa = new javax.swing.JLabel();
        tfCodigoTipoDespesa = new javax.swing.JTextField();
        tfNomeTipoDespesa = new javax.swing.JTextField();
        tfCodigoDespesa = new javax.swing.JTextField();
        tfNomeDespesa = new javax.swing.JTextField();
        labelFuncionario = new javax.swing.JLabel();
        tfCodigoFuncionario = new javax.swing.JTextField();
        tfNomeFuncionario = new javax.swing.JTextField();
        labelVeiculo = new javax.swing.JLabel();
        tfCodigoVeiculo = new javax.swing.JTextField();
        tfNomeVeiculo = new javax.swing.JTextField();
        tfCodigoClienteFisico = new javax.swing.JTextField();
        tfNomeClienteFisico = new javax.swing.JTextField();
        labelClienteFisico = new javax.swing.JLabel();
        labelClienteJuridico = new javax.swing.JLabel();
        tfCodigoClienteJuridico = new javax.swing.JTextField();
        tfNomeClienteJuridico = new javax.swing.JTextField();
        menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        cadastrarTipoDespesa = new javax.swing.JMenuItem();
        cadastrarDespesa = new javax.swing.JMenuItem();
        cadastrarFuncionario = new javax.swing.JMenuItem();
        cadastrarVeiculo = new javax.swing.JMenuItem();
        cadastrarClienteFisico = new javax.swing.JMenuItem();
        cadastrarClienteJuridico = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        consultarTipoDespesa = new javax.swing.JMenuItem();
        consultarDespesa = new javax.swing.JMenuItem();
        consultarFuncionario = new javax.swing.JMenuItem();
        consultarVeiculo = new javax.swing.JMenuItem();
        consultarClienteFisico = new javax.swing.JMenuItem();
        consultarClienteJuridico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(615, 565));
        setResizable(false);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        botaoConfirmar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoConfirmar.setText("Confirmar");
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

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Tela Principal");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        labelTipoDespesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTipoDespesa.setText("Tipo de Despesa");
        painelPrincipal.add(labelTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        labelDespesa.setBackground(new java.awt.Color(255, 255, 255));
        labelDespesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDespesa.setText("Despesa");
        painelPrincipal.add(labelDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        tfCodigoTipoDespesa.setEditable(false);
        tfCodigoTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoTipoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoTipoDespesa.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoTipoDespesa.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoTipoDespesa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfCodigoTipoDespesa.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 60, -1));

        tfNomeTipoDespesa.setEditable(false);
        tfNomeTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeTipoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeTipoDespesa.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeTipoDespesa.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeTipoDespesa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNomeTipoDespesa.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeTipoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 420, -1));

        tfCodigoDespesa.setEditable(false);
        tfCodigoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoDespesa.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoDespesa.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoDespesa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfCodigoDespesa.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 60, -1));

        tfNomeDespesa.setEditable(false);
        tfNomeDespesa.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeDespesa.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeDespesa.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeDespesa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNomeDespesa.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 420, -1));

        labelFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        labelFuncionario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFuncionario.setText("Funcionário");
        painelPrincipal.add(labelFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        tfCodigoFuncionario.setEditable(false);
        tfCodigoFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoFuncionario.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoFuncionario.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoFuncionario.setPreferredSize(new java.awt.Dimension(6, 30));
        tfCodigoFuncionario.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 60, -1));

        tfNomeFuncionario.setEditable(false);
        tfNomeFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeFuncionario.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeFuncionario.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeFuncionario.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNomeFuncionario.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 420, -1));

        labelVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        labelVeiculo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelVeiculo.setText("Veículo");
        painelPrincipal.add(labelVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        tfCodigoVeiculo.setEditable(false);
        tfCodigoVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoVeiculo.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoVeiculo.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoVeiculo.setPreferredSize(new java.awt.Dimension(6, 30));
        tfCodigoVeiculo.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 60, -1));

        tfNomeVeiculo.setEditable(false);
        tfNomeVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeVeiculo.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeVeiculo.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeVeiculo.setPreferredSize(new java.awt.Dimension(6, 30));
        tfNomeVeiculo.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 420, -1));

        tfCodigoClienteFisico.setEditable(false);
        tfCodigoClienteFisico.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoClienteFisico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoClienteFisico.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoClienteFisico.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoClienteFisico.setPreferredSize(new java.awt.Dimension(65, 30));
        tfCodigoClienteFisico.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoClienteFisico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 60, -1));

        tfNomeClienteFisico.setEditable(false);
        tfNomeClienteFisico.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeClienteFisico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeClienteFisico.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeClienteFisico.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeClienteFisico.setPreferredSize(new java.awt.Dimension(65, 30));
        tfNomeClienteFisico.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeClienteFisico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 420, -1));

        labelClienteFisico.setBackground(new java.awt.Color(255, 255, 255));
        labelClienteFisico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelClienteFisico.setText("Cliente Físico");
        painelPrincipal.add(labelClienteFisico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        labelClienteJuridico.setBackground(new java.awt.Color(255, 255, 255));
        labelClienteJuridico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelClienteJuridico.setText("Cliente Jurídico");
        painelPrincipal.add(labelClienteJuridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        tfCodigoClienteJuridico.setEditable(false);
        tfCodigoClienteJuridico.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigoClienteJuridico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigoClienteJuridico.setCaretColor(new java.awt.Color(255, 153, 51));
        tfCodigoClienteJuridico.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfCodigoClienteJuridico.setPreferredSize(new java.awt.Dimension(65, 30));
        tfCodigoClienteJuridico.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfCodigoClienteJuridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 60, -1));

        tfNomeClienteJuridico.setEditable(false);
        tfNomeClienteJuridico.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeClienteJuridico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeClienteJuridico.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNomeClienteJuridico.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNomeClienteJuridico.setPreferredSize(new java.awt.Dimension(65, 30));
        tfNomeClienteJuridico.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelPrincipal.add(tfNomeClienteJuridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 420, -1));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        menuCadastro.setBackground(new java.awt.Color(255, 255, 255));
        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        menuCadastro.setText("Cadastro");
        menuCadastro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cadastrarTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarTipoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarTipoDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/book_add.png"))); // NOI18N
        cadastrarTipoDespesa.setText("Tipo de Despesa");
        cadastrarTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarTipoDespesaActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarTipoDespesa);

        cadastrarDespesa.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/calculator_add.png"))); // NOI18N
        cadastrarDespesa.setText("Despesa");
        cadastrarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarDespesaActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarDespesa);

        cadastrarFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user_add.png"))); // NOI18N
        cadastrarFuncionario.setText("Funcionário");
        cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarFuncionario);

        cadastrarVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/lorry_add.png"))); // NOI18N
        cadastrarVeiculo.setText("Veículo");
        cadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarVeiculoActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarVeiculo);

        cadastrarClienteFisico.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarClienteFisico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarClienteFisico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/computer_add.png"))); // NOI18N
        cadastrarClienteFisico.setText("Cliente Físico");
        cadastrarClienteFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteFisicoActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarClienteFisico);

        cadastrarClienteJuridico.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarClienteJuridico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cadastrarClienteJuridico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/email_add.png"))); // NOI18N
        cadastrarClienteJuridico.setText("Cliente Jurídico");
        cadastrarClienteJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteJuridicoActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarClienteJuridico);

        menu.add(menuCadastro);

        menuConsultar.setBackground(new java.awt.Color(255, 255, 255));
        menuConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_magnify.png"))); // NOI18N
        menuConsultar.setText("Consultar");
        menuConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        consultarTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        consultarTipoDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarTipoDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/book_open.png"))); // NOI18N
        consultarTipoDespesa.setText("Tipo de Despesa");
        consultarTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarTipoDespesaActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarTipoDespesa);

        consultarDespesa.setBackground(new java.awt.Color(255, 255, 255));
        consultarDespesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/calculator_link.png"))); // NOI18N
        consultarDespesa.setText("Despesa");
        consultarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarDespesaActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarDespesa);

        consultarFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        consultarFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/user_edit.png"))); // NOI18N
        consultarFuncionario.setText("Funcionário");
        consultarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarFuncionarioActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarFuncionario);

        consultarVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        consultarVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/lorry_link.png"))); // NOI18N
        consultarVeiculo.setText("Veículo");
        consultarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarVeiculoActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarVeiculo);

        consultarClienteFisico.setBackground(new java.awt.Color(255, 255, 255));
        consultarClienteFisico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarClienteFisico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/computer_go.png"))); // NOI18N
        consultarClienteFisico.setText("Cliente Físico");
        consultarClienteFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarClienteFisicoActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarClienteFisico);

        consultarClienteJuridico.setBackground(new java.awt.Color(255, 255, 255));
        consultarClienteJuridico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        consultarClienteJuridico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/email_go.png"))); // NOI18N
        consultarClienteJuridico.setText("Cliente Jurídico");
        consultarClienteJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarClienteJuridicoActionPerformed(evt);
            }
        });
        menuConsultar.add(consultarClienteJuridico);

        menu.add(menuConsultar);

        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void cadastrarTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarTipoDespesaActionPerformed
        TipoDespesaCadastroJDialog tdCadastro = new TipoDespesaCadastroJDialog(this, true);
        tdCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarTipoDespesaActionPerformed

    private void cadastrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarDespesaActionPerformed
        DespesaCadastroJDialog dCadastro = new DespesaCadastroJDialog(this, true);
        dCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarDespesaActionPerformed

    private void cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFuncionarioActionPerformed
        FuncionarioCadastroJDialog fCadastro = new FuncionarioCadastroJDialog(this, true);
        fCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarFuncionarioActionPerformed

    private void cadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVeiculoActionPerformed
        VeiculoCadastroJDialog vCadastro = new VeiculoCadastroJDialog(this, true);
        vCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarVeiculoActionPerformed

    private void consultarTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarTipoDespesaActionPerformed
        TipoDespesaConsultarTrab tdConsultar = new TipoDespesaConsultarTrab(this, true);
        tdConsultar.setVisible(true);

        TipoDespesa td = tdConsultar.getTipoDespesa();
        if (td != null) {
            tfCodigoTipoDespesa.setText(td.getCDTIPODESPESA() + "");
            tfNomeTipoDespesa.setText(td.getNOME());
        }
    }//GEN-LAST:event_consultarTipoDespesaActionPerformed

    private void consultarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarDespesaActionPerformed
        DespesaConsultarTrab dConsultar = new DespesaConsultarTrab(this, true);
        dConsultar.setVisible(true);

        Despesa d = dConsultar.getDespesa();
        if (d != null) {
            tfCodigoDespesa.setText(d.getCDDESPESA() + "");
            tfNomeDespesa.setText(d.getDESCRICAO());
        }
    }//GEN-LAST:event_consultarDespesaActionPerformed

    private void consultarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarFuncionarioActionPerformed
        FuncionarioConsultarTrab fConsultar = new FuncionarioConsultarTrab(this, true);
        fConsultar.setVisible(true);

        Funcionario f = fConsultar.getFuncionario();
        if (f != null) {
            tfCodigoFuncionario.setText(f.getCDPESSOA() + "");
            tfNomeFuncionario.setText(f.getNOME());
        }
    }//GEN-LAST:event_consultarFuncionarioActionPerformed

    private void consultarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarVeiculoActionPerformed
        VeiculoConsultarTrab vConsultar = new VeiculoConsultarTrab(this, true);
        vConsultar.setVisible(true);

        Veiculo v = vConsultar.getVeiculo();
        if (v != null) {
            tfCodigoVeiculo.setText(v.getCDVEICULO() + "");
            tfNomeVeiculo.setText(v.getNOME());
        }
    }//GEN-LAST:event_consultarVeiculoActionPerformed

    private void cadastrarClienteFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteFisicoActionPerformed
        ClienteFisicoCadastroJDialog cfCadastro = new ClienteFisicoCadastroJDialog(this, true);
        cfCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarClienteFisicoActionPerformed

    private void cadastrarClienteJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteJuridicoActionPerformed
        ClienteJuridicoCadastroJDialog cjCadastro = new ClienteJuridicoCadastroJDialog(this, true);
        cjCadastro.setVisible(true);
    }//GEN-LAST:event_cadastrarClienteJuridicoActionPerformed

    private void consultarClienteFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarClienteFisicoActionPerformed
        ClienteFisicoConsultarTrab cfConsultar = new ClienteFisicoConsultarTrab(this, true);
        cfConsultar.setVisible(true);

        ClienteFisico cf = cfConsultar.getClienteFisico();
        if (cf != null) {
            tfCodigoClienteFisico.setText(cf.getCDPESSOA() + "");
            tfNomeClienteFisico.setText(cf.getNOME());
        }
    }//GEN-LAST:event_consultarClienteFisicoActionPerformed

    private void consultarClienteJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarClienteJuridicoActionPerformed
        ClienteJuridicoConsultarTrab cjConsultar = new ClienteJuridicoConsultarTrab(this, true);
        cjConsultar.setVisible(true);

        ClienteJuridico cj = cjConsultar.getClienteJuridico();
        if (cj != null) {
            tfCodigoClienteJuridico.setText(cj.getCDPESSOA() + "");
            tfNomeClienteJuridico.setText(cj.getNOME());
        }
    }//GEN-LAST:event_consultarClienteJuridicoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalTrab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JMenuItem cadastrarClienteFisico;
    private javax.swing.JMenuItem cadastrarClienteJuridico;
    private javax.swing.JMenuItem cadastrarDespesa;
    private javax.swing.JMenuItem cadastrarFuncionario;
    private javax.swing.JMenuItem cadastrarTipoDespesa;
    private javax.swing.JMenuItem cadastrarVeiculo;
    private javax.swing.JMenuItem consultarClienteFisico;
    private javax.swing.JMenuItem consultarClienteJuridico;
    private javax.swing.JMenuItem consultarDespesa;
    private javax.swing.JMenuItem consultarFuncionario;
    private javax.swing.JMenuItem consultarTipoDespesa;
    private javax.swing.JMenuItem consultarVeiculo;
    private javax.swing.JLabel labelClienteFisico;
    private javax.swing.JLabel labelClienteJuridico;
    private javax.swing.JLabel labelDespesa;
    private javax.swing.JLabel labelFuncionario;
    private javax.swing.JLabel labelTipoDespesa;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVeiculo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsultar;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextField tfCodigoClienteFisico;
    private javax.swing.JTextField tfCodigoClienteJuridico;
    private javax.swing.JTextField tfCodigoDespesa;
    private javax.swing.JTextField tfCodigoFuncionario;
    private javax.swing.JTextField tfCodigoTipoDespesa;
    private javax.swing.JTextField tfCodigoVeiculo;
    private javax.swing.JTextField tfNomeClienteFisico;
    private javax.swing.JTextField tfNomeClienteJuridico;
    private javax.swing.JTextField tfNomeDespesa;
    private javax.swing.JTextField tfNomeFuncionario;
    private javax.swing.JTextField tfNomeTipoDespesa;
    private javax.swing.JTextField tfNomeVeiculo;
    // End of variables declaration//GEN-END:variables
}
