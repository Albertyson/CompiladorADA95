package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class ElsIf {
    
    public Expression exp;
    public Statements stms;
    public int line, column;

    public ElsIf(Expression exp, Statements stms) {
        this.exp = exp;
        this.stms = stms;
    }
    
    public ElsIf(Expression exp, Statements stms, int l, int c) {
        this.exp = exp;
        this.stms = stms;
        this.line = l;
        this.column = c;
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