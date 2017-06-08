/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import javax.swing.*;

/**
 *
 * @author Ruan
 */
public class LimiteImovel extends JFrame {

    ControleImovel ctrImovel;

    //Panel
    JPanel panel;

    //Botões
    JButton btCadastrar;
    JButton btConsultar;

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

        //Adição do conteudo no painel
        panel.add(btCadastrar);
        panel.add(btConsultar);
        panel.add(lbOpcoes);

        //Finalização para exibição na tela
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
