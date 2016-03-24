package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({And.class,Or.class,Not.class})
@XmlType
public abstract class LogicalExpression extends Expression {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
