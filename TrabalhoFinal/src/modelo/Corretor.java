//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR
//RUAN MICHEL ADABO

package modelo;

//classe abstrata dos corretores
public abstract class Corretor {//abre classe Corretor
    
    private String aNome;
    private int aCreci;
    
    //construtor 
    public Corretor( String pNome, int pCreci ){//abre construtor 01
        
        aNome = pNome;
        aCreci = pCreci;
        
    }//fecha construtor 01
    
    public abstract double calculaRenda();
    
}//fecha classe Corretor