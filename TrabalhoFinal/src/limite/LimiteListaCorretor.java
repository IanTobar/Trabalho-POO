//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package limite;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.*;
import modelo.Corretor;
import modelo.CorretorComissionado;
import modelo.CorretorContratado;

public class LimiteListaCorretor extends JFrame {//abre classe LimiteListaCorretor

    //cria um grupo para o radio button
    ButtonGroup grp = new ButtonGroup();

    //construtor
    public LimiteListaCorretor(ArrayList<Corretor> listaCorretor) {//abre LimiteListaCorretor

        //chama construtor da classe JFrame
        super("Lista Corretores");

        //cria um novo painel
        JPanel p = new JPanel();

        //for que percorre todo o ArrayList que contém os corretores
        //passa os valores do ArryaList para a lista JList
        for (int i = 0; i < listaCorretor.size(); i++) {//abre for 01

            if (listaCorretor.get(i) instanceof CorretorContratado) {//abre if 01
                //cria um objeto auxiliar para pegar os dados do CorretorContratado
                CorretorContratado auxContratado = (CorretorContratado) listaCorretor.get(i);
                    
                String strAux = auxContratado.toString();//chama metodo toString e passa o valor da String
                //Cria JRadioButton
                JRadioButton rbi = new JRadioButton(strAux);//cria um novo botão

                p.add(rbi);//adiciona JRaidoButton no painel
                grp.add(rbi);//adiciona JRadioButton

                //adiciona listener
                rbi.addItemListener(
                        new ItemListener() {

                            public void itemStateChanged(ItemEvent e) {
                                if (e.getStateChange() == ItemEvent.SELECTED) {
                                    System.out.println(rbi.getText());
                                }
                            }
                        });

            }
            else {//abre else do if 01
                //cria um objeto auxiliar para pegar os dados do CorretorComissionado
                CorretorComissionado auxComissionado = (CorretorComissionado) listaCorretor.get(i);

                String strAux = auxComissionado.toString();
                //cria JRadioButton
                JRadioButton rbi = new JRadioButton(strAux);
                
                p.add(rbi);//adiciona JRadioButton no painel
                grp.add(rbi);//adiciona JRadioButton

                //adiciona listener
                rbi.addItemListener(
                        new ItemListener() {

                            public void itemStateChanged(ItemEvent e) {
                                if (e.getStateChange() == ItemEvent.SELECTED) {
                                    System.out.println(rbi.getText());
                                }
                            }
                        });

            }

        }//fecha for 01

        this.add(p);//adiciona o painel na janela
        this.setSize(500, 500);//define o tamanho da janela
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);//torna a janela visivel

    }//fecha LimiteListaCorretor

}//fecha classe LimiteListaCorretor
