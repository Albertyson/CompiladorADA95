package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class IfWithElsIF extends If {
    
    public Expression expression;
    public Statements statements;
    public ElsIfList elsIfList;
    public int line, column;


    public IfWithElsIF(Expression expression, Statements statements, ElsIfList elsIfList, int l, int c) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
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
