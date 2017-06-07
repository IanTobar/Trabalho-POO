//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package modelo;

import java.util.*;

public class CorretorContratado extends Corretor{//abre classeCorretorContratado

    private double aSalarioFixo;
    private Date aDataAdmissao;
    
    //construtor
    public CorretorContratado( String pNome, int pCreci, double pSalario, Date pDataAdmissao ){//abre construtor 01
        
        //chama construtor da classe abstrata Corretor.java
        super(pNome, pCreci);
        
        aSalarioFixo = pSalario;
        aDataAdmissao = pDataAdmissao;
        
    }//fecha construtor 01
    
    //GETTERS E SETTERS

    public double getaSalarioFixo() {
        return aSalarioFixo;
    }

    public void setaSalarioFixo(double aSalarioFixo) {
        this.aSalarioFixo = aSalarioFixo;
    }

    public Date getaDataAdmissao() {
        return aDataAdmissao;
    }

    public void setaDataAdmissao(Date aDataAdmissao) {
        this.aDataAdmissao = aDataAdmissao;
    }
    
    
    
    @Override
    public double calculaRenda() {
        
        return aSalarioFixo; // + 1% valor da venda de cada imóvel vendido
                
    }
    
}