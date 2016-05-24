package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

public class WhenOption {
    
    public Expression exp;
    public Range range;
    public int line, colunm;

    public WhenOption(Expression exp, int l, int c) {
        this.exp = exp;
        this.line = l;
        this.colunm = c;
    }

    public WhenOption(Range range, int l, int c) {
        this.range = range;
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
