package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Loop extends Statement {
    
    public Statements s;
    public int line, column;

    public Loop(int l, int c) {
        this.s = null;
        this.line = l;
        this.column = c;
    }
    
    public Loop(Statements s, int l, int c) {
        this.s = s;
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

}