/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediateCode;

/**
 *
 * @author Albertyson
 */
public class Temporal {
    private static int cont = 0;

    public String nuevoTemporal(){
        return String.format("t%d", cont++);
    }
    
    public int getCurrentCont(){
        return cont;
    }
}
