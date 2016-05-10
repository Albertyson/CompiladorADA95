package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class CaseOthers extends Case {
    
    public Expression exp;
    public WhenList whenList;
    public Statements statementsOthers;
    
    public CaseOthers(Expression exp, WhenList whenList, Statements statementsOthers) {
        this.exp = exp;
        this.whenList = whenList;
        this.statementsOthers = statementsOthers;
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