package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({TypeInteger.class,TypeBoolean.class,TypeFloat.class,TypeString.class})
@XmlType
public abstract class VariableType {
    
    public abstract void callPath(ParentPath PP);
    
}
