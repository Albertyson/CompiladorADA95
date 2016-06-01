package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

public class WhenOption {
    
    public Expression exp;
    public Range range;
    public int line, column;

    public WhenOption(Expression exp, int l, int c) {
        this.exp = exp;
        this.line = l;
        this.column = c;
    }

    public WhenOption(Range range, int l, int c) {
        this.range = range;
        this.line = l;
        this.column = c;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}
