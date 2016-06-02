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
public class Cuadruplo {
    private String operacion;
    private String oper1;
    private String oper2;
    private String oper3;
    private Etiqueta etiq;

    public Cuadruplo() {
    }

    public Cuadruplo(String operacion, String oper1, String oper2, String oper3) {
        this.operacion = operacion;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.oper3 = oper3;
    }
    
    public Cuadruplo(String operacion, String oper1, String oper2, String oper3, Etiqueta e) {
        this.operacion = operacion;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.oper3 = oper3;
        this.etiq = e;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOper1() {
        return oper1;
    }

    public void setOper1(String oper1) {
        this.oper1 = oper1;
    }

    public String getOper2() {
        return oper2;
    }

    public void setOper2(String oper2) {
        this.oper2 = oper2;
    }

    public String getOper3() {
        return oper3;
    }

    public void setOper3(String oper3) {
        this.oper3 = oper3;
    }
    
}
