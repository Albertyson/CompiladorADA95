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
    private int gt = -1;
    public String etiqueta = "";

    public Cuadruplo() {
    }
    
    public Cuadruplo(String e) {
        this.etiqueta = e;
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

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
        this.etiqueta = "_etiq"+gt;
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
            return "\t"+ oper3 + " = " + oper1 + " " + operacion + " " + oper2;
        }
        if(gt > -1){
            if(oper2.length() > 0){
                //if
                return "\tif " + oper1 + " " + operacion.replace("if","") + " " + oper2 + " goto " + etiqueta;
            } else {
                return "\tgoto " + etiqueta;
            }
        }
        if(etiqueta.length()>0){
            return etiqueta + ":";
        }
        return "\t" + oper2 + " " + operacion + " " + oper1;
    }
    
    public String toStringOriginal(){
        return this.operacion + "\t\t| " + this.oper1 + "\t| " + this.oper2 + "\t| " + this.oper3 + " \t| " + this.gt + "\t| " + this.etiqueta;
    }
}
