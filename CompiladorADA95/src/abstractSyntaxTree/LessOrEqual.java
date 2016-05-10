package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

public class LessOrEqual extends BooleanExpression {
    
    public Expression exp1, exp2;

    public LessOrEqual(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
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