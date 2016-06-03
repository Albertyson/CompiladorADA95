package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

public class While extends Statement {    
    public Expression exp;
    public Statements est;
    public int line, column;

    public While(Expression exp, int l, int c) {
        this.exp = exp;
        this.line = l;
        this.column = c;
    }
    
    public While(Expression exp, Statements est, int l, int c) {
        this.exp = exp;
        this.est = est;
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
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
}
