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
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("and", t1, t2, temp));
        return temp;
    }

    @Override
    public String visit(AssignVariableSimple h) {
        String exp = h.exp.generate(this);
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
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", h.number + "", temp));
        return temp;
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
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(Exit h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(False h) {
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", "false", temp));
        return temp;
    }

    @Override
    public String visit(FloatNumber h) {
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("=", h.number + "", temp));
        return temp;
    }

    @Override
    public String visit(For h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(GreaterOrEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if>=", t1, t2, -1));
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(Identifier h) {
        return h.id;
    }

    @Override
    public String visit(IfSimple h) {
        
        
        
        
        
        
        
    }

    @Override
    public String visit(IfWithElsIF h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(IfWithElsIfAndElse h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(IfWithElse h) {
        throw new UnsupportedOperationException("Not supported yet.");  //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    @Override
    public String visit(Less h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if<", t1, t2, -1));
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(LessOrEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if<=", t1, t2, -1));
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(Loop h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
        String t1 = h.exp.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("not", t1, temp));
        return temp;
    }

    @Override
    public String visit(NotEqual h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        cuadruplos.add(new Cuadruplo("if!=", t1, t2, -1));
        cuadruplos.add(new Cuadruplo("goto", -1));
        return "";
    }

    @Override
    public String visit(Or h) {
        String t1 = h.exp1.generate(this);
        String t2 = h.exp2.generate(this);
        String temp = t.nuevoTemporal();
        cuadruplos.add(new Cuadruplo("or", t1, t2, temp));
        return temp;
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
        return temp;
    }

    @Override
    public String visit(While h) {
        throw new UnsupportedOperationException("Not supported yet."); //   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
        }
        for (int i = 0; i < cuadruplos.size(); i++) {
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
