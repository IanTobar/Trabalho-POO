//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR

package controle;

import limite.LimitePrincipal;

public class ControlePrincipal {//abre classe ControlePrincipal

    ControleImovel ctrImovel;//cria um controle responasavel pelos imóveis
    
    LimitePrincipal lmtPrincipal;//variavel de instância responsavel pelo limite principal
    
    public ControlePrincipal(){
        lmtPrincipal = new LimitePrincipal(this);
    }
    
    public static void main(String[] args){
        new ControlePrincipal();
    }
    
}//fecha classe ControlePrincipal
