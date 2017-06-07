/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import controle.*;
import limite.*;
import modelo.*;

/**
 *
 * @author Ruan
 */
public class ControleImovel {
    LimiteImovel lmtImovel;
    
    public ControleImovel(){
        new LimiteImovel(this);
    }
}
