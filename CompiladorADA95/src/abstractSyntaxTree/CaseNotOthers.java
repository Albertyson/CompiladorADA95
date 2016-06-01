package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class CaseNotOthers extends Case {
    
    public Expression exp;
    public WhenList whenList;
    public int line, column;

    
    public CaseNotOthers(Expression exp, WhenList wl) {
        this.exp = exp;
        this.whenList = wl;
    }
    
    public CaseNotOthers(Expression exp, WhenList wl, int l, int c) {
        this.exp = exp;
        this.whenList = wl;
        this.line = l;
        this.column = c;
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    @Override
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
}