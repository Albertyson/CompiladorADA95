package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
public class WhenElement {
    private WhenOptions whenOptions;
    private Statements statements;

    public WhenElement() {
    }

    public WhenOptions getWhenOptions() {
        return whenOptions;
    }

    public Statements getStatements() {
        return statements;
    }
    
    public WhenElement(WhenOptions whenOptions, Statements statements) {
        this.whenOptions = whenOptions;
        this.statements = statements;
    }
    
    public WhenElement(WhenOptions whenOptions) {
        this.whenOptions = whenOptions;
    }
    
    // Caso que usa OTHERS
    public WhenElement(Statements statements) {
        this.statements = statements;
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
