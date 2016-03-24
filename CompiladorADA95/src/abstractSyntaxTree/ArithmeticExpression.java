package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({Add.class,Minus.class,Multiplication.class,Division.class,Pow.class,Negative.class,Module.class})
@XmlType
public abstract class ArithmeticExpression extends Expression {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
