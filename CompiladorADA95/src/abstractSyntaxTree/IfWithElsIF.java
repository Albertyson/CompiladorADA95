package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IfWithElsIF extends If {
    
    public Expression expression;
    public Statements statements;
    public ElsIfList elsIfList;

    public IfWithElsIF() {}

    public IfWithElsIF(Expression expression, Statements statements, ElsIfList elsIfList) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }

    public ElsIfList getElsIfList() {
        return elsIfList;
    }

    public void setElsIfList(ElsIfList elsIfList) {
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
