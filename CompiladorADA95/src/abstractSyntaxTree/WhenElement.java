package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class WhenElement {
    public WhenOptions whenOptions;
    public Statements statements;
    public int line, colunm;

    public WhenElement(int l, int c) {
        this.line = l;
        this.colunm = c;
    }
    
    public WhenElement(WhenOptions whenOptions, Statements statements, int l, int c) {
        this.whenOptions = whenOptions;
        this.statements = statements;
        this.line = l;
        this.colunm = c;
    }
    
    public WhenElement(WhenOptions whenOptions, int l, int c) {
        this.whenOptions = whenOptions;
        this.line = l;
        this.colunm = c;
    }
    
    // Caso que usa OTHERS
    public WhenElement(Statements statements, int l, int c) {
        this.statements = statements;
        this.line = l;
        this.colunm = c;
    }
    
    public WhenOptions getWhenOptions() {
        return whenOptions;
    }

    public Statements getStatements() {
        return statements;
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
