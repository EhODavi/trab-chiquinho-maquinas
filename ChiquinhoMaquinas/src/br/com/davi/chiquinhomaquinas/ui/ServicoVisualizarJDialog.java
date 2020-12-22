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
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ServicoVisualizarJDialog extends javax.swing.JDialog {

    public ServicoVisualizarJDialog(java.awt.Frame parent, boolean modal, int CDSERVICO) {
        super(parent, modal);
        initComponents();

        try {
            ServicoControle sControle = new ServicoControle();
            ServicoVeiculoControle svControle = new ServicoVeiculoControle();
            ServicoFuncionarioControle sfControle = new ServicoFuncionarioControle();
            ClienteFisicoControle cfControle = new ClienteFisicoControle();
            ClienteJuridicoControle cjControle = new ClienteJuridicoControle();
            DateParse dp = new DateParse();

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

            ComboBoxModel<Pessoa> pModel = new DefaultComboBoxModel<Pessoa>();
            boxPessoa.setModel(pModel);

            Pessoa p = cfControle.consultarPorId(s.getCDPESSOAFK());
            if (p == null) {
                p = cjControle.consultarPorId(s.getCDPESSOAFK());
            }

            boxPessoa.addItem(p);

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
            sfList = sfControle.consultarPorServico(CDSERVICO);

            preencheTabela(svList);
            preencheTabela1(sfList);
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
        botaoConfirmar = new javax.swing.JButton();
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
        setTitle("Visualização de Serviço");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));
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

        getContentPane().add(painelBotoes, java.awt.BorderLayout.PAGE_END);

        painelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        painelTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 153, 51));
        labelTitulo.setText("Visualização de Serviço");
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
        boxPessoa.setEnabled(false);
        boxPessoa.setPreferredSize(new java.awt.Dimension(65, 30));
        painelInformacoesBasicas.add(boxPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        botaoAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar.setEnabled(false);
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(41, 30));
        painelInformacoesBasicas.add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        painelDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        taDescricao.setEditable(false);
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

        tfEndereco.setEditable(false);
        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEndereco.setCaretColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfEndereco.setPreferredSize(new java.awt.Dimension(6, 30));
        tfEndereco.setSelectionColor(new java.awt.Color(255, 153, 51));
        painelInformacoesBasicas.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 260, -1));

        ftfDtInicio.setEditable(false);
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

        ftfDtFim.setEditable(false);
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
        radioV.setEnabled(false);
        radioV.setPreferredSize(new java.awt.Dimension(61, 30));
        painelFormaDePagamento.add(radioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, -1));

        radioP.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes1.add(radioP);
        radioP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioP.setText("A Prazo");
        radioP.setEnabled(false);
        radioP.setPreferredSize(new java.awt.Dimension(86, 30));
        painelFormaDePagamento.add(radioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        radioN.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes2.add(radioN);
        radioN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioN.setText("Não Paga");
        radioN.setEnabled(false);
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
        radioP1.setEnabled(false);
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

        ftfDataPagamento.setEditable(false);
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
        boxNumParcelas.setEnabled(false);
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
        tabela.setEnabled(false);
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(255, 153, 51));
        painelTabela.setViewportView(tabela);

        painelVeiculos.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 570, 150));

        boxVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boxVeiculo.setEnabled(false);
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
        botaoAdicionar1.setEnabled(false);
        botaoAdicionar1.setPreferredSize(new java.awt.Dimension(41, 30));
        painelVeiculos.add(botaoAdicionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 30));

        tfNumHorasViagens.setEditable(false);
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

        tfPreco.setEditable(false);
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
        botaoAdicionar2.setEnabled(false);
        botaoAdicionar2.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar2.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar2.setPreferredSize(new java.awt.Dimension(30, 30));
        painelVeiculos.add(botaoAdicionar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 60, -1));

        botaoRemover.setBackground(new java.awt.Color(255, 255, 255));
        botaoRemover.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/delete.png"))); // NOI18N
        botaoRemover.setEnabled(false);
        botaoRemover.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoRemover.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoRemover.setPreferredSize(new java.awt.Dimension(30, 30));
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
        boxFuncionario.setEnabled(false);
        boxFuncionario.setPreferredSize(new java.awt.Dimension(65, 30));
        painelFuncionarios.add(boxFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 190, 30));

        botaoAdicionar3.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/page_white_add.png"))); // NOI18N
        botaoAdicionar3.setEnabled(false);
        botaoAdicionar3.setPreferredSize(new java.awt.Dimension(41, 30));
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
        tabela1.setEnabled(false);
        tabela1.setGridColor(new java.awt.Color(255, 255, 255));
        tabela1.setSelectionBackground(new java.awt.Color(255, 153, 51));
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
        painelFuncionarios.add(botaoRemover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, -1));

        botaoAdicionar4.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoAdicionar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/add.png"))); // NOI18N
        botaoAdicionar4.setEnabled(false);
        botaoAdicionar4.setMaximumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar4.setMinimumSize(new java.awt.Dimension(0, 0));
        botaoAdicionar4.setPreferredSize(new java.awt.Dimension(30, 30));
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

        tfValorHora.setEditable(false);
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

        tfNumHoras.setEditable(false);
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

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    public void preencheTabela(List<ServicoVeiculo> svList) {
        if (svList != null) {
            String[] strSVet = new String[]{"Código", "Veículo", "Num. Horas/Viagens", "Preço", "Total"};
            String[][] strSVMat = new String[svList.size()][5];
            VeiculoControle vControle = new VeiculoControle();
            double total = 0;
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
            double total = 0;
            for (int i = 0; i < sfList.size(); i++) {
                ServicoFuncionario sf = sfList.get(i);
                try {
                    strSFMat[i][0] = Integer.toString(sf.getCDPESSOAFK());
                    strSFMat[i][1] = sControle.consultarPorId(sf.getCDPESSOAFK()).getNOME();
                    strSFMat[i][2] = Double.toString(sf.getNUMHORAS());
                    strSFMat[i][3] = "R$" + Double.toString(sf.getVALORHORA());
                    strSFMat[i][4] = "R$" + Double.toString(sf.getNUMHORAS() * sf.getVALORHORA());
                    total = total + sf.getNUMHORAS() * sf.getVALORHORA();
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
            tfTotal1.setText("R$" + total);
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
            java.util.logging.Logger.getLogger(ServicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicoVisualizarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServicoVisualizarJDialog dialog = new ServicoVisualizarJDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton botaoConfirmar;
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
