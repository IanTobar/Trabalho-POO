//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO
package limite;

import controle.ControleCorretor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class LimiteCorretor extends JFrame implements ActionListener {//abre classe LimiteCorretor

    //controlador
    ControleCorretor ctrCorretor;

    //declaração dos JTextField Corretor Contratado
    private JTextField tfNomeContratado;
    private JTextField tfCreciContratado;
    private JTextField tfSalario;

    //declaração dos JTextField Corretor Comissionado
    private JTextField tfNomeComissionados;
    private JTextField tfCreciComissionado;
    private JTextField tfComissao;
    
    //declaração dos JLabel Corretor Contratado
    private JLabel lbNomeContratado;
    private JLabel lbCreciContratado;
    //declaração dos JLabel Corretor Comissionado
    private JLabel lbNomeComissionados;
    private JLabel lbCreciComissionado;
    
    private JLabel lbSalario;
    private JLabel lbComissao;
    
    //declaração dos botões
    private JButton btCadastrar;
    private JButton btCadastrarComissionado;
    
    //declaração do JTabbedPane
    private JTabbedPane tab;
    //variaveis dos corretores
    private String pNome;
    private int pCreci;
    private double pSalario;
    Date pData;
    double pComissao;
    
    //variavel para verificar qual tab foi selecionada (0 - corretor contratado, 1 - comissionado)
    int indexTab = 0;
    //construtor
    public LimiteCorretor(ControleCorretor ctrCorretor) {//abre construtor 01

        //chama construtor da classe JFrame
        super("Cadastra Corretor");

        this.ctrCorretor = ctrCorretor;

        //criação dos objetos
        tfNomeContratado = new JTextField(20);
        tfNomeComissionados = new JTextField(20);
        tfCreciContratado = new JTextField(20);
        tfCreciComissionado = new JTextField(20);
        tfSalario = new JTextField(20);
        tfComissao = new JTextField(10);
        btCadastrar = new JButton("Cadastrar");
        btCadastrarComissionado = new JButton("Cadastrar");
        lbCreciContratado = new JLabel("Digite o Creci");
        lbCreciComissionado = new JLabel("Digite o Creci");
        lbNomeContratado = new JLabel("Digite o nome do corretor");
        lbNomeComissionados = new JLabel("Digite o nome do corretor");
        lbSalario = new JLabel("Digite o salario do corretor");
        lbComissao = new JLabel("Comissão");
        tab = new JTabbedPane();

        btCadastrar.addActionListener(this);//adiciona listener no botão
        btCadastrarComissionado.addActionListener(this);//adiciona listener no botão
                
        //criação do painel p1 (painel pra corretor contratado)
        JPanel p1 = new JPanel();
        //painel para corretores comissionados
        JPanel p2 = new JPanel();
        
        //adiciona os objetos ao painel p1 (contratado)
        p1.add(lbNomeContratado);
        p1.add(tfNomeContratado);
        p1.add(lbCreciContratado);
        p1.add(tfCreciContratado);
        p1.add(lbSalario);
        p1.add(tfSalario);
        p1.add(btCadastrar);

        p2.add(lbNomeComissionados);
        p2.add(tfNomeComissionados);        
        p2.add(lbCreciComissionado);
        p2.add(tfCreciComissionado);
        p2.add(lbComissao);
        p2.add(tfComissao);        
        p2.add(btCadastrarComissionado);
        
        //seta layout dos paineis
        p1.setLayout(new GridLayout(7, 2));
        p2.setLayout(new GridLayout(7, 2));        
        //adiciona JTabbedPane dos corretores contratados
        tab.addTab("Contratado", null, p1, "Cadastra Corretor Contratado");//titulo, icone, painel, ajuda
        tab.addTab("Comissionado", null, p2, "Cadastra Corretor Comissionado");//titulo, icone, painel, ajuda
        //adiciona listener na JTabbedPane tab, para saber qual painel está selecionado
        tab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
               
                System.out.println(tab.getSelectedIndex());
                
                indexTab = tab.getSelectedIndex();//atribui o index do painel selecionado no JTabbedPane
                
            }
        });        
        
        //como esta classe é uma janela:
        this.add(tab);//adiciona o painel nesta janela
        this.pack();//empacota tudo que está no painel JPane
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//fecha o programa
        this.setSize(500, 500);//define tamanho da janela
        this.setVisible(true);//torna a janela visivel      

    }//fecha construtor 01

    @Override
    public void actionPerformed(ActionEvent ae) {//abre actionPerformed



        if ((ae.getSource() == btCadastrar) && (indexTab == 0)) {//abre if 01
        
            pNome = tfNomeContratado.getText();
            pCreci = Integer.parseInt(tfCreciContratado.getText());        

            pSalario = Double.parseDouble(tfSalario.getText());                
            pData = new Date();                            
    
            System.out.println(pNome + " " + pCreci + " " + pSalario);

            //chama metodo insereContratado da classe ControleCorretor
            ctrCorretor.insereContratado(pNome, pCreci, pSalario, pData);
            
            //limpa os campos
            tfNomeContratado.setText("");
            tfCreciContratado.setText("");
            tfSalario.setText("");
            tfComissao.setText("");
            
        }//fecha if 01
        else{//abre else do if 01
            pNome = tfNomeComissionados.getText();
            pCreci = Integer.parseInt(tfCreciComissionado.getText());        
            
            pComissao = Double.parseDouble(tfComissao.getText());
            
            System.out.println(pNome + " " + pCreci + " " + pComissao);
            
            //chama metodo insereComissionado da classe ControleCorretor
            ctrCorretor.insereComissionado(pNome, pCreci, pComissao);
            //limpa os campos
            tfNomeComissionados.setText("");
            tfCreciComissionado.setText("");
            tfComissao.setText("");
            tfSalario.setText("");
        }//fecha else do if 01

    }//fecha actionPerformed

}//fecha classe LimiteCorretor