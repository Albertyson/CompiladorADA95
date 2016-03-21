package abstractSyntaxTree;

import AST_Path.ParentPath;


public class StringLiteral extends LiteralExpression {
    
    public String string;

    public StringLiteral(String string) {
        this.string = string;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
