//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package limite;

import javax.swing.*;

public class LimiteCorretor extends JFrame{//abre classe LimiteCorretor
    
    //declaração dos JTextField
    private JTextField tfNomeCorretor;
    private JTextField tfCreci;
    
    //declaração dos JLabel
    private JLabel lbNomeCorretor;
    private JLabel lbCreci;
    
    private JButton btCadastrar;//declaração do botao de cadastrar
    private JComboBox cbTipoCorretor;//declaracao do combobox que terá os tipos de corretores
    
    //construtor
    public LimiteCorretor(){//abre construtor 01

        //chama construtor da classe JFrame
        super("Cadastra Corretor");        
        
        //criação dos objetos
        tfNomeCorretor = new JTextField(20);
        tfCreci = new JTextField(20);
        cbTipoCorretor = new JComboBox();
        btCadastrar = new JButton("Cadastrar");
        lbCreci = new JLabel("Digite o Creci");
        lbNomeCorretor = new JLabel("Digite o nome do corretor");
        
        cbTipoCorretor.addItem("Comissionado");
        cbTipoCorretor.addItem("Contratado");
        
        //criação do painel
        JPanel p = new JPanel();
        
        //adiciona os objetos ao painel p
        p.add(lbNomeCorretor);
        p.add(tfNomeCorretor);
        p.add(lbCreci);
        p.add(tfCreci);
        p.add(cbTipoCorretor);
        p.add(btCadastrar);

        //como esta classe é uma janela:
        this.add(p);//adiciona o painel nesta janela
        this.pack();//empacota tudo que está no painel JPane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha o programa
        this.setSize(500, 500);//define tamanho da janela
        this.setVisible(true);//torna a janela visivel      
        
    }//fecha construtor 01
    
}//fecha classe LimiteCorretor