package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class IfWithElse extends If {
    public Expression exp;
    public Statements s1;
    public Statements s2;
    public int line, column;

    public IfWithElse(Expression exp, Statements s1, Statements s2, int l, int c) {
        this.exp = exp;
        this.s1 = s1;
        this.s2 = s2;
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
