package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

public class IntegerNumber extends LiteralExpression{
    
    public Integer number;
    public int line, colunm;

    public IntegerNumber(Integer number, int l, int c) {
        this.number = number;
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
