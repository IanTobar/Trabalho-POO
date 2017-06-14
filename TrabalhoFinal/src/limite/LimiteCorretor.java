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

    //declaração dos JTextField
    private JTextField tfNomeCorretor;
    private JTextField tfCreci;
    private JTextField tfSalario;
    private JTextField tfComissao;

    //declaração dos JLabel
    private JLabel lbNomeCorretor;
    private JLabel lbCreci;
    private JLabel lbSalario;
    private JLabel lbComissao;

    //declaração dos botões
    private JButton btCadastrar;//declaração do botao de cadastrar
    private JComboBox cbTipoCorretor;//declaracao do combobox que terá os tipos de corretores

    //construtor
    public LimiteCorretor(ControleCorretor ctrCorretor) {//abre construtor 01
        this.ctrCorretor = ctrCorretor;
    }//fecha construtor 01
    
    public void cadastraCorretor(){
        JFrame frCadastra = new JFrame();
 
        //criação dos objetos
        tfNomeCorretor = new JTextField(20);
        tfCreci = new JTextField(20);
        tfSalario = new JTextField(20);
        tfComissao = new JTextField(10);
        cbTipoCorretor = new JComboBox();
        btCadastrar = new JButton("Cadastrar");
        lbCreci = new JLabel("Digite o Creci");
        lbNomeCorretor = new JLabel("Digite o nome do corretor");
        lbSalario = new JLabel("Digite o salario do corretor (caso este for contratado)");
        lbComissao = new JLabel("Comissão");

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
        p.add(lbComissao);
        p.add(tfComissao);
        p.add(btCadastrar);
        
        p.setLayout(new GridLayout(10, 2));//grade 4 x 4

        //como esta classe é uma janela:
        frCadastra.add(p);//adiciona o painel nesta janela
        frCadastra.pack();//empacota tudo que está no painel JPane
        frCadastra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//fecha o programa
        frCadastra.setSize(500, 500);//define tamanho da janela
        frCadastra.setVisible(true);//torna a janela visivel      

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {//abre actionPerformed

        String pNome = tfNomeCorretor.getText();
        int pCreci = Integer.parseInt(tfCreci.getText());
        double pSalario = Double.parseDouble(tfSalario.getText());
        Date pData = new Date();
        String pTipo = (String) cbTipoCorretor.getSelectedItem();
        double pComissao = Double.parseDouble(tfComissao.getText());

        if ((ae.getSource() == btCadastrar) && (pTipo == "Contratado")) {//abre if 01

            System.out.println(pNome + " " + pCreci + " " + pSalario + " " + pTipo);

            //chama metodo insereContratado da classe ControleCorretor
            ctrCorretor.insereContratado(pNome, pCreci, pSalario, pData);
            //limpa os campos
            tfNomeCorretor.setText("");
            tfCreci.setText("");
            tfSalario.setText("");
            tfComissao.setText("");
        }//fecha if 01
        else {//abre else do if 01
            System.out.println(pNome + " " + pCreci + " " + pComissao + " " + pTipo);

            //chama metodo insereComissionado da classe ControleCorretor
            ctrCorretor.insereComissionado(pNome, pCreci, pComissao);
            //limpa os campos
            tfNomeCorretor.setText("");
            tfCreci.setText("");
            tfComissao.setText("");
            tfSalario.setText("");
        }//fecha else do if 01

    }//fecha actionPerformed

}//fecha classe LimiteCorretor
