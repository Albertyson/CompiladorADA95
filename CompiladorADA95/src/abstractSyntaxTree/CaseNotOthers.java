package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class CaseNotOthers extends Case {
    
    public Expression exp;
    public WhenList whenList;

    
    public CaseNotOthers(Expression exp, WhenList wl) {
        this.exp = exp;
        this.whenList = wl;
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
}