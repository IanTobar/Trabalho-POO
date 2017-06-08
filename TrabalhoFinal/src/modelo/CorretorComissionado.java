//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package modelo;

import java.io.Serializable;

public class CorretorComissionado extends Corretor  implements Serializable {//abre classe CorretorComissionado

    private double aComissao;
    
    /////////////////falta adicionar as vendas
    
    //construtor
    public CorretorComissionado( String pNome, int pCreci, double pComissao ){//abre construtor 01
        
        //chama construtor da classe Corretor.java
        super(pNome, pCreci);
        
        setaComissao(pComissao);//valida comissão
        
    }//fecha construtor 01

    //GETTERS E SETTERS

    public double getaComissao() {
        return aComissao;
    }

    public void setaComissao(double aComissao) {//abre setaComissao
        
        this.aComissao = ( aComissao >= 1 && aComissao <= 3) ? aComissao : 0;
        
    }//fecha setaComissao
    
    
    //calcula a renda do corretor
    @Override
    public double calculaRenda() {
        
        return aComissao;//de 1% a 3% da venda realizada (aComissao * venda)
        
    }
    
    //sobreescreve o metodo toString
    @Override
    public String toString(){//abre toString
        
        return "Nome: " + super.getaNome() + " CRECI: " + super.getaCreci() + 
                " Renda: " + this.calculaRenda();//retornar dados
        
    }//fecha toString
    
}//fecha classe CorretorComissionado