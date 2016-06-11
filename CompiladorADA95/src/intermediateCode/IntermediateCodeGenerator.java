package intermediateCode;

import abstractSyntaxTree.*;
import java.util.ArrayList;

/**
 *
 * @author Albertyson
 */
public class IntermediateCodeGenerator implements IntermediateGenerable{
    private Program program;
    private ArrayList<Cuadruplo> cuadruplos;
    private Temporal t = new Temporal();

    public IntermediateCodeGenerator(Program program, ArrayList<Cuadruplo> cuadruplos) {
        this.program = program;
        this.cuadruplos = cuadruplos;
    }
    
//    public void completar(ArrayList<Cuadruplo> lista,int idx){
//        for (int i = 0; i < lista.size(); i++) {
//            lista.get(i).gt = idx;
//        }
//    }
    
    public ArrayList<Integer> fusionar(ArrayList<Integer> l1, ArrayList<Integer> l2){
        ArrayList<Integer> retList = new ArrayList();
        for (int i = 0; i < l1.size(); i++) {
            retList.add(l1.get(i));
        }
        for (int i = 0; i < l2.size(); i++) {
            retList.add(l2.get(i));
        }
        return retList;
    }
    
    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String visit(Add h) {  
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("+", t1, t2, temp));
        return temp;
    }

    @Override
    public String visit(And h) {
        h.exp1.generate(this);
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        int gtTrue = cuadruplos.size()-1;
        h.exp2.generate(this);
        for (int i = 0; i < h.exp1.listaVerdadero.size(); i++){
            cuadruplos.get(h.exp1.listaVerdadero.get(i)).setGt(gtTrue);
        }
        
//        cuadruplos.get(h.exp2.listaVerdadero.get(0)).esEtiqueta = true;
        h.listaVerdadero = h.exp2.listaVerdadero;
        h.listaFalso = fusionar(h.exp1.listaFalso, h.exp2.listaFalso);
        
        return "";
//        String t1 = h.exp1.generate(this);
//        String t2 = h.exp2.generate(this);
//        String temp = t.nuevoTemporal();
//        cuadruplos.add(new Cuadruplo("and", t1, t2, temp));
//        return temp;
    }

    @Override
    public String visit(AssignVariableSimple h) {
        String exp = h.exp.generate(this);
        if (h.exp instanceof IntegerNumber){
            exp = t.nuevoTemporal();
            cuadruplos.add(new Cuadruplo("=",((IntegerNumber)h.exp).number+"",exp));
        }
        if(h.exp instanceof FloatNumber){
            exp = t.nuevoTemporal();
            cuadruplos.add(new Cuadruplo("=",((FloatNumber)h.exp).number+"",exp));
        }
        if(h.exp instanceof True){
            exp = t.nuevoTemporal();
            cuadruplos.add(new Cuadruplo("=","true",exp));
        }
        if(h.exp instanceof False){
            exp = t.nuevoTemporal();
            cuadruplos.add(new Cuadruplo("=","false",exp));            
        }
        String destino = h.id.generate(this);
        cuadruplos.add(new Cuadruplo("=",exp,destino));
        return h.id.id;
    }

    @Override
    public String visit(AssignVariableWithDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    @Override
    public String visit(IntegerNumber h) {
//        String temp = t.nuevoTemporal();
//        cuadruplos.add(new Cuadruplo("=", h.number + "", temp));
        return h.number+"";
    }

    @Override
    public String visit(CaseNotOthers h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(CaseOthers h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(Division h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("/", t1, t2, temp));
        return temp;
    }

    @Override
    public String visit(Equal h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if=", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(Exit h) {
        h.exp.generate(this);
        for(int i=0;i<h.exp.listaFalso.size();i++){
            cuadruplos.get(h.exp.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(False h) {
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", "false", temp));
        h.listaFalso.add(cuadruplos.size() - 1);
        return temp;
    }

    @Override
    public String visit(FloatNumber h) {
//        String temp = t.nuevoTemporal();
//        cuadruplos.add(new Cuadruplo("=", h.number + "", temp));
        return h.number+"";
    }

    @Override
    public String visit(For h) {
        //asignación de la variable de for
        cuadruplos.add(new Cuadruplo("=",((IntegerNumber)h.range.exp1).number+"",h.id.id));
        
        
        //generar etiqueta para saltar a la expresión
        int saltoExp = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        
        //evaluación de la expresión
        String t1 = h.id.id;
        String t2 = ((IntegerNumber)h.range.exp2).number+"";
        int gtTrue = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("if<=", t1, t2, -1));
        int gtFalse = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("goto", -1));
        
        //setear goto de la exp verdader
        cuadruplos.get(gtTrue).setGt(cuadruplos.size());
        //crea etiqueta de statements del for
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        //generar statements
        for(int i = 0; i < h.statements.size(); i++){
            h.statements.getAt(i).generate(this);
        }
        //generar incremento i = i + 1
        String temp = t.nuevoTemporal(); //t
        cuadruplos.add(new Cuadruplo("+",h.id.id,"1",temp));//t=i+1
        cuadruplos.add(new Cuadruplo("=",temp,h.id.id));//i=t
        
        //saltar a la expresión
        cuadruplos.add(new Cuadruplo("goto",-1));
        cuadruplos.get(cuadruplos.size()-1).setGt(saltoExp);
        //setear el goto de la expresión falso
        cuadruplos.get(gtFalse).setGt(cuadruplos.size());
        
        //caso especial para los exit when
        for(int i = 0; i < h.statements.size(); i++){
            if(h.statements.getAt(i) instanceof Exit){
                Exit e = ((Exit)h.statements.getAt(i));
                for(int j=0; j < e.exp.listaVerdadero.size(); j++){
                    cuadruplos.get(e.exp.listaVerdadero.get(j)).setGt(cuadruplos.size());
                }
            }
        }
        
        //crea etiqueta para el afuera del for
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        
        return "";
    }

    @Override
    public String visit(FunctionCall h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(GetValue h) {
        cuadruplos.add(new Cuadruplo("get", h.id.id, ""));
        return h.id.id;
    }

    @Override
    public String visit(Greater h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if>", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(GreaterOrEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if>=", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(Identifier h) {
        return h.id;
    }

    @Override
    public String visit(IfSimple h) {
        h.exp.generate(this);
        // llenar verdaderos con goto hacia la primera linea de los statements del if
        for(int i = 0; i < h.exp.listaVerdadero.size(); i++){
            cuadruplos.get(h.exp.listaVerdadero.get(i)).setGt(cuadruplos.size());            
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        for(int i = 0; i < h.statements.size(); i++){
            h.statements.getAt(i).generate(this);
        }
        // llenar falsas con goto hacia la ultima linea de los statements del if
        for(int i = 0; i < h.exp.listaFalso.size(); i++){
            cuadruplos.get(h.exp.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(IfWithElsIF h) {
        h.expression.generate(this);
        // llenar verdaderos con goto hacia la primera linea de los statements del if
        for(int i = 0; i < h.expression.listaVerdadero.size(); i++){
            cuadruplos.get(h.expression.listaVerdadero.get(i)).setGt(cuadruplos.size());            
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        for(int i = 0; i < h.statements.size(); i++){
            h.statements.getAt(i).generate(this);
        }
        ArrayList<Integer> saltos = new ArrayList();
        saltos.add(cuadruplos.size());
        
        cuadruplos.add(new Cuadruplo("goto",-1));
        
        // llenar falsas con goto hacia la ultima linea de los statements del if
        for(int i = 0; i < h.expression.listaFalso.size(); i++){
            cuadruplos.get(h.expression.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        for(int i=0 ;i < h.elsIfList.size(); i++){
            cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
            h.elsIfList.getAt(i).exp.generate(this);
            for(int j = 0; j < h.elsIfList.getAt(i).exp.listaVerdadero.size();j++){
                cuadruplos.get(h.elsIfList.getAt(i).exp.listaVerdadero.get(j)).setGt(cuadruplos.size());
            }
            cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
            for(int j = 0; j<h.elsIfList.getAt(i).stms.size(); j++){
                h.elsIfList.getAt(i).stms.getAt(j).generate(this);
            }
            saltos.add(cuadruplos.size());
            cuadruplos.add(new Cuadruplo("goto",-1));
            for(int j = 0; j < h.elsIfList.getAt(i).exp.listaFalso.size();j++){
                cuadruplos.get(h.elsIfList.getAt(i).exp.listaFalso.get(j)).setGt(cuadruplos.size());
            }            
        }
        //recorrer la lista de saltos
        for(int i = 0; i < saltos.size(); i++){
            cuadruplos.get(saltos.get(i)).setGt(cuadruplos.size());
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(IfWithElsIfAndElse h) {
        ArrayList<Integer> saltos = new ArrayList();
        h.expression.generate(this);
        // llenar verdaderos con goto hacia la primera linea de los statements del if
        for(int i = 0; i < h.expression.listaVerdadero.size(); i++){
            cuadruplos.get(h.expression.listaVerdadero.get(i)).setGt(cuadruplos.size());            
        }
        cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
        for(int i = 0; i < h.statements.size(); i++){
            h.statements.getAt(i).generate(this);
        }
        saltos.add(cuadruplos.size());
        cuadruplos.add(new Cuadruplo("goto", -1));
        // llenar falsas con goto hacia la ultima linea de los statements del if
        for(int i = 0; i < h.expression.listaFalso.size(); i++){
            cuadruplos.get(h.expression.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        
        for (int i = 0; i < h.elsIfList.size(); i++){
            cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
            h.elsIfList.getAt(i).exp.generate(this);
            for(int j = 0; j < h.elsIfList.getAt(i).exp.listaVerdadero.size(); j++){
                cuadruplos.get(h.elsIfList.getAt(i).exp.listaVerdadero.get(j)).setGt(cuadruplos.size());
            }
            cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
            
            for(int j = 0; j<h.elsIfList.getAt(i).stms.size(); j++){
                h.elsIfList.getAt(i).stms.getAt(j).generate(this);
            }
            saltos.add(cuadruplos.size());
            cuadruplos.add(new Cuadruplo("goto",-1));
            
            for(int j = 0; j < h.elsIfList.getAt(i).exp.listaFalso.size();j++){
                cuadruplos.get(h.elsIfList.getAt(i).exp.listaFalso.get(j)).setGt(cuadruplos.size());
            }  
        }
        cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
        for(int i = 0; i < h.elseStatements.size(); i++){
            h.elseStatements.getAt(i).generate(this);
        }
        for (int i = 0; i < saltos.size(); i++){
            cuadruplos.get(saltos.get(i)).setGt(cuadruplos.size());
        }
        cuadruplos.add(new Cuadruplo("_etiq" + cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(IfWithElse h) {
        h.exp.generate(this);
        // llenar verdaderos con goto hacia la primera linea de los statements del if
        for(int i = 0; i < h.exp.listaVerdadero.size(); i++){
            cuadruplos.get(h.exp.listaVerdadero.get(i)).setGt(cuadruplos.size());            
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        for(int i = 0; i < h.s1.size(); i++){
            h.s1.getAt(i).generate(this);
        }
        int gtTrue = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("goto",-1));        
        
        // llenar falsas con goto hacia la ultima linea de los statements del if
        for(int i = 0; i < h.exp.listaFalso.size(); i++){
            cuadruplos.get(h.exp.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        
        //generar statements del else
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        for(int i = 0; i < h.s2.size(); i++){
            h.s2.getAt(i).generate(this);
        }
        
        cuadruplos.get(gtTrue).setGt(cuadruplos.size());        
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(Less h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if<", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(LessOrEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if<=", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(Loop h) {
        int salto = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        for (int i = 0; i < h.s.size(); i++) {
            h.s.getAt(i).generate(this);
        }
        //generar goto
        cuadruplos.add(new Cuadruplo("goto",-1));
        cuadruplos.get(cuadruplos.size()-1).setGt(salto);
        //generar etiqueta de salida de loop
        int saltoFuera = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        //caso especial para los exit when
        for(int i = 0; i < h.s.size(); i++){
            if(h.s.getAt(i) instanceof Exit){
                Exit e = ((Exit)h.s.getAt(i));
                for(int j=0; j < e.exp.listaVerdadero.size(); j++){
                    cuadruplos.get(e.exp.listaVerdadero.get(j)).setGt(saltoFuera);
                }
            }
        }
        return "";
    }

    @Override
    public String visit(Minus h) {
        String t1=h.exp1.generate(this);
        String t2=h.exp2.generate(this);
        String temp=t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("-",t1,t2,temp));
        return temp;
    }

    @Override
    public String visit(Module h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("%", t1, t2, temp));
        return temp;
    }

    @Override
    public String visit(Multiplication h) {
        String t1=h.exp1.generate(this);
        String t2=h.exp2.generate(this);
        String temp=t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("*",t1,t2,temp));
        return temp;
    }

    @Override
    public String visit(Negative h) {
        String exp = h.exp.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", "-" + exp, temp));
        return temp;
    }

    @Override
    public String visit(Not h) {
        h.exp.generate(this);
        h.listaVerdadero = h.exp.listaFalso;
        h.listaFalso = h.exp.listaVerdadero;
        
        return "";
        
//        String t1 = h.exp.generate(this);
//        String temp = t.nuevoTemporal();
//        cuadruplos.add(new Cuadruplo("not", t1, temp));
//        return temp;
    }

    @Override
    public String visit(NotEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if!=", t1, t2, -1));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        cuadruplos.add(new Cuadruplo("goto", -1));
        h.listaFalso.add(cuadruplos.size() - 1);
        return "";
    }

    @Override
    public String visit(Or h) {
        h.exp1.generate(this);
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        int gtFalse = cuadruplos.size()-1;
        h.exp2.generate(this);
        for (int i = 0; i < h.exp1.listaFalso.size(); i++){
            cuadruplos.get(h.exp1.listaFalso.get(i)).setGt(gtFalse);
        }
//        cuadruplos.get(h.exp2.listaVerdadero.get(0)).esEtiqueta = true;
        
        h.listaFalso = h.exp2.listaFalso;
        h.listaVerdadero = fusionar(h.exp1.listaVerdadero, h.exp2.listaVerdadero);
       
        return "";
        
//        String t1 = h.exp1.generate(this);
//        String t2 = h.exp2.generate(this);
//        String temp = t.nuevoTemporal();
//        cuadruplos.add(new Cuadruplo("or", t1, t2, temp));
//        return temp;
    }

    @Override
    public String visit(Pow h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("^", t1, t2, temp));
        return temp;
    }

    @Override
    public String visit(PutValue h) {
        String t1 = h.exp.generate(this);
        cuadruplos.add(new Cuadruplo("put", t1, ""));
        return "";
    }

    @Override
    public String visit(Return h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(StringLiteral h) {
        return ""; //NO APLICA
    }

    @Override
    public String visit(True h) {
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", "true", temp));
        h.listaVerdadero.add(cuadruplos.size() - 1);
        return temp;
    }

    @Override
    public String visit(While h) {
        //crea etiqueta para saltar a la expresión
        int gotoExp = cuadruplos.size();
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        h.exp.generate(this);
        for(int i = 0; i < h.exp.listaVerdadero.size(); i++){
            cuadruplos.get(h.exp.listaVerdadero.get(i)).setGt(cuadruplos.size());
        }
        //crear etiqueta para statements
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        //generar statements
        for (int i = 0; i < h.est.size(); i++) {
            h.est.getAt(i).generate(this);
        }
        //generar goto hacia la expresión
        cuadruplos.add(new Cuadruplo("goto",-1));
        cuadruplos.get(cuadruplos.size()-1).setGt(gotoExp);
        //completar la lista de falsos de h.exp
        for(int i = 0; i < h.exp.listaFalso.size(); i++){
            cuadruplos.get(h.exp.listaFalso.get(i)).setGt(cuadruplos.size());
        }
        //caso especial para los exit when
        for(int i = 0; i < h.est.size(); i++){
            if(h.est.getAt(i) instanceof Exit){
                Exit e = ((Exit)h.est.getAt(i));
                for(int j=0; j < e.exp.listaVerdadero.size(); j++){
                    cuadruplos.get(e.exp.listaVerdadero.get(j)).setGt(cuadruplos.size());
                }
            }
        }
        cuadruplos.add(new Cuadruplo("_etiq"+cuadruplos.size()));
        return "";
    }

    @Override
    public String visit(FunctionDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(ProcedureDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(VariableDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet.");//   OJOOOOO
    }

    @Override
    public String visit(ModeIn h) {
        return "";
    }

    @Override
    public String visit(ModeInOut h) {
        return "";
    }

    @Override
    public String visit(ModeOut h) {
        return "";
    }

    @Override
    public String visit(TypeChar h) {
        return "";
    }

    @Override
    public String visit(TypeBoolean h) {
        return "";
    }

    @Override
    public String visit(TypeError h) {
        return "";
    }

    @Override
    public String visit(TypeFloat h) {
        return "";
    }

    @Override
    public String visit(TypeInteger h) {
        return "";
    }

    @Override
    public String visit(TypeNull h) {
        return "";
    }

    @Override
    public String visit(TypeString h) {
        return "";
    }

    @Override
    public String visit(DeclarationPart h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(ElsIf h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(ElsIfList h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(FunctionParameters h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(Parameter h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(ParameterDeclarations h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    @Override
    public String visit(Program h) {
        for(int i = 0; i < h.statements.size(); i++){
            if(h.statements.getAt(i) instanceof AssignVariableSimple){
                ((AssignVariableSimple)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof IfSimple){
                ((IfSimple)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof IfWithElse){
                ((IfWithElse)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof IfWithElsIF){
                ((IfWithElsIF)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof IfWithElsIfAndElse){
                ((IfWithElsIfAndElse)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof For){
                ((For)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof While){
                ((While)h.statements.getAt(i)).generate(this);
            }
            if(h.statements.getAt(i) instanceof Loop){
                ((Loop)h.statements.getAt(i)).generate(this);
            }
        }
        for (int i = 0; i < cuadruplos.size(); i++) {            
//            System.out.println((cuadruplos.get(i).esEtiqueta ? "_etiq"+i+":\n" : "")+cuadruplos.get(i).toString());
            System.out.println(cuadruplos.get(i).toString());
        }
        return"";
    }

    @Override
    public String visit(Range h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(Statements h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(WhenOptions h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(WhenOption h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(WhenList h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(WhenElement h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(VariableIDs h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }
    
}
