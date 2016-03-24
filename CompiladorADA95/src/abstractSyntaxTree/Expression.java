package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({LiteralExpression.class,Identifier.class,ArithmeticExpression.class,BooleanExpression.class,LogicalExpression.class,FunctionCall.class})
@XmlType
public abstract class Expression extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
