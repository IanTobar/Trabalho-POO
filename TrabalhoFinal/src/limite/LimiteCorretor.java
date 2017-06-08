//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO
package limite;

import controle.ControleCorretor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class LimiteCorretor extends JFrame implements ActionListener {//abre classe LimiteCorretor

    //controlador
    ControleCorretor ctrCorretor;

    //declaração dos JTextField
    private JTextField tfNomeCorretor;
    private JTextField tfCreci;
    private JTextField tfSalario;
    private JTextField tfDataAdmissao;

    //declaração dos JLabel
    private JLabel lbNomeCorretor;
    private JLabel lbCreci;
    private JLabel lbSalario;
    private JLabel lbDataAdmissao;

    private JButton btCadastrar;//declaração do botao de cadastrar
    private JComboBox cbTipoCorretor;//declaracao do combobox que terá os tipos de corretores

    //construtor
    public LimiteCorretor(ControleCorretor ctrCorretor) {//abre construtor 01

        //chama construtor da classe JFrame
        super("Cadastra Corretor");

        this.ctrCorretor = ctrCorretor;

        //criação dos objetos
        tfNomeCorretor = new JTextField(20);
        tfCreci = new JTextField(20);
        tfSalario = new JTextField(20);
        tfDataAdmissao = new JTextField(10);
        cbTipoCorretor = new JComboBox();
        btCadastrar = new JButton("Cadastrar");
        lbCreci = new JLabel("Digite o Creci");
        lbNomeCorretor = new JLabel("Digite o nome do corretor");
        lbSalario = new JLabel("Digite o salario do corretor (caso este for contratado)");
        lbDataAdmissao = new JLabel("Data de admissão");

        //adicionar itens no comboBox
        cbTipoCorretor.addItem("Comissionado");
        cbTipoCorretor.addItem("Contratado");

        btCadastrar.addActionListener(this);//adiciona listener no botão

        //criação do painel
        JPanel p = new JPanel();

        //adiciona os objetos ao painel p
        p.add(lbNomeCorretor);
        p.add(tfNomeCorretor);
        p.add(lbSalario);
        p.add(tfSalario);
        p.add(lbCreci);
        p.add(tfCreci);
        p.add(cbTipoCorretor);
        p.add(btCadastrar);
        p.add(lbDataAdmissao);
        p.add(tfDataAdmissao);

        //como esta classe é uma janela:
        this.add(p);//adiciona o painel nesta janela
        this.pack();//empacota tudo que está no painel JPane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha o programa
        this.setSize(500, 500);//define tamanho da janela
        this.setVisible(true);//torna a janela visivel      

    }//fecha construtor 01

    @Override
    public void actionPerformed(ActionEvent ae) {//abre actionPerformed

        String pNome = tfNomeCorretor.getText();
        int pCreci = Integer.parseInt(tfCreci.getText());
        double pSalario = Double.parseDouble(tfSalario.getText());
        Date pData = new Date();
        String pTipo = (String) cbTipoCorretor.getSelectedItem();
        double pComissao = Double.parseDouble(tfSalario.getText());

        if ((ae.getSource() == btCadastrar) && (pTipo == "Contratado")) {//abre if 01
            
            System.out.println(pNome + " " + pCreci + " " + pSalario + " " + pTipo);

            //chama metodo insereContratado da classe ControleCorretor
            ctrCorretor.insereContratado(pNome, pCreci, pSalario, pData);
            
        }//fecha if 01
        else{//abre else do if 01
            System.out.println(pNome + " " + pCreci + " " + pComissao + " " + pTipo);
            
            //chama metodo insereComissionado da classe ControleCorretor
            ctrCorretor.insereComissionado(pNome, pCreci, pComissao);
            
        }//fecha else do if 01

    }//fecha actionPerformed

}//fecha classe LimiteCorretor