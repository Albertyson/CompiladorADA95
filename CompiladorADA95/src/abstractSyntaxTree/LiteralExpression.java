package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({IntegerNumber.class,FloatNumber.class,True.class,False.class,StringLiteral.class})
@XmlType
public abstract class LiteralExpression extends Expression {

    @Override
    public abstract void callPath(ParentPath PP);
    
}
