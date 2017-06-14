/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.*;

/**
 *
 * @author Ruan
 */
public class Venda {
    double valorReal;//Valor real da venda
    String nomeComprador;//Nome do comprador do imovel
    Date dataVenda;//Data da venda
    String corretorResponsavel;

    public Venda(double valorReal, String nomeComprador, Date dataVenda, String corretorResponsavel) {
        this.valorReal = valorReal;
        this.nomeComprador = nomeComprador;
        this.dataVenda = dataVenda;
        this.corretorResponsavel = corretorResponsavel;
    }
    
    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
}
