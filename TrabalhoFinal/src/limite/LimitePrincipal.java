/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import limite.*;
import modelo.*;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ruan
 */
public class LimitePrincipal extends JFrame implements ActionListener {
    
    ControlePrincipal ctrPrincipal;
    
    JPanel panel;//Painel principal

    JButton btImovel;//Botão que leva para o limiteImovel

    JLabel lbImobiliaria;//Label que irá ter o nome da imobiliaria e etc

    public LimitePrincipal(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;//Armazena o controlador Principal numa variavel

        //Inicialiação dos conteudos
        panel = new JPanel();
        btImovel = new JButton();
        lbImobiliaria = new JLabel();

        //Adicionando Listeners nos Botões
        btImovel.addActionListener(this);
        
        //Setagem da tela
        panel.setLayout(null);
        setSize(500, 500);

        //Especificações do label lbImobiliaria
        lbImobiliaria.setBounds(0,0,150,25);
        lbImobiliaria.setText("Imoveis:");
        
        //Especificações do botão brImovel
        btImovel.setBounds(0, 25, 150, 25);//Posição
        btImovel.setText("Gerenciar Imoveis");
        
        //Adição do conteudo no painel
        panel.add(btImovel);
        panel.add(lbImobiliaria);
        
        //Finalização para exibição na tela
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ação caso o botão btImovel seja clicado
        if(e.getSource().equals(btImovel)){
            System.out.println("BtImovel");
            new ControleImovel();
        }
    }
}
