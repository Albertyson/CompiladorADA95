package abstractSyntaxTree;

import AST_Path.ParentPath;


public class IntegerNumber extends LiteralExpression{
    
    public Integer number;

    public IntegerNumber(Integer number) {
        this.number = number;
    }
    
    @Override
    public void callPath(ParentPath PP) {
       PP.path(this);
    }

}
