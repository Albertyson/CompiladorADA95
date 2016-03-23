package abstractSyntaxTree;

import AST_Path.ParentPath;

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

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }
    
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
