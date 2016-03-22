package abstractSyntaxTree;

import AST_Path.ParentPath;


public class FloatNumber extends LiteralExpression{
    
    public Double number;

    public FloatNumber(Double number) {
        this.number = number;
    }

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
    
}
