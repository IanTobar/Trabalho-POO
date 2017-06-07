/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import limite.LimitePrincipal;

/**
 *
 * @author Ruan
 */
public class ControlePrincipal {
    ControleImovel ctrImovel;
    
    LimitePrincipal lmtPrincipal;
    
    public ControlePrincipal(){
        lmtPrincipal = new LimitePrincipal(this);
    }
    
    public static void main(String[] args){
        new ControlePrincipal();
    }
}
