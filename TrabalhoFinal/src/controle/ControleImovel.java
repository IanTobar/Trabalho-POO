//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import java.util.*;

import controle.*;
import limite.*;
import modelo.*;

public class ControleImovel {//abre classe ControleImovel

    LimiteImovel lmtImovel;

    ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();

    //construtor 01
    public ControleImovel() {//abre construtor 01

        new LimiteImovel(this);

    }//fecha construtor 01

    public void cadastraImovel(int codigo, String tipo, String descricao, String nomeProprietario, double precoSolicitado, String data) {
        listaImoveis.add(new Imovel(codigo, tipo, descricao, nomeProprietario, precoSolicitado, data));
    }
}//fecha classe ControleImovel
