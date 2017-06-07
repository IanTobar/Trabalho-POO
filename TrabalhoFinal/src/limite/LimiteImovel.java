/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;

import java.awt.*;
import java.awt.event.*;
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

    public LimiteImovel(ControleImovel ctrImovel) {
        this.ctrImovel = ctrImovel;//Armazena o controlador Principal numa variavel

        //Inicialiação dos conteudos
        panel = new JPanel();
        btCadastrar = new JButton();
        btConsultar = new JButton();
        lbOpcoes = new JLabel();

        //Setagem da tela
        panel.setLayout(null);
        setSize(500, 500);

        //Especificações do label lbOpções
        lbOpcoes.setBounds(0, 0, 150, 25);
        lbOpcoes.setText("Opções:");

        //Especificações dos Botões
        //Especificações do botão brImovel
        btCadastrar.setBounds(0, 25, 150, 25);//Posição
        btCadastrar.setText("Cadastrar");

        //Especificações do botão brImovel
        btConsultar.setBounds(0, 50, 150, 25);//Posição
        btConsultar.setText("Consultar");

        //Listeners dos botões
        btCadastrar.addActionListener(this);
        btConsultar.addActionListener(this);

        //Adição do conteudo no painel
        panel.add(btCadastrar);
        panel.add(btConsultar);
        panel.add(lbOpcoes);

        //Finalização para exibição na tela
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
        JTextField tfCodigo = new JTextField();
        JTextField tfTipo = new JTextField();
        JTextField tfDescricao = new JTextField();
        JTextField tfProprietario = new JTextField();
        JTextField tfPreco = new JTextField();
        JTextField tfData = new JTextField();

        //Inicializa Labels
        JLabel lbLogo = new JLabel();
        JLabel lbCodigo = new JLabel();
        JLabel lbTipo = new JLabel();
        JLabel lbDescricao = new JLabel();
        JLabel lbProprietario = new JLabel();
        JLabel lbPreco = new JLabel();
        JLabel lbData = new JLabel();

        //Inicializa Botões
        JButton btSubmit = new JButton();
        JButton btCancelar = new JButton();

        
        pCadastro.setLayout(null);

        lbLogo.setText("DADOS DO IMOVEL");

        lbCodigo.setText("Codigo:");
        lbTipo.setText("Tipo:");
        lbDescricao.setText("Descrição:");
        lbProprietario.setText("Nome do proprietário:");
        lbPreco.setText("Preço proposto:");
        lbData.setText("Data do Cadastro:");

        btSubmit.setText("Cadastrar");
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Funciona!");
            }
        });
        
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frCadastra.dispose();
            }
        });

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
        
        frCadastra.setSize(500, 500);
        frCadastra.getContentPane().add(pCadastro);
        frCadastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frCadastra.setVisible(true);
    }
}
