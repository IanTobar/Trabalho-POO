/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.*;

import limite.*;
import modelo.*;

/**
 *
 * @author Ruan
 */
public class ControleVenda {
    
    LimiteVenda lmtVenda;

    ControlePrincipal ctrPrincipal;
    
    ArrayList<Venda> listaVendas = new ArrayList<Venda>();
    
    public ControleVenda(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;
        lmtVenda = new LimiteVenda(this); 
    }
    
    public void mostraFormulario(){
        new CadastraVenda(ctrPrincipal);
    }
    
    public void cadastraVenda(double valorReal,String nomeComprador, Date dataVenda, String nomeCorretor){
        listaVendas.add(new Venda(valorReal,nomeComprador,dataVenda,nomeCorretor));
    }
}
