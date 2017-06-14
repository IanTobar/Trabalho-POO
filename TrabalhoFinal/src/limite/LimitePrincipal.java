//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR

package limite;

import controle.*;
import limite.*;
import modelo.*;

import java.awt.event.*;
import javax.swing.*;

public class LimitePrincipal extends JFrame implements ActionListener {
    
    ControlePrincipal ctrPrincipal;//objeto responsável pelo controle desta visao
    ControleImovel ctrImovel = new ControleImovel("Vazio");
    ControleCorretor ctrCorretor = new ControleCorretor();
    
    LimiteCorretor lmtCorretor;
    
    JPanel panel;//Painel principal
    //declaração dos Menus
    JMenu smCadastrar;
    JMenu mCorretor;
 //   JMenu smContratado;//submenu

    //Declaração dos itens dos menus
    JMenuItem miCadastImovel;
    JMenuItem miConsulImovel;
    JMenuItem miCadastCorretor;
    JMenuItem miListCorretor;
    JMenuItem miCadastVenda;
    JMenuItem miConsulVenda;
    
    //construtor, passa o controle para o construtor
    public LimitePrincipal(ControlePrincipal ctrPrincipal) {//abre construtor 01

        this.ctrPrincipal = ctrPrincipal;//Armazena o controlador Principal numa variavel

        // Constrói a barra de menus
        JMenuBar mb = new JMenuBar();
        
        setJMenuBar(mb);//setMenu adiciona o menu o JFrame
        
        // Constrói um menu e o adiciona a barra
        JMenu mImovel = new JMenu("Imóvel", true);        
        //adiciona o menu m na barra JMenuBar
        mb.add(mImovel);

        //////////////////////
        //INICIO MENU DO CORRETOR//
        //////////////////////    
        mCorretor = new JMenu("Corretor", true);// Constrói um menu e o adiciona a barra
        mb.add(mCorretor);//adiciona o menu mCorretor na barra JMenuBar        
        
        //smContratado = new JMenu("Corretor Contratado");// Cria um submenu
        //mCorretor.add(smContratado);//adicionar o submenu no menu mContratar
        
        miCadastCorretor = new JMenuItem("Cadastrar");// Cria um item de menu e o adiciona ao submenu
        mCorretor.add(miCadastCorretor);//adicionar o menu item no mCorretor        
        miCadastCorretor.addActionListener(this);//adiciona listener aqui        

        miListCorretor = new JMenuItem("Listar");// Cria um item de menu e o adiciona ao submenu
        mCorretor.add(miListCorretor);//adicionar o menu item no mCorretor        
        miListCorretor.addActionListener(this);//adiciona listener aqui                
        //////////////////////
        //FIM MENU DO CORRETOR//
        //////////////////////
        
        // Constrói um menu e o adiciona a barra
        JMenu mVendas = new JMenu("Vendas", true);        
        //adiciona o menu m na barra JMenuBar
        mb.add(mVendas);                

        // Constrói um menu e o adiciona a barra
        JMenu mPagamento = new JMenu("Pagamentos", true);        
        //adiciona o menu m na barra JMenuBar
        mb.add(mPagamento);                        
        mPagamento.addActionListener(this);
        
        
        // Constrói um menu e o adiciona a barra
        JMenu mRelatorios = new JMenu("Relatórios", true);        
        //adiciona o menu mRelatorios na barra JMenuBar
        mb.add(mRelatorios);                        
        
        // Cria um item de menu e o adiciona ao submenu
        //possui todas as propriedades comuns de um botão
        miCadastImovel = new JMenuItem("Cadastrar");
        mImovel.add(miCadastImovel);//adicionar o menu item no sub menu sm
        miCadastImovel.addActionListener(this);//adicionar listener no miCadastImovel
        
        // Cria um item de menu e o adiciona ao submenu
        //possui todas as propriedades comuns de um botão
        miConsulImovel = new JMenuItem("Consultar");
        mImovel.add(miConsulImovel);//adicionar o menu item no sub menu sm
        miConsulImovel.addActionListener(this);//adicionar listener
        
        // Cria um item de menu e o adiciona ao submenu
        //possui todas as propriedades comuns de um botão
        miCadastVenda = new JMenuItem("Cadastrar");
        mVendas.add(miCadastVenda);//adicionar o menu item no sub menu sm
        miCadastVenda.addActionListener(this);//adicionar listener
        
        // Cria um item de menu e o adiciona ao submenu
        //possui todas as propriedades comuns de um botão
        miConsulVenda = new JMenuItem("Consultar");
        mVendas.add(miConsulVenda);//adicionar o menu item no sub menu sm
        miConsulVenda.addActionListener(this);//adicionar listener
        
        
        //Inicialiação dos conteudos
        panel = new JPanel();

        //Setagem da tela
        panel.setLayout(null);
        setSize(500, 500);
        
        //Finalização para exibição na tela
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
                
    }//fecha  construtor 01

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(miCadastImovel)){//se selecionar o cadastrar do imovel
            LimiteImovel lmtImovel = new LimiteImovel(ctrImovel);
            lmtImovel.cadastraImovel();
        }
        
        if(ae.getSource().equals(miConsulImovel)){//se selecionar a consulta do imovel
            LimiteImovel lmtImovel = new LimiteImovel(ctrImovel);
            lmtImovel.listaImoveis();
        }
        
        if(ae.getSource().equals(miCadastCorretor)){//se selecionar o cadastrar do corretor
            
            //new ControleCorretor();//chama controlador do corretor contratado
            
            lmtCorretor = new LimiteCorretor(ctrCorretor);
            
            
        }
        
        if(ae.getSource().equals(miListCorretor)){
            
          ctrCorretor.listaCorretor();
            
        }
        
        if(ae.getSource().equals(miCadastVenda)){
          
            ctr
           
        }
        
    }


}
