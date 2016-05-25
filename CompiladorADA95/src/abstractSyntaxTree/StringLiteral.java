package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class StringLiteral extends LiteralExpression {
    
    public String string;
    public int line, colunm;

    public StringLiteral(String string, int l, int c) {
        this.string = string;
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
