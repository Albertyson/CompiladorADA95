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


    public IfWithElsIF(Expression expression, Statements statements, ElsIfList elsIfList) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
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
