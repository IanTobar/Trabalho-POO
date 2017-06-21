//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package modelo;

import java.io.Serializable;
import java.util.*;

public class CorretorContratado extends Corretor  implements Serializable {//abre classeCorretorContratado

    private double aSalarioFixo;
    private Date aDataAdmissao;
    
    //falta adicionar a venda!!!
    
    //construtor
    public CorretorContratado( String pNome, int pCreci, double pSalario, Date pDataAdmissao ){//abre construtor 01

        
        //chama construtor da classe abstrata Corretor.java
        super(pNome, pCreci);

        setaSalarioFixo(pSalario);//valida salário
        this.aDataAdmissao = pDataAdmissao;
        
    }//fecha construtor 01
    
    //GETTERS E SETTERS

    public double getaSalarioFixo() {
        return aSalarioFixo;
    }

    public void setaSalarioFixo(double aSalarioFixo) {//abre setaSalarioFixo

        this.aSalarioFixo = aSalarioFixo < 0.0 ? 0.0 : aSalarioFixo;
        
    }//fecha setaSalarioFixo

    public Date getaDataAdmissao() {
        return aDataAdmissao;
    }

    public void setaDataAdmissao(Date aDataAdmissao) {
        this.aDataAdmissao = aDataAdmissao;
    }

    //retorna o rendimento
    @Override
    public double calculaRenda() {
        
        return aSalarioFixo; // + 1% valor da venda de cada imóvel vendido
                
    }
    
    //sobreescreve o metodo toString
    @Override
    public String toString(){//abre toString
        
        return "Nome: " + super.getaNome() + " CRECI: " + super.getaCreci() + 
                " Renda: " + this.calculaRenda();//retornar dados
        
    }//fecha toString 
    
}