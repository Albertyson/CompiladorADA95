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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
}
