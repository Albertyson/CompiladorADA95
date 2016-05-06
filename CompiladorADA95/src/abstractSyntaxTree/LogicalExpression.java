package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({And.class,Or.class,Not.class})
@XmlType
public abstract class LogicalExpression extends Expression {
    
    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
}
