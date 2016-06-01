package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class For extends Statement {
    
    public Identifier id;
    public Range range;
    public Statements statements;
    public int line, column;
    

    public For(Identifier id, Range range, Statements statements, int l, int c) {
        this.id = id;
        this.range = range;
        this.statements = statements;
        this.line = l;
        this.column = c;
    }
    
    public For(Identifier id, Range range, int l, int c) {
        this.id = id;
        this.range = range;
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
