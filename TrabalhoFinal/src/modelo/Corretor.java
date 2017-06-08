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
        
        this.aNome = pNome;
        this.aCreci = pCreci;
        
    }//fecha construtor 01
   
    //GETTERS E SETTERS

    public String getaNome() {
        return aNome;
    }

    public void setaNome(String aNome) {
        this.aNome = aNome;
    }

    public int getaCreci() {
        return aCreci;
    }

    public void setaCreci(int aCreci) {
        this.aCreci = aCreci;
    }
    
    //retorna a representação de String do objeto Corretor
    @Override
    public String toString(){//abre toString
		
    	return String.format("Nome: %s \nCreci: %d", getaNome(), getaCreci());//retorna dado
		
    }//fecha toString    
    
    //metodo abstrato, que será implementado nas classes concretas
    public abstract double calculaRenda();
    
}//fecha classe Corretor