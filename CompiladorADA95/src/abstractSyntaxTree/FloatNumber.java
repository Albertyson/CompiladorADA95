package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class FloatNumber extends LiteralExpression {
    
    public Double number;
    public int line, column;

    public FloatNumber(Double number) {
        this.number = number;
    }
    
    public FloatNumber(Double number, int l, int c) {
        this.number = number;
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
