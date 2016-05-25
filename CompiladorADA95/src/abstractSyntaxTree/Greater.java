package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Greater extends BooleanExpression {
    
    public Expression exp1, exp2;
    public int line, column;

    public Greater(Expression exp1, Expression exp2, int l, int c) {
        this.exp1 = exp1;
        this.exp2 = exp2;
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

    
}
