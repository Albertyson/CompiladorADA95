package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Exit extends Statement {
    
    public Expression exp;
    public int line, column;

    public Exit(Expression exp) {
        this.exp = exp;
    }
    
    public Exit(Expression exp, int l, int c) {
        this.exp = exp;
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