package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class GetValue extends Statement {
    
    public Identifier id;
    public int line, column;

    public GetValue(Identifier id, int l, int c) {
        this.id = id;
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
