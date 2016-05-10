package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

public class IntegerNumber extends LiteralExpression{
    
    public Integer number;

    public IntegerNumber(Integer number) {
        this.number = number;
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
