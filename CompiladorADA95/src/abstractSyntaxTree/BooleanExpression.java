package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({Equal.class,NotEqual.class,Greater.class,Less.class,GreaterOrEqual.class,LessOrEqual.class})
@XmlType
public abstract class BooleanExpression extends Expression {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
