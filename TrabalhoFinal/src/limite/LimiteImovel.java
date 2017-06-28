//BRUNO GUILHERME LUNARDI - 2016003830//IAN MARCEL TOBAR - 2016001693 //RUAN MICHEL ADABO - 2016015278 package limite;import controle.*;import modelo.*;import java.awt.*;import java.awt.event.*;import java.util.ArrayList;import javax.swing.*;/** * * @author Ruan */public class LimiteImovel extends JFrame implements ActionListener {    ControleImovel ctrImovel;    //Panel    JPanel panel;    //BotÃµes    JButton btCadastrar;    JButton btConsultar;    //labels    JLabel lbOpcoes;    //sera usado para editar ou excluir    int index = 0;    public LimiteImovel(ControleImovel ctrImovel) {        this.ctrImovel = ctrImovel;//Armazena o controlador Principal numa variavel    }    @Override    public void actionPerformed(ActionEvent e) {        if (e.getSource().equals(btCadastrar)) {            cadastraImovel();        }        if (e.getSource().equals(btConsultar)) {        }    }    void cadastraImovel() {        //Inicializa Tela        JFrame frCadastra = new JFrame();        //Inicializa Painel        JPanel pCadastro = new JPanel();        //Inicializa TextFields         JTextField tfCodigo = new JTextField("");        JTextField tfDescricao = new JTextField("");        JTextField tfProprietario = new JTextField("");        JTextField tfPreco = new JTextField("");        JTextField tfData = new JTextField("");        //ComboBox        JComboBox cbTipo = new JComboBox();        cbTipo.addItem("Casa");        cbTipo.addItem("Apartamento");        cbTipo.addItem("Sala Comercial");        cbTipo.addItem("Lote");        cbTipo.addItem("Chácara");        cbTipo.addItem("Sítio");        cbTipo.addItem("Fazenda");                //Inicializa Labels        JLabel lbLogo = new JLabel("DADOS DO IMOVEL");        JLabel lbCodigo = new JLabel("CÃ³digo:");        JLabel lbTipo = new JLabel("Tipo:");        JLabel lbDescricao = new JLabel("Descrição:");        JLabel lbProprietario = new JLabel("Proprietário do Imóvel:");        JLabel lbPreco = new JLabel("Preço:");        JLabel lbData = new JLabel("Data:");        //Inicializa BotÃµes        JButton btSubmit = new JButton("Cadastrar");        JButton btCancelar = new JButton("Cancelar");        pCadastro.setLayout(null);        //Listener dos botÃµes        btSubmit.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                if (tfCodigo.getText().equals("")                        || tfDescricao.getText().equals("") || tfProprietario.getText().equals("")                        || tfPreco.getText().equals("") || tfData.getText().equals("")) {                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusÃ£o do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);                } else {                    //chama o metodo para cadastrar imovel, que esta no ControleImovel                    ctrImovel.cadastraImovel(Integer.parseInt(tfCodigo.getText()),                            (String)cbTipo.getSelectedItem(),                             tfDescricao.getText(), tfProprietario.getText(),                            Double.valueOf(tfPreco.getText()), tfData.getText());                    //frCadastra.dispose();                            //limpar os campos do formulario                            tfCodigo.setText("");                            tfDescricao.setText("");                            tfProprietario.setText("");                            tfPreco.setText("");                            tfData.setText("");                }            }        });        btCancelar.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                frCadastra.dispose();            }        });        //-PosiÃ§Ãµes dos elementos-// (x, y, largura, altura)        lbLogo.setBounds(200, 0, 125, 25);        lbCodigo.setBounds(0, 50, 500, 25);        lbTipo.setBounds(0, 100, 500, 25);        lbDescricao.setBounds(0, 150, 500, 25);        lbProprietario.setBounds(0, 200, 500, 25);        lbPreco.setBounds(0, 250, 500, 25);        lbData.setBounds(0, 300, 500, 25);        cbTipo.setBounds(0, 125, 485, 25);                tfCodigo.setBounds(0, 75, 500, 25);        tfDescricao.setBounds(0, 175, 500, 25);        tfProprietario.setBounds(0, 225, 500, 25);        tfPreco.setBounds(0, 275, 500, 25);        tfData.setBounds(0, 325, 500, 25);        btSubmit.setBounds(200, 375, 100, 25);        btCancelar.setBounds(200, 425, 100, 25);        //-AdiÃ§Ã£o dos elementos no painel-//        pCadastro.add(tfCodigo);        pCadastro.add(cbTipo);        pCadastro.add(tfDescricao);        pCadastro.add(tfProprietario);        pCadastro.add(tfPreco);        pCadastro.add(tfData);        pCadastro.add(lbLogo);        pCadastro.add(lbCodigo);        pCadastro.add(lbTipo);        pCadastro.add(lbDescricao);        pCadastro.add(lbProprietario);        pCadastro.add(lbPreco);        pCadastro.add(lbData);        pCadastro.add(btSubmit);        pCadastro.add(btCancelar);        //Ajustes no frame        frCadastra.setSize(500, 500);        frCadastra.getContentPane().add(pCadastro);        frCadastra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        frCadastra.setVisible(true);    }    public void listaImoveis(String pTipo) {//abre listaImoveis        JFrame frConsultar = new JFrame();        JPanel pMain = new JPanel();//Painel principal        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial        JPanel pButtons = new JPanel();//Painel pra guardar os botÃµes de Editar, Excluir e Cadastrar um novo Imovel                //pMain especificações        pMain.setLayout(null);        //pLabel especificações        pLabel.setLayout(new BorderLayout());        pLabel.add(new JLabel("LISTA DE IMOVEIS"), BorderLayout.CENTER);        //ComboBox        JComboBox cbTipo = new JComboBox();                   /////////////////        //Evitar repetições no JComboBox        ////////////////        //Array para pegar os tipos de imóveis já cadastrados        ArrayList<String> auxString = new ArrayList<String>();        //inicializa ComboBox        for (Imovel i : ctrImovel.getLista()) {//abre for 01            //se não existir no Array auxiliar o tipo cadastrado            if(!auxString.contains(i.getTipo())){//abre if 01                auxString.add(i.getTipo());//adiciona o tipo no Array auxiliar                cbTipo.addItem(i.getTipo());//adiciona item no comboBox            }//fecha if 01        }//fecha for 01                cbTipo.addItem("Todos");        cbTipo.setSelectedItem(pTipo);                //pButtons especificações        pButtons.setLayout(new GridLayout(1, 4, 5, 0));        //Adição dos botões        JButton bCadastrar = new JButton("Cadastrar Novo Imovel");        JButton bEditar = new JButton("Editar Imovel");        JButton bExcluir = new JButton("Excluir Imovel");        cbTipo.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                ctrImovel.listarImoveis((String)cbTipo.getSelectedItem());                frConsultar.dispose();                listaImoveis((String)cbTipo.getSelectedItem());            }        });                        bCadastrar.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                frConsultar.dispose();                cadastraImovel();            }        });        bEditar.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                frConsultar.dispose();                editaImovel(index);            }        });        bExcluir.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                frConsultar.dispose();                ctrImovel.removeLista(index);                listaImoveis(pTipo);                            }        });        pButtons.add(bCadastrar);        pButtons.add(bEditar);        pButtons.add(bExcluir);        pButtons.add(cbTipo);        ArrayList<String> lista = ctrImovel.listarImoveis(pTipo);        JPanel pLista = new JPanel();        pLista.setLayout(new BoxLayout(pLista, BoxLayout.Y_AXIS));        pLista.add(pLabel);        pLista.add(pButtons);        ButtonGroup grp = new ButtonGroup();        int i = 1;        int y = 110;        if (lista.size() != 0) {            for (String s : lista) {                JRadioButton rb = new JRadioButton(String.valueOf(i));                pLista.setBounds(0, y, 50, 100);                rb.setBounds(0, y, 50, 50);                rb.addItemListener(new ItemListener() {                    @Override                    public void itemStateChanged(ItemEvent e) {                        JToggleButton button = (JToggleButton) e.getSource();                        if (e.getStateChange() == ItemEvent.SELECTED) {                            index = Integer.parseInt(button.getText()) - 1;                        }                    }                });                grp.add(rb);                pLista.add(rb);                JTextArea text = new JTextArea(s);                text.setBounds(50, y, 500, 100);                pLista.add(text);                i++;                y += 110;            }        }        pLabel.setBounds(0, 0, 500, 50);        pButtons.setBounds(0, 50, 500, 50);        //pLista.setPreferredSize(new Dimension(500, 600));        JScrollPane scroll = new JScrollPane(pLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);        frConsultar.setPreferredSize(new Dimension(550, 600));        frConsultar.setLayout(new BorderLayout());        frConsultar.add(scroll, BorderLayout.CENTER);        frConsultar.pack();        //frConsultar.getContentPane().add(scroll);        frConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        frConsultar.setSize(900, 600);        frConsultar.setVisible(true);                    }//fecha listaImoveis    public void editaImovel(int index) {        //Inicializa Tela        JFrame frEdita = new JFrame();        //Inicializa Painel        JPanel pEdita = new JPanel();        Imovel i = ctrImovel.getLista().get(index);        //Inicializa TextFields         JTextField tfDescricao = new JTextField(i.getDescricao());        JTextField tfProprietario = new JTextField(i.getNomeVendedor());        JTextField tfPreco = new JTextField(String.valueOf(i.getPrecoSolicitado()));        JTextField tfData = new JTextField(i.getData());                //Inicializa Labels        JLabel lbLogo = new JLabel("DADOS DO IMOVEL");        JLabel lbDescricao = new JLabel("Descrição:");        JLabel lbProprietario = new JLabel("Proprietario do Imovel:");        JLabel lbPreco = new JLabel("Preço:");        JLabel lbData = new JLabel("Data:");        //Inicializa BotÃµes        JButton btSubmit = new JButton("Cadastrar");        JButton btCancelar = new JButton("Cancelar");        pEdita.setLayout(null);        //Listener dos botÃµes        btSubmit.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                if (tfDescricao.getText().equals("") || tfProprietario.getText().equals("")                        || tfPreco.getText().equals("") || tfData.getText().equals("")) {                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusão do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);                } else {                    i.setDescricao(tfDescricao.getText());                    i.setNomeVendedor(tfProprietario.getText());                    i.setPrecoSolicitado(Double.parseDouble(tfPreco.getText()));                    i.setData(tfData.getText());                    ctrImovel.editaLista(index, i);                    frEdita.dispose();                    listaImoveis("Todos");                    //frCadastra.dispose();                }            }        });        btCancelar.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                frEdita.dispose();                listaImoveis("Todos");            }        });        //-Posições dos elementos-// (x, y, largura, altura)        lbLogo.setBounds(200, 0, 125, 25);        lbDescricao.setBounds(0, 50, 500, 25);        lbProprietario.setBounds(0, 100, 500, 25);        lbPreco.setBounds(0, 150, 500, 25);        lbData.setBounds(0, 200, 500, 25);                tfDescricao.setBounds(0, 75, 500, 25);        tfProprietario.setBounds(0, 125, 500, 25);        tfPreco.setBounds(0, 175, 500, 25);        tfData.setBounds(0, 225, 500, 25);                              btSubmit.setBounds(200, 375, 100, 25);        btCancelar.setBounds(200, 425, 100, 25);        //-Adição dos elementos no painel-//        pEdita.add(tfDescricao);        pEdita.add(tfProprietario);        pEdita.add(tfPreco);        pEdita.add(tfData);        pEdita.add(lbLogo);        pEdita.add(lbDescricao);        pEdita.add(lbProprietario);        pEdita.add(lbPreco);        pEdita.add(lbData);        pEdita.add(btSubmit);        pEdita.add(btCancelar);        //Ajustes no frame        frEdita.setSize(500, 500);        frEdita.getContentPane().add(pEdita);        frEdita.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        frEdita.setVisible(true);    }}