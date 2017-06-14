//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import limite.LimitePrincipal;

public class ControlePrincipal {//abre classe ControlePrincipal

    public ControleImovel ctrImovel;
    public ControleVenda ctrVenda;
    public ControleCorretor ctrCorretor;

    LimitePrincipal lmtPrincipal;

    public ControlePrincipal() {
        ctrImovel = new ControleImovel("Vazio");
        ctrVenda = new ControleVenda(this);
        ctrCorretor = new ControleCorretor();
        lmtPrincipal = new LimitePrincipal(this);
    }

    public static void main(String[] args) {
        new ControlePrincipal();
    }

}//fecha classe ControlePrincipal
