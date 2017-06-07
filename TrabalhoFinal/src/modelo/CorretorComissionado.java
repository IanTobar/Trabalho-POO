//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package modelo;

public class CorretorComissionado extends Corretor{//abre classe CorretorComissionado

    private float aComissao;
    
    //construtor
    public CorretorComissionado( String pNome, int pCreci, float pComissao){//abre construtor 01
        
        //chama construtor da classe Corretor.java
        super(pNome, pCreci);
        
        aComissao = pComissao;
        
    }//fecha construtor 01
    
    @Override
    public double calculaRenda() {
        
        return aComissao;//de 1% a 3% da venda realizada
        
    }
    
}//fecha classe CorretorComissionado