//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import java.util.*;

import controle.*;
import limite.*;
import modelo.*;

public class ControleImovel {//abre classe ControleImovel

    public LimiteImovel lmtImovel;
    
    ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();

    //construtor 01
    public ControleImovel(String op) {//abre construtor 01
        if(op.equals("Limite")){
            new LimiteImovel(this);
        }
    }//fecha construtor 01

    public void cadastraImovel(int codigo, String tipo, String descricao, String nomeProprietario, double precoSolicitado, String data) {
        listaImoveis.add(new Imovel(codigo, tipo, descricao, nomeProprietario, precoSolicitado, data));
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
}//fecha classe ControleImovel
