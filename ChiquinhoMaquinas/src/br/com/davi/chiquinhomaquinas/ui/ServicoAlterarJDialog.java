package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.ClienteFisico;
import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import br.com.davi.chiquinhomaquinas.entidade.DateParse;
import br.com.davi.chiquinhomaquinas.entidade.Funcionario;
import br.com.davi.chiquinhomaquinas.entidade.Pessoa;
import br.com.davi.chiquinhomaquinas.entidade.Servico;
import br.com.davi.chiquinhomaquinas.entidade.ServicoFuncionario;
import br.com.davi.chiquinhomaquinas.entidade.ServicoVeiculo;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;
import br.com.davi.chiquinhomaquinas.negocio.ClienteFisicoControle;
import br.com.davi.chiquinhomaquinas.negocio.ClienteJuridicoControle;
import br.com.davi.chiquinhomaquinas.negocio.FuncionarioControle;
import br.com.davi.chiquinhomaquinas.negocio.ServicoControle;
import br.com.davi.chiquinhomaquinas.negocio.ServicoFuncionarioControle;
import br.com.davi.chiquinhomaquinas.negocio.ServicoVeiculoControle;
import br.com.davi.chiquinhomaquinas.negocio.VeiculoControle;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ServicoAlterarJDialog extends javax.swing.JDialog {

    private Servico s = null;
    private double total = 0;
    private double total1 = 0;
    List<ServicoVeiculo> svListAtual = null;
    List<String> svListConfirmar = null;
    List<ServicoFuncionario> sfListAtual = null;
    List<String> sfListConfirmar = null;

    public Servico getServico() {
        return this.s;
    }

    public ServicoAlterarJDialog(java.awt.Frame parent, boolean modal, int CDSERVICO) {
        super(parent, modal);
        initComponents();

        try {
            ServicoControle sControle = new ServicoControle();
            ServicoVeiculoControle svControle = new ServicoVeiculoControle();
            ServicoFuncionarioControle sfControle = new ServicoFuncionarioControle();
            ClienteFisicoControle cfControle = new ClienteFisicoControle();
            ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
            DateParse dp = new DateParse();
            List<ClienteFisico> cfList = null;
            List<ClienteJuridico> cjList = null;
            List<Pessoa> pList = null;

            Servico s = sControle.consultarPorId(CDSERVICO);

            List<Veiculo> vList = null;
            VeiculoControle vControle = new VeiculoControle();

            vList = vControle.consultarTodos();

            ComboBoxModel<Veiculo> vModel = new DefaultComboBoxModel<Veiculo>();
            boxVeiculo.setModel(vModel);
            for (int i = 0; i < vList.size(); i++) {
                boxVeiculo.addItem(vList.get(i));
            }

            List<Funcionario> fList = null;
            FuncionarioControle fControle = new FuncionarioControle();

            fList = fControle.consultarTodos();

            ComboBoxModel<Funcionario> fModel = new DefaultComboBoxModel<Funcionario>();
            boxFuncionario.setModel(fModel);
            for (int i = 0; i < fList.size(); i++) {
                boxFuncionario.addItem(fList.get(i));
            }

            cfList = cfControle.consultarTodos();
            cjList = cjControle.consultarTodos();
            pList = new ArrayList();

            for (int i = 0; i < cfList.size(); i++) {
                pList.add(cfList.get(i));
            }
            for (int i = 0; i < cjList.size(); i++) {
                pList.add(cjList.get(i));
            }

            ComboBoxModel<Pessoa> pModel = new DefaultComboBoxModel<Pessoa>();
            boxPessoa.setModel(pModel);
            for (int i = 0; i < pList.size(); i++) {
                boxPessoa.addItem(pList.get(i));
            }

            Pessoa p = cfControle.consultarPorId(s.getCDPESSOAFK());
            if (p == null) {
                p = cjControle.consultarPorId(s.getCDPESSOAFK());
            }

            int index = -1;
            for (int i = 0; i < pList.size(); i++) {
                if (p.getCDPESSOA() == pList.get(i).getCDPESSOA()) {
                    index = i;
                }
            }
            boxPessoa.setSelectedIndex(index);

            taDescricao.setText(s.getDESCRICAO());
            tfEndereco.setText(s.getENDERECO());
            ftfDtInicio.setText(dp.dateToString(s.getDATAINICIO()));
            ftfDtFim.setText(dp.dateToString(s.getDATAFIM()));

            if (s.getFORMAPAG().equals("V")) {
                radioV.setSelected(true);
            } else {
                radioP.setSelected(true);
            }

            boxNumParcelas.setSelectedIndex(s.getNUMPARCELAS() - 1);
            ftfDataPagamento.setText(dp.dateToString(s.getDATAPAGAMENTO()));

            if (s.getSITUACAO().equals("P")) {
                radioP1.setSelected(true);
            } else {
                radioN.setSelected(true);
            }

            List<ServicoVeiculo> svList = null;
            List<ServicoFuncionario> sfList = null;

            svList = svControle.consultarPorServico(CDSERVICO);
            svListAtual = svList;
            sfList = sfControle.consultarPorServico(CDSERVICO);
            sfListAtual = sfList;

            svListConfirmar = new ArrayList();
            sfListConfirmar = new ArrayList();

            for (int i = 0; i < svListAtual.size(); i++) {
                svListConfirmar.add("N");
            }

            for (int i = 0; i < sfListAtual.size(); i++) {
                sfListConfirmar.add("N");
            }

            preencheTabela(svList);
            preencheTabela1(sfList);

            this.s = s;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes1 = new javax.swing.ButtonGroup();
        grupoBotoes2 = new javax.swing.ButtonGroup();
        painelBotoes = new javax.swing.JPanel();
        botaoAlterar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JTabbedPane();
        painelInformacoesBasicas = new javax.swing.JPanel();
        labelAsterisco1 = new javax.swing.JLabel();
        labelPessoa = new javax.swing.JLabel();
        boxPessoa = new javax.swing.JComboBox<>();
        botaoAdicionar = new javax.swing.JButton();
        painelDescricao = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        labelDescricao = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        labelAsterisco3 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        ftfDtInicio = new javax.swing.JFormattedTextField();
        ftfDtFim = new javax.swing.JFormattedTextField();
        labelDtFim = new javax.swing.JLabel();
        labelAsterisco4 = new javax.swing.JLabel();
        labelDtInicial = new javax.swing.JLabel();
        labelAsterisco5 = new javax.swing.JLabel();
        painelFormaDePagamento = new javax.swing.JPanel();
        labelFormaDePagamento = new javax.swing.JLabel();
        labelAsterisco6 = new javax.swing.JLabel();
        radioV = new javax.swing.JRadioButton();
        radioP = new javax.swing.JRadioButton();
        radioN = new javax.swing.JRadioButton();
        labelSituacao = new javax.swing.JLabel();
        radioP1 = new javax.swing.JRadioButton();
        labelAsterisco7 = new javax.swing.JLabel();
        labelNumParcelas = new javax.swing.JLabel();
        labelAsterisco8 = new javax.swing.JLabel();
        ftfDataPagamento = new javax.swing.JFormattedTextField();
        labelDataPagamento = new javax.swing.JLabel();
        labelAsterisco9 = new javax.swing.JLabel();
        boxNumParcelas = new javax.swing.JComboBox<>();
        painelVeiculos = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        boxVeiculo = new javax.swing.JComboBox<>();
        labelVeiculo = new javax.swing.JLabel();
        labelAsterisco10 = new javax.swing.JLabel();
        botaoAdicionar1 = new javax.swing.JButton();
        tfNumHorasViagens = new javax.swing.JTextField();
        labelNumHorasViagens = new javax.swing.JLabel();
        labelAsterisco11 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        labelAsterisco12 = new javax.swing.JLabel();
        botaoAdicionar2 = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        labelPrevia = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        painelFuncionarios = new javax.swing.JPanel();
        labelFuncionario = new javax.swing.JLabel();
        labelAsterisco13 = new javax.swing.JLabel();
        boxFuncionario = new javax.swing.JComboBox<>();
        botaoAdicionar3 = new javax.swing.JButton();
        painelTabela1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        tfTotal1 = new javax.swing.JTextField();
        botaoRemover1 = new javax.swing.JButton();
        botaoAdicionar4 = new javax.swing.JButton();
        labelValorHora = new javax.swing.JLabel();
        labelAsterisco14 = new javax.swing.JLabel();
        tfValorHora = new javax.swing.JTextField();
        labelNumHorasViagens1 = new javax.swing.JLabel();
        labelAsterisco15 = new javax.swing.JLabel();
        tfNumHoras = new javax.swing.JTextField();
        labelTotal1 = new javax.swing.JLabel();
        labelPrevia1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Serviço");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
        setResizable(false);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoAlterar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAlterar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/tick.png"))); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAlterar);

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
        labelTitulo.setText("Alteração de Serviço");
        painelTitulo.add(labelTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.PAGE_START);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        painelInformacoesBasicas.setBackground(new java.awt.Color(255, 255, 255));
        painelInformacoesBasicas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelInformacoesBasicas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        labelAsterisco1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco1.setPreferredSize(new java.awt.Dimension(10, 10));
        painelInformacoesBasicas.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 10, 10));

        labelPessoa.setBackground(new java.awt.Color(255, 255, 255));
        labelPessoa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPessoa.setText("Pessoa");
        labelPessoa.setPreferredSize(new java.awt.Dimension(94, 30));
        painelInformacoesBasicas.add(labelPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 50, 30));

        boxPessoa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxPessoa.setPreferredSize(new java.awt.Dimension(65, 30));
        painelInformacoesBasicas.add(boxPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        botaoAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(41, 30));
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        painelInformacoesBasicas.add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        painelDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        taDescricao.setRows(5);
        taDescricao.setCaretColor(new java.awt.Color(255, 153, 51));
        taDescricao.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        taDescricao.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelDescricao.setViewportView(taDescricao);

        painelInformacoesBasicas.add(painelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 240, 110));

        labelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        labelDescricao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDescricao.setText("Descrição");
        labelDescricao.setPreferredSize(new java.awt.Dimension(58, 30));
        painelInformacoesBasicas.add(labelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        labelAsterisco2.setPreferredSize(new java.awt.Dimension(10, 10));
        painelInformacoesBasicas.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 10, 10));

        labelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        labelEndereco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEndereco.setText("Endereço");
        painelInformacoesBasicas.add(labelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        labelAsterisco3.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco3.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco3.setText("*");
        painelInformacoesBasicas.add(labelAsterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEndereco.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEndereco.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelInformacoesBasicas.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 260, -1));

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
        painelInformacoesBasicas.add(ftfDtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 80, -1));

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
        painelInformacoesBasicas.add(ftfDtFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 80, -1));

        labelDtFim.setBackground(new java.awt.Color(255, 255, 255));
        labelDtFim.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDtFim.setText("Data Final");
        painelInformacoesBasicas.add(labelDtFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        labelAsterisco4.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco4.setText("*");
        painelInformacoesBasicas.add(labelAsterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        labelDtInicial.setBackground(new java.awt.Color(255, 255, 255));
        labelDtInicial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDtInicial.setText("Data Inicial");
        painelInformacoesBasicas.add(labelDtInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        labelAsterisco5.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco5.setText("*");
        painelInformacoesBasicas.add(labelAsterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        painelPrincipal.addTab("Informações Básicas", painelInformacoesBasicas);

        painelFormaDePagamento.setBackground(new java.awt.Color(255, 255, 255));
        painelFormaDePagamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelFormaDePagamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFormaDePagamento.setBackground(new java.awt.Color(255, 255, 255));
        labelFormaDePagamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFormaDePagamento.setText("Forma de Pagamento");
        labelFormaDePagamento.setPreferredSize(new java.awt.Dimension(50, 30));
        painelFormaDePagamento.add(labelFormaDePagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 150, -1));

        labelAsterisco6.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco6.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco6.setText("*");
        labelAsterisco6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco6.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFormaDePagamento.add(labelAsterisco6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 20, -1));

        radioV.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes1.add(radioV);
        radioV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioV.setSelected(true);
        radioV.setText("À Vista");
        radioV.setPreferredSize(new java.awt.Dimension(61, 30));
        painelFormaDePagamento.add(radioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, -1));

        radioP.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes1.add(radioP);
        radioP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioP.setText("A Prazo");
        radioP.setPreferredSize(new java.awt.Dimension(86, 30));
        painelFormaDePagamento.add(radioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        radioN.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes2.add(radioN);
        radioN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioN.setText("Não Paga");
        radioN.setPreferredSize(new java.awt.Dimension(86, 30));
        painelFormaDePagamento.add(radioN, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 90, -1));

        labelSituacao.setBackground(new java.awt.Color(255, 255, 255));
        labelSituacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSituacao.setText("Situação");
        labelSituacao.setPreferredSize(new java.awt.Dimension(50, 30));
        painelFormaDePagamento.add(labelSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        radioP1.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes2.add(radioP1);
        radioP1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioP1.setSelected(true);
        radioP1.setText("Paga");
        radioP1.setPreferredSize(new java.awt.Dimension(61, 30));
        painelFormaDePagamento.add(radioP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 60, -1));

        labelAsterisco7.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco7.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco7.setText("*");
        labelAsterisco7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco7.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFormaDePagamento.add(labelAsterisco7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 20, -1));

        labelNumParcelas.setBackground(new java.awt.Color(255, 255, 255));
        labelNumParcelas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNumParcelas.setText("Num. Parcelas");
        labelNumParcelas.setPreferredSize(new java.awt.Dimension(30, 30));
        painelFormaDePagamento.add(labelNumParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, -1));

        labelAsterisco8.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco8.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco8.setText("*");
        labelAsterisco8.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFormaDePagamento.add(labelAsterisco8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 20, -1));

        try {
            ftfDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDataPagamento.setCaretColor(new java.awt.Color(255, 153, 51));
        ftfDataPagamento.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        ftfDataPagamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ftfDataPagamento.setPreferredSize(new java.awt.Dimension(90, 30));
        ftfDataPagamento.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelFormaDePagamento.add(ftfDataPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 80, -1));

        labelDataPagamento.setBackground(new java.awt.Color(255, 255, 255));
        labelDataPagamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDataPagamento.setText("Data de Pagamento");
        labelDataPagamento.setPreferredSize(new java.awt.Dimension(26, 30));
        painelFormaDePagamento.add(labelDataPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 120, -1));

        labelAsterisco9.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco9.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco9.setText("*");
        labelAsterisco9.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFormaDePagamento.add(labelAsterisco9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 20, -1));

        boxNumParcelas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxNumParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        boxNumParcelas.setPreferredSize(new java.awt.Dimension(56, 30));
        painelFormaDePagamento.add(boxNumParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, -1));

        painelPrincipal.addTab("Forma de Pagamento", painelFormaDePagamento);

        painelVeiculos.setBackground(new java.awt.Color(255, 255, 255));
        painelVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelVeiculos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Veículo", "Num. Horas/Viagens", "Preço", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        painelTabela.setViewportView(tabela);

        painelVeiculos.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 570, 150));

        boxVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxVeiculo.setPreferredSize(new java.awt.Dimension(65, 30));
        painelVeiculos.add(boxVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        labelVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        labelVeiculo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelVeiculo.setText("Veículo");
        labelVeiculo.setPreferredSize(new java.awt.Dimension(94, 30));
        painelVeiculos.add(labelVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 50, 30));

        labelAsterisco10.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco10.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco10.setText("*");
        labelAsterisco10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco10.setPreferredSize(new java.awt.Dimension(10, 10));
        painelVeiculos.add(labelAsterisco10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 10, 10));

        botaoAdicionar1.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar1.setPreferredSize(new java.awt.Dimension(41, 30));
        botaoAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionar1ActionPerformed(evt);
            }
        });
        painelVeiculos.add(botaoAdicionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        tfNumHorasViagens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNumHorasViagens.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNumHorasViagens.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNumHorasViagens.setPreferredSize(new java.awt.Dimension(14, 30));
        tfNumHorasViagens.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelVeiculos.add(tfNumHorasViagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 50, -1));

        labelNumHorasViagens.setBackground(new java.awt.Color(255, 255, 255));
        labelNumHorasViagens.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNumHorasViagens.setText("Num. Horas/Viagens");
        labelNumHorasViagens.setPreferredSize(new java.awt.Dimension(30, 30));
        painelVeiculos.add(labelNumHorasViagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 120, 30));

        labelAsterisco11.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco11.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco11.setText("*");
        labelAsterisco11.setPreferredSize(new java.awt.Dimension(10, 10));
        painelVeiculos.add(labelAsterisco11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 20, -1));

        tfPreco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfPreco.setCaretColor(new java.awt.Color(255, 153, 51));
        tfPreco.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfPreco.setPreferredSize(new java.awt.Dimension(14, 30));
        tfPreco.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelVeiculos.add(tfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 50, -1));

        labelPreco.setBackground(new java.awt.Color(255, 255, 255));
        labelPreco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPreco.setText("Preço");
        labelPreco.setPreferredSize(new java.awt.Dimension(30, 30));
        painelVeiculos.add(labelPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 40, -1));

        labelAsterisco12.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco12.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco12.setText("*");
        labelAsterisco12.setPreferredSize(new java.awt.Dimension(10, 10));
        painelVeiculos.add(labelAsterisco12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 20, -1));

        botaoAdicionar2.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/add.png"))); // NOI18N
        botaoAdicionar2.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar2.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar2.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionar2ActionPerformed(evt);
            }
        });
        painelVeiculos.add(botaoAdicionar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 60, -1));

        botaoRemover.setBackground(new java.awt.Color(255, 255, 255));
        botaoRemover.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/delete.png"))); // NOI18N
        botaoRemover.setEnabled(false);
        botaoRemover.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoRemover.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoRemover.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        painelVeiculos.add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, -1));

        labelPrevia.setBackground(new java.awt.Color(255, 255, 255));
        labelPrevia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrevia.setText("Prévia:");
        painelVeiculos.add(labelPrevia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        labelTotal.setBackground(new java.awt.Color(255, 255, 255));
        labelTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotal.setText("Total");
        painelVeiculos.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotal.setCaretColor(new java.awt.Color(255, 153, 51));
        tfTotal.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfTotal.setPreferredSize(new java.awt.Dimension(70, 30));
        tfTotal.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelVeiculos.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, -1));

        painelPrincipal.addTab("Veículos", painelVeiculos);

        painelFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        painelFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painelFuncionarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        labelFuncionario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFuncionario.setText("Funcionário");
        labelFuncionario.setPreferredSize(new java.awt.Dimension(94, 30));
        painelFuncionarios.add(labelFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 70, 30));

        labelAsterisco13.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco13.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco13.setText("*");
        labelAsterisco13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelAsterisco13.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFuncionarios.add(labelAsterisco13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 10, 10));

        boxFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxFuncionario.setPreferredSize(new java.awt.Dimension(65, 30));
        painelFuncionarios.add(boxFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        botaoAdicionar3.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar3.setPreferredSize(new java.awt.Dimension(41, 30));
        botaoAdicionar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionar3ActionPerformed(evt);
            }
        });
        painelFuncionarios.add(botaoAdicionar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        tabela1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Funcionário", "Num. Horas", "Valor/Hora", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.setGridColor(new java.awt.Color(255, 255, 255));
        tabela1.setSelectionBackground(new java.awt.Color(255, 153, 51));
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        painelTabela1.setViewportView(tabela1);

        painelFuncionarios.add(painelTabela1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 570, 150));

        tfTotal1.setEditable(false);
        tfTotal1.setBackground(new java.awt.Color(255, 255, 255));
        tfTotal1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotal1.setCaretColor(new java.awt.Color(255, 153, 51));
        tfTotal1.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfTotal1.setPreferredSize(new java.awt.Dimension(70, 30));
        tfTotal1.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelFuncionarios.add(tfTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, -1));

        botaoRemover1.setBackground(new java.awt.Color(255, 255, 255));
        botaoRemover1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoRemover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/delete.png"))); // NOI18N
        botaoRemover1.setEnabled(false);
        botaoRemover1.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoRemover1.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoRemover1.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemover1ActionPerformed(evt);
            }
        });
        painelFuncionarios.add(botaoRemover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, -1));

        botaoAdicionar4.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/add.png"))); // NOI18N
        botaoAdicionar4.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar4.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar4.setPreferredSize(new java.awt.Dimension(30, 30));
        botaoAdicionar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionar4ActionPerformed(evt);
            }
        });
        painelFuncionarios.add(botaoAdicionar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 60, -1));

        labelValorHora.setBackground(new java.awt.Color(255, 255, 255));
        labelValorHora.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelValorHora.setText("Valor/Hora");
        labelValorHora.setPreferredSize(new java.awt.Dimension(30, 30));
        painelFuncionarios.add(labelValorHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 60, -1));

        labelAsterisco14.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco14.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco14.setText("*");
        labelAsterisco14.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFuncionarios.add(labelAsterisco14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        tfValorHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValorHora.setCaretColor(new java.awt.Color(255, 153, 51));
        tfValorHora.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfValorHora.setPreferredSize(new java.awt.Dimension(14, 30));
        tfValorHora.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelFuncionarios.add(tfValorHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 50, -1));

        labelNumHorasViagens1.setBackground(new java.awt.Color(255, 255, 255));
        labelNumHorasViagens1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNumHorasViagens1.setText("Num. Horas");
        labelNumHorasViagens1.setPreferredSize(new java.awt.Dimension(30, 30));
        painelFuncionarios.add(labelNumHorasViagens1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 70, 30));

        labelAsterisco15.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco15.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco15.setText("*");
        labelAsterisco15.setPreferredSize(new java.awt.Dimension(10, 10));
        painelFuncionarios.add(labelAsterisco15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 20, -1));

        tfNumHoras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNumHoras.setCaretColor(new java.awt.Color(255, 153, 51));
        tfNumHoras.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfNumHoras.setPreferredSize(new java.awt.Dimension(14, 30));
        tfNumHoras.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelFuncionarios.add(tfNumHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 50, -1));

        labelTotal1.setBackground(new java.awt.Color(255, 255, 255));
        labelTotal1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotal1.setText("Total");
        painelFuncionarios.add(labelTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        labelPrevia1.setBackground(new java.awt.Color(255, 255, 255));
        labelPrevia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrevia1.setText("Prévia:");
        painelFuncionarios.add(labelPrevia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        painelPrincipal.addTab("Funcionários", painelFuncionarios);

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        if (boxPessoa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo [Pessoa] é obrigatório! Por favor, selecione-o [Caso não exista, cadastre um novo].", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Descrição] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taDescricao.getText().length() > 255) {
            JOptionPane.showMessageDialog(null, "O Campo [Descrição] deve possuir no máximo 255 caracteres. Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Endereço] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEndereco.getText().length() > 255) {
            JOptionPane.showMessageDialog(null, "O Campo [Endereço] deve possuir no máximo 255 caracteres! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ftfDtInicio.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Data Inicial] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DateParse dp = new DateParse();
        try {
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
            dp.parseDate(ftfDtFim.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "A Data Final informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (dp.parseDate(ftfDtInicio.getText()).getTime() > dp.parseDate(ftfDtFim.getText()).getTime()) {
                JOptionPane.showMessageDialog(null, "O Campo [Data Inicial] é maior do que o Campo [Data Final]! Por favor, corrija-os.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (ftfDataPagamento.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "O Campo [Data Pagamento] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            dp.parseDate(ftfDataPagamento.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "A Data de Pagamento informada é inválida! Por favor, corrija-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (dp.parseDate(ftfDtFim.getText()).getTime() > dp.parseDate(ftfDataPagamento.getText()).getTime()) {
                JOptionPane.showMessageDialog(null, "O Campo [Data Final] é maior do que o Campo [Data de Pagamento]! Por favor, corrija-os.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DefaultTableModel m = (DefaultTableModel) tabela.getModel();
        if (m.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "A Tabela de Veículos não está preenchida! Por favor, preencha-a.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.s.setDESCRICAO(taDescricao.getText());
        Object o = boxPessoa.getSelectedItem();
        Pessoa p = (Pessoa) o;
        this.s.setCDPESSOAFK(p.getCDPESSOA());
        this.s.setENDERECO(tfEndereco.getText());
        try {
            this.s.setDATAINICIO(dp.parseDate(ftfDtInicio.getText()));
            this.s.setDATAFIM(dp.parseDate(ftfDtFim.getText()));
            this.s.setDATAPAGAMENTO(dp.parseDate(ftfDataPagamento.getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (radioV.isSelected() == true) {
            this.s.setFORMAPAG("V");
        } else {
            this.s.setFORMAPAG("P");
        }
        if (radioP1.isSelected() == true) {
            this.s.setSITUACAO("P");
        } else {
            this.s.setSITUACAO("N");
        }
        o = boxNumParcelas.getSelectedItem();
        this.s.setNUMPARCELAS(Integer.parseInt(o.toString()));

        try {
            ServicoControle sControle = new ServicoControle();
            sControle.alterar(this.s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        ServicoVeiculoControle svControle = new ServicoVeiculoControle();
        boolean validacao;
        for (int i = 0; i < m.getRowCount(); i++) {
            validacao = false;
            ServicoVeiculo sv = new ServicoVeiculo();
            sv.setCDSERVICOFK(this.s.getCDSERVICO());
            sv.setCDVEICULOFK(Integer.parseInt(m.getValueAt(i, 0).toString()));
            sv.setNUMHORASVIAGENS(Double.parseDouble(m.getValueAt(i, 2).toString()));
            sv.setPRECO(Double.parseDouble(m.getValueAt(i, 3).toString().substring(2, m.getValueAt(i, 3).toString().length())));

            for (int k = 0; k < svListAtual.size(); k++) {
                if (svListAtual.get(k).getCDVEICULOFK() == sv.getCDVEICULOFK()) {
                    validacao = true;
                    svListConfirmar.remove(k);
                    svListConfirmar.add(k, "C");
                }
            }
            try {
                if (validacao == true) {
                    svControle.alterar(sv, sv.getCDVEICULOFK());
                } else {
                    svControle.inserir(sv);
                }

            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

        for (int k = 0; k < svListConfirmar.size(); k++) {
            if (svListConfirmar.get(k).equals("N")) {
                try {
                    svControle.excluir(this.s.getCDSERVICO(), svListAtual.get(k).getCDVEICULOFK());
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        this.s.setPRECOTOTAL(total);

        DefaultTableModel m1 = (DefaultTableModel) tabela1.getModel();
        ServicoFuncionarioControle sfControle = new ServicoFuncionarioControle();
        for (int i = 0; i < m1.getRowCount(); i++) {
            validacao = false;
            ServicoFuncionario sf = new ServicoFuncionario();
            sf.setCDSERVICOFK(this.s.getCDSERVICO());
            sf.setCDPESSOAFK(Integer.parseInt(m1.getValueAt(i, 0).toString()));
            sf.setNUMHORAS(Double.parseDouble(m1.getValueAt(i, 2).toString()));
            sf.setVALORHORA(Double.parseDouble(m1.getValueAt(i, 3).toString().substring(2, m1.getValueAt(i, 3).toString().length())));

            for (int k = 0; k < sfListAtual.size(); k++) {
                if (sfListAtual.get(k).getCDPESSOAFK() == sf.getCDPESSOAFK()) {
                    validacao = true;
                    sfListConfirmar.remove(k);
                    sfListConfirmar.add(k, "C");
                }
            }

            try {
                if (validacao == true) {
                    sfControle.alterar(sf, sf.getCDPESSOAFK());
                } else {
                    sfControle.inserir(sf);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

        for (int k = 0; k < sfListConfirmar.size(); k++) {
            if (sfListConfirmar.get(k).equals("N")) {
                try {
                    sfControle.excluir(this.s.getCDSERVICO(), sfListAtual.get(k).getCDPESSOAFK());
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Alteração de Serviço realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.s = null;
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        OpcaoPessoaCadastroJDialog opCadastro = new OpcaoPessoaCadastroJDialog(this, true);
        opCadastro.setVisible(true);

        Pessoa p = opCadastro.getPessoa();
        if (p != null) {
            boxPessoa.addItem(p);
            boxPessoa.setSelectedItem(p);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionar1ActionPerformed
        VeiculoCadastroJDialog vCadastro = new VeiculoCadastroJDialog(this, true);
        vCadastro.setVisible(true);

        Veiculo v = vCadastro.getVeiculo();
        if (v != null) {
            boxVeiculo.addItem(v);
            boxVeiculo.setSelectedItem(v);
        }
    }//GEN-LAST:event_botaoAdicionar1ActionPerformed

    private void botaoAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionar2ActionPerformed
        if (boxVeiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo [Veículo] é obrigatório! Por favor, selecione-o [Caso não exista, cadastre um novo].", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tfNumHorasViagens.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Num. Horas/Viagens] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfNumHorasViagens.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Num. de Horas/Viagens informado deve ser um número maior do que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Num. de Horas/Viagens] deve receber apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tfPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Preco] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfPreco.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Preco informado deve ser um número maior do que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Preco] deve receber apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object o = boxVeiculo.getSelectedItem();
        Veiculo v = (Veiculo) o;
        DefaultTableModel m = (DefaultTableModel) tabela.getModel();
        String[] objeto = new String[]{Integer.toString(v.getCDVEICULO()), v.getNOME(), tfNumHorasViagens.getText(), "R$" + tfPreco.getText(), "R$" + Double.toString(Double.parseDouble(tfNumHorasViagens.getText()) * Double.parseDouble(tfPreco.getText()))};
        m.addRow(objeto);
        total = total + Double.parseDouble(tfNumHorasViagens.getText()) * Double.parseDouble(tfPreco.getText());
        tfTotal.setText("R$" + Double.toString(total));
        tfNumHorasViagens.setText("");
        tfPreco.setText("");
    }//GEN-LAST:event_botaoAdicionar2ActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        int linha = tabela.getSelectedRow();
        DefaultTableModel m = (DefaultTableModel) tabela.getModel();
        total = total - Double.parseDouble(m.getValueAt(linha, 2).toString()) * Double.parseDouble(m.getValueAt(linha, 3).toString().substring(2, m.getValueAt(linha, 3).toString().length()));;
        tfTotal.setText("R$" + Double.toString(total));
        m.removeRow(linha);
        botaoRemover.setEnabled(false);
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        botaoRemover.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    private void botaoAdicionar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionar3ActionPerformed
        FuncionarioCadastroJDialog fCadastro = new FuncionarioCadastroJDialog(this, true);
        fCadastro.setVisible(true);

        Funcionario f = fCadastro.getFuncionario();
        if (f != null) {
            boxFuncionario.addItem(f);
            boxFuncionario.setSelectedItem(f);
        }
    }//GEN-LAST:event_botaoAdicionar3ActionPerformed

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        botaoRemover1.setEnabled(true);
    }//GEN-LAST:event_tabela1MouseClicked

    private void botaoRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemover1ActionPerformed
        int linha = tabela1.getSelectedRow();
        DefaultTableModel m = (DefaultTableModel) tabela1.getModel();
        total1 = total1 - Double.parseDouble(m.getValueAt(linha, 2).toString()) * Double.parseDouble(m.getValueAt(linha, 3).toString().substring(2, m.getValueAt(linha, 3).toString().length()));;
        tfTotal1.setText("R$" + Double.toString(total1));
        m.removeRow(linha);
        botaoRemover1.setEnabled(false);
    }//GEN-LAST:event_botaoRemover1ActionPerformed

    private void botaoAdicionar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionar4ActionPerformed
        if (boxFuncionario.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo [Funcionario] é obrigatório! Por favor, selecione-o [Caso não exista, cadastre um novo].", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tfNumHoras.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Num. Horas] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfNumHoras.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Num. de Horas informado deve ser um número maior do que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Num. de Horas] deve receber apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tfValorHora.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor/Hora] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(tfValorHora.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "O Valor/Hora informado deve ser um número maior do que 0! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Campo [Valor/Hora] deve receber apenas valores numéricos! Por favor, corrija-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object o = boxFuncionario.getSelectedItem();
        Funcionario f = (Funcionario) o;
        DefaultTableModel m = (DefaultTableModel) tabela1.getModel();
        String[] objeto = new String[]{Integer.toString(f.getCDPESSOA()), f.getNOME(), tfNumHoras.getText(), "R$" + tfValorHora.getText(), "R$" + Double.toString(Double.parseDouble(tfNumHoras.getText()) * Double.parseDouble(tfValorHora.getText()))};
        m.addRow(objeto);
        total1 = total1 + Double.parseDouble(tfNumHoras.getText()) * Double.parseDouble(tfValorHora.getText());
        tfTotal1.setText("R$" + Double.toString(total1));
        tfNumHoras.setText("");
        tfValorHora.setText("");
    }//GEN-LAST:event_botaoAdicionar4ActionPerformed

    public void preencheTabela(List<ServicoVeiculo> svList) {
        if (svList != null) {
            String[] strSVet = new String[]{"Código", "Veículo", "Num. Horas/Viagens", "Preço", "Total"};
            String[][] strSVMat = new String[svList.size()][5];
            VeiculoControle vControle = new VeiculoControle();
            for (int i = 0; i < svList.size(); i++) {
                ServicoVeiculo sv = svList.get(i);
                try {
                    strSVMat[i][0] = Integer.toString(sv.getCDVEICULOFK());
                    strSVMat[i][1] = vControle.consultarPorId(sv.getCDVEICULOFK()).getNOME();
                    strSVMat[i][2] = Double.toString(sv.getNUMHORASVIAGENS());
                    strSVMat[i][3] = "R$" + Double.toString(sv.getPRECO());
                    strSVMat[i][4] = "R$" + Double.toString(sv.getNUMHORASVIAGENS() * sv.getPRECO());
                    total = total + sv.getNUMHORASVIAGENS() * sv.getPRECO();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strSVMat, strSVet) {
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
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tfTotal.setText("R$" + total);
        }
    }

    public void preencheTabela1(List<ServicoFuncionario> sfList) {
        if (sfList != null) {
            String[] strSFVet = new String[]{"Código", "Funcionário", "Num. Horas", "Valor/Hora", "Total"};
            String[][] strSFMat = new String[sfList.size()][5];
            FuncionarioControle sControle = new FuncionarioControle();

            for (int i = 0; i < sfList.size(); i++) {
                ServicoFuncionario sf = sfList.get(i);
                try {
                    strSFMat[i][0] = Integer.toString(sf.getCDPESSOAFK());
                    strSFMat[i][1] = sControle.consultarPorId(sf.getCDPESSOAFK()).getNOME();
                    strSFMat[i][2] = Double.toString(sf.getNUMHORAS());
                    strSFMat[i][3] = "R$" + Double.toString(sf.getVALORHORA());
                    strSFMat[i][4] = "R$" + Double.toString(sf.getNUMHORAS() * sf.getVALORHORA());
                    total1 = total1 + sf.getNUMHORAS() * sf.getVALORHORA();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(strSFMat, strSFVet) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            tabela1.setModel(modelo);
            tabela1.setRowSorter(new TableRowSorter(modelo));
            tabela1.getColumnModel().getColumn(0).setResizable(false);
            tabela1.getColumnModel().getColumn(1).setResizable(false);
            tabela1.getColumnModel().getColumn(2).setResizable(false);
            tabela1.getColumnModel().getColumn(3).setResizable(false);
            tabela1.getColumnModel().getColumn(4).setResizable(false);
            tabela1.getTableHeader().setReorderingAllowed(false);
            tabela1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tfTotal1.setText("R$" + total1);
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
            java.util.logging.Logger.getLogger(ServicoAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicoAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicoAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicoAlterarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServicoAlterarJDialog dialog = new ServicoAlterarJDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAdicionar1;
    private javax.swing.JButton botaoAdicionar2;
    private javax.swing.JButton botaoAdicionar3;
    private javax.swing.JButton botaoAdicionar4;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoRemover1;
    private javax.swing.JComboBox<Funcionario> boxFuncionario;
    private javax.swing.JComboBox<String> boxNumParcelas;
    private javax.swing.JComboBox<Pessoa> boxPessoa;
    private javax.swing.JComboBox<Veiculo> boxVeiculo;
    private javax.swing.JFormattedTextField ftfDataPagamento;
    private javax.swing.JFormattedTextField ftfDtFim;
    private javax.swing.JFormattedTextField ftfDtInicio;
    private javax.swing.ButtonGroup grupoBotoes1;
    private javax.swing.ButtonGroup grupoBotoes2;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco10;
    private javax.swing.JLabel labelAsterisco11;
    private javax.swing.JLabel labelAsterisco12;
    private javax.swing.JLabel labelAsterisco13;
    private javax.swing.JLabel labelAsterisco14;
    private javax.swing.JLabel labelAsterisco15;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelAsterisco3;
    private javax.swing.JLabel labelAsterisco4;
    private javax.swing.JLabel labelAsterisco5;
    private javax.swing.JLabel labelAsterisco6;
    private javax.swing.JLabel labelAsterisco7;
    private javax.swing.JLabel labelAsterisco8;
    private javax.swing.JLabel labelAsterisco9;
    private javax.swing.JLabel labelDataPagamento;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelDtFim;
    private javax.swing.JLabel labelDtInicial;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelFormaDePagamento;
    private javax.swing.JLabel labelFuncionario;
    private javax.swing.JLabel labelNumHorasViagens;
    private javax.swing.JLabel labelNumHorasViagens1;
    private javax.swing.JLabel labelNumParcelas;
    private javax.swing.JLabel labelPessoa;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelPrevia;
    private javax.swing.JLabel labelPrevia1;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JLabel labelValorHora;
    private javax.swing.JLabel labelVeiculo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JScrollPane painelDescricao;
    private javax.swing.JPanel painelFormaDePagamento;
    private javax.swing.JPanel painelFuncionarios;
    private javax.swing.JPanel painelInformacoesBasicas;
    private javax.swing.JTabbedPane painelPrincipal;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JScrollPane painelTabela1;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JPanel painelVeiculos;
    private javax.swing.JRadioButton radioN;
    private javax.swing.JRadioButton radioP;
    private javax.swing.JRadioButton radioP1;
    private javax.swing.JRadioButton radioV;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela1;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNumHoras;
    private javax.swing.JTextField tfNumHorasViagens;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTotal1;
    private javax.swing.JTextField tfValorHora;
    // End of variables declaration//GEN-END:variables
}
