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

    ControlePrincipal ctrPrincipal;
    
    LimiteCorretor lmtCorretor;
    LimiteListaCorretor lmtListaCorretor;

    private ArrayList<Corretor> listaCorretor = new ArrayList<Corretor>();//array para vendedor

    //constante
    //private final String arquivo = "disc.dat";    
    //construtor
    public ControleCorretor() {//abre ControleCorretor
        this.ctrPrincipal = ctrPrincipal;
        //new LimiteCorretor(this);
    }//fecha ControleCorretor

    //metodo para inserir corretor contratado
    public void insereContratado(String pNome, int pCreci, double pSalario, Date pDate) {//abre metodo insereContratado

        //chama o modelo CorretorContratado e aciona o seu construtor
        CorretorContratado contratado = new CorretorContratado(pNome, pCreci, pSalario, pDate);//cria objeto contratado
        listaCorretor.add(contratado);//adiciona o contratado no array list de corretor

    }//fecha metodo inseteContratado    

    //metodo para inserir vendedor contratado
    public void insereComissionado(String pNome, int pCreci, double pComissao) {//abre metodo insereContratado

        //chama modelo CorretorComissionado e aciona o seu construtor
        CorretorComissionado comissionado = new CorretorComissionado(pNome, pCreci, pComissao);//cria objeto contratado
        listaCorretor.add(comissionado);//adiciona o contratado no array list de corretor

    }//fecha metodo inseteContratado        

    //metodo para listar os corretoes
    public String listaCorretor() {///abre listaCorretor

        String str = "";

        for (int i = 0; i < listaCorretor.size(); i++) {

            str += listaCorretor.get(i).getaNome();//pega o nome do corretor

            if (listaCorretor.get(i) instanceof CorretorComissionado) {//abre if 01

                CorretorComissionado auxComissionado = (CorretorComissionado) listaCorretor.get(i);

            }//fecha if 01

        }

        lmtListaCorretor = new LimiteListaCorretor(listaCorretor);

        return str;

    }//fecha listaCorretor
    
    public ArrayList<Corretor> getList(){
        return listaCorretor;
    }

    /*
    //metodo para serializa o corretor contratado, para salvar em arquivo
    private void serializaCorretorContratado() throws Exception {//abre serializaDisciplina
        
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("corretorContratados.dat");
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
    private void desserializaCorretorContratado() throws Exception {//abre desserializaDisciplina
        
        //nome do arquivo que será lido
        File objFile = new File("corretorContratados.dat");
        
        //se o arquivo existir
        if (objFile.exists()) {//abre if 01
            
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("corretorContratados.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo Vector e atribui ao Vector vecADisciplinas
            listaCorretor = (ArrayList) objIS.readObject();
            //fecha stream
            objIS.close();
            
        }//fecha if 01
        
    }//fecha desserializaDisciplina

    
    
    //metodo que faz a chamada da serializacao do vetor para arquivo
    public void finalize() throws Exception {//abre finalize
        
        serializaCorretorContratado();
        
    }//fecha finalize    
     */
}//fecha classe ControleCorretor
