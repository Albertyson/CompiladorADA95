package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Range {
    
    public Expression exp1, exp2;
    public int line, colunm;

    public Range(Expression exp1, Expression exp2, int l, int c) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.line = l;
        this.colunm = c;
    }
    

    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
