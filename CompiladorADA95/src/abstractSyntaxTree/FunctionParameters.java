package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class FunctionParameters {
    
    private ArrayList<Expression> exps;
    
    public FunctionParameters() {
        exps = new ArrayList();
    }
    
    public void add(Expression e) {
        exps.add(0,e);
    }
    
    public int size() {
        return exps.size();
    } 
    
    public Expression getAt(int pos) {
        return exps.get(pos);
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}
