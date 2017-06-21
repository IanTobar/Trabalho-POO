//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import java.util.*;

import controle.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import limite.*;

import modelo.*;

public class ControleImovel {//abre classe ControleImovel

    public ControlePrincipal ctrPrincipal;
    
    public LimiteImovel lmtImovel;

    private ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();

    //construtor 01
    public ControleImovel(ControlePrincipal ctrPrincipal) {//abre construtor 01
        
        this.ctrPrincipal = ctrPrincipal;
        lmtImovel = new LimiteImovel(this);
        
        try {
            this.desserializaImovel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }        

    }//fecha construtor 01

    public void cadastraImovel(int codigo, String tipo, String descricao, String nomeProprietario, double precoSolicitado, String data) {

        listaImoveis.add(new Imovel(codigo, tipo, descricao, nomeProprietario, precoSolicitado, data));

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel cadastrado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }        
        

    }

    public ArrayList<String> listarImoveis() {

        ArrayList<String> lista = new ArrayList<String>();

        String aux;

        for (Imovel i : listaImoveis) {

            aux = "Codigo: " + i.getCodigo() + "\nTipo: " + i.getTipo() + "\nDescrição: " + i.getDescricao() + "\nNome Do Proprietário: "
                    + i.getNomeVendedor() + "\nPreço: " + i.getPrecoSolicitado() + "\nData de Cadastro: " + i.getData();

            lista.add(aux);

        }

        return lista;

    }

    public ArrayList<Imovel> getLista() {

        return listaImoveis;

    }

    public void editaLista(int index, Imovel i) {

        listaImoveis.remove(index);

        listaImoveis.add(index, i);

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel editado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }                
        
    }

    public void removeLista(int index) {

        listaImoveis.remove(index);

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel removido com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }                
        
    }

    //metodo para serializa os imoveis, para salvar em arquivo
    private void serializaImovel() throws Exception {//abre serializaImovel
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o Array no arquivo
        objOS.writeObject(listaImoveis);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }//fecha serializaImovel
    
    //metodo para desserializar o arquivo de imoveis
    private void desserializaImovel() throws Exception {//abre desserializaDisciplina
        //nome do arquivo que será lido
        File objFile = new File("imoveis.dat");
        //se o arquivo existir
        if (objFile.exists()) {//abre if 01
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaImoveis = (ArrayList<Imovel>) objIS.readObject();
            //fecha stream
            objIS.close();
        }//fecha if 01

    }//fecha desserializaDisciplina
    
    
}//fecha classe ControleImovel