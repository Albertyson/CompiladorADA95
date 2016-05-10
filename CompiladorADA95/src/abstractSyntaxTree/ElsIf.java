package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class ElsIf {
    
    public Expression exp;
    public Statements stms;

    public ElsIf(Expression exp, Statements stms) {
        this.exp = exp;
        this.stms = stms;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

}