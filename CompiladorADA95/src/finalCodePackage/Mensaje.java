/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalCodePackage;

/**
 *
 * @author Albertyson
 */
public class Mensaje {
    public static int cont=0;
    public String nuevoMensaje(){
        return String.format("_msg%d", cont++);
    }
}
