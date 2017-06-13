/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import modelo.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Ruan
 */
public class LimiteImovel extends JFrame implements ActionListener {

    ControleImovel ctrImovel;

    //Panel
    JPanel panel;

    //Botões
    JButton btCadastrar;
    JButton btConsultar;

    //labels
    JLabel lbOpcoes;

    int index = 0;

    public LimiteImovel(ControleImovel ctrImovel) {
        this.ctrImovel = ctrImovel;//Armazena o controlador Principal numa variavel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btCadastrar)) {
            cadastraImovel();
        }
        if (e.getSource().equals(btConsultar)) {

        }

    }

    void cadastraImovel() {
        //Inicializa Tela
        JFrame frCadastra = new JFrame();

        //Inicializa Painel
        JPanel pCadastro = new JPanel();

        //Inicializa TextFields 
        JTextField tfCodigo = new JTextField("");
        JTextField tfTipo = new JTextField("");
        JTextField tfDescricao = new JTextField("");
        JTextField tfProprietario = new JTextField("");
        JTextField tfPreco = new JTextField("");
        JTextField tfData = new JTextField("");

        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DO IMOVEL");
        JLabel lbCodigo = new JLabel("Código:");
        JLabel lbTipo = new JLabel("Tipo:");
        JLabel lbDescricao = new JLabel("Descrição:");
        JLabel lbProprietario = new JLabel("Proprietário do Imóvel:");
        JLabel lbPreco = new JLabel("Preço:");
        JLabel lbData = new JLabel("Data:");

        //Inicializa Botões
        JButton btSubmit = new JButton("Cadastrar");
        JButton btCancelar = new JButton("Cancelar");

        pCadastro.setLayout(null);

        //Listener dos botões
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().equals("") || tfTipo.getText().equals("")
                        || tfDescricao.getText().equals("") || tfProprietario.getText().equals("")
                        || tfPreco.getText().equals("") || tfData.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusão do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    ctrImovel.cadastraImovel(Integer.parseInt(tfCodigo.getText()),
                            tfTipo.getText(), tfDescricao.getText(), tfProprietario.getText(),
                            Double.valueOf(tfPreco.getText()), tfData.getText());
                    //frCadastra.dispose();
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frCadastra.dispose();
            }
        });

        //-Posições dos elementos-//
        lbLogo.setBounds(200, 0, 125, 25);

        lbCodigo.setBounds(0, 50, 500, 25);
        lbTipo.setBounds(0, 100, 500, 25);
        lbDescricao.setBounds(0, 150, 500, 25);
        lbProprietario.setBounds(0, 200, 500, 25);
        lbPreco.setBounds(0, 250, 500, 25);
        lbData.setBounds(0, 300, 500, 25);

        tfCodigo.setBounds(0, 75, 500, 25);
        tfTipo.setBounds(0, 125, 500, 25);
        tfDescricao.setBounds(0, 175, 500, 25);
        tfProprietario.setBounds(0, 225, 500, 25);
        tfPreco.setBounds(0, 275, 500, 25);
        tfData.setBounds(0, 325, 500, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);

        //-Adição dos elementos no painel-//
        pCadastro.add(tfCodigo);
        pCadastro.add(tfTipo);
        pCadastro.add(tfDescricao);
        pCadastro.add(tfProprietario);
        pCadastro.add(tfPreco);
        pCadastro.add(tfData);

        pCadastro.add(lbLogo);
        pCadastro.add(lbCodigo);
        pCadastro.add(lbTipo);
        pCadastro.add(lbDescricao);
        pCadastro.add(lbProprietario);
        pCadastro.add(lbPreco);
        pCadastro.add(lbData);

        pCadastro.add(btSubmit);
        pCadastro.add(btCancelar);

        //Ajustes no frame
        frCadastra.setSize(500, 500);
        frCadastra.getContentPane().add(pCadastro);
        frCadastra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frCadastra.setVisible(true);
    }

    public void listaImoveis() {
        System.out.println("Teste1");
        JFrame frConsultar = new JFrame();
        JPanel pMain = new JPanel();//Painel principal
        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial
        JPanel pButtons = new JPanel();//Painel pra guardar os botões de Editar, Excluir e Cadastrar um novo Imovel

        System.out.println("Aqui1");
        //pMain especificações
        pMain.setLayout(null);

        //pLabel especificações
        pLabel.setLayout(new BorderLayout());
        pLabel.add(new JLabel("LISTA DE IMOVEIS"), BorderLayout.CENTER);

        //pButtons especificações
        pButtons.setLayout(new GridLayout(1, 3, 5, 0));
        //Adição dos botões
        JButton bCadastrar = new JButton("Cadastrar Novo Imóvel");
        JButton bEditar = new JButton("Editar Imóvel");
        JButton bExcluir = new JButton("Excluir Imóvel");

        bCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                cadastraImovel();
            }
        });
        bEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                editaImovel(index);
            }
        });
        bExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                ctrImovel.removeLista(index);
                listaImoveis();
            }
        });

        pButtons.add(bCadastrar);
        pButtons.add(bEditar);
        pButtons.add(bExcluir);

        ArrayList<String> lista = ctrImovel.listarImoveis();

        JPanel pLista = new JPanel();
        pLista.setLayout(null);

        ButtonGroup grp = new ButtonGroup();

        int i = 1;
        int y = 110;
        if (lista.size() != 0) {
            for (String s : lista) {
                JRadioButton rb = new JRadioButton(String.valueOf(i));
                pLista.setBounds(0, y, 50, 100);
                rb.setBounds(0,y,50,50);
                
                rb.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        JToggleButton button = (JToggleButton) e.getSource();
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            index = Integer.parseInt(button.getText()) - 1;
                        }
                    }
                });
                grp.add(rb);
                pLista.add(rb);

                JTextArea text = new JTextArea(s);
                text.setBounds(50, y, 500, 100);

                pLista.add(text);
                i++;
                y += 110;
            }
        }

        pLista.add(pLabel);
        pLista.add(pButtons);
        
        pLabel.setBounds(0, 0, 500, 50);
        pButtons.setBounds(0, 50, 500, 50);

        frConsultar.setSize(500,600);
        pLista.setPreferredSize(new Dimension(500, 600));
        JScrollPane scroll = new JScrollPane(pLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frConsultar.getContentPane().add(scroll);
        frConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frConsultar.setVisible(true);
    }

    public void editaImovel(int index) {
        //Inicializa Tela
        JFrame frEdita = new JFrame();

        //Inicializa Painel
        JPanel pEdita = new JPanel();

        Imovel i = ctrImovel.getLista().get(index);

        //Inicializa TextFields 
        JTextField tfCodigo = new JTextField(String.valueOf(i.getCodigo()));
        JTextField tfTipo = new JTextField(i.getTipo());
        JTextField tfDescricao = new JTextField(i.getDescricao());
        JTextField tfProprietario = new JTextField(i.getNomeVendedor());
        JTextField tfPreco = new JTextField(String.valueOf(i.getPrecoSolicitado()));
        JTextField tfData = new JTextField(i.getData());

        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DO IMOVEL");
        JLabel lbCodigo = new JLabel("Código:");
        JLabel lbTipo = new JLabel("Tipo:");
        JLabel lbDescricao = new JLabel("Descrição:");
        JLabel lbProprietario = new JLabel("Proprietário do Imóvel:");
        JLabel lbPreco = new JLabel("Preço:");
        JLabel lbData = new JLabel("Data:");

        //Inicializa Botões
        JButton btSubmit = new JButton("Cadastrar");
        JButton btCancelar = new JButton("Cancelar");

        pEdita.setLayout(null);

        //Listener dos botões
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().equals("") || tfTipo.getText().equals("")
                        || tfDescricao.getText().equals("") || tfProprietario.getText().equals("")
                        || tfPreco.getText().equals("") || tfData.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusão do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    i.setCodigo(Integer.parseInt(tfCodigo.getText()));
                    i.setTipo(tfTipo.getText());
                    i.setDescricao(tfDescricao.getText());
                    i.setNomeVendedor(tfProprietario.getText());
                    i.setPrecoSolicitado(Double.parseDouble(tfPreco.getText()));
                    i.setData(tfData.getText());
                    ctrImovel.editaLista(index, i);
                    frEdita.dispose();
                    listaImoveis();
                    //frCadastra.dispose();
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frEdita.dispose();
                listaImoveis();
            }
        });

        //-Posições dos elementos-//
        lbLogo.setBounds(200, 0, 125, 25);

        lbCodigo.setBounds(0, 50, 500, 25);
        lbTipo.setBounds(0, 100, 500, 25);
        lbDescricao.setBounds(0, 150, 500, 25);
        lbProprietario.setBounds(0, 200, 500, 25);
        lbPreco.setBounds(0, 250, 500, 25);
        lbData.setBounds(0, 300, 500, 25);

        tfCodigo.setBounds(0, 75, 500, 25);
        tfTipo.setBounds(0, 125, 500, 25);
        tfDescricao.setBounds(0, 175, 500, 25);
        tfProprietario.setBounds(0, 225, 500, 25);
        tfPreco.setBounds(0, 275, 500, 25);
        tfData.setBounds(0, 325, 500, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);

        //-Adição dos elementos no painel-//
        pEdita.add(tfCodigo);
        pEdita.add(tfTipo);
        pEdita.add(tfDescricao);
        pEdita.add(tfProprietario);
        pEdita.add(tfPreco);
        pEdita.add(tfData);

        pEdita.add(lbLogo);
        pEdita.add(lbCodigo);
        pEdita.add(lbTipo);
        pEdita.add(lbDescricao);
        pEdita.add(lbProprietario);
        pEdita.add(lbPreco);
        pEdita.add(lbData);

        pEdita.add(btSubmit);
        pEdita.add(btCancelar);

        //Ajustes no frame
        frEdita.setSize(500, 500);
        frEdita.getContentPane().add(pEdita);
        frEdita.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frEdita.setVisible(true);
    }
}
