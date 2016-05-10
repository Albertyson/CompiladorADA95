package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class For extends Statement {
    
    public Identifier id;
    public Range range;
    public Statements statements;
    

    public For(Identifier id, Range range, Statements statements) {
        this.id = id;
        this.range = range;
        this.statements = statements;
    }

    public For(Identifier id, Range range) {
        this.id = id;
        this.range = range;
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
