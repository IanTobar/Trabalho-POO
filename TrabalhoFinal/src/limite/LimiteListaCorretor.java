//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package limite;

import controle.ControleCorretor;
import controle.ControleImovel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Corretor;
import modelo.CorretorComissionado;
import modelo.CorretorContratado;

public class LimiteListaCorretor extends JFrame implements ActionListener, ListSelectionListener{//abre classe LimiteListaCorretor

    ControleCorretor ctrCorretor;

    int index;
    
    private ArrayList <Corretor> auxListaCorretor = new ArrayList <Corretor>();//array para Corretor

    //define lista como dinâmica
    private DefaultListModel listModel;
    //declaraão do JList
    private JList dinamicCorretorList;
    
    int i;
    
    //declara botão
    private JButton btEditar;
    
    //construtor recebe o ArrayList de Corretor, vindo do ControleCorretor
    public LimiteListaCorretor(ControleCorretor ctrCorretor) {//abre LimiteListaCorretor

        //chama construtor da classe JFrame
        super("Lista Corretores");
        
        //cria o model par adicionar elementos, dinâmicamente
        listModel = new DefaultListModel();        
        
        //cria um novo painel
        JPanel p = new JPanel();
        
        //for que percorre todo o ArrayList que contém os corretores
        //passa os valores do ArryaList para a lista JList
        for (i = 0; i < ctrCorretor.getListaCorretor().size(); i++) {//abre for 01

            if (ctrCorretor.getListaCorretor().get(i) instanceof CorretorContratado) {//abre if 01
                //cria um objeto auxiliar para pegar os dados do CorretorContratado
                CorretorContratado auxContratado = (CorretorContratado) ctrCorretor.getListaCorretor().get(i);
                //adiciona elementos na lista
                listModel.addElement(auxContratado);
                
            }//fecha if 01
            else {//abre else do if 01
                //cria um objeto auxiliar para pegar os dados do CorretorComissionado
                CorretorComissionado auxComissionado = (CorretorComissionado) ctrCorretor.getListaCorretor().get(i);
                //adiciona elementos na lista
                listModel.addElement(auxComissionado);

            }//fecha else do if 01

        }//fecha for 01
        
        // Cria a lista passando o modelo como parametro
        dinamicCorretorList = new JList(listModel);        
        //cria botão
        JButton btEditar = new JButton("Editar");
        //adiciona listener
        btEditar.addActionListener(this);
        dinamicCorretorList.addListSelectionListener(this);     
        
        p.add(btEditar);//adiciona botão no painel
        p.add(dinamicCorretorList);//adiciona a ista no painel
        
        this.add(p);//adiciona o painel na janela
        this.setSize(500, 500);//define o tamanho da janela
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);//torna a janela visivel

        auxListaCorretor = ctrCorretor.getListaCorretor();
        
    }//fecha LimiteListaCorretor

    @Override
    public void actionPerformed(ActionEvent ae) {//abre actionPerformed
        
            if(auxListaCorretor.get(index) instanceof CorretorContratado){
                CorretorContratado auxContratado = (CorretorContratado) auxListaCorretor.get(index);
                
                double salarioNovo = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo salario"));
                
                auxContratado.setaSalarioFixo(salarioNovo);
            }
            else{
                CorretorComissionado auxComissionado = (CorretorComissionado) auxListaCorretor.get(index);
                
                double comissaoNova = Double.parseDouble(JOptionPane.showInputDialog("Informe a nova comissão"));
                
                auxComissionado.setaComissao(comissaoNova);                
            }
        
    }//fecha actionPerformed

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (dinamicCorretorList.getSelectedIndex() != -1) {
                index = dinamicCorretorList.getSelectedIndex();
            }
        }
    }    
    
}//fecha classe LimiteListaCorretor