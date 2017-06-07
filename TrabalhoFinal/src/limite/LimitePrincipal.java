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
    
    JPanel panel;//Painel principal
    
    JMenu smCadastrar;

    JMenuItem miCadastImovel;
    
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

        // Constrói um menu e o adiciona a barra
        JMenu mCorretor = new JMenu("Corretor", true);        
        //adiciona o menu m na barra JMenuBar
        mb.add(mCorretor);        

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
        //adiciona o menu m na barra JMenuBar
        mb.add(mRelatorios);                        
        
        
        // Cria um item de menu e o adiciona ao submenu
        //possui todas as propriedades comuns de um botão
        miCadastImovel = new JMenuItem("Cadastrar");
        miCadastImovel.setMnemonic(KeyEvent.VK_M);//define tecla de atalho
        mImovel.add(miCadastImovel);//adicionar o menu item no sub menu sm
        miCadastImovel.addActionListener(this);//adicionar listener no mi
        
        //Inicialiação dos conteudos
        panel = new JPanel();

        //Setagem da tela
        panel.setLayout(null);
        setSize(500, 500);


        
        
        //Especificações do label lbImobiliaria
//        lbImobiliaria.setBounds(0,0,150,25);
        
        //Finalização para exibição na tela
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
                
    }//fecha  construtor 01

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(miCadastImovel)){
            new ControleImovel();
        }
        
    }


}
