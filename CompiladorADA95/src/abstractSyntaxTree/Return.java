package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Return extends Statement {

    public Expression exp;
    public int line, colunm;

    public Return(Expression exp, int l, int c) {
        this.exp = exp;
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
