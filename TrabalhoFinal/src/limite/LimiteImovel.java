//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBARmite;
package limite;
import controle.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteImovel extends JFrame implements ActionListener {//abre classe LimiteImovel

    ControleImovel ctrImovel;//variavel de instancia referente ao ControleImovel

    //Panel
    JPanel panel;

    //Botões
    JButton btCadastrar;
    JButton btConsultar;

    //labels
    JLabel lbOpcoes;

    //construtor
    public LimiteImovel(ControleImovel ctrImovel) {//abre construtor 01
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
        
    }//fecha construtor 01
    //metodo para eventos dos botões
    @Override
    public void actionPerformed(ActionEvent e) {
        //verifica se o botão precionado foi o cadastrar
        if (e.getSource().equals(btCadastrar)) {
            cadastraImovel();//chama metodo cadastraImovel
        }
        //verifica se o botão selecionado foi o consultar
        if (e.getSource().equals(btConsultar)) {

        }

    }
    //metodo para cadastrarImovel
    void cadastraImovel() {//abre cadastraImovel
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
                System.out.println("Funciona!");
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
        frCadastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frCadastra.setVisible(true);
        
    }//fecha cadastraImovel
    
}//fecha classe LimiteImovel