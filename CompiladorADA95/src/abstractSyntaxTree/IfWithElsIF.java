package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class IfWithElsIF extends If {
    
    public Expression expression;
    public Statements statements;
    public ElsIfList elsIfList;
    public int line, colunm;


    public IfWithElsIF(Expression expression, Statements statements, ElsIfList elsIfList, int l, int c) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
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
