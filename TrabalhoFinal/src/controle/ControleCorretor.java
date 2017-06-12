//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import limite.LimiteCorretor;
import limite.LimiteListaCorretor;
import modelo.Corretor;
import modelo.CorretorComissionado;
import modelo.CorretorContratado;

public class ControleCorretor {//abre classe ControleCorretor

    LimiteCorretor lmtCorretor;//variavel de instancia responsavel pelo limite dos corretores
    LimiteListaCorretor lmtListaCorretor;//variavel de instancia responsavel pelo limite de listagem dos corretores

    private ArrayList<Corretor> listaCorretor = new ArrayList<Corretor>();//array para Corretor

//    private final String arquivo = "disc.dat";//constante
    //construtor
    public ControleCorretor() {//abre ControleCorretor

        //new LimiteCorretor(this);
        try {
            this.desserializaCorretor();
        } catch (Exception e) {
            System.err.println("Aqui");
            
        }

    }//fecha ControleCorretor

    //metodo para inserir corretor contratado
    public void insereContratado(String pNome, int pCreci, double pSalario, Date pDate) {//abre metodo insereContratado

        //cria um obejto do modelo CorretorContratado e aciona o seu construtor
        CorretorContratado contratado = new CorretorContratado(pNome, pCreci, pSalario, pDate);//cria objeto contratado
        listaCorretor.add(contratado);//adiciona o contratado no array list de corretor

    }//fecha metodo inseteContratado    

    //metodo para inserir vendedor contratado
    public void insereComissionado(String pNome, int pCreci, double pComissao) {//abre metodo insereContratado

        //chama um obejto do modelo CorretorComissionado e aciona o seu construtor
        CorretorComissionado comissionado = new CorretorComissionado(pNome, pCreci, pComissao);//cria objeto contratado
        listaCorretor.add(comissionado);//adiciona o contratado no array list de corretor

        try {
            this.serializaCorretor();
        } catch (Exception e) {
            System.err.println("Erro ao fechar arquivo!");
        }

    }//fecha metodo inseteContratado        

    //metodo para listar os corretoes
    public String listaCorretor() {///abre listaCorretor

        String str = "";
        //Cria o LimiteListaCorretor e passa o ArrayList listaCorretor, que contém todos os corretores
        lmtListaCorretor = new LimiteListaCorretor(this);

        return "";

    }//fecha listaCorretor

    //GETTERS E SETTERS
    public ArrayList<Corretor> getListaCorretor() {
        return listaCorretor;
    }

    public void setListaCorretor(ArrayList<Corretor> listaCorretor) {
        this.listaCorretor = listaCorretor;
    }

    //metodo para serializa a o corretor, para salvar em arquivo
    private void serializaCorretor() throws Exception {//abre serializaDisciplina

        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o vetor no arquivo
        objOS.writeObject(listaCorretor);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();

    }//fecha serializaDisciplina

    //metodo para desserializar o arquivo de Disciplinas
    private void desserializaCorretor() throws Exception {//abre desserializaDisciplina
        //nome do arquivo que será lido
        File objFile = new File("corretores.dat");
        //se o arquivo existir
        if (objFile.exists()) {//abre if 01
            
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("corretores.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaCorretor = (ArrayList<Corretor>) objIS.readObject();
            //fecha stream
            objIS.close();
            
        }//fecha if 01

    }//fecha desserializaDisciplina

}//fecha classe ControleCorretor
