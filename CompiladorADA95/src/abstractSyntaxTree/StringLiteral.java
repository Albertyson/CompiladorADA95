package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class StringLiteral extends LiteralExpression {
    
    public String string;
    public int line, column;

    public StringLiteral(String string, int l, int c) {
        this.string = string;
        this.line = l;
        this.column = c;
    }
    
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    @Override
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
}
