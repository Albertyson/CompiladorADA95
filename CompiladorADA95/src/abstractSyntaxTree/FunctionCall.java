package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class FunctionCall extends Expression {
    
    public Identifier id;
    public FunctionParameters fp;
    

    public FunctionCall(Identifier id, FunctionParameters fp) {
        this.id = id;
        this.fp = fp;
    }
    
    public FunctionCall(Identifier id) {
        this.id = id;
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
