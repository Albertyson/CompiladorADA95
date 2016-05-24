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
    public int line, colunm;
    

    public For(Identifier id, Range range, Statements statements, int l, int c) {
        this.id = id;
        this.range = range;
        this.statements = statements;
        this.line = l;
        this.colunm = c;
    }
    
    public For(Identifier id, Range range, int l, int c) {
        this.id = id;
        this.range = range;
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
