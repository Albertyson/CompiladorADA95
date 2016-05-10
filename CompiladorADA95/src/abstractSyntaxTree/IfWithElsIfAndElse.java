package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class IfWithElsIfAndElse extends If {
    
    public Expression expression;
    public Statements statements;
    public ElsIfList elsIfList;
    public Statements elseStatements;

    public IfWithElsIfAndElse(Expression expression, Statements statements, ElsIfList elsIfList, Statements elseStatements) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
        this.elseStatements = elseStatements;
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
