package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

public class While extends Statement {    
    public Expression exp;
    public Statements est;
    public int line, colunm;

    public While(Expression exp, int l, int c) {
        this.exp = exp;
        this.line = l;
        this.colunm = c;
    }
    
    public While(Expression exp, Statements est, int l, int c) {
        this.exp = exp;
        this.est = est;
        this.line = l;
        this.colunm = c;
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
