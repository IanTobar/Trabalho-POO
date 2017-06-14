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

public class LimiteListaCorretor implements ListSelectionListener{//abre classe LimiteListaCorretor

    ControleCorretor ctrCorretor;//controle dos corretores
    int index;//pega index do elemento da lista selecionado
    private ArrayList <Corretor> auxListaCorretor = new ArrayList <Corretor>();//array para Corretor
    //define lista como dinâmica
    private DefaultListModel listModel;
    //declaraão do JList
    private JList dinamicCorretorList;
    //declara botão
    private JButton btEditar = new JButton("Editar");
    private JButton btExluir = new JButton("Excluir");
    
    //declara tela
    private JFrame tela = new JFrame("Lista Corretores");
    
    //construtor
    public LimiteListaCorretor(ControleCorretor ctrCorretor) {//abre LimiteListaCorretor
        //inicializa a variavel de instancia ctrCorretor com o ctrCorretor do construtor
        this.ctrCorretor = ctrCorretor;
        //cria o model par adicionar elementos, dinâmicamente
        listModel = new DefaultListModel();        
        //for que percorre todo o ArrayList que contém os corretores
        //passa os valores do ArryaList para a lista JList
        for (int i = 0; i < ctrCorretor.getListaCorretor().size(); i++) {//abre for 01
            
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
        
        criaTela();
                
    }//fecha LimiteListaCorretor

    //cria tela
    public void criaTela(){//abre criaTela
        
        //cria um novo painel
        JPanel p = new JPanel();        
        // Cria a lista passando o modelo como parametro
        dinamicCorretorList = new JList(listModel);        
        
        //adiciona listener na lista, para pegar o indice do item selecionado na lista
        dinamicCorretorList.addListSelectionListener(this);     
        //adiciona elementos no painel p
        p.add(btEditar);//adiciona botão no painel
        p.add(btExluir);//adiciona botão no painel
        p.add(dinamicCorretorList);//adiciona a lista no painel
        
        btEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //chama metodo para editar corretor, método da classe ControleCorretor
                ctrCorretor.editaCorretor(index);            
                tela.dispose();
                new LimiteListaCorretor(ctrCorretor);
            }
        });           
        //coloca Listener para botão btExluir
        btExluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //chama metodo para editar corretor, método da classe ControleCorretor
                ctrCorretor.excluiCorretor(index);
                tela.dispose();
                new LimiteListaCorretor(ctrCorretor);    
            }
        });                        
        
        //configura janela
        tela.add(p);//adiciona o painel na janela
        tela.setSize(500, 500);//define o tamanho da janela
        tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//esconede a janela
        tela.setVisible(true);//torna a janela visivel        
    
    }//fecha criaTela
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (dinamicCorretorList.getSelectedIndex() != -1) {
                index = dinamicCorretorList.getSelectedIndex();
            }
        }
    }    
    
}//fecha classe LimiteListaCorretor