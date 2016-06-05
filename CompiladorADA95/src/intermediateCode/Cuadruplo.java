package intermediateCode;

/**
 *
 * @author Albertyson
 */
public class Cuadruplo {
    private String operacion = "";
    private String oper1 = "";
    private String oper2 = "";
    private String oper3 = "";
    public int gt = -1;

    public Cuadruplo() {
    }

    //para aritmeticas, booleanas, lógicas
    public Cuadruplo(String operacion, String oper1, String oper2, String oper3) {
        this.operacion = operacion;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.oper3 = oper3;
    }
    
    //para if
    public Cuadruplo(String operacion, String oper1, String oper2, int gt) {
        this.operacion = operacion;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.gt = gt;
    }
    
    //para asignacion
    public Cuadruplo(String operacion, String oper1, String oper2) {
        this.operacion = operacion;
        this.oper1 = oper1;
        this.oper2 = oper2;
    }
    
    //para el goto
    public Cuadruplo(String operacion, int gt) {
        this.operacion = operacion;
        this.gt = gt;
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

    @Override
    public String toString() {
        if(this.oper3.length() > 0){
            //aritmeticas, logicas, booleanas
            return oper3 + " = " + oper1 + " " + operacion + " " + oper2;
        }
        if(gt > -1){
            if(oper2.length() > 0){
                //if
                return "if " + oper1 + " " + operacion.replace("if","") + " " + oper2 + " goto "+gt;
            } else {
                return "goto " + gt;
            }
        }
        return oper2 + " " + operacion + " " + oper1;
    }
    
}
